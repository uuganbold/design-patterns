package edu.luc.comp473.loader;

import java.nio.charset.StandardCharsets;

public abstract class CloudDocumentLoader implements DocumentLoader{

    protected byte[] download(String url){
        System.out.println("Downloading file:"+url);
        return ("It is document on the cloud:"+url).getBytes(StandardCharsets.UTF_8);
    }
}