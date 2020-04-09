package edu.luc.comp473.factory;

import java.net.MalformedURLException;
import java.net.URL;

import edu.luc.comp473.loader.DocumentLoader;
import edu.luc.comp473.loader.FileSystemDocumentLoader;
import edu.luc.comp473.loader.GoogleDriveDocumentLoader;
import edu.luc.comp473.loader.OneDriveDocumentLoader;

public class SimpleDocumentLoaderFactory implements DocumentLoaderFactory {

    @Override
    public DocumentLoader createLoader(String urlString) {
        System.out.println("Creating Document Loader using Factory Method Pattern");
        try{
            URL url=new URL(urlString);
            if(url.getProtocol().equals("file")){
                return new FileSystemDocumentLoader();
            }else if(url.getProtocol().equals("https")){
                if(url.getHost().equals("drive.google.com")){
                    return new GoogleDriveDocumentLoader();
                }else if(url.getHost().equals("onedrive.live.com")){
                    return new OneDriveDocumentLoader();
                }else{
                    throw new IllegalArgumentException("not supported url");
                }
            }else{
                throw new IllegalArgumentException("not supported url");
            }
        }catch(MalformedURLException mue){
            throw new RuntimeException(mue);
        }
    }

    

}