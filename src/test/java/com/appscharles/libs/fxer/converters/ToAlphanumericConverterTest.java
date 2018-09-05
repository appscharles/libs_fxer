package com.appscharles.libs.fxer.converters;

import org.junit.Assert;
import org.junit.Test;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 30.08.2018
 * Time: 10:50
 * Project name: stocker
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class ToAlphanumericConverterTest {

    @Test
    public void shouldGetAlphanumeric(){
        String url = "https://2.allegroimg.allegrosandbox.pl/original/034649/76e45af1482cb22c932a849a7322";
       String result = ToAlphanumericConverter.convert(url);
        String resultToCompare = "https2allegroimgallegrosandboxploriginal03464976e45af1482cb22c932a849a7322";
        Assert.assertEquals(result, resultToCompare);
    }
}