package com.appscharles.libs.fxer.factories;

import com.appscharles.libs.fxer.controllers.ISetStagableFX;
import com.appscharles.libs.fxer.controllers.IStageShownableFX;
import com.appscharles.libs.fxer.controls.UTF8Control;
import com.appscharles.libs.fxer.exceptions.FxerException;
import com.appscharles.libs.fxer.runners.ThreadPlatform;
import com.appscharles.libs.fxer.stages.FXStage;
import com.sun.javafx.application.PlatformImpl;
import javafx.fxml.FXMLLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

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
        this(view, (ResourceBundle) null);
    }

    public AbstractFXStageFactory(String view, ResourceBundle resourceBundle) throws FxerException {
        this.view = view;
        this.resourceStylesheetPaths = new ArrayList<>();
        PlatformImpl.startup(()->{});
        this.fXMLLoader = new FXMLLoader(getClass().getResource(this.view), resourceBundle);
        initFXStage();
    }

    public AbstractFXStageFactory(String view, String resourceBundle) throws FxerException {
        this(view, ResourceBundle.getBundle(resourceBundle, new UTF8Control()));
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
    public void setController(ISetStagableFX controller) {
        controller.setFXStage(this.fXStage);
        this.fXMLLoader.setController(controller);
    }

    @Override
    public <T> T setIcon(String resourcePath) throws FxerException {
        this.fXStage.setIcon(resourcePath);
        return (T) this;
    }

    private void initFXStage() throws FxerException {
      new ThreadPlatform<FxerException>().runAndWait(()->{
          this.fXStage = new FXStage(this.fXMLLoader);
      });
    }

    protected void setControllerEvents() {
        ISetStagableFX controller = this.fXStage.getController();
        if (controller != null) {
            this.fXStage.setOnShown((event -> {
                if (controller instanceof IStageShownableFX){
                    ((IStageShownableFX)controller).onShown(event);
                }
            }));
        }
    }

    @Override
    public FXStage getFXStage() {
        return this.fXStage;
    }

}
