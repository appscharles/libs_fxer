package com.appscharles.libs.fxer.builders;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * The type Button builder.
 */
public class ButtonBuilder {

    private List<String> styleClasses;

    private String text;

    private String toolTipValue;

    private String imageResource;

    private Integer fitHeightImage;

    private Integer fitWidthImage;

    private Boolean enableImageSetPreserveRatio;

    private Consumer<ActionEvent> onAction;

    private ButtonBuilder() {
        this.styleClasses = new ArrayList<>();
        this.enableImageSetPreserveRatio = true;
    }

    /**
     * Create button builder.
     *
     * @param text the text
     * @return the button builder
     */
    public static ButtonBuilder create(String text) {
        ButtonBuilder instance = new ButtonBuilder();
        instance.text = text;
        return instance;
    }

    /**
     * Build button.
     *
     * @return the button
     */
    public Button build() {
        Button button = new Button(this.text);
        button.setFocusTraversable(false);
        if (this.toolTipValue != null) {
            button.setTooltip(new Tooltip(this.toolTipValue));
        }
        button.getStyleClass().addAll(this.styleClasses);
        if (this.imageResource != null) {
            Image image = new Image(getClass().getResourceAsStream(this.imageResource));
            ImageView imageView = new ImageView(image);
            if (this.fitHeightImage != null) {
                imageView.setFitHeight(this.fitHeightImage);
            }
            if (this.fitWidthImage != null) {
                imageView.setFitWidth(this.fitWidthImage);
            }
            imageView.setPreserveRatio(this.enableImageSetPreserveRatio);
            button.setGraphic(imageView);
        }

        button.setOnAction(event -> {
            if (this.onAction != null){
                this.onAction.accept(event);
            }
        });
        return button;
    }

    /**
     * Add style class button builder.
     *
     * @param styleClass the style class
     * @return the button builder
     */
    public ButtonBuilder addStyleClass(String styleClass) {
        this.styleClasses.add(styleClass);
        return this;
    }

    /**
     * Tool tip value button builder.
     *
     * @param value the value
     * @return the button builder
     */
    public ButtonBuilder toolTipValue(String value) {
        this.toolTipValue = value;
        return this;
    }

    /**
     * Image resource button builder.
     *
     * @param imageResource the image resource
     * @return the button builder
     */
    public ButtonBuilder imageResource(String imageResource) {
        this.imageResource = imageResource;
        return this;
    }


    /**
     * Fit height image button builder.
     *
     * @param fitHeightImage the fit height image
     * @return the button builder
     */
    public ButtonBuilder fitHeightImage(Integer fitHeightImage) {
        this.fitHeightImage = fitHeightImage;
        return this;
    }


    /**
     * Fit width image button builder.
     *
     * @param fitWidthImage the fit width image
     * @return the button builder
     */
    public ButtonBuilder fitWidthImage(Integer fitWidthImage) {
        this.fitWidthImage = fitWidthImage;
        return this;
    }

    /**
     * Disable image set preserve ratio button builder.
     *
     * @return the button builder
     */
    public ButtonBuilder disableImageSetPreserveRatio() {
        this.enableImageSetPreserveRatio = false;
        return this;
    }

    /**
     * Sets on action.
     *
     * @param onAction the on action
     * @return the on action
     */
    public ButtonBuilder setOnAction(Consumer<ActionEvent> onAction) {
        this.onAction = onAction;
        return this;
    }
}
