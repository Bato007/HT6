import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CardAdministrator {

    public MyMap<String, String[]> readText(MyMap<String, String[]> empty, String needRead){
        // Variables necesarias para poder leer y guardar
        String readTxt, readContainer, key = "";
        String[] cardContainer = new String[1];

        // Leyendo el archivo de texto y agregandolo a la compuerta
        try {
            FileReader fr = new FileReader(needRead);
            BufferedReader bf = new BufferedReader(fr);

            // Generando números aleatorios y metiendolos al .txt
            while((readTxt = bf.readLine()) != null){
                readContainer = "";

                for(int i = 0; i < readTxt.length(); i++){
                    if(readTxt.charAt(i) != '|'){
                        readContainer += readTxt.charAt(i);
                    }else{
                        key = readContainer;
                        readContainer = "";
                    }
                }
                cardContainer[0] = readContainer;

                empty.put(key, cardContainer);
            }
            bf.close();
        } catch (IOException e) {
            System.out.println("Did do");
        }

        return empty;
    }

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

}
