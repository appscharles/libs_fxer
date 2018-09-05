package com.appscharles.libs.fxer.builders.previewImage;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

/**
 * The type Image rectangle builder.
 */
public class ImageRectangleBuilder {

    private Image image;

    private Double arcWidth;

    private Double arcHeight;

    private ImageRectangleBuilder(){

    }

    /**
     * Create image rectangle builder.
     *
     * @param image        the image
     * @param roundCorners the round corners
     * @return the image rectangle builder
     */
    public static ImageRectangleBuilder create(Image image, Double arcWidth, Double arcHeight){
        ImageRectangleBuilder instance = new ImageRectangleBuilder();
        instance.image = image;
        instance.arcWidth = arcWidth;
        instance.arcHeight = arcHeight;
        return instance;
    }

    /**
     * Build rectangle.
     *
     * @return the rectangle
     */
    public Rectangle build(){
        Rectangle rectangle = new Rectangle(this.image.getWidth(), this.image.getHeight());
        rectangle.setFill(new ImagePattern(this.image));
        rectangle.setArcWidth(this.arcWidth);
        rectangle.setArcHeight(this.arcHeight);
        return rectangle;
    }
}
