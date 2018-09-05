package com.appscharles.libs.fxer.builders.previewImage;

import com.appscharles.libs.fxer.exceptions.FxerException;
import com.appscharles.libs.fxer.getters.MaxHeightSizeGetter;
import com.appscharles.libs.fxer.getters.MaxWidthSizeGetter;
import com.appscharles.libs.fxer.setters.DelayTimeToolTipSetter;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.net.MalformedURLException;

/**
 * The type Preview image builder.
 */
public class PreviewImageBuilder extends AbstractPreviewImage {

    /**
     * The Image file.
     */
    protected File imageFile;

    /**
     * Create preview image builder.
     *
     * @param imageFile       the image file
     * @param maxHeight       the max height
     * @param thumbnailHeight the thumbnail height
     * @return the preview image builder
     */
    public static PreviewImageBuilder create(File imageFile, Double maxHeight, Double thumbnailHeight) {
        PreviewImageBuilder instance = new PreviewImageBuilder();
        instance.imageFile = imageFile;
        instance.maxHeight = maxHeight;
        instance.maxHeightThumbnail = thumbnailHeight;
        return instance;
    }

    /**
     * Build parent.
     *
     * @return the parent
     * @throws FxerException the fxer exception
     */
    public Parent build() throws FxerException {
        try {
            Image imagePreview = new Image(String.valueOf(this.imageFile.toURI().toURL()), this.maxWidth, this.maxHeight, this.preserveRatio, false);
            Tooltip tooltip = new Tooltip();
            DelayTimeToolTipSetter.setDelay(this.durationOpen, this.durationVisible, this.durationClose, tooltip);

            ImageView previewImageView = new ImageView(imagePreview);
            previewImageView.setFitWidth(MaxWidthSizeGetter.get(imagePreview, this.maxWidth));
            previewImageView.setFitHeight(MaxHeightSizeGetter.get(imagePreview, this.maxHeight));
            previewImageView.setPreserveRatio(this.preserveRatio);
            tooltip.setGraphic(previewImageView);

            Image thumbnailImage = new Image(String.valueOf(this.imageFile.toURI().toURL()), MaxWidthSizeGetter.get(imagePreview, this.maxWidthThumbnail), MaxHeightSizeGetter.get(imagePreview, this.maxHeightThumbnail), this.preserveRatioThumbnail, false);

            Rectangle rectangle = new Rectangle(thumbnailImage.getWidth(), thumbnailImage.getHeight());
            rectangle.setFill(new ImagePattern(thumbnailImage));
            rectangle.setArcWidth(this.roundCornersThumbnail);
            rectangle.setArcHeight(this.roundCornersThumbnail);
            Tooltip.install(rectangle, tooltip);
            Label label = new Label();
            label.setGraphic(rectangle);
            return label;
        } catch (MalformedURLException e) {
            throw new FxerException(e);
        }
    }
}
