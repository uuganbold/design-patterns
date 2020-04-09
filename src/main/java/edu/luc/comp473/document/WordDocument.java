package edu.luc.comp473.document;

import edu.luc.comp473.loader.DocumentLoader;

public class WordDocument extends Document {

    @Override
    public void load() {
        System.out.println("Loading Word Document");
        super.load();
    }

    public WordDocument(DocumentLoader loader, String url) {
        super(loader,url);
    }
    
}