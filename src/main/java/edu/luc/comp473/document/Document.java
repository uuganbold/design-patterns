package edu.luc.comp473.document;

import java.util.ArrayList;
import java.util.List;

import edu.luc.comp473.loader.DocumentLoader;
import edu.luc.comp473.observer.Observable;
import edu.luc.comp473.observer.Observer;
import edu.luc.comp473.renderer.DocumentRenderer;

public abstract class Document implements Observable{

    private List<Observer> observers=new ArrayList<>();

    protected DocumentLoader loader;

    protected byte[] content;
    protected String url;

    public Document(DocumentLoader loader, String url){
         this.loader=loader;
         this.setUrl(url);
    }

    public void setUrl(String url){
        this.url=url;
    }

    public String getUrl(){
        return url;
    }
    
    public DocumentLoader getLoader(){
        return loader;
    }

    public byte[] getContent(){
        return content;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    @Override
    public void notifyObservers() {
        System.out.println("Observer pattern usage:\nNotifying observers that the document is rendered");
        for (Observer ob : observers) {
            ob.update(this);
        }
    }

     
    public void load(){
        System.out.println("Usage of Bridge Pattern: Loading document using DocumentLoader which is implementation logic");
        this.content=loader.load(this.url);
    }

    public void render(DocumentRenderer renderer){
        System.out.println("Rendering document using Visitor pattern");
        renderer.render(this);
        notifyObservers();
    }

    
}