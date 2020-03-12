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
     * @return una instancia de un mapa
     */
    public MyMap<String, String> getMyMap(String mapType){

        switch (mapType){
            case "1":
                return new MyHashMap<>();
            case "2":
                return new MyTreeMap<>();
            default:
                return new MyLinkedHashMap<>();
        }

    }

}
