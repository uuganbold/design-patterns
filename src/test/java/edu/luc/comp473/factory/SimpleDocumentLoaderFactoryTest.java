package edu.luc.comp473.factory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.luc.comp473.loader.FileSystemDocumentLoader;
import edu.luc.comp473.loader.GoogleDriveDocumentLoader;
import edu.luc.comp473.loader.OneDriveDocumentLoader;

public class SimpleDocumentLoaderFactoryTest {

    @Test
    public void whenGivenMalformedUrl_throwException(){
        SimpleDocumentLoaderFactory factory=new SimpleDocumentLoaderFactory();

        assertThrows(RuntimeException.class, ()->{factory.createLoader("jalsdfaasdfas");});
    }

    @Test
    public void whenFileSystemUrl_ReturnFileSystemDocumentLoader(){
        SimpleDocumentLoaderFactory factory=new SimpleDocumentLoaderFactory();

        assertEquals(FileSystemDocumentLoader.class, factory.createLoader("file:///home/uuganbold/Document.pdf").getClass());
    }

    @Test
    public void whenGoogleUrl_ReturnGoogleDriveDocumentLoader(){
        SimpleDocumentLoaderFactory factory=new SimpleDocumentLoaderFactory();

        assertEquals(GoogleDriveDocumentLoader.class, factory.createLoader("https://drive.google.com/").getClass());
    }

    @Test
    public void whenOneDrive_ReturnOneDriveDocumentLoader(){
        SimpleDocumentLoaderFactory factory=new SimpleDocumentLoaderFactory();

        assertEquals(OneDriveDocumentLoader.class, factory.createLoader("https://onedrive.live.com/").getClass());
    }


    @Test
    public void whenNotSupported_ReturnThrowIllegalArgumentException(){
        SimpleDocumentLoaderFactory factory=new SimpleDocumentLoaderFactory();

        assertThrows(IllegalArgumentException.class, ()->{factory.createLoader("http://google.com/");});
        assertThrows(IllegalArgumentException.class, ()->{factory.createLoader("https://google.com/");});
    }


}