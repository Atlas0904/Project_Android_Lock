package com.example.atlas_huang.patternlock;

import android.util.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by atlas_huang on 2017/3/23.
 */

public class PinUtils {
    private PinUtils() {}

    private static byte[] sha1(byte[] input) {
        try {
            return MessageDigest.getInstance("SHA-1").digest(input);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static String bytesToString(byte[] bytes) {
        return Base64.encodeToString(bytes, Base64.NO_WRAP);
    }

    public static String pinToShaString(String pin) {
        return bytesToString(sha1(pin.getBytes()));
    }

}
