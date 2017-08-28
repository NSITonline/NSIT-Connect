package nsit.app.com.nsitapp.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class StringDownloader extends Downloader {
    private String mString;


    public String getString() {
        return mString;
    }

    @Override
    protected void processData(InputStream inputStream) {
        final StringBuilder out = new StringBuilder();
        try {
            final BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            try {
                String line;
                while ((line = in.readLine()) != null) {
                    out.append(line);
                }
            } finally {
                in.close();
            }
        } catch (UnsupportedEncodingException ex) {
        } catch (IOException ex) {
        }
        mString = out.toString();
    }
}
