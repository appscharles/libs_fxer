package com.appscharles.libs.fxer.programs.viewer;

import com.appscharles.libs.fxer.controllers.AbstractControllerFX;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.WindowEvent;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 03.07.2018
 * Time: 14:36
 * Project name: fxer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class ProgramControllerFX extends AbstractControllerFX {

    @FXML
    private TextField username;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("initialize");
    }

    @Override
    public void onShown(WindowEvent event) {
        System.out.println("on shown");
    }
}
