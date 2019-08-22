package MojProgram;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XML {

    private Document xml;
    private String city;

    public XML(Document xml, String city) {
        this.xml = xml;
        this.city = city;
    }

    public void prognozaPogody(){
        NodeList calaPogoda =  xml.getElementsByTagName("weather");
        System.out.println("Pogoda miasta: "+city+" na "+calaPogoda.getLength()+" dni");
        for (int i = 0; i <calaPogoda.getLength();i++) {
            Element pogoda =(Element) calaPogoda.item(i);
            wyswietlaniePogody(pogoda);
        }
    }

    public void wyswietlaniePogody(Element pogoda) {
        // wyjecie danych o dacie poprzez pomocnicza metode getTextContent
        System.out.println("\t" + getTextContent("date", pogoda));
        // pobranie tempetratur z dodatkowym wyliczeniem średniej
        System.out.println("Maksymalna temperatura: " +getTextContent("maxtempC", pogoda));
        System.out.println("Minimalna temperatura: " +getTextContent("mintempC", pogoda));
        System.out.println("Srednia temperatura: "+getTextContent("avgtempC",pogoda));
        System.out.println("Zachmurzenie: " + getTextContent("sunHour", pogoda) + "h");
        System.out.println();

        }

    private String getTextContent(String elementTag, Element element) {
        return element.getElementsByTagName(elementTag).item(0).getTextContent();
    }
}
