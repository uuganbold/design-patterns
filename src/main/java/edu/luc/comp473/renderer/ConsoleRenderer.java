package edu.luc.comp473.renderer;

import edu.luc.comp473.document.Document;

public class ConsoleRenderer implements DocumentRenderer {

    @Override
    public void render(Document document) {
        System.out.println("Rendering document on the console");
        System.out.println(new String(document.getContent()));

    }

    
}