package nsit.app.com.nsitapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import nsit.app.com.nsitapp.helper.AppPermissionChecker;

/**
 * Created by prateekjain on 10/31/16.
 */
public class BaseActivity extends AppCompatActivity {
    protected AppPermissionChecker appPermissionChecker;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appPermissionChecker = new AppPermissionChecker(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        appPermissionChecker.handlePermissionResult(requestCode, permissions, grantResults);
    }

}
