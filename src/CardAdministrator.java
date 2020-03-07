import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class CardAdministrator {

    public Map<String, String > readText(Map<String, String> empty, String needRead){
        // Variables necesarias para poder leer y guardar
        String readTxt, readContainer;
        String[] cardContainer = new String[2];

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
                        cardContainer[0] = readContainer;
                        readContainer = "";
                    }
                }
                cardContainer[1] = readContainer;

                empty.put(cardContainer[0], cardContainer[1]);
            }
            bf.close();
        } catch (IOException e) {
            System.out.println("Did do");
        }

        return empty;
    }

}
