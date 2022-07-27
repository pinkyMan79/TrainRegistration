package org.terenin.services;

import java.nio.charset.StandardCharsets;
import java.util.Random;

public class KeyGenForStaff {

    public static String generateAccessToken(){

        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);

        return new String(array, StandardCharsets.UTF_8);

    }

}
