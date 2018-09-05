package com.appscharles.libs.fxer.remembers;

import com.appscharles.libs.fxer.converters.ToAlphanumericConverter;
import com.appscharles.libs.fxer.exceptions.FxerException;
import com.appscharles.libs.ioer.downloaders.file.HttpFileDownloader;
import com.appscharles.libs.ioer.exceptions.IoerException;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * The type Image online remember.
 */
public class ImageOnlineRemember implements IImageOnlineRemember {

    private File rememberDir;

    public ImageOnlineRemember(File rememberDir) {
        this.rememberDir = rememberDir;
    }

    @Override
    public File getFile(URL imageUrl) {
        String filename = ToAlphanumericConverter.convert(imageUrl.toString());
        return new File(this.rememberDir, filename);
    }

    @Override
    public Boolean isRemember(URL imageUrl) {
        String filename = ToAlphanumericConverter.convert(imageUrl.toString());
        return new File(this.rememberDir, filename).exists();
    }

    @Override
    public File save(URL imageUrl, Image image) throws FxerException {
        String filename = ToAlphanumericConverter.convert(imageUrl.toString());
        if (this.rememberDir.exists() == false){
            this.rememberDir.mkdirs();
        }
        File file = new File(this.rememberDir, filename);
        int pushbackLimit = 100;
        try(InputStream urlStream = imageUrl.openStream();
            PushbackInputStream pushUrlStream = new PushbackInputStream(urlStream, pushbackLimit)) {
            byte[] firstBytes = new byte[pushbackLimit];
            pushUrlStream.read(firstBytes);
            pushUrlStream.unread(firstBytes);
            try (ByteArrayInputStream bais = new ByteArrayInputStream(firstBytes)) {
                String mimeType = URLConnection.guessContentTypeFromStream(bais);
                if (mimeType.startsWith("image/")) {
                    String imageType = mimeType.substring("image/".length());
                    BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
                    ImageIO.write(bImage, imageType, file);
                } else {
                    new HttpFileDownloader(imageUrl, 3).download(file);
                }
            }
        } catch (IOException | IoerException e) {
            throw new FxerException(e);
        }
        return file;

    }
}
