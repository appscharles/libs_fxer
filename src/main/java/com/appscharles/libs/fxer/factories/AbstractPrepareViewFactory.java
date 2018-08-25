package com.appscharles.libs.fxer.factories;

import com.appscharles.libs.fxer.stages.FXStage;

/**
 * The type Abstract view factory.
 */
public abstract class AbstractPrepareViewFactory implements IPrepareViewFactory {

    /**
     * The F x stage.
     */
    protected FXStage fXStage;


    @Override
    public void setFXStage(FXStage fxStage) {
        this.fXStage = fxStage;
    }

    @Override
    public FXStage getFXStage() {
        return this.fXStage;
    }

}
