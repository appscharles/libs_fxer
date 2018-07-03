package com.appscharles.libs.fxer.controllers;

import com.appscharles.libs.fxer.stages.FXStage;
import javafx.stage.WindowEvent;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 03.07.2018
 * Time: 14:37
 * Project name: fxer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public abstract class AbstractControllerFX implements IControllerFX, IShownableFX, IStagableFX {

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
    }
}
