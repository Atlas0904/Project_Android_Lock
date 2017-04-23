package com.example.atlas_huang.patternlock.patternlock;

import android.content.Intent;
import android.util.Log;

import java.util.List;

import me.zhanghai.android.patternlock.PatternUtils;
import me.zhanghai.android.patternlock.PatternView;
import me.zhanghai.android.patternlock.SetPatternActivity;

/**
 * Created by atlas_huang on 2017/3/23.
 */

public class PatternSetActivity extends SetPatternActivity {
    private static final String TAG = PatternSetActivity.class.getSimpleName();


    @Override
    protected void onSetPattern(List<PatternView.Cell> pattern) {
        String patternSha1 = PatternUtils.patternToSha1String(pattern);
        // TODO: Save patternSha1 in SharedPreferences.
        Log.d(TAG, "onSetPattern pattern=" + pattern);

        PatternLockManganer.setPattern(pattern);

        Intent intent = new Intent(this, PatternConfrimActivity.class);
        startActivity(intent);
    }
}
