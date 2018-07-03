package com.appscharles.libs.fxer.factories;

import com.appscharles.libs.fxer.controllers.AbstractControllerFX;
import com.appscharles.libs.fxer.exceptions.FxerException;
import com.appscharles.libs.fxer.runners.PlatformRunner;
import com.appscharles.libs.fxer.stages.FXStage;
import com.sun.javafx.application.PlatformImpl;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.FutureTask;

/**
 * The type Abstract stage factory.
 */
public abstract class AbstractFXStageFactory implements IFXStageFactory {

    protected String view;

    protected String title;

    protected List<String> resourceStylesheetPaths;

    protected FXMLLoader fXMLLoader;

    protected FXStage fXStage;

    public AbstractFXStageFactory(String view) throws FxerException {
        this.view = view;
        this.resourceStylesheetPaths = new ArrayList<>();
        PlatformImpl.startup(()->{});
        this.fXMLLoader = new FXMLLoader(getClass().getResource(this.view));
        initFXStage();
    }

    @Override
    public void addStylesheet(String resourcePath) {
        this.resourceStylesheetPaths.add(resourcePath);
    }

    /**
     * Setter for property 'title'.
     *
     * @param title Value to set for property 'title'.
     */
    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setController(AbstractControllerFX controller) {
        controller.setFXStage(this.fXStage);
        this.fXMLLoader.setController(controller);
    }

    @Override
    public void setIcon(String resourcePath) throws FxerException {
        this.fXStage.getIcons().add(new Image(getClass().getResourceAsStream(resourcePath)));
    }

    private void initFXStage() throws FxerException {
        PlatformRunner.runLater(new FutureTask(()->{
            this.fXStage = new FXStage(this.fXMLLoader);
            return null;
        }));
    }

    protected void setControllerEvents() {
        AbstractControllerFX controller = this.fXStage.getController();
        if (controller != null) {
            this.fXStage.setOnShown((event -> {
                controller.onShown(event);
            }));
        }
    }
}
