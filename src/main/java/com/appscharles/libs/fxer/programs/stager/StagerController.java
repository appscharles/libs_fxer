package com.appscharles.libs.fxer.programs.stager;

import com.appscharles.libs.fxer.controllers.AbstractControllerFX;
import com.appscharles.libs.fxer.exceptions.FxerException;
import com.appscharles.libs.fxer.factories.FXStageFactory;
import com.appscharles.libs.fxer.factories.IFXStageFactory;
import com.appscharles.libs.fxer.programs.viewer.ProgramControllerFX;
import com.appscharles.libs.fxer.stages.FXStage;
import javafx.application.Platform;
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
public class StagerController extends AbstractControllerFX {

    private String result;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       if (resources != null){
           Platform.runLater(()->{
               this.fXStage.setTitle(resources.getString("view.title_stage"));
           });
       }
    }

    @Override
    public void onShown(WindowEvent event) {
        try {
            openStage();
            Thread.sleep(2000);
        } catch (FxerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void openStage() throws FxerException {
        IFXStageFactory stageFactory = new FXStageFactory(
                "/com/appscharles/libs/fxer/programs/viewer/ProgramView.fxml",
                "com/appscharles/libs/fxer/programs/viewer/translations/Program");
        stageFactory.addStylesheet("/com/appscharles/libs/fxer/programs/viewer/ProgramStyle.css");
        stageFactory.setIcon("/com/appscharles/libs/fxer/programs/viewer/ProgramIcon.png");
        ProgramControllerFX controller = new ProgramControllerFX();
        stageFactory.setController(controller);
        stageFactory.setTitle("MyApp");
        FXStage stage = stageFactory.create();
        stage.show();
        this.result = controller.getResult();
    }

    public String getResult() {
        return this.result;
    }
}
