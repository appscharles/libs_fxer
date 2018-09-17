package com.appscharles.libs.fxer.sneakers;

import com.appscharles.libs.dialoger.factories.ExceptionDialogFactory;
import com.appscharles.libs.fxer.exceptions.ThrowingConsumer;
import com.sun.javafx.application.PlatformImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The type Exception dialog sneaky.
 */
public class ExceptionDialogThrowSneaker {

    private static final Logger logger = LogManager.getLogger(ExceptionDialogThrowSneaker.class);


    /**
     * Sneaky.
     *
     * @param consumer the consumer
     */
    public static void sneaky(ThrowingConsumer<Exception> consumer){
        try {
            consumer.accept();
        } catch (Exception e) {
            logger.error(e, e);
            PlatformImpl.runAndWait(()->{
                ExceptionDialogFactory.create("Error", e.getMessage(), e).build().showAndWait();
            });
        }
    }
    public static void sneakyWithoutWait(ThrowingConsumer<Exception> consumer){
        try {
            consumer.accept();
        } catch (Exception e) {
            logger.error(e, e);
            PlatformImpl.runAndWait(()->{
                ExceptionDialogFactory.create("Error", e.getMessage(), e).build().show();
            });
        }
    }
}
