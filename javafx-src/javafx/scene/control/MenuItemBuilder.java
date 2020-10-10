/*
 * Copyright (c) 2011, 2014, Oracle and/or its affiliates. All rights reserved.
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

package javafx.scene.control;

/**
Builder class for javafx.scene.control.MenuItem
@see javafx.scene.control.MenuItem
@deprecated This class is deprecated and will be removed in the next version
* @since JavaFX 2.0
*/
@javax.annotation.Generated("Generated by javafx.builder.processor.BuilderProcessor")
@Deprecated
public class MenuItemBuilder<B extends javafx.scene.control.MenuItemBuilder<B>> implements javafx.util.Builder<javafx.scene.control.MenuItem> {
    protected MenuItemBuilder() {
    }

    /** Creates a new instance of MenuItemBuilder. */
    @SuppressWarnings({"deprecation", "rawtypes", "unchecked"})
    public static javafx.scene.control.MenuItemBuilder<?> create() {
        return new javafx.scene.control.MenuItemBuilder();
    }

    private int __set;
    private void __set(int i) {
        __set |= 1 << i;
    }
    public void applyTo(javafx.scene.control.MenuItem x) {
        int set = __set;
        while (set != 0) {
            int i = Integer.numberOfTrailingZeros(set);
            set &= ~(1 << i);
            switch (i) {
                case 0: x.setAccelerator(this.accelerator); break;
                case 1: x.setDisable(this.disable); break;
                case 2: x.setGraphic(this.graphic); break;
                case 3: x.setId(this.id); break;
                case 4: x.setMnemonicParsing(this.mnemonicParsing); break;
                case 5: x.setOnAction(this.onAction); break;
                case 6: x.setOnMenuValidation(this.onMenuValidation); break;
                case 7: x.setStyle(this.style); break;
                case 8: x.getStyleClass().addAll(this.styleClass); break;
                case 9: x.setText(this.text); break;
                case 10: x.setUserData(this.userData); break;
                case 11: x.setVisible(this.visible); break;
            }
        }
    }

    private javafx.scene.input.KeyCombination accelerator;
    /**
    Set the value of the {@link javafx.scene.control.MenuItem#getAccelerator() accelerator} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B accelerator(javafx.scene.input.KeyCombination x) {
        this.accelerator = x;
        __set(0);
        return (B) this;
    }

    private boolean disable;
    /**
    Set the value of the {@link javafx.scene.control.MenuItem#isDisable() disable} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B disable(boolean x) {
        this.disable = x;
        __set(1);
        return (B) this;
    }

    private javafx.scene.Node graphic;
    /**
    Set the value of the {@link javafx.scene.control.MenuItem#getGraphic() graphic} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B graphic(javafx.scene.Node x) {
        this.graphic = x;
        __set(2);
        return (B) this;
    }

    private java.lang.String id;
    /**
    Set the value of the {@link javafx.scene.control.MenuItem#getId() id} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B id(java.lang.String x) {
        this.id = x;
        __set(3);
        return (B) this;
    }

    private boolean mnemonicParsing;
    /**
    Set the value of the {@link javafx.scene.control.MenuItem#isMnemonicParsing() mnemonicParsing} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B mnemonicParsing(boolean x) {
        this.mnemonicParsing = x;
        __set(4);
        return (B) this;
    }

    private javafx.event.EventHandler<javafx.event.ActionEvent> onAction;
    /**
    Set the value of the {@link javafx.scene.control.MenuItem#getOnAction() onAction} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B onAction(javafx.event.EventHandler<javafx.event.ActionEvent> x) {
        this.onAction = x;
        __set(5);
        return (B) this;
    }

    private javafx.event.EventHandler<javafx.event.Event> onMenuValidation;
    /**
    Set the value of the {@link javafx.scene.control.MenuItem#getOnMenuValidation() onMenuValidation} property for the instance constructed by this builder.
    * @since JavaFX 2.2
    */
    @SuppressWarnings("unchecked")
    public B onMenuValidation(javafx.event.EventHandler<javafx.event.Event> x) {
        this.onMenuValidation = x;
        __set(6);
        return (B) this;
    }

    private java.lang.String style;
    /**
    Set the value of the {@link javafx.scene.control.MenuItem#getStyle() style} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B style(java.lang.String x) {
        this.style = x;
        __set(7);
        return (B) this;
    }

    private java.util.Collection<? extends java.lang.String> styleClass;
    /**
    Add the given items to the List of items in the {@link javafx.scene.control.MenuItem#getStyleClass() styleClass} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B styleClass(java.util.Collection<? extends java.lang.String> x) {
        this.styleClass = x;
        __set(8);
        return (B) this;
    }

    /**
    Add the given items to the List of items in the {@link javafx.scene.control.MenuItem#getStyleClass() styleClass} property for the instance constructed by this builder.
    */
    public B styleClass(java.lang.String... x) {
        return styleClass(java.util.Arrays.asList(x));
    }

    private java.lang.String text;
    /**
    Set the value of the {@link javafx.scene.control.MenuItem#getText() text} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B text(java.lang.String x) {
        this.text = x;
        __set(9);
        return (B) this;
    }

    private java.lang.Object userData;
    /**
    Set the value of the {@link javafx.scene.control.MenuItem#getUserData() userData} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B userData(java.lang.Object x) {
        this.userData = x;
        __set(10);
        return (B) this;
    }

    private boolean visible;
    /**
    Set the value of the {@link javafx.scene.control.MenuItem#isVisible() visible} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B visible(boolean x) {
        this.visible = x;
        __set(11);
        return (B) this;
    }

    /**
    Make an instance of {@link javafx.scene.control.MenuItem} based on the properties set on this builder.
    */
    public javafx.scene.control.MenuItem build() {
        javafx.scene.control.MenuItem x = new javafx.scene.control.MenuItem();
        applyTo(x);
        return x;
    }
}