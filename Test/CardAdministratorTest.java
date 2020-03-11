import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.*;

public class CardAdministratorTest {

    @Test
    public void showCards() {
        MyMap<String, String[]> map = new MyHashMap<>();

        // Variables necesarias para poder leer y guardar
        String readTxt;
        String[] cardContainer = new String[1];
        String[] key;
        int sup = 100;

        // Leyendo el archivo de texto y agregandolo a la compuerta
        try {
            FileReader fr = new FileReader("cards_desc.txt");
            BufferedReader bf = new BufferedReader(fr);

            // Generando números aleatorios y metiendolos al .txt
            for (int i = 0; i < sup; i++){
                readTxt = bf.readLine();
                key = readTxt.split("\\|");
                cardContainer[0] = key[1];
                map.put(key[0], cardContainer);
            }

            bf.close();
        } catch (IOException e) {
            System.out.println("Did do");
        }



    }
}