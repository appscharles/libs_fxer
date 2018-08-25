package com.appscharles.libs.fxer.factories;

import com.appscharles.libs.fxer.controllers.IGetStagableFX;
import com.appscharles.libs.fxer.controllers.ISetStagableFX;
import com.appscharles.libs.fxer.exceptions.FxerException;
import com.appscharles.libs.fxer.stages.FXStage;

/**
 * The interface Ifx stage factory.
 */
public interface IFXStageFactory extends IStageIconable, IStageStylable, IGetStagableFX {

    /**
     * Create fx stage.
     *
     * @return the fx stage
     * @throws FxerException the fxer exception
     */
    FXStage create() throws FxerException;


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
    void setController(ISetStagableFX controller);
}
