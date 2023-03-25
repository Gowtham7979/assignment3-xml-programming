package schema;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class DomParserDTD {

    public static void main(String[] args)
    {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);
            factory.setNamespaceAware(true);

            DocumentBuilder builder = factory.newDocumentBuilder();
            builder.setErrorHandler(new SimpleErrorHandler());

            Document doc = builder.parse("cinema.xml");

            NodeList movies = doc.getElementsByTagName("movie");

            for (int i = 0; i < movies.getLength(); i++) {
                Element movie = (Element) movies.item(i);
                String id = movie.getAttribute("id");
                String title = movie.getElementsByTagName("title").item(0).getTextContent();
                String director = movie.getElementsByTagName("director").item(0).getTextContent();
                String budget = movie.getElementsByTagName("budget").item(0).getTextContent();
                String currency = ((Element) movie.getElementsByTagName("budget").item(0)).getAttribute("currency");
                System.out.println("Movie ID: " + id);
                System.out.println("Title: " + title);
                System.out.println("Director: " + director);
                System.out.println("Budget: " + currency + " " + budget);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class SimpleErrorHandler implements ErrorHandler {

        public void warning(SAXParseException e) throws SAXException {
            System.out.println(e.getMessage());
        }

        public void error(SAXParseException e) throws SAXException {
            System.out.println(e.getMessage());
        }

        public void fatalError(SAXParseException e) throws SAXException {
            System.out.println(e.getMessage());
        }
    }
}
