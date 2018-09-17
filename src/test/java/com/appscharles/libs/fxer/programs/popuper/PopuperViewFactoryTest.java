package com.appscharles.libs.fxer.programs.popuper;

import com.appscharles.libs.fxer.exceptions.FxerException;
import com.appscharles.libs.fxer.guis.popup.PopupStage;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 17.09.2018
 * Time: 12:05
 * Project name: fxer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class PopuperViewFactoryTest {


    @Test
    public void shouldOpenView() throws FxerException {
        new PopupStage(new PopuperViewFactory()).setWithWait(false).showFx();
    }
}