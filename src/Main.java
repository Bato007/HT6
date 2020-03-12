import java.io.IOException;
import java.util.*;
/**
 * @author Brandon Hernández 19376
 * @author Carlos Ráxtum
 *
 * Punto inicial del programa
 */
public class Main {

    public static void main(String[] args){
        // Instancia del factory, reserva de espacio para el map y el administrador de las cartas
        Factory factory = new Factory();
        CardAdministrator cards = new CardAdministrator();
        Scanner input = new Scanner(System.in);

        // Implementaciones de mapas
        MyMap<String, String> cardsDesc;
        MyMap<String, String> playersDesc;

        // Atributos
        String[] inputCard = new String[2];
        String[][] showCards;
        String option;

        // Pidiendole la implementación al usuario
        System.out.println("|\tBienvenido a su administrador de cartas");
        System.out.println("| 1. HasMap");
        System.out.println("| 2. TreeMap");
        System.out.println("| 3. LinkedHasMap");
        System.out.print("| Ingrese desea guardar su coleccion: ");
        option = input.nextLine();

        // Instanciando los maps y llenando las cartas
        cardsDesc = factory.getMyMap(option);
        playersDesc = factory.getMyMap(option);

        cards.readText(cardsDesc,"Cards_desc.txt", 8861);

        // Empezando el menu
        while(!option.equals("7")){
            System.out.println("|\n|\n|\tEstas son las opciones que se pueden realizar:");
            System.out.println("| 1. Agregar carta al maso");
            System.out.println("| 2. Buscar tipo de la carta");
            System.out.println("| 3. Mostrar catas en maso");
            System.out.println("| 4. Mostrar cartas ordenadas en maso");
            System.out.println("| 5. Mostrar cartas en coleccion");
            System.out.println("| 6. Mostrar cartas ordenadas en coleccion");
            System.out.println("| 7. Salir");
            System.out.print("| Ingrese la opcion que desee: ");
            option = input.nextLine();

            // LLevando a cabo la accion que desea el usuario
            switch (option){

                // Agregar una nueva carta al maso
                case "1":
                    System.out.print("| Ingrese la carta que desea agregar: ");
                    option = input.nextLine();

                    // Verificando que exista
                    if(cardsDesc.containsKey(option)){

                        // Agregando
                        inputCard[0] = option;
                        inputCard[1] = cardsDesc.get(option);

                        playersDesc = cards.addNewPlayerCard(playersDesc, inputCard);
                        System.out.println("| Se ha agregado la carta " + option + " a su maso");
                    }else{
                        System.out.println("| La carta: " + option + " no se encuentra en la coleccion");
                    }

                    option = "";
                    break;

                // Mostrando el valor de una carta
                case "2":
                    System.out.print("| Ingrese la carta que desea consultar: ");
                    option = input.nextLine();

                    if(cardsDesc.containsKey(option)){
                        System.out.println("| La carta que selecciono es de tipo: " + cardsDesc.get(option));
                    }else{
                        System.out.println("| La carta: " + option + " no se encuentra en la coleccion");
                    }
                    option = "";
                    break;

                // Mostrar el maso del jugador
                case "3":
                    System.out.println("| Estas son las cartas en su coleccion: ");
                    showCards = cards.showCards(playersDesc, true);

                    if(playersDesc.size() != 0){
                        for(int i = 0; i < playersDesc.size(); i++){
                            System.out.println("| La carta " + showCards[i][0] + " es de tipo " +
                                    showCards[i][1] + " y existen " + showCards[i][2] + " de su tipo");
                        }
                    }else {
                        System.out.println("| No hay cartas que mostrar");
                    }
                    option = "";
                    break;

                // Mostrando el maso del jugador ordenado
                case "4":
                    System.out.println("| Estas son las cartas en su coleccion: ");
                    showCards = cards.showCards(playersDesc, true);

                    if(showCards.length != 0){
                        for(int i = 0; i < playersDesc.size(); i++){
                            System.out.println("| La carta " + showCards[i][0] + " es de tipo " + showCards[i][1]
                            + " y posee " + showCards[i][2] + " en su maso");
                        }
                    }else {
                        System.out.println("| No hay cartas que mostrar");
                    }
                    option = "";
                    break;

                // Mostrar la coleccion
                case "5":
                    System.out.println("| Estas son las cartas en la coleccion:\n");
                    showCards = cards.showCards(cardsDesc, false);

                    for(int i = 0; i < cardsDesc.size(); i++){
                        System.out.println("| La carta " + showCards[i][0] + " es de tipo " + showCards[i][1]);
                    }
                    option = "";
                    break;

                // Mostrar la coleccion ordenada
                case "6":
                    System.out.println("| Estas son las cartas ordenadas en la coleccion:\n");
                    showCards = cards.showCards(cardsDesc, false);
                    showCards = cards.sort(showCards);

                    for(int i = 0; i < cardsDesc.size(); i++){
                        System.out.println( i +"| La carta " + showCards[i][0] + " es de tipo " + showCards[i][1]);
                    }
                    option = "";
                    break;

                // Casos en los que se sale u opcion incorrecta
                case "7":
                    System.out.println("|\n|-----Se han devuelto todas las cartas, vuelva pronto-----");
                    break;
                default:
                    System.out.println("|\n|-----Ingrese una opcion valida-----");
                    option = "";
                    break;
            }

        }

    }
}
