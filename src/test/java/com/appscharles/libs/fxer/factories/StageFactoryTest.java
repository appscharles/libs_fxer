package com.appscharles.libs.fxer.factories;

import com.appscharles.libs.fxer.controllers.AbstractControllerFX;
import com.appscharles.libs.fxer.exceptions.FxerException;
import com.appscharles.libs.fxer.programs.viewer.ProgramControllerFX;
import com.appscharles.libs.fxer.stages.FXStage;
import org.junit.Assert;
import org.junit.Test;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 03.07.2018
 * Time: 12:44
 * Project name: fxer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class StageFactoryTest {

    @Test
    public void shouldShowStage() throws FxerException, InterruptedException {
        IFXStageFactory stageFactory = new FXStageFactory("/com/appscharles/libs/fxer/programs/viewer/ProgramView.fxml");
        stageFactory.addStylesheet("/com/appscharles/libs/fxer/programs/viewer/ProgramStyle.css");
        stageFactory.setIcon("/com/appscharles/libs/fxer/programs/viewer/ProgramIcon.png");
        stageFactory.setController(new ProgramControllerFX());
        stageFactory.setTitle("MyApp");
        FXStage stage = stageFactory.create();
        stage.showFX();

        AbstractControllerFX controllerFX = stage.getController();
        Assert.assertNotNull(controllerFX);
        Assert.assertTrue(stage.isShowing());
    }
}