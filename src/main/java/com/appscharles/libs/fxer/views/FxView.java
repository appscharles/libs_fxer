package com.appscharles.libs.fxer.views;

import com.appscharles.libs.fxer.controllers.IClosableFX;
import com.appscharles.libs.fxer.controllers.ISetStagableFX;
import com.appscharles.libs.fxer.controllers.IViewShownableFX;
import com.appscharles.libs.fxer.controllers.IViewableFX;
import com.appscharles.libs.fxer.stages.FXStage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Window;
import org.reactfx.value.Val;

import java.io.IOException;
import java.util.List;

/**
 * The type Fx view.
 */
public class FxView {

    private FXMLLoader fXMLLoader;

    private List<String> resourceStylesheets;

    private FXStage fXStage;

    /**
     * Instantiates a new Fx view.
     *
     * @param fXMLLoader          the f xml loader
     * @param resourceStylesheets the resource stylesheets
     * @param fXStage             the f x stage
     */
    public FxView(FXMLLoader fXMLLoader, List<String> resourceStylesheets, FXStage fXStage) {
        this.fXMLLoader = fXMLLoader;
        this.resourceStylesheets = resourceStylesheets;
        this.fXStage=  fXStage;
    }

    /**
     * Gets fxml loader.
     *
     * @return the fxml loader
     */
    public FXMLLoader getFXMLLoader() {
        return fXMLLoader;
    }

    /**
     * Create view parent.
     *
     * @return the parent
     * @throws IOException the io exception
     */
    public Parent createView() throws IOException {
        ((IViewableFX)this.fXMLLoader.getController()).setFXView(this);
        ((ISetStagableFX)this.fXMLLoader.getController()).setFXStage(this.fXStage);
        Parent parent = this.fXMLLoader.load();
        parent.getStylesheets().addAll(this.resourceStylesheets);
        Val<Boolean> showing = Val.flatMap(parent.sceneProperty(), Scene::windowProperty)
                .flatMap(Window::showingProperty);
        parent.parentProperty().addListener((args, oldVal, newVal)->{
            if (newVal != null){
                ((IViewShownableFX)this.fXMLLoader.getController()).onShown();
            }
        });
        showing.addListener((args, oldVal, newVal)->{
            if (newVal == null){
                ((IClosableFX)this.fXMLLoader.getController()).onClose();
            } else if (oldVal != null) {
                if (newVal == false && oldVal == true){
                    ((IClosableFX)this.fXMLLoader.getController()).onClose();
                }
            }
        });
        return parent;
    }

    /**
     * Gets fx stage.
     *
     * @return the fx stage
     */
    public FXStage getFXStage() {
        return fXStage;
    }
}
