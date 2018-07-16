package com.appscharles.libs.fxer.stages;

import com.appscharles.libs.fxer.exceptions.FxerException;
import com.appscharles.libs.fxer.runners.PlatformRunner;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

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
        PlatformRunner.runAndWait(()->{
            super.show();
        });
    }

    /**
     * Show and wait fx.
     *
     * @throws FxerException the fxer exception
     */
    public void showAndWaitFX() throws FxerException {
        PlatformRunner.runAndWait(()->{
            super.showAndWait();
        });
    }

    /**
     * To front fx.
     *
     * @throws FxerException the fxer exception
     */
    public void toFrontFX() throws FxerException {
        PlatformRunner.runAndWait(()->{
            super.toFront();
        });
    }

    /**
     * To back fx.
     *
     * @throws FxerException the fxer exception
     */
    public void toBackFX() throws FxerException {
        PlatformRunner.runAndWait(()->{
            super.toBack();
        });
    }

    /**
     * Close fx.
     *
     * @throws FxerException the fxer exception
     */
    public void closeFX() throws FxerException {
        PlatformRunner.runAndWait(()->{
            super.close();
        });
    }

    /**
     * Size to scene fx.
     *
     * @throws FxerException the fxer exception
     */
    public void sizeToSceneFX() throws FxerException {
        PlatformRunner.runAndWait(()->{
            super.sizeToScene();
        });
    }

    /**
     * Center on screen fx.
     *
     * @throws FxerException the fxer exception
     */
    public void centerOnScreenFX() throws FxerException {
        PlatformRunner.runAndWait(()->{
            super.centerOnScreen();
        });
    }

    /**
     * Hide fx.
     *
     * @throws FxerException the fxer exception
     */
    public void hideFX() throws FxerException {
        PlatformRunner.runAndWait(()->{
            super.hide();
        });
    }

    @Override
    public <T> T getController() {
        return this.fxmlLoader.getController();
    }

}
