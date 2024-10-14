package org.example.MenuPrincipal;

// Autor: Eric Macià Gómez

import org.example.Logica.MostrarCasetas;
import org.example.Logica.Unmarshalling;
import org.example.Objetos.CasetaFeria;
import org.example.Logica.Generador;
import org.example.Logica.Marshalling;
import org.example.Validador.Helper;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        // Creación del objeto Scanner para solicitar datos por teclado
        Scanner sc = new Scanner(System.in);

        System.out.println("¡Bienvenido a FeriaApp!\n");

        // Atributos
        int opcionSeleccionada;
        int numCaseta;
        boolean opcionValida = false;

        // Creación de una lista ArrayList<CasetaFeria>
        ArrayList<CasetaFeria> listaObjetosCasetas;

        // Guardar cada objeto generado en el ArrayList declarado anteriormente
        listaObjetosCasetas = Generador.objetoCasetas();

        // Bucle do..while, solo finalizará cuando el usuario introduzca como opción un 7.
        do {

            // Menú visible en terminal
            System.out.print("Por favor, seleccione la opción deseada: \n\n" +
                    "1. Marshalling casetas a XML.\n" +
                    "2. Unmarshalling casetas de XML\n" +
                    "3. Mostrar la caseta número X.\n" +
                    "4. Marshalling casetas a JSON.\n" +
                    "5. Unmarshalling casetas de JSON.\n" +
                    "6. Mostrar la caseta número X desde JSON\n" +
                    "7. Salir\n\n");

            // Lectura de la opción seleccionada por teclado
            opcionSeleccionada = sc.nextInt();

            // Condición que se ejecutará si la opción seleccionada comprende los valores que admite el menú (1-7)
            if (opcionSeleccionada > 0 && opcionSeleccionada < 8) {

                // Estructura switch que ejecutará un caso concreto que deriva de la opción selecionada
                switch (opcionSeleccionada) {
                    case 1:
                        System.out.println("Operación en proceso: Marshalling casetas a XML\n");

                        // Invocar método que procesará el marshalling a XML, pasando la lista de objetos como parámetro
                        Marshalling.mXML(listaObjetosCasetas);

                        break;
                    case 2:
                        System.out.println("Operación en proceso: Unmarshalling casetas de XML\n");

                        if (Helper.existeXML()) {
                            // Invocar método que procesará el unmarshalling del fichero XML
                            Unmarshalling.umXML();
                        }

                        break;
                    case 3:
                        System.out.println("Operación en proceso: Mostrar la caseta número X desde XML\n");
                        System.out.println("Por favor indique el número de identificación de la caseta a mostrar: ");
                        numCaseta = sc.nextInt();

                        if (Helper.existeXML() && Helper.comprobarNumCaseta(numCaseta, listaObjetosCasetas.size())) {

                            /* Invocar método que, pasado el id, mostrará la caseta que queremos. Validación previa a
                               partir del tamaño de la lista de casetas*/
                            MostrarCasetas.mostrarDesdeXML(numCaseta);

                        }
                        break;
                    case 4:
                        System.out.println("Operación en proceso: Marshalling casetas a JSON\n");

                        // Invocar método que procesará el marshalling a JSON, pasando la lista de objetos como parámetro
                        Marshalling.mJSON(listaObjetosCasetas);
                        break;
                    case 5:
                        System.out.println("Operación en proceso: Unmarshalling casetas de JSON.\n");

                        if (Helper.existeJSON()) {
                            // Invocar método que procesará el unmarshalling del fichero JSON
                            Unmarshalling.umJSON();
                        }
                        break;
                    case 6:
                        System.out.println("Operación en proceso: Mostrar la caseta número X desde JSON\n");
                        System.out.println("Por favor indique el número de identificación de la caseta a mostrar: ");
                        numCaseta = sc.nextInt();

                        // Si los validadores del helper son ambos true, se procede a la mostrar las casetas
                        if (Helper.existeJSON() && Helper.comprobarNumCaseta(numCaseta, listaObjetosCasetas.size())) {

                            /* Invocar método que, pasado el id, mostrará la caseta que queremos. Validación previa a
                               partir del tamaño de la lista de casetas*/
                            MostrarCasetas.mostrarDesdeJSON(numCaseta);

                        }
                        break;
                    case 7:
                        opcionValida = true;
                        System.out.print("Se procederá a salir del programa\n" +
                                "¡Gracias por usar FeriaApp!");
                        System.exit(1); //Sale del sistema de forma correcta
                    default:
                        System.out.println("Opción seleccionada no válida");
                        break;
                }
            } else {
                System.out.println("Opción seleccionada no válida");
            }
        } while (!opcionValida);
    }
}