package nsit.app.com.nsitapp.helper;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * Created by prateekjain on 10/31/16.
 */
public class AppPermissionChecker {
    private int permissionRequestCode;
    private PermissionRequestCallBack callBack;
    private Activity activity;

    public AppPermissionChecker(Activity activity) {
        this.activity = activity;
    }

    public void handlePermission(String permission, int permissionRequestCode, PermissionRequestCallBack callBack) {
        this.permissionRequestCode = permissionRequestCode;
        this.callBack = callBack;
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(activity, new String[]{permission}, permissionRequestCode);
            } else {
                callBack.permissionGranted();
            }
        } else {
            callBack.permissionGranted();
        }
    }

    public void handlePermissionResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == permissionRequestCode && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            callBack.permissionGranted();
        } else {
            callBack.permissionDenied();
        }

    }

    public interface PermissionRequestCallBack {
        void permissionGranted();

        void permissionDenied();
    }

}
