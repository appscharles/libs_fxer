package com.appscharles.libs.fxer.guis.popup;

import com.appscharles.libs.fxer.exceptions.FxerException;
import com.appscharles.libs.fxer.factories.FXStageFactory;
import com.appscharles.libs.fxer.factories.IFXStageFactory;
import com.appscharles.libs.fxer.factories.IPrepareViewFactory;
import com.appscharles.libs.fxer.stages.FXStage;
import javafx.stage.Modality;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Popup stage.
 */
public class PopupStage {

    private IPrepareViewFactory viewFactory;

    private Boolean withWait;

    private String resourceIcon;

    private List<String> stylesheets;

    /**
     * Instantiates a new Popup stage.
     *
     * @param viewFactory the view factory
     */
    public PopupStage(IPrepareViewFactory viewFactory) {
        this.viewFactory = viewFactory;
        this.withWait = true;
        this.stylesheets = new ArrayList<>();
    }


    /**
     * Show fx.
     *
     * @throws FxerException the fxer exception
     */
    public void showFx() throws FxerException {
        IFXStageFactory stageFactory = new FXStageFactory("/com/appscharles/libs/fxer/guis/popup/PopupView.fxml");
        this.viewFactory.setFXStage(stageFactory.getFXStage());
        if (this.resourceIcon != null){
            stageFactory.setIcon(this.resourceIcon);
        }
        for (String stylesheet : this.stylesheets) {
            stageFactory.addStylesheet(stylesheet);
        }
        stageFactory.setController(new PopupController(this.viewFactory));
        FXStage stage = stageFactory.create();
        stage.initModality(Modality.APPLICATION_MODAL);
        if (this.withWait){
            stage.showAndWaitFX();
        } else {
            stage.showFX();
        }
    }

    /**
     * Sets with wait.
     *
     * @param withWait the with wait
     * @return the with wait
     */
    public PopupStage setWithWait(Boolean withWait) {
        this.withWait = withWait;
        return this;
    }

    /**
     * Sets resource icon.
     *
     * @param resourceIcon the resource icon
     * @return the resource icon
     */
    public PopupStage setResourceIcon(String resourceIcon) {
        this.resourceIcon = resourceIcon;
        return this;
    }

    /**
     * Add stylesheet popup stage.
     *
     * @param stylesheet the stylesheet
     * @return the popup stage
     */
    public PopupStage addStylesheet(String stylesheet){
        this.stylesheets.add(stylesheet);
        return this;
    }

    /**
     * Gets stylesheets.
     *
     * @return the stylesheets
     */
    public List<String> getStylesheets() {
        return stylesheets;
    }
}
