package edu.luc.comp473.renderer.docorators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import edu.luc.comp473.document.Document;
import edu.luc.comp473.loader.DocumentLoader;
import edu.luc.comp473.renderer.DocumentRenderer;
import edu.luc.comp473.renderer.decorators.DocumentRendererDecorator;

public class DocumentRendererDecoratorTest {

    @Test
    public void whenGetRequest_thenForwardTheRequestAndDecorateTheResult(){
        Document document=new Document(Mockito.mock(DocumentLoader.class),"some urls"){};

        DocumentRenderer originalRenderer=Mockito.mock(DocumentRenderer.class);

        DocumentRendererDecorator decorator=new DocumentRendererDecorator(originalRenderer){
            @Override
            protected String getDescription(Document document) {
                return "It is decorate";
            }
        };

        DocumentRendererDecorator spyDecorator=Mockito.spy(decorator);

        document.render(spyDecorator);

        ArgumentCaptor<Document> captor=ArgumentCaptor.forClass(Document.class);
        verify(originalRenderer,times(1)).render(captor.capture());

        assertEquals(document, captor.getValue());

        verify(spyDecorator,times(1)).render(captor.capture());

        assertEquals(document, captor.getValue());
    }
    

}