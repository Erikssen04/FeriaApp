package org.example.Validador;

import java.io.File;

public class Helper {

    // Método que comprueba la existencia del fichero XML
    public static boolean existeXML() {

        // Dirección del fichero XML
        File xmlFilePath = new File("src/main/java/org/example/Ficheros/casetas.xml");

        if (xmlFilePath.exists()) {
            return true;    //Si el fichero ha sido creado previamente, el método devuelve true
        } else {
            System.out.println("Error: El archivo casetas.xml no existe.");
            return false;
        }
    }

    // Método que comprueba la existencia del fichero XML
    public static boolean existeJSON() {

        //Dirección del fichero JSON
        File jsonFilePath = new File("src/main/java/org/example/Ficheros/casetas.json");

        if (jsonFilePath.exists()) {
            return true;    //Si el fichero ha sido creado previamente, el método devuelve true
        } else {
            System.out.println("Error: El archivo casetas.json no existe.");
            return false;
        }
    }

    // Método para validar la entrada numérica del usuario, asegurándonos de que sea un número entero
    public static boolean comprobarNumCaseta(int numCaseta, int tamanoListaCasetas) {
        if (numCaseta > 0 && numCaseta <= tamanoListaCasetas) {
            return true;
        } else {
            System.out.println("Error: No se ha encontrado caseta con el numero introducido");
            return false;
        }
    }
}

