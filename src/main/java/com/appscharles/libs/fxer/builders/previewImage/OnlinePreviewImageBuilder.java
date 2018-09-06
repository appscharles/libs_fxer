package com.appscharles.libs.fxer.builders.previewImage;

import com.appscharles.libs.fxer.exceptions.FxerException;
import com.appscharles.libs.fxer.getters.MaxHeightSizeGetter;
import com.appscharles.libs.fxer.getters.MaxImageGetter;
import com.appscharles.libs.fxer.getters.MaxWidthSizeGetter;
import com.appscharles.libs.fxer.remembers.IImageOnlineRemember;
import com.appscharles.libs.fxer.setters.DelayTimeToolTipSetter;
import com.appscharles.libs.fxer.setters.GraphicTooltipSetter;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
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

    /**
     * The Image loading preserve ratio.
     */
    protected Boolean imageLoadingPreserveRatio;

    /**
     * The Image online remember.
     */
    protected IImageOnlineRemember imageOnlineRemember;

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
        BooleanProperty loadingLaunched = new SimpleBooleanProperty(false);
        Tooltip tooltip = new Tooltip();
        DelayTimeToolTipSetter.setDelay(this.durationOpen, this.durationVisible, this.durationClose, tooltip);
        tooltip.activatedProperty().addListener((a, o, n) -> {
            if (loadingLaunched.getValue() == false && n) {
                loadingLaunched.setValue(true);
                ObjectProperty<Image> previewImage = new SimpleObjectProperty<>();
                if (this.imageOnlineRemember != null && this.imageOnlineRemember.isRemember(this.imageUrl)) {
                    try {
                        previewImage.set(new Image(String.valueOf(this.imageOnlineRemember.getFile(this.imageUrl).toURI().toURL())));
                        GraphicTooltipSetter.set(tooltip, previewImage.getValue(), this.maxWidth, this.maxHeight, this.preserveRatio);
                        Image imageThumbnail = new Image(String.valueOf(this.imageOnlineRemember.getFile(this.imageUrl).toURI().toURL()), MaxWidthSizeGetter.get(previewImage.getValue(), this.maxWidthThumbnail), MaxHeightSizeGetter.get(previewImage.getValue(), this.maxHeightThumbnail), this.preserveRatioThumbnail, false);
                        Rectangle rectangle = ImageRectangleBuilder.create(imageThumbnail, this.roundCornersThumbnail, this.roundCornersThumbnail).build();
                        label.setGraphic(rectangle);
                    } catch (MalformedURLException e) {
                        logger.error(e, e);
                    }
                } else {
                    previewImage.setValue(new Image(String.valueOf(this.imageUrl), true));
                    previewImage.getValue().progressProperty().addListener((args, oldVal, newVal) -> {
                        if (newVal.doubleValue() >= 1.0) {
                            GraphicTooltipSetter.set(tooltip, previewImage.getValue(), this.maxWidth, this.maxHeight, this.preserveRatio);
                            if (this.imageOnlineRemember != null && this.imageOnlineRemember.isRemember(this.imageUrl) == false) {
                                try {
                                    tooltip.setOnHiding(event->{
                                        event.consume();
                                    });
                                    this.imageOnlineRemember.save(this.imageUrl, previewImage.getValue());
                                    Image imageThumbnail = new Image(String.valueOf(this.imageOnlineRemember.getFile(this.imageUrl).toURI().toURL()), MaxWidthSizeGetter.get(previewImage.getValue(), this.maxWidthThumbnail), MaxHeightSizeGetter.get(previewImage.getValue(), this.maxHeightThumbnail), this.preserveRatioThumbnail, false);
                                    Rectangle rectangle = ImageRectangleBuilder.create(imageThumbnail, this.roundCornersThumbnail, this.roundCornersThumbnail).build();
                                    label.setGraphic(rectangle);
                                } catch (MalformedURLException | FxerException e) {
                                    logger.error(e, e);
                                }
                            }
                        }
                    });
                }
            }
        });

        Image imageLoading = new MaxImageGetter(this.imageLoadingResource, this.loadingImageMaxWidth, this.loadingImageMaxHeight).setPreserveRatio(this.imageLoadingPreserveRatio).get();
        tooltip.setGraphic(new ImageView(imageLoading));

        Image imageThumbnail;
        if (this.imageOnlineRemember != null && this.imageOnlineRemember.isRemember(this.imageUrl)){
            try {
                imageThumbnail = new MaxImageGetter(this.imageOnlineRemember.getFile(this.imageUrl).toURI().toURL(), this.maxWidthThumbnail, this.maxHeightThumbnail).setPreserveRatio(this.preserveRatioThumbnail).get();
            } catch (MalformedURLException e) {
                throw new FxerException(e);
            }
        } else {
            imageThumbnail = new MaxImageGetter(this.thumbnailImageResource, this.maxWidthThumbnail, this.maxHeightThumbnail).setPreserveRatio(this.preserveRatioThumbnail).get();
        }
        Rectangle rectangle = ImageRectangleBuilder.create(imageThumbnail, this.roundCornersThumbnail, this.roundCornersThumbnail).build();
        Tooltip.install(label, tooltip);
        label.setGraphic(rectangle);
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
}
