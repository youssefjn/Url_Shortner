package com.yj.url.logic;

import java.nio.charset.Charset;

import org.apache.commons.validator.routines.UrlValidator;

import com.google.common.hash.Hashing;

public class GenerateShortUrl {

    public static String HashUrl(String url) {

        String shortUrl = Hashing
                .murmur3_32_fixed()
                .hashString(url, Charset.defaultCharset())
                .toString();
        return shortUrl;
    }

    public static boolean isUrlValid(String url) {
        UrlValidator urlValidator = new UrlValidator(
                new String[] { "http", "https" });
        boolean result = urlValidator.isValid(url);
        return result;
    }

}
