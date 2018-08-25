package com.appscharles.libs.fxer.programs.childer;

import com.appscharles.libs.fxer.TestCase;
import com.appscharles.libs.fxer.exceptions.FxerException;
import com.appscharles.libs.fxer.factories.FXStageFactory;
import com.appscharles.libs.fxer.factories.IFXStageFactory;
import com.appscharles.libs.fxer.stages.FXStage;
import org.junit.Test;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 21.08.2018
 * Time: 13:30
 * Project name: fxer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class ChilderControllerTest extends TestCase {

    @Test
    public void shouldOpenStage() throws FxerException {
        IFXStageFactory stageFactory = new FXStageFactory(
                "/com/appscharles/libs/fxer/programs/childer/ChilderView.fxml",
                "com/appscharles/libs/fxer/programs/childer/translations/Childer");
        stageFactory.setController(new ChilderController());
        FXStage stage = stageFactory.create();
        stage.showFX();
    }
}