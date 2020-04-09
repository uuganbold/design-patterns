package edu.luc.comp473.renderer.decorators;

import edu.luc.comp473.document.Document;
import edu.luc.comp473.renderer.DocumentRenderer;

public class FileTypeDecorator extends DocumentRendererDecorator {

    protected String getDescription(Document document) {
        String className=document.getClass().getSimpleName();
        return "file type:"+className.substring(0,className.length()-"Document".length());
    }

    public FileTypeDecorator(DocumentRenderer renderer) {
        super(renderer);
    }

}