package com.appscharles.libs.fxer;

import com.appscharles.libs.logger.configurators.Log4j2Console;
import com.appscharles.libs.logger.configurators.Log4jConsole;
import com.sun.javafx.application.PlatformImpl;
import org.apache.logging.log4j.Level;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 21.08.2018
 * Time: 14:03
 * Project name: fxer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class TestCase {

    @Rule
    public TemporaryFolder temp = new TemporaryFolder();

    @Before
    public void before(){
        PlatformImpl.startup(()->{});
        PlatformImpl.setImplicitExit(false);
        new Log4j2Console(Level.TRACE).config();
        new Log4jConsole(org.apache.log4j.Level.INFO).config();
    }
}
