package edu.luc.comp473.loader;


public class GoogleDriveDocumentLoader extends CloudDocumentLoader {

    @Override
    public byte[] load(String url) {
        System.out.println("Loading document from Google drive:"+url);
        return download(url);
    }
    
}