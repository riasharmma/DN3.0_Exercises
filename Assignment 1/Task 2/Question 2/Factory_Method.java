public class Factory_Method {
  interface Document {
    void open();
    void close();
    void save();
  }

  static class WordDocument implements Document {

    @Override
    public void open() {
      System.out.println("Opening Word document...");
    }

    @Override
    public void close() {
      System.out.println("Closing Word document...");
    }

    @Override
    public void save() {
      System.out.println("Saving Word document...");
    }
  }

  static class PdfDocument implements Document {

    @Override
    public void open() {
      System.out.println("Opening PDF document...");
    }

    @Override
    public void close() {
      System.out.println("Closing PDF document...");
    }

    @Override
    public void save() {
      System.out.println("Saving PDF document...");
    }
  }

  static class ExcelDocument implements Document {

    @Override
    public void open() {
      System.out.println("Opening Excel document...");
    }

    @Override
    public void close() {
      System.out.println("Closing Excel document...");
    }

    @Override
    public void save() {
      System.out.println("Saving Excel document...");
    }
  }

  abstract static class DocumentFactory {

    public abstract Document createDocument();
  }

  static class WordDocumentFactory extends DocumentFactory {

    @Override
    public Document createDocument() {
      return new WordDocument();
    }
  }

  static class PdfDocumentFactory extends DocumentFactory {

    @Override
    public Document createDocument() {
      return new PdfDocument();
    }
  }

  static class ExcelDocumentFactory extends DocumentFactory {

    @Override
    public Document createDocument() {
      return new ExcelDocument();
    }
  }

  public static void main(String[] args) {
    DocumentFactory wordFactory = new WordDocumentFactory();
    Document wordDoc = wordFactory.createDocument();
    wordDoc.open();
    wordDoc.save();
    wordDoc.close();

    DocumentFactory pdfFactory = new PdfDocumentFactory();
    Document pdfDoc = pdfFactory.createDocument();
    pdfDoc.open();
    pdfDoc.save();
    pdfDoc.close();

    DocumentFactory excelFactory = new ExcelDocumentFactory();
    Document excelDoc = excelFactory.createDocument();
    excelDoc.open();
    excelDoc.save();
    excelDoc.close();
  }
}
