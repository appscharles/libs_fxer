package com.appscharles.libs.fxer.factories;

import com.appscharles.libs.fxer.controllers.AbstractControllerFX;
import com.appscharles.libs.fxer.exceptions.FxerException;
import com.appscharles.libs.fxer.programs.viewer.ProgramControllerFX;
import com.appscharles.libs.fxer.stages.FXStage;
import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

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

    @Test
    public void shouldDisplayLatinCharacters() throws FxerException, InterruptedException {
        IFXStageFactory stageFactory = new FXStageFactory(
                "/com/appscharles/libs/fxer/programs/viewer/ProgramView.fxml",
                "com/appscharles/libs/fxer/programs/viewer/translations/Program");
        stageFactory.addStylesheet("/com/appscharles/libs/fxer/programs/viewer/ProgramStyle.css");
        stageFactory.setIcon("/com/appscharles/libs/fxer/programs/viewer/ProgramIcon.png");
        stageFactory.setController(new ProgramControllerFX());
        stageFactory.setTitle("MyApp");
        FXStage stage = stageFactory.create();
        stage.showFX();
        final ProgramControllerFX controllerFX = stage.getController();
        final String latin = controllerFX.getLatin();
        System.out.println(latin);

        Assert.assertEquals(latin,"ążćśęłńa");
    }

    @Test
    public void shouldGetEnglishTranslations() throws FxerException {
        Locale.setDefault(Locale.ENGLISH);
        IFXStageFactory stageFactory = new FXStageFactory(
                "/com/appscharles/libs/fxer/programs/viewer/ProgramView.fxml",
                "com/appscharles/libs/fxer/programs/viewer/translations/Program");
        stageFactory.addStylesheet("/com/appscharles/libs/fxer/programs/viewer/ProgramStyle.css");
        stageFactory.setIcon("/com/appscharles/libs/fxer/programs/viewer/ProgramIcon.png");
        stageFactory.setController(new ProgramControllerFX());
        stageFactory.setTitle("MyApp");
        FXStage stage = stageFactory.create();
        stage.showFX();
        Assert.assertTrue(stage.getTitle().equals("English program"));
    }

    @Test
    public void shouldGetPolishTranslations() throws FxerException {
        Locale.setDefault(new Locale("PL"));
        IFXStageFactory stageFactory = new FXStageFactory(
                "/com/appscharles/libs/fxer/programs/viewer/ProgramView.fxml",
                "com/appscharles/libs/fxer/programs/viewer/translations/Program");
        stageFactory.addStylesheet("/com/appscharles/libs/fxer/programs/viewer/ProgramStyle.css");
        stageFactory.setIcon("/com/appscharles/libs/fxer/programs/viewer/ProgramIcon.png");
        stageFactory.setController(new ProgramControllerFX());
        stageFactory.setTitle("MyApp");
        FXStage stage = stageFactory.create();
        stage.showFX();
        Assert.assertTrue(stage.getTitle().equals("Polish program"));
    }
}