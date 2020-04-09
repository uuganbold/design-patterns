package edu.luc.comp473.renderer.decorators;

import edu.luc.comp473.document.Document;
import edu.luc.comp473.renderer.DocumentRenderer;

public class FileSizeDecorator extends DocumentRendererDecorator{

    public FileSizeDecorator(DocumentRenderer renderer) {
        super(renderer);
    }

    protected String getDescription(Document document){
        return "file size:"+document.getContent().length;
    }

}