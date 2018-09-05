package com.appscharles.libs.fxer.builders.previewImage;

import com.appscharles.libs.fxer.TestCase;
import com.appscharles.libs.fxer.exceptions.FxerException;
import com.appscharles.libs.fxer.stages.FXStage;
import com.appscharles.libs.ioer.downloaders.file.HttpFileDownloader;
import com.appscharles.libs.ioer.exceptions.IoerException;
import com.sun.javafx.application.PlatformImpl;
import javafx.scene.Scene;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 30.08.2018
 * Time: 14:29
 * Project name: stocker
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class PreviewImageBuilderTest extends TestCase {

    @Test
    public void shouldDisplayControl() throws IOException, IoerException {
        URL imageUrl = new URL("https://www.w3schools.com/w3css/img_lights.jpg");
        File imageFile = this.temp.newFile();
        new HttpFileDownloader(imageUrl, 3).download(imageFile);
        PreviewImageBuilder builder = PreviewImageBuilder.create(imageFile, 600.0,200.0).setRoundCornersThumbnail(15.0);
        PlatformImpl.runAndWait(()->{
            FXStage fxStage = new FXStage(null);
            Scene scene = null;
            try {
                scene = new Scene(builder.build());
            } catch (FxerException e) {
                e.printStackTrace();
            }
            fxStage.setScene(scene);
            fxStage.showAndWait();
        });
    }
}