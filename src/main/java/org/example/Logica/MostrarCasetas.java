package org.example.Logica;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Objetos.CasetaFeria;
import org.example.Objetos.Feria;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MostrarCasetas {

    /* Esta método mostrará, a partir de la opción pasada por parametro, la caseta que el usuario desea mostrar
       desde el fichero XML previamente serializado */
    public static void mostrarDesdeXML(int numCaseta){
        File xmlFilePath = new File("src/main/java/org/example/Ficheros/casetas.xml");

        try {
            // Crear un contexto JAXB para la clase Feria
            JAXBContext jaxbContext = JAXBContext.newInstance(Feria.class);

            // Crear un unmarshaller para convertir el XML a objeto
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            // Deserializar objeto Feria desde el fichero XML
            Feria feriaFromXml = (Feria) unmarshaller.unmarshal(xmlFilePath);

            /* Se obtiene la lista de casetas y se guarda en un ArrayList<CasetaFeria>
               para facilitar la búsqueda de la caseta elegida*/
            ArrayList<CasetaFeria> listaCasetas = feriaFromXml.getListaCasetas();

            /* Se busca la caseta con el identificador pasado por parámetro, asignando un objeto
            CasetaFeria y haciendo uso de un stream con expresiones lambda sobre la lista de casetas
            para filtrar la caseta dentro de la lista a partir de nuestro identificador */
            CasetaFeria casetaElegida = listaCasetas.stream()
                    .filter(caseta -> caseta.getId() == numCaseta)
                    .findFirst()
                    .orElse(null);

            // Se muestra por pantalla la caseta elegida
            System.out.println("Se ha encontrado la siguiente caseta: \n"+casetaElegida);

            System.out.println("\nOperación completada\n");

        } catch (JAXBException e) {
            System.out.println("Error: Ha surgido un error relacionado con JAXB: "+e.getMessage());
        }
    }

    /* Esta método mostrará, a partir de la opción pasada por parametro, la caseta que el usuario desea mostrar
       desde el fichero JSON previamente serializado */
    public static void mostrarDesdeJSON(int numCaseta){

        // Declaración del fichero JSON a ser utilizado
        File jsonFilePath = new File("src/main/java/org/example/Ficheros/casetas.json");

        try {
            // Creación del objeto ObjectMapper para posterior Unmarshalling
            ObjectMapper objectMapper = new ObjectMapper();

            // Deserialización del fichero JSON a un array de objetos CasetaFeria para facilitar la búsqueda de la caseta
            CasetaFeria[] feriaFromJSON = objectMapper.readValue(jsonFilePath, CasetaFeria[].class);

            /* Bucle for que recorrerá el array CasetaFeria[] y obtendrá la caseta entera a partir de
               nuestro ID pasado por parámetro */
            for (CasetaFeria caseta : feriaFromJSON) {
                if (caseta.getId() == numCaseta) {

                    // Mostrar la caseta elegida
                    System.out.println("Se ha encontrado la siguiente caseta: \n"+ caseta);

                }
            }

            System.out.println("\nOperación completada\n");

        }catch(IOException e){
            System.out.println("Error: Ha surgido un error relacionado con el archivo: "+e.getMessage());
        }
    }
}

