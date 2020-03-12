import java.util.*;
import java.io.*;
/**
 * @author Brandon Hernández 19376
 * @author Carlos Ráxtum
 *
 * Realiza las acciones repetidas que hay en el arranque del programa
 */
public class CardAdministrator {

    // Consiguiendo todas las llaves
    ArrayList<String> keys = new ArrayList<>();
    ArrayList<String > pKeys = new ArrayList<>();

    /**
     * Llena un maso
     * @param empty es el maso sin nada
     * @param needRead archivo de texto de donde se van a jalar los datos
     */
    public void readText(MyMap<String, String> empty, String needRead, Integer cardsToRead){

        // Variables necesarias para poder leer y guardar
        String readTxt;
        String[] key;
        Integer contador = 0;

        // Leyendo el archivo de texto y agregandolo a la compuerta
        try {
            FileReader fr = new FileReader(needRead);
            BufferedReader bf = new BufferedReader(fr);

            // Generando números aleatorios y metiendolos al .txt
            while(contador < cardsToRead) {
                readTxt = bf.readLine();
                key = readTxt.split("\\|");
                keys.add(key[0]);
                empty.put(key[0], key[1]);
                contador++;
            }

            bf.close();
        } catch (IOException e) {
            System.out.println("Did do");
        }

    }

    /**+
     * Agrega una nueva carta al maso
     * @param playerCards es el maso a la que se le quiere agregar el maso
     * @param insert llave/valor que se le quiere insertar al maso
     * @return maso con la nueva carta o actualizada
     */
    public MyMap<String, String> addNewPlayerCard(MyMap<String, String> playerCards, String[] insert){
        boolean flag = false;
        int contador = 0;
        String aux;

        // Verificando si ya esta en el mapa
        if(playerCards.containsKey(insert[0])){
            aux = playerCards.get(insert[0]);

            // Verificando que sea un numero
            contador = Integer.parseInt(aux.substring(aux.length() - 1)) + 1;
            aux = aux.substring(0, aux.length() - 1) + contador;

            playerCards.replace(insert[0], playerCards.get(insert[0]), aux);
        // Metiendo si no hay
        }else{
            pKeys.add(insert[0]);
            playerCards.put(insert[0], insert[1] + "1");
        }
        return playerCards;
    }

    /**
     * Consiguie la informacion de una coleccion de cartas
     * @param cards es la coleccion de tipo mapa a la que se le quiere sacar la informacion
     * @param isPlayer valor que define si es
     * @return informacion de la llave, valor y cantidad (si la hay)
     */
    public String[][] showCards(MyMap<String, String> cards, Boolean isPlayer){
        String[][] sCards = new String[keys.size()][3];
        String temp;

        // Consiguiendo las cartas en el
        if(cards.size() != 0){

            if(isPlayer){

                for(int i = 0; i < pKeys.size(); i++){
                    temp = cards.get(pKeys.get(i));
                    sCards[i][0] = pKeys.get(i);
                    sCards[i][1] = temp.substring(0, temp.length() - 1);
                    sCards[i][2] = temp.substring(temp.length() - 1);
                }

            }else{
                for(int i = 0; i < keys.size(); i++){
                    sCards[i][0] = keys.get(i);
                    sCards[i][1] = cards.get(keys.get(i));
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
