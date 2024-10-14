package org.example.Logica;

import org.example.Objetos.CasetaFeria;

import java.io.*;
import java.util.ArrayList;

public class Generador{

    /* Este método creará, a partir del fichero casetas.txt, una lista que contiene cada caseta que aparece
       en el fichero,y será devuelta para su posterior uso. */
    public static ArrayList<CasetaFeria> objetoCasetas(){

        // Creación de la lista ArrayList<CasetaFeria> para su posterior retorno
        ArrayList<CasetaFeria> listaObjetosCasetas = new ArrayList<>();

        // Indicamos a la clase File la ruta del fichera casetas.txt para manipularlo
        File archivoCasetas = new File("src/main/resources/casetas.txt");
        String linea;

        // Bloque try-catch que contiene la clase que lee los ficheros y su lectura por linea
        try(FileReader fr = new FileReader(archivoCasetas);
            BufferedReader br = new BufferedReader(fr)){

            // Se procede a leer por linea, y el bucle no se detendrá hasta que la linea a leer sea nula
            while ((linea = br.readLine()) != null) {

                /* De la linea leida, se crea un array de String que guardará sus valores
                   tras separarlos entre ellos usando una expresion regular */
                String[] valores = linea.split(" - ");

                /* Partiendo de los atributos declarados en la clase CasetaFeria, se asignará cada valor
                   a la posición del array de valores correspondiente */
                String nombre = valores[0];
                String titular = valores[1];
                int aforo = Integer.parseInt(valores[2]);
                String tipoCaseta = valores[3];

                // Se inicia la creación de cada objeto CasetaFeria a partir de los valores obtenidos
                CasetaFeria casetaFeria = new CasetaFeria(nombre, titular, aforo,tipoCaseta);

                // Se añade cada caseta generada al ArrayList<CasetaFeria> creado al inicio del método
                listaObjetosCasetas.add(casetaFeria);

            }
        } catch (IOException e){
            System.out.println("Error: Ha surgido un error relacionado con el archivo: "+e.getMessage());
        }
        return listaObjetosCasetas; //Devuelve la lista con las casetas registradas
    }
}
