package javadeveloper.module7.httpstatus;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.net.URL;

public class HttpStatusImageDownloader {
    public static void downloadStatusImage(int code) {
        HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
        String imageUrl = httpStatusChecker.getStatusImage(code);
        String imageFileName = System.getProperty("user.dir") + "/" + code + ".jpg";

        try(BufferedInputStream inputStream = new BufferedInputStream(new URL(imageUrl).openStream());
            FileOutputStream outputStream = new FileOutputStream(imageFileName)) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(dataBuffer, 0, 1024)) != -1) {
                outputStream.write(dataBuffer, 0, bytesRead);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}