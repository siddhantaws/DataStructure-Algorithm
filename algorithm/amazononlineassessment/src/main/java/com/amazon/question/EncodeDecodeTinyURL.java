package com.amazon.question;

import java.util.HashMap;
import java.util.Map;

public class EncodeDecodeTinyURL {
    private static String str="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijlkmnopqrstuvwxyz0123456789";

    private long count  = 10000000;

    private Map<String,String> map =new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        count++;
        long num =count; int length=0;char ch []=new char[7];
        while(length<7){
            ch[length++]=str.charAt((int)num%62);
            num=num/62;
        }
        String url = new String(ch);
        map.put(url, longUrl);
        return url;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }


    public static void main(String[] args) {
        EncodeDecodeTinyURL decodeTinyURL =new EncodeDecodeTinyURL();
        System.out.println(decodeTinyURL.encode("https://leetcode.com/problems/design-tinyurl"));
        System.out.println(decodeTinyURL.encode("https://leetcode.com/problems/design-tinyurl"));
        System.out.println(decodeTinyURL.encode("https://leetcode.com/problems/design-tinyurl"));
        System.out.println(decodeTinyURL.encode("https://leetcode.com/problems/design-tinyurl"));

    }
}
