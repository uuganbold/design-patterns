package edu.luc.comp473;

import edu.luc.comp473.document.Document;
import edu.luc.comp473.document.PdfDocument;
import edu.luc.comp473.document.WordDocument;
import edu.luc.comp473.factory.DocumentLoaderFactory;
import edu.luc.comp473.factory.SimpleDocumentLoaderFactory;
import edu.luc.comp473.loader.DocumentLoader;
import edu.luc.comp473.observer.observers.EmailNotifier;
import edu.luc.comp473.observer.observers.RenderCounter;
import edu.luc.comp473.renderer.ConsoleRenderer;
import edu.luc.comp473.renderer.DocumentRenderer;
import edu.luc.comp473.renderer.JavaFXRenderer;
import edu.luc.comp473.renderer.decorators.FileSizeDecorator;
import edu.luc.comp473.renderer.decorators.FileTypeDecorator;
import edu.luc.comp473.renderer.decorators.ReadedCountDecorator;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        System.out.println("Welcome to Document Management System!");
        System.out.println("This system uses");
        System.out.println("1. Factory method");
        System.out.println("2. Bridge");
        System.out.println("3. Observer");
        System.out.println("4. Visitor");
        System.out.println("5. Decorator");
        System.out.print("---------------------------------\n\n");

        final String documentUrl1="file:///home/user/Document/wordfile.docx";
        final String documentUrl2="https://drive.google.com/file/d/1vOJHZmV1FDZQSqcasdfAx53/view?usp=sharing";
        final String documentUrl3="https://onedrive.live.com/?cid=A439A08BEA94&id=A439A6EA94%21106&parId=A439A6C5E08BEA94%21103&o=OneUp";

        final DocumentLoaderFactory loaderFactory=new SimpleDocumentLoaderFactory();
        final DocumentLoader loader1=loaderFactory.createLoader(documentUrl1);
        final DocumentLoader loader2=loaderFactory.createLoader(documentUrl2);
        final DocumentLoader loader3=loaderFactory.createLoader(documentUrl3);

        System.out.print("---------------------------------\n\n");


        final Document doc1=new WordDocument(loader1,documentUrl1);
        final Document doc2=new PdfDocument(loader2,documentUrl2);
        final Document doc3=new PdfDocument(loader3,documentUrl3);

        doc1.load();
        System.out.print("---------------------------------\n");

        doc2.load();
        System.out.print("---------------------------------\n");

        doc3.load();

        System.out.print("---------------------------------\n\n");

        final RenderCounter renderCounter=new RenderCounter();
        doc1.registerObserver(renderCounter);
        doc2.registerObserver(renderCounter);

        final EmailNotifier emailNotifier2=new EmailNotifier();
        doc2.registerObserver(emailNotifier2);

        final DocumentRenderer console=new ReadedCountDecorator(
                                        new FileSizeDecorator(
                                            new FileTypeDecorator(
                                                new ConsoleRenderer()
                                            )
                                        ), renderCounter);

        final DocumentRenderer javafx=new FileSizeDecorator(
            new FileTypeDecorator(new JavaFXRenderer())
        );


   
        doc1.render(javafx);
        System.out.print("---------------------------------\n");

        doc1.render(console);
        System.out.print("---------------------------------\n");
        doc2.render(javafx);
        System.out.print("---------------------------------\n");
        doc2.render(console);
        System.out.print("---------------------------------\n");
        doc3.render(javafx);
        System.out.print("---------------------------------\n");
        doc3.render(console);

    }
}
