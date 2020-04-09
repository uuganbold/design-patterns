package edu.luc.comp473.loader;


public class OneDriveDocumentLoader extends CloudDocumentLoader {

    @Override
    public byte[] load(String url) {
        System.out.println("Loading document from OneDrive:"+url);
        return download(url);
    }
    
}