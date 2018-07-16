package com.appscharles.libs.fxer.programs.stager;

import com.appscharles.libs.fxer.exceptions.FxerException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 16.07.2018
 * Time: 20:01
 * Project name: fxer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class StagerTest {

    @Test
    public void shouldGetDataFromSubStage() throws FxerException {
        Assert.assertEquals(Stager.getResult(), "result");
    }
}