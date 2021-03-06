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
Builder class for javafx.scene.control.ProgressIndicator
@see javafx.scene.control.ProgressIndicator
@deprecated This class is deprecated and will be removed in the next version
* @since JavaFX 2.0
*/
@javax.annotation.Generated("Generated by javafx.builder.processor.BuilderProcessor")
@Deprecated
public class ProgressIndicatorBuilder<B extends javafx.scene.control.ProgressIndicatorBuilder<B>> extends javafx.scene.control.ControlBuilder<B> implements javafx.util.Builder<javafx.scene.control.ProgressIndicator> {
    protected ProgressIndicatorBuilder() {
    }

    /** Creates a new instance of ProgressIndicatorBuilder. */
    @SuppressWarnings({"deprecation", "rawtypes", "unchecked"})
    public static javafx.scene.control.ProgressIndicatorBuilder<?> create() {
        return new javafx.scene.control.ProgressIndicatorBuilder();
    }

    private boolean __set;
    public void applyTo(javafx.scene.control.ProgressIndicator x) {
        super.applyTo(x);
        if (__set) x.setProgress(this.progress);
    }

    private double progress;
    /**
    Set the value of the {@link javafx.scene.control.ProgressIndicator#getProgress() progress} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B progress(double x) {
        this.progress = x;
        __set = true;
        return (B) this;
    }

    /**
    Make an instance of {@link javafx.scene.control.ProgressIndicator} based on the properties set on this builder.
    */
    public javafx.scene.control.ProgressIndicator build() {
        javafx.scene.control.ProgressIndicator x = new javafx.scene.control.ProgressIndicator();
        applyTo(x);
        return x;
    }
}
