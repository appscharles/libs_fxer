package com.appscharles.libs.fxer.builders.previewImage;

import com.appscharles.libs.fxer.TestCase;
import com.appscharles.libs.fxer.exceptions.FxerException;
import com.appscharles.libs.fxer.remembers.ImageOnlineRemember;
import com.appscharles.libs.fxer.stages.FXStage;
import com.appscharles.libs.ioer.exceptions.IoerException;
import com.sun.javafx.application.PlatformImpl;
import javafx.scene.Scene;
import org.junit.Assert;
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
public class OnlinePreviewImageBuilderTest extends TestCase {

    @Test
    public void shouldDisplayControl() throws IOException, IoerException {
        File tempDir = this.temp.newFolder();
        URL imageUrl = new URL("https://www.sample-videos.com/img/Sample-jpg-image-1mb.jpg");
        // URL imageUrl = new URL("https://wiki.totalwar.com/images/0/00/Lepidus_icon.png");
        OnlinePreviewImageBuilder builder = OnlinePreviewImageBuilder.create(imageUrl, 600.0, 100.0).setImageOnlineRemember(new ImageOnlineRemember(tempDir)).setLoadingImageMaxHeight(40.0).setRoundCornersThumbnail(15.0);
        PlatformImpl.runAndWait(() -> {
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
        Assert.assertTrue(tempDir.list().length == 1);
    }

    @Test
    public void waiter() {

    }
}