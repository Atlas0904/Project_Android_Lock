package com.example.atlas_huang.patternlock.patternlock.util;

import android.util.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import me.zhanghai.android.patternlock.PatternView;

import static me.zhanghai.android.patternlock.PatternUtils.patternToBytes;

/**
 * Created by atlas_huang on 2017/4/23.
 */

public class PatternUtils {

    public PatternUtils() {}

    private static String bytesToString(byte[] bytes) {
        return Base64.encodeToString(bytes, Base64.NO_WRAP);
    }

    private static byte[] stringToBytes(String string) {
        return Base64.decode(string, Base64.DEFAULT);
    }

    public static byte[] patternToSha256(List<PatternView.Cell> pattern) {
        return sha256(patternToBytes(pattern));
    }

    public static String patternToSha256String(List<PatternView.Cell> pattern) {
        return bytesToString(patternToSha256(pattern));
    }

    private static byte[] sha256(byte[] input) {
        try {
            return MessageDigest.getInstance("SHA-256").digest(input);

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
