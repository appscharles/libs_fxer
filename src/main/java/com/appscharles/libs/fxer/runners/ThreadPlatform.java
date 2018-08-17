package com.appscharles.libs.fxer.runners;

import com.appscharles.libs.fxer.exceptions.ThrowingConsumer;
import com.sun.javafx.application.PlatformImpl;
import javafx.beans.property.SimpleObjectProperty;

/**
 * The type Platform runner.
 */
public class ThreadPlatform<E extends Throwable> {

    public void runAndWait(ThrowingConsumer<E> runnable) throws E {
        if (PlatformImpl.isFxApplicationThread()){
            runnable.accept();
        } else {
            SimpleObjectProperty<E> exception = new SimpleObjectProperty();
            PlatformImpl.runAndWait(()->{
                try {
                    runnable.accept();
                } catch (Throwable e) {
                    exception.setValue((E)e);
                }
            });
            if (exception.get() != null){
                throw exception.getValue();
            }
        }
    }


}
