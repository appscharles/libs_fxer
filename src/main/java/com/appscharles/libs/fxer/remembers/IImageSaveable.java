package com.appscharles.libs.fxer.remembers;

import com.appscharles.libs.fxer.exceptions.FxerException;
import javafx.scene.image.Image;

import java.io.File;
import java.net.URL;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 03.09.2018
 * Time: 11:41
 * Project name: stocker
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public interface IImageSaveable {

    File save(URL imageUrl, Image image) throws FxerException;
}
