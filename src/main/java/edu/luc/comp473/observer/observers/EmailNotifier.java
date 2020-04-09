package edu.luc.comp473.observer.observers;

import edu.luc.comp473.document.Document;
import edu.luc.comp473.observer.Observable;
import edu.luc.comp473.observer.Observer;

public class EmailNotifier implements Observer{

    public void update(Observable observable){
        Document doc=(Document)observable; 
        System.out.println("Sending email notification");
        System.out.println("File readed:"+doc.getUrl());
    }

}