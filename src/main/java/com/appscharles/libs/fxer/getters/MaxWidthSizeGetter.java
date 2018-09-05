package com.appscharles.libs.fxer.getters;

import javafx.scene.image.Image;

/**
 * The type Max width size getter.
 */
public class MaxWidthSizeGetter {

    public static Double get(Image image, Double maxWidth){
         return (image.getWidth() < maxWidth) ? image.getWidth() : maxWidth;
    }
}
