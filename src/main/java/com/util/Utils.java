package com.util;

/**
 * Created by Nir on 11/4/2017.
 */
public class Utils {

    public static boolean isEmpty(String str, boolean removeWhitespaces){
        return str == null || str.isEmpty() || (removeWhitespaces && str.trim().isEmpty());
    }
}
