package com.ottapp.android.basemodule.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class DecodeUrl {
    public  String decodeData(String url)
    {
        try {
            String prevURL="";
            String decodeURL=url;
            while(!prevURL.equals(decodeURL))
            {
                prevURL=decodeURL;
                decodeURL= URLDecoder.decode( decodeURL, "UTF-8" );
            }
            return decodeURL;
        } catch (UnsupportedEncodingException e) {
            return "Issue while decoding" +e.getMessage();
        }
    }
}
