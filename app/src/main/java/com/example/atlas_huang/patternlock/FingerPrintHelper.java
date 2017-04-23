package com.example.atlas_huang.patternlock;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

/**
 * Created by atlas_huang on 2017/3/23.
 */

public class FingerPrintHelper {
    private static final String TAG = FingerPrintHelper.class.getSimpleName();
    private static final int REASON_USER_DO_NOT_ENABLE = 0;
    private static final int REASON_HARDWARE_NOT_SUPPORT = 1;
    private static final int REASON_USER_UNENROLLERED_FINGERPRINT = 2;
    private static final int REASON_SDK_VERSION_INCOMPATIABLE =3;
    private static final int REASON_OK = 3;


    private FingerPrintHelper() {}


    @TargetApi(Build.VERSION_CODES.M)
    public static int checkAuth(Context context) {

        //Fingerprint API only available on from Android 6.0 (M)
        FingerprintManager fingerprintManager = (FingerprintManager) context.getSystemService(Context.FINGERPRINT_SERVICE);
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.USE_FINGERPRINT) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            Log.d(TAG, "User do not enable permission.");
            return REASON_USER_DO_NOT_ENABLE;
        }
        if (!fingerprintManager.isHardwareDetected()) {
            // Device doesn't support fingerprint authentication
            return REASON_HARDWARE_NOT_SUPPORT;
        } else if (!fingerprintManager.hasEnrolledFingerprints()) {
            // User hasn't enrolled any fingerprints to authenticate with
            return REASON_USER_UNENROLLERED_FINGERPRINT;
        } else {
            // Everything is ready for fingerprint authentication
            return REASON_OK;
        }

    }

}
