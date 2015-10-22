package nsit.app.com.nsitapp.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public abstract class Downloader {
    public boolean download (String targetURL) throws IOException {
        boolean isSuccess = true;
        InputStream inputStream = null;
        URL url = new URL(targetURL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        try {
            inputStream = conn.getInputStream();
            conn.connect();
            if (conn.getResponseCode()==HttpURLConnection.HTTP_OK) {
                inputStream = conn.getInputStream();
            }else {
                isSuccess = false;
            }

            processData(inputStream);

        } finally {
            if (conn!=null) {
                conn.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return isSuccess;
    }
    protected abstract void processData(InputStream inputStream);
}
