package com.appscharles.libs.fxer.runners;

import com.appscharles.libs.fxer.exceptions.FxerException;
import javafx.application.Platform;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * The type Platform runner.
 */
public class PlatformRunner {

    /**
     * Run later object.
     *
     * @param futureTask the future task
     * @return the object
     * @throws FxerException the fxer exception
     */
    public static Object runLater(final FutureTask futureTask) throws FxerException {
        if (Platform.isFxApplicationThread()){
            return futureTask;
        }
        Platform.runLater(futureTask);
        try {
            return futureTask.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new FxerException(e);
        }
    }
}
