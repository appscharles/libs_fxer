package com.appscharles.libs.fxer.factories;

import com.appscharles.libs.fxer.controllers.AbstractViewControllerFX;
import com.appscharles.libs.fxer.controls.UTF8Control;
import com.appscharles.libs.fxer.stages.FXStage;
import com.appscharles.libs.fxer.views.FxView;
import javafx.fxml.FXMLLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * The type Fx view factory.
 */
public class FxViewFactory {

    private ResourceBundle resourceBundle;

    private String resourceView;

    private List<String> resourceStylesheets;

    private AbstractViewControllerFX controller;

    private FXStage parentFXStage;

    /**
     * Instantiates a new Fx view factory.
     *
     * @param resourceView   the resource view
     * @param resourceBundle the resource bundle
     * @param controller     the controller
     * @param parentFXStage  the parent fx stage
     */
    public FxViewFactory(String resourceView, String resourceBundle, AbstractViewControllerFX controller, FXStage parentFXStage) {
        this(resourceView, ResourceBundle.getBundle(resourceBundle, new UTF8Control()), controller, parentFXStage);
    }

    /**
     * Instantiates a new Fx view factory.
     *
     * @param resourceView   the resource view
     * @param resourceBundle the resource bundle
     * @param controller     the controller
     * @param parentFXStage  the parent fx stage
     */
    public FxViewFactory(String resourceView, ResourceBundle resourceBundle, AbstractViewControllerFX controller, FXStage parentFXStage) {
        this.resourceView = resourceView;
        this.resourceBundle = resourceBundle;
        this.controller = controller;
        this.parentFXStage = parentFXStage;
        this.resourceStylesheets = new ArrayList<>();
    }

    /**
     * Create fx view.
     *
     * @return the fx view
     */
    public FxView create()  {
        FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource(this.resourceView), this.resourceBundle);
        fXMLLoader.setController(this.controller);
        return new FxView(fXMLLoader, this.resourceStylesheets, this.parentFXStage);
    }

    /**
     * Add stylesheet fx view factory.
     *
     * @param resourceStylesheet the resource stylesheet
     * @return the fx view factory
     */
    public FxViewFactory addStylesheet(String resourceStylesheet) {
        if (this.resourceStylesheets.contains(resourceStylesheet) == false) {
            this.resourceStylesheets.add(resourceStylesheet);
        }
        return this;
    }
}
