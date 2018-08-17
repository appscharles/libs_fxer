package com.appscharles.libs.fxer.runners;

import com.appscharles.libs.fxer.exceptions.FxerException;
import com.sun.javafx.application.PlatformImpl;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 17.08.2018
 * Time: 09:55
 * Project name: fxer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class ThreadPlatformTest {

    @Test(expected = FxerException.class)
    public void shouldThrowException() throws FxerException {
        PlatformImpl.startup(()->{});
        new ThreadPlatform<FxerException>().runAndWait(()->{
            if (new Integer(0).equals(0)){
                try {
                    throw new IOException("sfff");
                } catch (IOException e) {
                    throw new FxerException(e);
                }
            }
        });
    }
}