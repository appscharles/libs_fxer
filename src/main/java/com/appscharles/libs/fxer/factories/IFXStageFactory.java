package com.appscharles.libs.fxer.factories;

import com.appscharles.libs.fxer.controllers.IStagableFX;
import com.appscharles.libs.fxer.exceptions.FxerException;
import com.appscharles.libs.fxer.stages.FXStage;

/**
 * The interface Ifx stage factory.
 */
public interface IFXStageFactory {

    /**
     * Create fx stage.
     *
     * @return the fx stage
     * @throws FxerException the fxer exception
     */
    FXStage create() throws FxerException;

    /**
     * Add stylesheet.
     *
     * @param resourcePath the resource path
     */
    void addStylesheet(String resourcePath);

    /**
     * Sets title.
     *
     * @param title the title
     */
    void setTitle(String title);

    /**
     * Sets controller.
     *
     * @param controller the controller
     */
    void setController(IStagableFX controller);

    /**
     * Sets icon.
     *
     * @param resourcePath the resource path
     * @throws FxerException the fxer exception
     */
    void setIcon(String resourcePath) throws FxerException;
}
