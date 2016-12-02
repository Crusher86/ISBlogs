package ru.innopolis.isblogs.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static java.security.MessageDigest.getInstance;

/**
 * Created by Crusher on 02.12.2016.
 */
public class CryptUtil {

    private static MessageDigest messageDigest;



    static {
        try {
            messageDigest = getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static String cript(String msg){
        messageDigest.update(msg.getBytes());
        return new String(messageDigest.digest());
    }

}
