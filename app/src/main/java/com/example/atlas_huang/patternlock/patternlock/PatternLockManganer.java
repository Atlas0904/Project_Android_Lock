package com.example.atlas_huang.patternlock.patternlock;

import java.util.List;

import me.zhanghai.android.patternlock.PatternUtils;
import me.zhanghai.android.patternlock.PatternView;

/**
 * Created by atlas_huang on 2017/4/23.
 */

public class PatternLockManganer {

    private static List<PatternView.Cell> patternLock;

    public PatternLockManganer() {
        resetPattern();
    }

    public static boolean setPattern(List<PatternView.Cell> pattern) {
        patternLock = pattern;
        return true;
    }

    public static boolean isSetPatternLock() {
        return (null == patternLock);
    }

    public static List<PatternView.Cell> getPatternLock() {
        return patternLock;
    }

    public static void resetPattern() {
        patternLock = null;
    }

}
