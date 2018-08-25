package com.appscharles.libs.fxer.programs.childer;

import com.appscharles.libs.fxer.controllers.AbstractViewControllerFX;
import com.appscharles.libs.fxer.exceptions.FxerException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * The type Childer controller.
 */
public class SubController extends AbstractViewControllerFX {

    @FXML
    private Button testButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Initialize sub controller");
        this.testButton.setText("New text");
    }

    @Override
    public void onShown() {
        System.out.println("Sub on shown");
        try {
            this.fxStage.closeFX();
        } catch (FxerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClose() {
        System.out.println("Sub on close");
    }
}
