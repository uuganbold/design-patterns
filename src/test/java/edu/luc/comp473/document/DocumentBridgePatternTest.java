package edu.luc.comp473.document;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import edu.luc.comp473.loader.DocumentLoader;

public class DocumentBridgePatternTest {

    @Test
    public void whenLoadDocument_thenLoaderInvoked(){

        DocumentLoader loader=Mockito.mock(DocumentLoader.class);
        String url="some urls";
        Document document=new Document(loader,url){};

        byte[] loadedDocumentContent=new byte[10];
        when(loader.load(anyString())).thenReturn(loadedDocumentContent);

        document.load();

        ArgumentCaptor<String> captor=ArgumentCaptor.forClass(String.class);
        verify(loader,times(1)).load(captor.capture());
        assertEquals(url, captor.getValue());
        assertEquals(loadedDocumentContent, document.getContent());
    }

}