package edu.luc.comp473.renderer;

import edu.luc.comp473.document.Document;

public class JavaFXRenderer implements DocumentRenderer {

    @Override
    public void render(Document document) {
        System.out.println("Rendering document on JavaFX UI");
        System.out.println(new String(document.getContent()));
    }
    
}