/*
 * Copyright (c) 2012, 2014, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package com.sun.javafx.scene.control.skin;

import java.util.Map;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

/**
 * The embedded context menu for a text input control.
 * The menu will be displayed horizontally underneath the cursor
 * with the available text editing options i.e. cut, copy, paste, select all.
 *
 */
public class EmbeddedTextContextMenuContent extends StackPane {

    private ContextMenu contextMenu;
    private StackPane pointer;
    private HBox menuBox;

    public EmbeddedTextContextMenuContent(final ContextMenu popupMenu) {
        this.contextMenu = popupMenu;
        this.menuBox = new HBox();
        this.pointer = new StackPane();
        pointer.getStyleClass().add("pointer");

        updateMenuItemContainer();
        getChildren().addAll(pointer, menuBox);

        contextMenu.ownerNodeProperty().addListener(arg0 -> {
            if (contextMenu.getOwnerNode() instanceof TextArea) {
                TextAreaSkin tas = (TextAreaSkin)((TextArea)contextMenu.getOwnerNode()).getSkin();
                tas.getSkinnable().getProperties().addListener(new InvalidationListener() {
                    @Override public void invalidated(Observable arg0) {
                        requestLayout();
                    }
                });
            } else if (contextMenu.getOwnerNode() instanceof TextField) {
                TextFieldSkin tfs = (TextFieldSkin)((TextField)contextMenu.getOwnerNode()).getSkin();
                tfs.getSkinnable().getProperties().addListener(new InvalidationListener() {
                    @Override public void invalidated(Observable arg0) {
                        requestLayout();
                    }
                });
            }
        });

        contextMenu.getItems().addListener((ListChangeListener<MenuItem>) c -> {
            // Listener to items in PopupMenu to update items in PopupMenuContent
            updateMenuItemContainer();
        });
    }

    private void updateMenuItemContainer() {
        menuBox.getChildren().clear();
        for (MenuItem item: contextMenu.getItems()) {
            MenuItemContainer menuItemContainer = new MenuItemContainer(item);
            menuItemContainer.visibleProperty().bind(item.visibleProperty());
            menuBox.getChildren().add(menuItemContainer);
        }
    }

    private void hideAllMenus(MenuItem item) {
        contextMenu.hide();

        Menu parentMenu;
        while ((parentMenu = item.getParentMenu()) != null) {
            parentMenu.hide();
            item = parentMenu;
        }
        if (parentMenu == null && item.getParentPopup() != null) {
            item.getParentPopup().hide();
        }
    }

    @Override protected double computePrefHeight(double width) {
        final double pointerHeight = snapSize(pointer.prefHeight(width));
        final double menuBoxHeight = snapSize(menuBox.prefHeight(width));
        return snappedTopInset() + pointerHeight + menuBoxHeight + snappedBottomInset();
    }

    @Override protected double computePrefWidth(double height) {
        final double menuBoxWidth = snapSize(menuBox.prefWidth(height));
        return snappedLeftInset() + menuBoxWidth + snappedRightInset();
    }

    @Override protected void layoutChildren() {
        final double left = snappedLeftInset();
        final double right = snappedRightInset();
        final double top = snappedTopInset();
        final double width = getWidth() - (left + right);
        final double pointerWidth = snapSize(Utils.boundedSize(pointer.prefWidth(-1), pointer.minWidth(-1), pointer.maxWidth(-1)));
        final double pointerHeight = snapSize(Utils.boundedSize(pointer.prefWidth(-1), pointer.minWidth(-1), pointer.maxWidth(-1)));
        final double menuBoxWidth = snapSize(Utils.boundedSize(menuBox.prefWidth(-1), menuBox.minWidth(-1), menuBox.maxWidth(-1)));
        final double menuBoxHeight = snapSize(Utils.boundedSize(menuBox.prefWidth(-1), menuBox.minWidth(-1), menuBox.maxWidth(-1)));
        double sceneX = 0;
        double screenX = 0;
        double pointerX = 0;

        // Get the positions of the cursor from the TextArea/TextField and draw the arrow underneath it.
        Map<Object,Object> properties = null;
        if (contextMenu.getOwnerNode() instanceof TextArea) {
            properties = ((TextArea)contextMenu.getOwnerNode()).getProperties();
        } else if (contextMenu.getOwnerNode() instanceof TextField) {
            properties = ((TextField)contextMenu.getOwnerNode()).getProperties();
        }

        if (properties != null) {
            if (properties.containsKey("CONTEXT_MENU_SCENE_X")) {
                sceneX = Double.valueOf(properties.get("CONTEXT_MENU_SCENE_X").toString());
                properties.remove("CONTEXT_MENU_SCENE_X");
            }

            if (properties.containsKey("CONTEXT_MENU_SCREEN_X")) {
                screenX = Double.valueOf(properties.get("CONTEXT_MENU_SCREEN_X").toString());
                properties.remove("CONTEXT_MENU_SCREEN_X");
            }
        }

        if (sceneX == 0) {
            pointerX = width/2;
        } else {
            pointerX = (screenX - sceneX - contextMenu.getX()) + sceneX;
        }

        pointer.resize(pointerWidth, pointerHeight);
        positionInArea(pointer, pointerX, top, pointerWidth, pointerHeight, 0, HPos.CENTER, VPos.CENTER);
        menuBox.resize(menuBoxWidth, menuBoxHeight);
        positionInArea(menuBox, left, top + pointerHeight, menuBoxWidth, menuBoxHeight, 0, HPos.CENTER, VPos.CENTER);
    }

    class MenuItemContainer extends Button {
        private MenuItem item;

        public MenuItemContainer(MenuItem item){
            getStyleClass().addAll(item.getStyleClass());
            setId(item.getId());
            this.item = item;
            setText(item.getText());
            setStyle(item.getStyle());

            // bind to text property in menu item
            textProperty().bind(item.textProperty());
        }

        public MenuItem getItem() {
            return item;
        }

        @Override public void fire() {
            Event.fireEvent(item, new ActionEvent());
            if (Boolean.TRUE.equals((Boolean)item.getProperties().get("refreshMenu"))) {
                //refreshMenu();
            } else {
                hideAllMenus(item);
            }
        }
    }
}
