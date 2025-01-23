package com.hen.mongodb_springboot_projetct.controllers.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {

    // static para n percisar instanciar o objeto URL
    public static String decodeParam(String text) {
        try {
            return URLDecoder.decode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
           return "";
        }
        // UTF-8 é o código padrão da web
    }
}
