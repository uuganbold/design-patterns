package edu.luc.comp473.renderer.decorators;

import edu.luc.comp473.document.Document;
import edu.luc.comp473.renderer.DocumentRenderer;

public abstract class DocumentRendererDecorator implements DocumentRenderer {
    private DocumentRenderer renderer;

    public DocumentRendererDecorator(DocumentRenderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public void render(Document document) {
        System.out.println("Decorator pattern usage:"+this.getClass().getSimpleName()+", description:"+getDescription(document));
        renderer.render(document);
    }

    protected abstract String getDescription(Document document);

    
}