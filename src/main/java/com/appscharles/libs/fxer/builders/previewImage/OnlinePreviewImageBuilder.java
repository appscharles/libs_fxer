package com.appscharles.libs.fxer.builders.previewImage;

import com.appscharles.libs.fxer.exceptions.FxerException;
import com.appscharles.libs.fxer.getters.MaxHeightSizeGetter;
import com.appscharles.libs.fxer.getters.MaxImageGetter;
import com.appscharles.libs.fxer.getters.MaxImageViewGetter;
import com.appscharles.libs.fxer.getters.MaxWidthSizeGetter;
import com.appscharles.libs.fxer.remembers.IImageOnlineRemember;
import com.appscharles.libs.fxer.stages.FXStage;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ListChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * The type Online preview image builder.
 */
public class OnlinePreviewImageBuilder extends AbstractPreviewImage {

    private static final Logger logger = LogManager.getLogger(OnlinePreviewImageBuilder.class);

    /**
     * The Image url.
     */
    protected URL imageUrl;

    /**
     * The Thumbnail image resource.
     */
    protected String thumbnailImageResource;

    /**
     * The Image loading resource.
     */
    protected String imageLoadingResource;

    /**
     * The Loading image max width.
     */
    protected Double loadingImageMaxWidth;

    /**
     * The Loading image max height.
     */
    protected Double loadingImageMaxHeight;

    protected Double loadingImagePadding;

    /**
     * The Image loading preserve ratio.
     */
    protected Boolean imageLoadingPreserveRatio;

    /**
     * The Image online remember.
     */
    protected IImageOnlineRemember imageOnlineRemember;

    protected String title;

    /**
     * Create online preview image builder.
     *
     * @param imageUrl           the image url
     * @param maxHeight          the max height
     * @param maxHeightThumbnail the max height thumbnail
     * @return the online preview image builder
     */
    public static OnlinePreviewImageBuilder create(URL imageUrl, Double maxHeight, Double maxHeightThumbnail) {
        OnlinePreviewImageBuilder instance = new OnlinePreviewImageBuilder();
        instance.imageUrl = imageUrl;
        instance.maxHeight = maxHeight;
        instance.maxHeightThumbnail = maxHeightThumbnail;
        instance.imageLoadingResource = "/com/appscharles/libs/fxer/builders/previewImage/LoadingIcon.gif";
        instance.thumbnailImageResource = "/com/appscharles/libs/fxer/builders/previewImage/PreviewImageIcon.png";
        instance.loadingImageMaxWidth = 900.0;
        instance.loadingImageMaxHeight = 900.0;
        instance.imageLoadingPreserveRatio = true;
        instance.loadingImagePadding = 0.0;
        instance.title = "";
        return instance;
    }

