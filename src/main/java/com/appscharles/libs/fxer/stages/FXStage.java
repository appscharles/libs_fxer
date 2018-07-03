package com.appscharles.libs.fxer.stages;

import com.appscharles.libs.fxer.exceptions.FxerException;
import com.appscharles.libs.fxer.runners.PlatformRunner;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import java.util.concurrent.FutureTask;

/**
 * The type Fx stage.
 */
public class FXStage extends Stage implements IStageControllable {

    private FXMLLoader fxmlLoader;

    public FXStage(FXMLLoader fxmlLoader) {
        super();
        this.fxmlLoader = fxmlLoader;
    }

    /**
     * Show fx.
     *
     * @throws FxerException the fxer exception
     */
    public void showFX() throws FxerException {
        PlatformRunner.runLater(new FutureTask(()->{
            super.show();
            return null;
        }));
    }

    /**
     * Show and wait fx.
     *
     * @throws FxerException the fxer exception
     */
    public void showAndWaitFX() throws FxerException {
        PlatformRunner.runLater(new FutureTask(()->{
            super.showAndWait();
            return null;
        }));
    }

    /**
     * To front fx.
     *
     * @throws FxerException the fxer exception
     */
    public void toFrontFX() throws FxerException {
        PlatformRunner.runLater(new FutureTask(()->{
            super.toFront();
            return null;
        }));
    }

    /**
     * To back fx.
     *
     * @throws FxerException the fxer exception
     */
    public void toBackFX() throws FxerException {
        PlatformRunner.runLater(new FutureTask(()->{
            super.toBack();
            return null;
        }));
    }

    /**
     * Close fx.
     *
     * @throws FxerException the fxer exception
     */
    public void closeFX() throws FxerException {
        PlatformRunner.runLater(new FutureTask(()->{
            super.close();
            return null;
        }));
    }

    /**
     * Size to scene fx.
     *
     * @throws FxerException the fxer exception
     */
    public void sizeToSceneFX() throws FxerException {
        PlatformRunner.runLater(new FutureTask(()->{
            super.sizeToScene();
            return null;
        }));
    }

    /**
     * Center on screen fx.
     *
     * @throws FxerException the fxer exception
     */
    public void centerOnScreenFX() throws FxerException {
        PlatformRunner.runLater(new FutureTask(()->{
            super.centerOnScreen();
            return null;
        }));
    }

    /**
     * Hide fx.
     *
     * @throws FxerException the fxer exception
     */
    public void hideFX() throws FxerException {
        PlatformRunner.runLater(new FutureTask(()->{
            super.hide();
            return null;
        }));
    }

    @Override
    public <T> T getController() {
        return this.fxmlLoader.getController();
    }
}
