package com.appscharles.libs.fxer.getters;

import javafx.scene.image.Image;

/**
 * The type Max height size getter.
 */
public class MaxHeightSizeGetter {

    public static Double get(Image image, Double maxHeight){
         return (image.getHeight() < maxHeight) ? image.getHeight() : maxHeight;
    }
}
