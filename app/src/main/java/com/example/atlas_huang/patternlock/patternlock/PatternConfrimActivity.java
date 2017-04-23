package com.example.atlas_huang.patternlock.patternlock;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;

import java.util.List;

import me.zhanghai.android.patternlock.ConfirmPatternActivity;
import me.zhanghai.android.patternlock.PatternView;

/**
 * Created by atlas_huang on 2017/3/23.
 */

public class PatternConfrimActivity extends ConfirmPatternActivity {


    private static final String TAG = PatternConfrimActivity.class.getSimpleName();

    @Override
    protected boolean isStealthModeEnabled() {
        // TODO: Return the value from SharedPreferences.
        Log.d(TAG, "isStealthModeEnabled");
        return false;
    }

    @Override
    protected boolean isPatternCorrect(List<PatternView.Cell> pattern) {
        Log.d(TAG, "isPatternCorrect pattern=" + pattern);

        List<PatternView.Cell> savedPattern = PatternLockManganer.getPatternLock();
        Log.d(TAG, "isPatternCorrect pattern=" + savedPattern);

        return TextUtils.equals(
                com.example.atlas_huang.patternlock.patternlock.util.PatternUtils.patternToSha256String(pattern),
                com.example.atlas_huang.patternlock.patternlock.util.PatternUtils.patternToSha256String(savedPattern));
    }

    @Override
    protected void onForgotPassword() {
        Log.d(TAG, "onForgotPassword");

        startActivity(new Intent(this, PatternResetPwdActivity.class));

        // Finish with RESULT_FORGOT_PASSWORD.
        super.onForgotPassword();
    }
}
