package nsit.app.com.nsitapp.network;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StringDownloader extends Downloader{
    private String mString;


    public String getString(){
        return mString;
    }

    @Override
    protected void processData(InputStream inputStream) {
        final StringBuilder out = new StringBuilder();
        try {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))) {
                String line;
                while ((line = in.readLine()) != null) {
                    out.append(line);
                }
            }
        } catch (IOException ex) {
            Log.e("ERROR ", ex.getMessage());
        }
        mString = out.toString();
    }
}