    /**
     * Build parent.
     *
     * @return the parent
     * @throws FxerException the fxer exception
     */
    public Parent build() throws FxerException {
        Label label = new Label();
        StackPane imageContainer = new StackPane();
        ObjectProperty<Image> previewImage = new SimpleObjectProperty<>();
        if (this.imageOnlineRemember != null && this.imageOnlineRemember.isRemember(this.imageUrl)) {
            try {
                previewImage.set(new Image(String.valueOf(this.imageOnlineRemember.getFile(this.imageUrl).toURI().toURL())));
                Image imageThumbnail = new Image(String.valueOf(this.imageOnlineRemember.getFile(this.imageUrl).toURI().toURL()), MaxWidthSizeGetter.get(previewImage.getValue(), this.maxWidthThumbnail), MaxHeightSizeGetter.get(previewImage.getValue(), this.maxHeightThumbnail), this.preserveRatioThumbnail, false);
                Rectangle rectangle = ImageRectangleBuilder.create(imageThumbnail, this.roundCornersThumbnail, this.roundCornersThumbnail).build();
                label.setGraphic(rectangle);
                imageContainer.getChildren().clear();
                imageContainer.getChildren().add(new MaxImageViewGetter(previewImage.getValue(), this.maxWidth, this.maxHeight, this.preserveRatio).get());
            } catch (MalformedURLException e) {
                logger.error(e, e);
            }
        }

        Image imageThumbnail;
        if (this.imageOnlineRemember != null && this.imageOnlineRemember.isRemember(this.imageUrl)) {
            try {
                imageThumbnail = new MaxImageGetter(this.imageOnlineRemember.getFile(this.imageUrl).toURI().toURL(), this.maxWidthThumbnail, this.maxHeightThumbnail).setPreserveRatio(this.preserveRatioThumbnail).get();
            } catch (MalformedURLException e) {
                throw new FxerException(e);
            }
        } else {
            imageThumbnail = new MaxImageGetter(this.thumbnailImageResource, this.maxWidthThumbnail, this.maxHeightThumbnail).setPreserveRatio(this.preserveRatioThumbnail).get();
        }
        Rectangle rectangle = ImageRectangleBuilder.create(imageThumbnail, this.roundCornersThumbnail, this.roundCornersThumbnail).build();
        label.setGraphic(rectangle);
        label.setOnMouseClicked(event->{
            if (this.imageOnlineRemember == null || this.imageOnlineRemember.isRemember(this.imageUrl) == false) {
                Image imageLoading = new MaxImageGetter(this.imageLoadingResource, this.loadingImageMaxWidth, this.loadingImageMaxHeight).setPreserveRatio(this.imageLoadingPreserveRatio).get();
                imageContainer.getChildren().clear();
                StackPane stack = new StackPane();
                stack.setPadding(new Insets(this.loadingImagePadding));
                stack.getChildren().add(new ImageView(imageLoading));
                imageContainer.getChildren().add(stack);
                previewImage.setValue(new Image(String.valueOf(this.imageUrl), true));
                previewImage.getValue().progressProperty().addListener((args, oldVal, newVal) -> {
                    if (newVal.doubleValue() >= 1.0) {
                        imageContainer.getChildren().clear();
                        imageContainer.getChildren().add(new MaxImageViewGetter(previewImage.getValue(), this.maxWidth, this.maxHeight, this.preserveRatio).get());
                        if (this.imageOnlineRemember != null && this.imageOnlineRemember.isRemember(this.imageUrl) == false) {
                            try {
                                this.imageOnlineRemember.save(this.imageUrl, previewImage.getValue());
                                Image newImageThumbnail = new Image(String.valueOf(this.imageOnlineRemember.getFile(this.imageUrl).toURI().toURL()), MaxWidthSizeGetter.get(previewImage.getValue(), this.maxWidthThumbnail), MaxHeightSizeGetter.get(previewImage.getValue(), this.maxHeightThumbnail), this.preserveRatioThumbnail, false);
                                Rectangle newRectangle = ImageRectangleBuilder.create(newImageThumbnail, this.roundCornersThumbnail, this.roundCornersThumbnail).build();
                                label.setGraphic(newRectangle);
                            } catch (MalformedURLException | FxerException e) {
                                logger.error(e, e);
                            }
                        }
                    }
                });
            }
            FXStage fxStage = new FXStage(null);
            fxStage.setResizable(false);
            fxStage.setTitle(this.title);
            fxStage.getIcons().add(new Image(this.thumbnailImageResource));
            StackPane stackPane = new StackPane();
            imageContainer.getChildren().addListener((ListChangeListener.Change<? extends Node> n)->{
                if (imageContainer.getChildren().size() > 0){
                    try {
                        fxStage.sizeToSceneFX();
                        fxStage.centerOnScreen();
                    } catch (FxerException e) {
                        logger.error(e, e);
                    }
                }
            });
            stackPane.getChildren().add(imageContainer);
            stackPane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
            Scene scene = new Scene(stackPane);
            fxStage.setScene(scene);
            try {
                fxStage.initModality(Modality.APPLICATION_MODAL);
                fxStage.sizeToSceneFX();
                fxStage.showAndWaitFX();
            } catch (FxerException e) {
                logger.error(e, e);
            }
        });
        return label;
    }

    /**
     * Sets image loading resource.
     *
     * @param imageLoadingResource the image loading resource
     * @return the image loading resource
     */
    public OnlinePreviewImageBuilder setImageLoadingResource(String imageLoadingResource) {
        this.imageLoadingResource = imageLoadingResource;
        return this;
    }

    /**
     * Sets loading image max width.
     *
     * @param loadingImageMaxWidth the loading image max width
     * @return the loading image max width
     */
    public OnlinePreviewImageBuilder setLoadingImageMaxWidth(Double loadingImageMaxWidth) {
        this.loadingImageMaxWidth = loadingImageMaxWidth;
        return this;
    }

    /**
     * Sets loading image max height.
     *
     * @param loadingImageMaxHeight the loading image max height
     * @return the loading image max height
     */
    public OnlinePreviewImageBuilder setLoadingImageMaxHeight(Double loadingImageMaxHeight) {
        this.loadingImageMaxHeight = loadingImageMaxHeight;
        return this;
    }

    /**
     * Sets image loading preserve ratio.
     *
     * @param imageLoadingPreserveRatio the image loading preserve ratio
     * @return the image loading preserve ratio
     */
    public OnlinePreviewImageBuilder setImageLoadingPreserveRatio(Boolean imageLoadingPreserveRatio) {
        this.imageLoadingPreserveRatio = imageLoadingPreserveRatio;
        return this;
    }

    /**
     * Sets thumbnail image resource.
     *
     * @param thumbnailImageResource the thumbnail image resource
     * @return the thumbnail image resource
     */
    public OnlinePreviewImageBuilder setThumbnailImageResource(String thumbnailImageResource) {
        this.thumbnailImageResource = thumbnailImageResource;
        return this;
    }

    /**
     * Sets image online remember.
     *
     * @param imageOnlineRemember the image online remember
     * @return the image online remember
     */
    public OnlinePreviewImageBuilder setImageOnlineRemember(IImageOnlineRemember imageOnlineRemember) {
        this.imageOnlineRemember = imageOnlineRemember;
        return this;
    }

    /**
     * Setter for property 'loadingImagePadding'.
     *
     * @param loadingImagePadding Value to set for property 'loadingImagePadding'.
     */
    public OnlinePreviewImageBuilder setLoadingImagePadding(Double loadingImagePadding) {
        this.loadingImagePadding = loadingImagePadding;
        return this;
    }

    public OnlinePreviewImageBuilder setTitle(String title) {
        this.title = title;
        return this;
    }
}
