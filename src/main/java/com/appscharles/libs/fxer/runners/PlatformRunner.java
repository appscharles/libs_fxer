package com.appscharles.libs.fxer.runners;

import com.appscharles.libs.fxer.exceptions.FxerException;
import com.appscharles.libs.fxer.exceptions.ThrowingRunnable;
import com.sun.javafx.application.PlatformImpl;
import javafx.beans.property.SimpleObjectProperty;

/**
 * The type Platform runner.
 */
public class PlatformRunner {

    /**
     * Run and wait.
     *
     * @param runnable the runnable
     * @throws FxerException the fxer exception
     */
    @Deprecated
    public static void runAndWait(ThrowingRunnable runnable) throws FxerException {
        if (PlatformImpl.isFxApplicationThread()){
            runnable.accept();
        } else {
            SimpleObjectProperty<FxerException> exception = new SimpleObjectProperty();
            PlatformImpl.runAndWait(()->{
                try {
                    runnable.accept();
                } catch (FxerException e) {
                    exception.setValue(e);
                }
            });
            if (exception.get() != null){
                throw new FxerException(exception.get());
            }
        }
    }


}
