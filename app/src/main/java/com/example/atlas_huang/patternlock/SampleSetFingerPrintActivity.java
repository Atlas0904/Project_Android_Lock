package com.example.atlas_huang.patternlock;

import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.multidots.fingerprintauth.AuthErrorCodes;
import com.multidots.fingerprintauth.FingerPrintAuthCallback;
import com.multidots.fingerprintauth.FingerPrintAuthHelper;

public class SampleSetFingerPrintActivity extends AppCompatActivity implements FingerPrintAuthCallback {

    private static final String TAG = SampleSetPinActivity.class.getSimpleName();
    private FingerPrintAuthHelper mFingerPrintAuthHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_set_finger_print);

        Log.d(TAG, "CheckAuth ret=" + FingerPrintHelper.checkAuth(this));

        
        mFingerPrintAuthHelper = FingerPrintAuthHelper.getHelper(this, this);
        mFingerPrintAuthHelper.startAuth();
        Log.d(TAG, "onCreate startAuth");
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume");
        super.onResume();
        mFingerPrintAuthHelper.startAuth();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause");

        super.onPause();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mFingerPrintAuthHelper.stopAuth();
        }
    }

    @Override
    public void onNoFingerPrintHardwareFound() {
        Log.d(TAG, "onNoFingerPrintHardwareFound");

    }

    @Override
    public void onNoFingerPrintRegistered() {
        Log.d(TAG, "onNoFingerPrintHardwareFound");

    }

    @Override
    public void onBelowMarshmallow() {
        Log.d(TAG, "onBelowMarshmallow");

    }

    @Override
    public void onAuthSuccess(FingerprintManager.CryptoObject cryptoObject) {
        Log.d(TAG, "onAuthSuccess");

    }

    @Override
    public void onAuthFailed(int errorCode, String errorMessage) {
        Log.d(TAG, "onAuthFailed");

        switch (errorCode) {    //Parse the error code for recoverable/non recoverable error.
            case AuthErrorCodes.CANNOT_RECOGNIZE_ERROR:
                //Cannot recognize the fingerprint scanned.
                break;
            case AuthErrorCodes.NON_RECOVERABLE_ERROR:
                //This is not recoverable error. Try other options for user authentication. like pin, password.
                break;
            case AuthErrorCodes.RECOVERABLE_ERROR:
                //Any recoverable error. Display message to the user.
                break;
        }
    }
}
