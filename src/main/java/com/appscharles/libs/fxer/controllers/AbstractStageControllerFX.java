package com.appscharles.libs.fxer.controllers;

import com.appscharles.libs.fxer.stages.FXStage;
import javafx.stage.WindowEvent;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * The type Abstract controller fx.
 */
public abstract class AbstractStageControllerFX implements IControllerFX, IStageShownableFX, IGetStagableFX,ISetStagableFX, IClosableFX {

    /**
     * The F x stage.
     */
    protected FXStage fXStage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public void onShown(WindowEvent event) {

    }

    @Override
    public void setFXStage(FXStage fXStage) {
        this.fXStage = fXStage;
        this.fXStage.showingProperty().addListener((args, oldVal, newVal)->{
            if (newVal == false){
                onClose();
            }
        });
    }

    @Override
    public FXStage getFXStage() {
        return this.fXStage;
    }

    @Override
    public void onClose() {

    }
}
