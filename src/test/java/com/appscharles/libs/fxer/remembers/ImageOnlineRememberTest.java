package com.appscharles.libs.fxer.remembers;

import com.appscharles.libs.fxer.TestCase;
import com.appscharles.libs.fxer.converters.ToAlphanumericConverter;
import com.appscharles.libs.fxer.exceptions.FxerException;
import javafx.scene.image.Image;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 03.09.2018
 * Time: 12:10
 * Project name: stocker
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class ImageOnlineRememberTest extends TestCase {

    @Test
    public void shouldSaveImage() throws IOException, FxerException {
        URL imageUrl = new URL("https://d.allegroimg.com/original/00b162/4516e6254c48a8d42911080b2ffd/Elektryczna-szczoteczka-do-zebow-Oral-B-D12-KIDS-StarWars-przod");
        File tempDir = this.temp.newFolder();
        IImageOnlineRemember remember = new ImageOnlineRemember(tempDir);
        remember.save(imageUrl, new Image(String.valueOf(imageUrl)));
        File rememberFile = new File(tempDir, tempDir.list()[0]);
        Assert.assertEquals(rememberFile.getPath(), new File(tempDir, ToAlphanumericConverter.convert(imageUrl.toString())).getPath());
    }
}