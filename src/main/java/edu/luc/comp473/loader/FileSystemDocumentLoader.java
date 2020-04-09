package edu.luc.comp473.loader;

import java.nio.charset.StandardCharsets;

public class FileSystemDocumentLoader implements DocumentLoader {

    @Override
    public byte[] load(String url) {
        System.out.println("Loading document from file system:"+url);
        return ("It is File system document at url"+url).getBytes(StandardCharsets.UTF_8);
    }

    
}