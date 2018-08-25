package com.appscharles.libs.fxer.programs.childer;

import com.appscharles.libs.dialoger.factories.ExceptionDialogFactory;
import com.appscharles.libs.fxer.controllers.AbstractStageControllerFX;
import com.appscharles.libs.fxer.factories.FxViewFactory;
import com.appscharles.libs.fxer.views.FxView;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.WindowEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * The type Childer controller.
 */
public class ChilderController extends AbstractStageControllerFX {

    private static final Logger logger = LogManager.getLogger(ChilderController.class);

    @FXML
    private AnchorPane rightAnchorPane;

    private FxView view;

    public ChilderController(){

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Childer initialize");
        if (resources != null) {
            Platform.runLater(() -> {
                this.fXStage.setTitle(resources.getString("view.title_stage"));
            });

        }
        this.view = new FxViewFactory("/com/appscharles/libs/fxer/programs/childer/SubView.fxml",
                "com/appscharles/libs/fxer/programs/childer/translations/Sub", new SubController(), this.fXStage).create();
        try {
            this.rightAnchorPane.getChildren().add(this.view.createView());
        } catch (IOException e) {
            logger.error(e, e);
            ExceptionDialogFactory.create("Error", e.getMessage(), e).build().showAndWait();

        }
    }

    @Override
    public void onShown(WindowEvent event) {
        System.out.println("Childer on shown");
        this.rightAnchorPane.getChildren().clear();

    }

    @Override
    public void onClose() {
        System.out.println("Childer on close");
    }
}
