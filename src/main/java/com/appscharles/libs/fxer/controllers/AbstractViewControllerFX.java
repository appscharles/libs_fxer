package com.appscharles.libs.fxer.controllers;

import com.appscharles.libs.fxer.stages.FXStage;
import com.appscharles.libs.fxer.views.FxView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * The type Abstract view controller fx.
 */
public abstract class AbstractViewControllerFX implements IControllerFX, IViewShownableFX, IGetStagableFX, ISetStagableFX, IViewableFX, IClosableFX {

    /**
     * The Fx view.
     */
    protected FxView fxView;

    /**
     * The F x stage.
     */
    protected FXStage fxStage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public void onShown() {

    }

    @Override
    public void setFXStage(FXStage fxStage) {
        this.fxStage = fxStage;
    }

    @Override
    public FXStage getFXStage() {
        return this.fxStage;
    }



    @Override
    public void setFXView(FxView fxView) {
this.fxView = fxView;
    }

    @Override
    public FxView getFXView() {
        return this.fxView;
    }

    @Override
    public void onClose() {

    }
}
