package com.appscharles.libs.fxer.factories;

import com.appscharles.libs.fxer.controllers.AbstractControllerFX;
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
     * @throws FxerException the fxer exception
     */
    void addStylesheet(String resourcePath);

    void setTitle(String title);

    void setController(AbstractControllerFX controller);

    void setIcon(String resourcePath) throws FxerException;
}
