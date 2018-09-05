package com.appscharles.libs.fxer.builders.previewImage;

/**
 * The type Abstract preview image.
 */
public abstract class AbstractPreviewImage implements IPreviewImage {

    /**
     * The Thumbnail width.
     */
    protected Double maxWidthThumbnail;

    /**
     * The Max width.
     */
    protected Double maxWidth;

    /**
     * The Max height.
     */
    protected Double maxHeight;

    /**
     * The Thumbnail height.
     */
    protected Double maxHeightThumbnail;

    /**
     * The Preserve ratio.
     */
    protected Boolean preserveRatio;

    /**
     * The Preserve ratio thumbnail.
     */
    protected Boolean preserveRatioThumbnail;

    /**
     * The Duration open.
     */
    protected Integer durationOpen;

    /**
     * The Duration visible.
     */
    protected Integer durationVisible;

    /**
     * The Duration close.
     */
    protected Integer durationClose;

    /**
     * The Round corners thumbnail.
     */
    protected Double roundCornersThumbnail;


    /**
     * Instantiates a new Abstract preview image.
     */
    protected AbstractPreviewImage() {
        this.maxWidth = 800.0;
        this.maxHeight = 600.0;
        this.maxWidthThumbnail = 200.0;
        this.maxHeightThumbnail = 100.0;
        this.durationOpen = 50;
        this.durationVisible = 60000;
        this.durationClose = 50;
        this.preserveRatio = true;
        this.preserveRatioThumbnail = true;
        this.roundCornersThumbnail = 0.0;
    }

    @Override
    public <T> T setPreserveRatio(Boolean preserveRatio) {
        this.preserveRatio = preserveRatio;
        return (T) this;
    }

    @Override
    public <T> T setPreserveRatioThumbnail(Boolean preserveRatioThumbnail) {
        this.preserveRatioThumbnail = preserveRatioThumbnail;
        return (T) this;
    }

    @Override
    public <T> T setMaxWidthThumbnail(Double maxWidthThumbnail) {
        this.maxWidthThumbnail = maxWidthThumbnail;
        return (T) this;
    }

    @Override
    public <T> T setMaxHeightThumbnail(Double maxHeightThumbnail) {
        this.maxHeightThumbnail = maxHeightThumbnail;
        return (T) this;
    }

    @Override
    public <T> T setMaxWidth(Double maxWidth) {
        this.maxWidth = maxWidth;
        return (T) this;
    }

    @Override
    public <T> T setMaxHeight(Double maxHeight) {
        this.maxHeight = maxHeight;
        return (T) this;
    }

    @Override
    public <T> T setDurationOpen(Integer durationOpen) {
        this.durationOpen = durationOpen;
        return (T) this;
    }

    @Override
    public <T> T setDurationVisible(Integer durationVisible) {
        this.durationVisible = durationVisible;
        return (T) this;
    }

    @Override
    public <T> T setDurationClose(Integer durationClose) {
        this.durationClose = durationClose;
        return (T) this;
    }

    @Override
    public <T> T setRoundCornersThumbnail(Double roundCornersThumbnail) {
        this.roundCornersThumbnail = roundCornersThumbnail;
        return (T) this;
    }
}
