package com.appscharles.libs.fxer.programs.viewer;

import com.appscharles.libs.fxer.controllers.AbstractStageControllerFX;
import javafx.application.Platform;
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
public class ProgramControllerFX extends AbstractStageControllerFX {

    @FXML
    private TextField username;

    private String latin;

    private String result;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("initialize");
       if (resources != null){
           this.latin = resources.getString("view.test_latin");
           Platform.runLater(()->{
               this.fXStage.setTitle(resources.getString("view.title_stage"));
           });
       }
    }

    @Override
    public void onShown(WindowEvent event) {
        System.out.println("on shown");
        this.result = "result";
    }

    public String getLatin() {
        return latin;
    }

    public String getResult() {
        return this.result;
    }
}
