package com.appscharles.libs.fxer.stages;

import com.appscharles.libs.fxer.exceptions.FxerException;
import com.appscharles.libs.fxer.runners.ThreadPlatform;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * The type Fx stage.
 */
public class FXStage extends Stage implements IStageControllable {

    private FXMLLoader fxmlLoader;

    /**
     * Instantiates a new Fx stage.
     *
     * @param fxmlLoader the fxml loader
     */
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
        new ThreadPlatform<FxerException>().runAndWait(()->{
            super.show();
        });
    }

    /**
     * Show and wait fx.
     *
     * @throws FxerException the fxer exception
     */
    public void showAndWaitFX() throws FxerException {
        new ThreadPlatform<FxerException>().runAndWait(()->{
            super.showAndWait();
        });
    }

    /**
     * To front fx.
     *
     * @throws FxerException the fxer exception
     */
    public void toFrontFX() throws FxerException {
        new ThreadPlatform<FxerException>().runAndWait(()->{
            super.toFront();
        });
    }

    /**
     * To back fx.
     *
     * @throws FxerException the fxer exception
     */
    public void toBackFX() throws FxerException {
        new ThreadPlatform<FxerException>().runAndWait(()->{
            super.toBack();
        });
    }

    /**
     * Close fx.
     *
     * @throws FxerException the fxer exception
     */
    public void closeFX() throws FxerException {
        new ThreadPlatform<FxerException>().runAndWait(()->{
            super.close();
        });
    }

    /**
     * Size to scene fx.
     *
     * @throws FxerException the fxer exception
     */
    public void sizeToSceneFX() throws FxerException {
        new ThreadPlatform<FxerException>().runAndWait(()->{
            super.sizeToScene();
        });
    }

    /**
     * Center on screen fx.
     *
     * @throws FxerException the fxer exception
     */
    public void centerOnScreenFX() throws FxerException {
        new ThreadPlatform<FxerException>().runAndWait(()->{
            super.centerOnScreen();
        });
    }

    /**
     * Hide fx.
     *
     * @throws FxerException the fxer exception
     */
    public void hideFX() throws FxerException {
        new ThreadPlatform<FxerException>().runAndWait(()->{
            super.hide();
        });
    }

    @Override
    public <T> T getController() {
        return this.fxmlLoader.getController();
    }

    /**
     * Sets icon.
     *
     * @param resourcePath the resource path
     * @throws FxerException the fxer exception
     */
    public void setIcon(String resourcePath) throws FxerException {
        new ThreadPlatform<FxerException>().runAndWait(()->{
            this.getIcons().add(new Image(getClass().getResourceAsStream(resourcePath)));
        });
    }

}
