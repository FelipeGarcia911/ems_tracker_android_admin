package co.original.codigo.ems_tracker_admin.helpers;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class MobileDataHelper {

    private Activity activity;
    public static final int MULTIPLE_PERMISSIONS = 1010;

    private static class SingletonHolder {
        private static final MobileDataHelper INSTANCE = new MobileDataHelper();
    }

    public static MobileDataHelper getInstance() {
        return MobileDataHelper.SingletonHolder.INSTANCE;
    }

    public void initialize(Activity activity){
        this.activity = activity;
    }

    public boolean isPermissionGranted(String manifestPermission){
        return ContextCompat.checkSelfPermission(activity,manifestPermission) == PackageManager.PERMISSION_GRANTED;
    }

    public boolean isShowPermissionRequired(){
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }

    public List<String> getListPermissionRequired(){
        List<String> permissionsList = new ArrayList<>();

        if( !isPermissionGranted(Manifest.permission.READ_EXTERNAL_STORAGE)){
            permissionsList.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        }
        if( !isPermissionGranted(Manifest.permission.WRITE_EXTERNAL_STORAGE)){
            permissionsList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if( !isPermissionGranted(Manifest.permission.CAMERA)){
            permissionsList.add(Manifest.permission.CAMERA);
        }
        if( !isPermissionGranted(Manifest.permission.ACCESS_FINE_LOCATION)){
            permissionsList.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if( !isPermissionGranted(Manifest.permission.ACCESS_COARSE_LOCATION)){
            permissionsList.add(Manifest.permission.ACCESS_COARSE_LOCATION);
        }
        return permissionsList;
    }

}
