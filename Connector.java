package MojProgram;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Connector {
    private String miasto;
    private int dni;
    private URL url;

    public Connector(String miasto, int dni) {
        this.miasto = miasto;
        this.dni = dni;
        getUrl();
        getDocument();
    }

    public URL getUrl() {
        try {
            url = new URL("http://api.worldweatheronline.com/premium/v1/weather.ashx?key=50bbbb6190ff48a084f91138192208&q=" + miasto + "&num_of_days=" + dni + "&format=xml");

        } catch (MalformedURLException e) {
            System.out.println("Problem z połączeniem ");
        }
        return url;
    }

    public Document getDocument() {
        Document document = null;
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DataInputStream data = new DataInputStream(connection.getInputStream());
            document = builder.parse(data);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    return document;
    }
}
