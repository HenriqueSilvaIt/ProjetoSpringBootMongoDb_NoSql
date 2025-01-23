package com.hen.mongodb_springboot_projetct.controllers.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

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

    public static Date convertDate(String textDate, Date defaultValue) { // esse default
        //value é caso ocorrar um erro nessa data textDate que é a data convertida
        // ele traz o valor padrão da data
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            return sdf.parse(textDate);
        } catch (ParseException e) {
            return defaultValue;// caso a conversão falhe retorna o formato de data
            // padrão
        }
        // tem como pegar também o padrão da data e hora local do usuário
        // e ele vai exigir que isso seja enviado na requisição na camada Resource
        // provavelment
    }
}
