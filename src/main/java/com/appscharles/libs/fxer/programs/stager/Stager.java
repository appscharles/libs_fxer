package com.appscharles.libs.fxer.programs.stager;

import com.appscharles.libs.fxer.exceptions.FxerException;
import com.appscharles.libs.fxer.factories.FXStageFactory;
import com.appscharles.libs.fxer.factories.IFXStageFactory;
import com.appscharles.libs.fxer.stages.FXStage;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 16.07.2018
 * Time: 17:53
 * Project name: fxer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class Stager {

    public static String getResult() throws FxerException {
        IFXStageFactory stageFactory = new FXStageFactory(
                "/com/appscharles/libs/fxer/programs/stager/StagerView.fxml",
                "com/appscharles/libs/fxer/programs/stager/translations/Stager");
        StagerController controller = new StagerController();
        stageFactory.setController(controller);
        stageFactory.setTitle("MyApp");
        FXStage stage = stageFactory.create();
        stage.showFX();
        return controller.getResult();
    }
}
