package com.payment.payfareserver.utilities;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class SHA256Helper {
    public static String generateHash(String data) {
        try {
            // we will get the instance of SHA256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            //by using  digest() function, we will get has as one dimensional byte array
            byte[] hash = digest.digest(data.getBytes("UTF-8"));
            //we wanna use hexadecimal values not bytes in our program
            // will covert byte into hexadecimal
            StringBuffer hexadecimalString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                String hexadecimal = Integer.toHexString(0xff & hash[i]);
                if (hexadecimal.length() == 1) hexadecimalString.append('0');
                hexadecimalString.append(hexadecimal);
            }
            return hexadecimalString.toString();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static String randomString(final int length) {
        Random r = new Random(); // perhaps make it a class variable so you don't make a new one every time
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++) {
            char c = (char)(r.nextInt((int)(Character.MAX_VALUE)));
            sb.append(c);
        }
        return sb.toString();
    }
}
