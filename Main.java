package MojProgram;

import org.w3c.dom.Document;

public class Main {

    public static void main(String[] args) {
        Dane dane = new Dane();
        String miasto = dane.miasto();
        int dni = dane.liczbaDni();

        Connector connector = new Connector(miasto, dni);
            // wywolanie metody getDeocument dostarcza obiekt typu Documen z danymi od serwera w formacie xml
            Document dokument = connector.getDocument();
            // tworzymy xmlParserser odpowiedzialny za odczytanie danych z xml
            // przy tworzeniu przekazujemy otrzymany wczesniej dokument i nazwe miasta
            XML xmlParser = new XML(dokument, miasto);
            // wywołujemy metode diplay odpowiedzialną za wyświetlenie całości informacji na konsole
            xmlParser.prognozaPogody();
    }
    // solid, wstrzykiwanie zależności dependency indections, uncheck -> runtime ex, jesli w try cache to program działą dalej,
    // jestli throw to się kończy program, interfejs funkcyjny, lambda, stream , collections, statcyczna metoda i niestatyczna,
    // typy proste, typy złożone, po object jest -> toString, equals, hashCode, getClass, pattern null object,
    // łączenie branczy marche, w enumach jest konstruktor prywatny, obiekty w enum są statyczne, publiczne, finalne, czysty kod,
    // singleoton-> w enumie, zmienne lokalne ->razem z metodami są przechowywane, a pola z klasami, castowanie, przekazuje w
    // javie wartość a nie referencje,złożoność obliczneniowa( ile czasu(czasowa), ile zasobów potrzeba(pamięcowa)
    // <= kosztowność algorytmu, algorytmy sortujące! <= quick sort, wstawianie, wybór, budowanie projektu<= maven,
    // kiss <= jak najprościej pisać program, dry-> jak najmniej powtarzać kod,
    //

}
