package com.ecommerce.wFlowerService.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

public class Utils {

    public static String generateKey(int length) {
        String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        int n = alphabet.length();

        StringBuilder sb = new StringBuilder();
        Random r = new Random();

        for (int i=0; i<length; i++)
            sb.append(alphabet.charAt(r.nextInt(n)));

        return sb.toString();
    }

    public static boolean checkUserNameFTokenAndUserNameFromBIsMatched(HttpServletRequest request, String username) {
        if (request.getHeader("Authorization").equals(username)) {
            return true;
        }
        return false;
    }
}
