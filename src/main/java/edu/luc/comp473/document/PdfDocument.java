package edu.luc.comp473.document;

import edu.luc.comp473.loader.DocumentLoader;

public class PdfDocument extends Document {

    public PdfDocument(DocumentLoader loader, String url) {
        super(loader,url);
    }

    @Override
    public void load() {
        System.out.println("Loading PDF document");
        super.load();
    }

    
    
}