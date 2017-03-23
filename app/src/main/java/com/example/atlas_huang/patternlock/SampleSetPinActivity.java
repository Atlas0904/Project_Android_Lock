package com.example.atlas_huang.patternlock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import android.widget.TextView;

import com.andrognito.pinlockview.IndicatorDots;
import com.andrognito.pinlockview.PinLockListener;
import com.andrognito.pinlockview.PinLockView;

public class SampleSetPinActivity extends AppCompatActivity {

    private static final String TAG = SampleSetPinActivity.class.getSimpleName();
    private PinLockView mPinLockView;
    private IndicatorDots mIndicatorDots;
    private static String mDefaultPassword = "1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_set_pin);


        mPinLockView = (PinLockView) findViewById(R.id.pin_lock_view);
        mPinLockView.setPinLockListener(mPinLockListener);

        mIndicatorDots = (IndicatorDots) findViewById(R.id.indicator_dots);
        mPinLockView.attachIndicatorDots(mIndicatorDots);
    }

    private PinLockListener mPinLockListener = new PinLockListener() {
        @Override
        public void onComplete(String pin) {
            // TODO: Save pinSha1 in SharedPreferences.

            Log.d(TAG, "Pin complete:sha " + pin);
            if (TextUtils.equals(PinUtils.pinToShaString(pin), PinUtils.pinToShaString(mDefaultPassword))) {
                Log.d(TAG, "Pin correct pin" + pin);

            } else {
                Log.d(TAG, "Pin incorrect pin" + pin);
                mPinLockView.resetPinLockView();
            }
            Log.d(TAG, "Pin sha1String: " + PinUtils.pinToShaString(pin));
        }

        @Override
        public void onEmpty() {
            Log.d(TAG, "Pin empty");
        }

        @Override
        public void onPinChange(int pinLength, String intermediatePin) {
            Log.d(TAG, "Pin changed, new length " + pinLength + " with intermediate pin " + intermediatePin);
        }
    };
}
