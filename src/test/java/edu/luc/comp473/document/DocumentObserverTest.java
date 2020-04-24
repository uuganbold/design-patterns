package edu.luc.comp473.document;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import edu.luc.comp473.loader.DocumentLoader;
import edu.luc.comp473.observer.Observable;
import edu.luc.comp473.observer.Observer;

public class DocumentObserverTest {

    @Test
    public void whenAddObserver_thenCountOfObserversIncreased(){
        Document document=new Document(Mockito.mock(DocumentLoader.class),"some urls"){};

        Observer observer1=Mockito.mock(Observer.class);
        document.registerObserver(observer1);

        assertEquals(1, document.countObservers());

        Observer observer2=Mockito.mock(Observer.class);
        document.registerObserver(observer2);
        assertEquals(2,document.countObservers());
    }

    @Test
    public void whenRemoveObserver_thenCountOfObserversDecreased(){
        Document document=new Document(Mockito.mock(DocumentLoader.class),"some urls"){};

        Observer observer1=Mockito.mock(Observer.class);
        Observer observer2=Mockito.mock(Observer.class);
        document.registerObserver(observer1);
        document.registerObserver(observer2);

        assertEquals(2, document.countObservers());

        document.removeObserver(observer1);
        assertEquals(1, document.countObservers());

        document.removeObserver(observer2);
        assertEquals(0, document.countObservers());

    }


    @Test
    public void whenRemoveObserverWhichIsNotRegistered_thenCountOfObserversRemainSame(){
        Document document=new Document(Mockito.mock(DocumentLoader.class),"some urls"){};

        Observer observer1=Mockito.mock(Observer.class);
        Observer observer2=Mockito.mock(Observer.class);
        document.registerObserver(observer1);

        assertEquals(1, document.countObservers());

        document.removeObserver(observer2);
        assertEquals(1, document.countObservers());
    }

    @Test
    public void whenNotifyObservers_thenObserversReceiveNotifications(){
        Document document=new Document(Mockito.mock(DocumentLoader.class),"some urls"){};

        Observer observer1=Mockito.mock(Observer.class);
        Observer observer2=Mockito.mock(Observer.class);
        document.registerObserver(observer1);
        document.registerObserver(observer2);

        assertEquals(2, document.countObservers());
        document.notifyObservers();

        ArgumentCaptor<Observable> captor=ArgumentCaptor.forClass(Observable.class);
        verify(observer1,times(1)).update(captor.capture());
        assertEquals(document, captor.getValue());

        verify(observer2,times(1)).update(captor.capture());
        assertEquals(document, captor.getValue());
    }

    @Test
    public void whenRemoveObservers_thenObserverNotReceiveNotification(){
        Document document=new Document(Mockito.mock(DocumentLoader.class),"some urls"){};

        Observer observer1=Mockito.mock(Observer.class);
        Observer observer2=Mockito.mock(Observer.class);
        document.registerObserver(observer1);
        document.registerObserver(observer2);

        assertEquals(2, document.countObservers());

        document.removeObserver(observer1);
        assertEquals(1, document.countObservers());


        document.notifyObservers();

        ArgumentCaptor<Observable> captor=ArgumentCaptor.forClass(Observable.class);
        verify(observer1,never()).update(captor.capture());

        verify(observer2,times(1)).update(captor.capture());
        assertEquals(document, captor.getValue());
    }

}