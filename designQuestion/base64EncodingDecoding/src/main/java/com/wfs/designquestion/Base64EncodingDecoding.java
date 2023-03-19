package com.wfs.designquestion;

import com.sun.deploy.net.HttpRequest;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class Base64EncodingDecoding {

    String base62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Long counter = 434L;
    Map<Long, String> indexToUrl = new HashMap<>();
    Map<String, Long> urlToIndex = new HashMap<String, Long>();

    private String base62Encode(long value) {
        StringBuilder sb = new StringBuilder();
        while (value != 0) {
            sb.append(base62.charAt((int)(value % 62)));
            value /= 62;
        }
        while (sb.length() < 6) {
            sb.append(0);
        }
        return sb.reverse().toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String base62Encoded = shortUrl.substring(shortUrl.lastIndexOf("/") + 1);
        long decode = 0;
        for(int i = 0; i < base62Encoded.length(); i++) {
            decode = decode * 62 + base62.indexOf("" + base62Encoded.charAt(i));
        }
        return indexToUrl.get(decode);
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (urlToIndex.containsKey(longUrl)) {
            return "http://tinyurl.com/"+base62Encode(urlToIndex.get(longUrl));
        }
        else {
            indexToUrl.put(counter, longUrl);
            urlToIndex.put(longUrl, counter);
            counter++;
            return "http://tinyurl.com/"+base62Encode(urlToIndex.get(longUrl));
        }
    }

    public static void main(String[] args) {
        Base64EncodingDecoding decoding =new Base64EncodingDecoding();
        System.out.println(decoding.encode("http://tinyurl.com/AAAAAAAAAAAAAAA"));
        System.out.println(decoding.decode("000070"));
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/post"))
                .headers("Content-Type", "text/plain;charset=UTF-8")
                .POST(HttpRequest.BodyPublishers.ofString("Sample request body"))
                .build();
    }

}
