import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;

/**
 * @author Brandon Hernández 19376
 * @author Carlos Ráxtum
 *
 * Se encarga de mandar una instancia de un
 * map<k,v> en el que ambos son strings
 */

public class Factory{

    /**
     * Devuelve una instancia de un map
     *
     * @param mapType es la instancia que quiere
     * @return una instancia
     */
    public Map<String, String > getMyMap(String mapType){

        switch (mapType){
            case "1":
                return new HashMap<>();
            case "2":
                return new TreeMap<>();
            default:
                return new LinkedHashMap<>();
        }

    }

}
