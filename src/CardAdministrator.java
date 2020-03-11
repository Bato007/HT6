import java.io.*;
import java.util.ArrayList;
/**
 * @author Brandon Hernández 19376
 * @author Carlos Ráxtum
 *
 * Realiza las acciones repetidas que hay en el arranque del programa
 */
public class CardAdministrator {

    // Consiguiendo todas las llaves
    ArrayList<String> keys = new ArrayList<>();

    /**
     * Llena un maso
     * @param empty es el maso sin nada
     * @param needRead archivo de texto de donde se van a jalar los datos
     */
    public void readText(MyMap<String, String[]> empty, String needRead){
        // Variables necesarias para poder leer y guardar
        String readTxt;
        String[] cardContainer = new String[1];
        String[] key;

        // Leyendo el archivo de texto y agregandolo a la compuerta
        try {
            FileReader fr = new FileReader(needRead);
            BufferedReader bf = new BufferedReader(fr);

            // Generando números aleatorios y metiendolos al .txt

            for (int i = 0; i < 100; i++){
                readTxt = bf.readLine();
                key = readTxt.split("\\|");
                keys.add(key[0]);
                System.out.println(key[1]);
                cardContainer[0] = key[1];
                empty.put(key[0], cardContainer);
            }

            bf.close();
        } catch (IOException e) {
            System.out.println("Did do");
        }

        System.out.println("final" + keys.get(0));
    }

    /**
     * Agrega una nueva carta al maso
     * @param playerCards es el maso a la que se le quiere agregar el maso
     * @param insert llave/valor que se le quiere insertar al maso
     * @return maso con la nueva carta o actualizada
     */
    public MyMap<String, String[]> addNewPlayerCard(MyMap<String, String[]> playerCards, String[] insert){
        String[] insertA = new String[2];

        // Verificando si ya esta en el mapa
        if(playerCards.containsKey(insert[0])){
            insertA = playerCards.get(insert[0]);
            insertA[1] = Integer.toString(Integer.parseInt(insertA[1]) + 1);
            playerCards.replace(insert[0], playerCards.get(insert[0]), insertA);
        // Metiendo si no hay
        }else{
            insertA[0] = insert[1];
            insertA[1] = "1";
            playerCards.put(insert[0], insertA);
        }
        return playerCards;
    }

    /**
     * Consiguie la informacion de una coleccion de cartas
     * @param cards es la coleccion de tipo mapa a la que se le quiere sacar la informacion
     * @return informacion de la llave, valor y cantidad (si la hay)
     */
    public String[][] showCards(MyMap<String, String[]> cards){
        String[][] sCards = new String[keys.size()][3];
        boolean isPlayer;

        // Consiguiendo las cartas en el
        if(cards.size() != 0){
            isPlayer = (cards.get(keys.get(0)).length == 2);

            for(int i = 0; i < cards.size(); i++){
                sCards[i][0] = keys.get(i);
                sCards[i][1] = cards.get(keys.get(i))[0];

                if(isPlayer){
                    sCards[i][2] = cards.get(keys.get(i))[1];
                }else {
                    sCards[i][2] = "";
                }
            }

        }
        return sCards;
    }

    /**
     * Ordena las cartas
     * @param cards cartas sin ordenar
     * @return las cartas ordenadas
     */
    public String[][] sort(String[][] cards){
        String[][] sortedCards = new String[cards.length][3];
        int contador= 0;

        for (int i = 0; i < cards.length; i++){
            if(cards[i][1].equals("Monstruo")){
                sortedCards[contador][0] = cards[i][0];
                sortedCards[contador][1] = cards[i][1];
                sortedCards[contador][2] = cards[i][2];
                contador++;
            }
        }

        for (int i = 0; i < cards.length; i++){
            if(cards[i][1].equals("Hechizo")){
                sortedCards[contador][0] = cards[i][0];
                sortedCards[contador][1] = cards[i][1];
                sortedCards[contador][2] = cards[i][2];
                contador++;
            }
        }

        for (int i = 0; i < cards.length; i++){
            if(cards[i][1].equals("Trampa")){
                sortedCards[contador][0] = cards[i][0];
                sortedCards[contador][1] = cards[i][1];
                sortedCards[contador][2] = cards[i][2];
                contador++;
            }
        }

        return sortedCards;
    }
}
