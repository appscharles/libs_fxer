package com.appscharles.libs.fxer.factories;

import com.appscharles.libs.fxer.exceptions.FxerException;
import com.appscharles.libs.fxer.runners.PlatformRunner;
import com.appscharles.libs.fxer.stages.FXStage;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.ResourceBundle;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 03.07.2018
 * Time: 10:28
 * Project name: fxer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class FXStageFactory extends AbstractFXStageFactory {

    public FXStageFactory(String view) throws FxerException {
        super(view);
    }

    public FXStageFactory(String view, ResourceBundle resourceBundle) throws FxerException {
        super(view, resourceBundle);
    }

    public FXStageFactory(String view, String resource) throws FxerException {
        super(view, resource);
    }

    @Override
    public FXStage create() throws FxerException {
        PlatformRunner.runAndWait(() -> {
            try {
                Scene scene = new Scene(this.fXMLLoader.load());
                scene.getStylesheets().addAll(this.resourceStylesheetPaths);
                this.fXStage.setTitle(this.title);
                this.fXStage.setScene(scene);
                setControllerEvents();
            } catch (IOException e) {
                throw new FxerException(e);
            }
        });
        return this.fXStage;
    }
}
