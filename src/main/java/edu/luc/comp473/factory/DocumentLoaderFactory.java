package edu.luc.comp473.factory;

import edu.luc.comp473.loader.*;

public interface DocumentLoaderFactory {

    public DocumentLoader createLoader(String url);
}