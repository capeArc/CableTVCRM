package com.example.service;

import android.util.Base64;
import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;



/**
 * Created by Pavan on 9/28/2016.
 */

public class Cryptography {

    private static String ALGORITHM = null;
    private static String DIGEST = null;
    private static String IV = null;
    public static final String TAG = "YourAppName";
    private static String TRANSFORMATION;
    private static IvParameterSpec _IVParamSpec;
    private static Cipher _cipher;
    private static SecretKey _password;
    private final String password;

    static {
        TRANSFORMATION = "AES/CBC/PKCS7Padding";
        ALGORITHM = "AES";
        DIGEST = "MD5";
        IV = "LaWdi@ry112013C@";
    }

    public Cryptography() {
        this.password = "C@PE@RC";
        try {
            _password = new SecretKeySpec(MessageDigest.getInstance(DIGEST).digest("C@PE@RC".getBytes()), ALGORITHM);
            byte[] bArr = null;
            try {
                bArr = IV.getBytes("UTF8");
                Log.d("test", "IV " + bArr.length);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            _cipher = Cipher.getInstance(TRANSFORMATION);
            _IVParamSpec = new IvParameterSpec(bArr);
        } catch (NoSuchAlgorithmException e2) {
            Log.e(TAG, "No such algorithm " + ALGORITHM, e2);
        } catch (NoSuchPaddingException e3) {
            Log.e(TAG, "No such padding PKCS7", e3);
        }
    }

    public String encrypt(byte[] text) {
        try {
            _cipher.init(1, _password, _IVParamSpec);
            return Base64.encodeToString(_cipher.doFinal(text), 0);
        } catch (InvalidKeyException e) {
            Log.e(TAG, "Invalid key  (invalid encoding, wrong length, uninitialized, etc).", e);
            return null;
        } catch (InvalidAlgorithmParameterException e2) {
            Log.e(TAG, "Invalid or inappropriate algorithm parameters for " + ALGORITHM, e2);
            return null;
        } catch (IllegalBlockSizeException e3) {
            Log.e(TAG, "The length of data provided to a block cipher is incorrect", e3);
            return null;
        } catch (BadPaddingException e4) {
            Log.e(TAG, "The input data but the data is not padded properly.", e4);
            return null;
        }
    }

    public String decrypt(String text) {
        try {
            _cipher.init(2, _password, _IVParamSpec);
            return new String(_cipher.doFinal(Base64.decode(text.getBytes(), 0)));
        } catch (InvalidKeyException e) {
            Log.e(TAG, "Invalid key  (invalid encoding, wrong length, uninitialized, etc).", e);
            return null;
        } catch (InvalidAlgorithmParameterException e2) {
            Log.e(TAG, "Invalid or inappropriate algorithm parameters for " + ALGORITHM, e2);
            return null;
        } catch (IllegalBlockSizeException e3) {
            Log.e(TAG, "The length of data provided to a block cipher is incorrect", e3);
            return null;
        } catch (BadPaddingException e4) {
            Log.e(TAG, "The input data but the data is not padded properly.", e4);
            return null;
        }
    }
}




