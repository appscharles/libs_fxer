package com.appscharles.libs.fxer.programs.popuper;

import com.appscharles.libs.fxer.exceptions.FxerException;
import com.appscharles.libs.fxer.factories.AbstractPrepareViewFactory;
import com.appscharles.libs.fxer.factories.FxViewFactory;
import com.appscharles.libs.fxer.views.FxView;
import javafx.scene.Parent;

import java.io.IOException;

/**
 * The type Popuper view factory.
 */
public class PopuperViewFactory extends AbstractPrepareViewFactory {


    public Parent create() throws FxerException {
        try {
           PopuperController controller = new PopuperController();
            FxViewFactory factory = new FxViewFactory("/com/appscharles/libs/fxer/programs/popuper/PopuperView.fxml",
                    "com/appscharles/libs/fxer/programs/popuper/Popuper", controller, this.fXStage);
            FxView fxView = factory.create();
            return fxView.createView();
        } catch (IOException e) {
            throw new FxerException(e);
        }
    }
}