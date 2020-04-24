package edu.luc.comp473.document;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import edu.luc.comp473.loader.DocumentLoader;
import edu.luc.comp473.renderer.DocumentRenderer;

public class DocumentVisitorTest {

    @Test
    public void whenRenderDocument_thenAcceptRendererAndForwardRequest(){
        Document document=new Document(Mockito.mock(DocumentLoader.class),"some urls"){};

        DocumentRenderer renderer=Mockito.mock(DocumentRenderer.class);

        document.render(renderer);

        ArgumentCaptor<Document> captor=ArgumentCaptor.forClass(Document.class);
        verify(renderer,times(1)).render(captor.capture());

        assertEquals(document, captor.getValue());
    }
}