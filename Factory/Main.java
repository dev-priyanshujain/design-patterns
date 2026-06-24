// interface Document {
//     void open(String name);
// }
// class PDF implements Document {
//     @Override
//     public void open(String name) {
//         System.out.println("opening PDF: " + name);
//     }
// }
// class Excel implements Document {
//     @Override
//     public void open(String name) {
//         System.out.println("opening Excel: " + name);
//     }
// }
// class Word implements Document {
//     @Override
//     public void open(String name) {
//         System.out.println("opening Word: " + name);
//     }
// }
// interface DocumentFactory {
//     Document create();
// }
// class PDFFactory implements DocumentFactory {
//     @Override
//     public Document create() {
//         return new PDF();
//     }
// }
// class ExcelFactory implements DocumentFactory {
//     @Override
//     public Document create() {
//         return new Excel();
//     }
// }
// class WordFactory implements DocumentFactory {
//     @Override
//     public Document create() {
//         return new Word();
//     }
// }
// class Main {
//     public static void main(String[] args) {
//         DocumentFactory pdfFactory = new PDFFactory();
//         Document pdf = pdfFactory.create();
//         pdf.open("report");
//         DocumentFactory excelFactory = new ExcelFactory();
//         Document excel = excelFactory.create();
//         excel.open("spreadsheet");
//         DocumentFactory wordFactory = new WordFactory();
//         Document word = wordFactory.create();
//         word.open("document");
//     }
// }
// mitigatting the switch statement with registry pattern
// import java.util.HashMap;
// import java.util.Map;
// import java.util.function.Supplier;
// interface Document {
//     void open(String name);
// }
// class PDF implements Document {
//     public void open(String name) {
//         System.out.println("Opening PDF: " + name);
//     }
// }
// class Excel implements Document {
//     public void open(String name) {
//         System.out.println("Opening Excel: " + name);
//     }
// }
// class Word implements Document {
//     public void open(String name) {
//         System.out.println("Opening Word: " + name);
//     }
// }
// class DocumentFactory {
//     private static final Map<String, Supplier<Document>> registry =
//         new HashMap<>();
//     static {
//         registry.put("PDF", PDF::new);
//         registry.put("Excel", Excel::new);
//         registry.put("Word", Word::new);
//     }
//     public static Document createDocument(String type) {
//         Supplier<Document> creator = registry.get(type);
//         if (creator == null) {
//             throw new IllegalArgumentException("Unknown document type");
//         }
//         return creator.get();
//     }
// }
// class Main {
//     public static void main(String[] args) {
//         Document pdf = DocumentFactory.createDocument("PDF");
//         pdf.open("report");
//         Document excel = DocumentFactory.createDocument("Excel");
//         excel.open("spreadsheet");
//         Document word = DocumentFactory.createDocument("Word");
//         word.open("document");
//     }
// }
