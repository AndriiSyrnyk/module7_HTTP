package javadeveloper.module7.httpstatus;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class HttpStatusChecker {
    public String getStatusImage(int code) {
        String url = "https://http.cat/";
        String imageUrl = "";

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url + code)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.code() != 404) imageUrl = url + code;
            else throw new ImageNotFoundException("No image for code " + code);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return imageUrl;
    }
}