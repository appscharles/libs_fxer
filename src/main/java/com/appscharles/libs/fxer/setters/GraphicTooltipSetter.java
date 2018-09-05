package com.appscharles.libs.fxer.setters;

import com.appscharles.libs.fxer.getters.MaxHeightSizeGetter;
import com.appscharles.libs.fxer.getters.MaxWidthSizeGetter;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * The type Graphic tooltip setter.
 */
public class GraphicTooltipSetter {

    /**
     * Set.
     *
     * @param tooltip       the tooltip
     * @param image         the image
     * @param maxWidth      the max width
     * @param maxHeight     the max height
     * @param preserveRatio the preserve ratio
     */
    public static void set(Tooltip tooltip, Image image, Double maxWidth, Double maxHeight, Boolean preserveRatio){
        ImageView previewImageView = new ImageView(image);
        previewImageView.setFitWidth(MaxWidthSizeGetter.get(image, maxWidth));
        previewImageView.setFitHeight(MaxHeightSizeGetter.get(image, maxHeight));
        previewImageView.setPreserveRatio(preserveRatio);
        tooltip.setGraphic(previewImageView);
    }
}
