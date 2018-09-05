package com.appscharles.libs.fxer.getters;

import javafx.scene.image.Image;

import java.net.URL;

/**
 * The type Max image getter.
 */
public class MaxImageGetter implements IMaxImageGetter {

    private String imageResource;

    private URL imageUrl;

    private Double maxWidth;

    private Double maxHeight;

    private Boolean preserveRatio;

    /**
     * Instantiates a new Max image getter.
     *
     * @param imageUrl  the image url
     * @param maxWidth  the max width
     * @param maxHeight the max height
     */
    public MaxImageGetter(URL imageUrl, Double maxWidth, Double maxHeight) {
        this.imageUrl = imageUrl;
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
        this.preserveRatio = true;
    }

    /**
     * Instantiates a new Max image getter.
     *
     * @param imageResource the image resource
     * @param maxWidth      the max width
     * @param maxHeight     the max height
     */
    public MaxImageGetter(String imageResource, Double maxWidth, Double maxHeight) {
        this.imageResource = imageResource;
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
        this.preserveRatio = true;
    }

    public Image get() {
        Image imageOriginal = null;
        if (this.imageResource != null){
            imageOriginal = new Image(getClass().getResourceAsStream(this.imageResource));
        } else if (this.imageUrl != null) {
            imageOriginal = new Image(String.valueOf(this.imageUrl));
        }

        Double finalMaxWidth = (imageOriginal.getWidth() < this.maxWidth) ? imageOriginal.getWidth() : this.maxWidth;
        Double finalMaxHeight = (imageOriginal.getHeight() < this.maxHeight) ? imageOriginal.getHeight() : this.maxHeight;
        Image image = null;
        if (this.imageResource != null){
            image = new Image(getClass().getResourceAsStream(this.imageResource), finalMaxWidth, finalMaxHeight, this.preserveRatio, false);
        } else if (this.imageUrl != null) {
            image = new Image(String.valueOf(this.imageUrl), finalMaxWidth, finalMaxHeight, this.preserveRatio, false);
        }
        return image;
    }

    /**
     * Sets preserve ratio.
     *
     * @param preserveRatio the preserve ratio
     * @return the preserve ratio
     */
    public MaxImageGetter setPreserveRatio(Boolean preserveRatio) {
        this.preserveRatio = preserveRatio;
        return this;
    }
}
