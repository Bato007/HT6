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
        MyMap<String, String[]> cardsDesc, playersDesc;
        String[] inputCard = new String[2];
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

        cardsDesc = cards.readText(cardsDesc,"Cards_desc.txt");

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
                        inputCard[1] = cardsDesc.get(option)[0];

                        cards.addNewPlayerCard(playersDesc, inputCard);
                        System.out.println("| Se ha agregado la carta " + option + " a su maso");
                    }else{
                        System.out.println("| La carta: " + option + " no se encuentra en la coleccion");
                    }

                    break;

                // Mostrando el valor de una carta
                case "2":
                    System.out.print("| Ingrese la carta que desea consultar: ");
                    option = input.nextLine();

                    if(cardsDesc.containsKey(option)){
                        System.out.println("| La carta que selecciono es de tipo: " + cardsDesc.get(option)[0]);
                    }else{
                        System.out.println("| La carta: " + option + " no se encuentra en la coleccion");
                    }

                    break;

                case "3":

                    break;

                case "4":
                    break;

                case "5":
                    System.out.println("| Aquí se muestran las cartas: ");
                    break;

                case "6":
                    break;

                // Casos en los que se sale u opcion incorrecta
                case "7":
                    System.out.println("|\n|-----Se han devuelto todas las cartas, vuelva pronto-----");
                    break;
                default:
                    System.out.println("|\n|-----Ingrese una opcion valida-----");
                    break;
            }

        }

    }
}
