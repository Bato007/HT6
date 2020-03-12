import org.junit.Test;

import static org.junit.Assert.*;

public class CardAdministratorTest {

    @Test
    public void showCards() {
        CardAdministrator cards = new CardAdministrator();
        MyMap<String, String> map = new MyTreeMap<>();
        String[][] showCards;

        cards.readText(map, "cards_desc.txt", 100);

        System.out.println("| Estas son las cartas en la coleccion:\n");
        showCards = cards.showCards(map, false);

        for(int i = 0; i < map.size(); i++){
            System.out.println( (i + 1) + "| La carta " + showCards[i][0] + " es de tipo " + showCards[i][1]);
        }

    }
}