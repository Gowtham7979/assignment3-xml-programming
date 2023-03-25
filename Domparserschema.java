
package schema;
import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.w3c.dom.Document;

public class Domparserschema {
  public static void main(String[] args) {
    try {
     
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
 Document doc = builder.parse("cinema.xml");
      SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
      Schema schema = schemaFactory.newSchema(new File("cinema.xsd"));
      Validator validator = schema.newValidator();
      validator.validate(new DOMSource(doc));
      
      System.out.println("Validation against the Schema was successful.");
    } catch (Exception e) {
      System.out.println("Validation against the Schema failed: " + e.getMessage());
    }
  }
}
