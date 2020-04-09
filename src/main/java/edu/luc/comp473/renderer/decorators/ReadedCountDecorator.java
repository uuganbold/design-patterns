package edu.luc.comp473.renderer.decorators;

import edu.luc.comp473.document.Document;
import edu.luc.comp473.observer.observers.RenderCounter;
import edu.luc.comp473.renderer.DocumentRenderer;

public class ReadedCountDecorator extends DocumentRendererDecorator {

    private RenderCounter counter;

    public ReadedCountDecorator(DocumentRenderer renderer, RenderCounter counter ) {
        super(renderer);
        this.counter=counter;
    }

    protected String getDescription(Document document){
        return "document readed:"+counter.getCount(document);
    }

}