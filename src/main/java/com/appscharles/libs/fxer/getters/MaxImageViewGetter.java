package com.appscharles.libs.fxer.getters;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * The type Max image view getter.
 */
public class MaxImageViewGetter {

    private Image image;

    private Double maxWidth;

    private Double maxHeight;

    private Boolean preserveRatio;

    /**
     * Instantiates a new Max image view getter.
     *
     * @param image         the image
     * @param maxWidth      the max width
     * @param maxHeight     the max height
     * @param preserveRatio the preserve ratio
     */
    public MaxImageViewGetter(Image image, Double maxWidth, Double maxHeight, Boolean preserveRatio) {

        this.image = image;
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
        this.preserveRatio = preserveRatio;
    }

    /**
     * Get image view.
     *
     * @return the image view
     */
    public ImageView get() {
        ImageView previewImageView = new ImageView(this.image);
        previewImageView.setFitWidth(MaxWidthSizeGetter.get(this.image, this.maxWidth));
        previewImageView.setFitHeight(MaxWidthSizeGetter.get(this.image, this.maxHeight));
        previewImageView.setPreserveRatio(this.preserveRatio);
        return previewImageView;
    }
}
