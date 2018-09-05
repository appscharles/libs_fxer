package com.appscharles.libs.fxer.converters;

import java.text.Normalizer;

/**
 * The type To alphanumeric converter.
 */
public class ToAlphanumericConverter {

    /**
     * Convert string.
     *
     * @param content the content
     * @return the string
     */
    public static String convert(String content){
        String normalized = Normalizer.normalize(content, Normalizer.Form.NFD);
        return normalized.replaceAll("[^A-Za-z0-9]", "");
    }
}
