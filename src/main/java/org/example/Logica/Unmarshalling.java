package org.example.Logica;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Objetos.CasetaFeria;
import org.example.Objetos.Feria;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;

public class Unmarshalling {

    // Método que procesara el unmarshalling del fichero XML
    public static void umXML(){

        // Fichero para deserializar el objeto Feria
        File xmlFilePath = new File("src/main/java/org/example/Ficheros/casetas.xml");

        try {
            // Crear un contexto JAXB para la clase
            JAXBContext jaxbContext = JAXBContext.newInstance(Feria.class);

            // Deserializar objeto Feria desde fichero XML
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            // Procesar Unmarshalling del fichero XML, y guardar información resultante en objeto Feria
            Feria feriaFromXml = (Feria) unmarshaller.unmarshal(xmlFilePath);

            // Mostramos el objeto Feria, con sus respectivos objetos CasetaFeria, recuperados del fichero XML
            System.out.println("Objeto Feria después de deserializar:");
            System.out.println(feriaFromXml.toString());

            System.out.println("\nOperación completada\n");

        }catch(JAXBException e){
            System.out.println("Error: Ha surgido un error relacionado con JAXB: "+e.getMessage());
        }
    }

    // Método que procesara el unmarshalling del fichero JSON
    public static void umJSON(){

        // Declaración del fichero JSON a ser utilizado
        File jsonFilePath = new File("src/main/java/org/example/Ficheros/casetas.json");

        try {
            // Creación del objeto ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            /* Realización del Unmarshalling del fichero JSON a un array de objetos CasetaFeria
               para facilitar la lectura de cada valor */
            CasetaFeria[] feriaFromJSON = objectMapper.readValue(jsonFilePath, CasetaFeria[].class);

            // Mostramos las casetas recuperadas del JSON mediante el array de objetos CasetaFeria creado anteriormente
            System.out.println("Objetos CasetaFeria después de deserializar:");
            for (CasetaFeria caseta : feriaFromJSON) {
                System.out.println(caseta);
            }

            System.out.println("\nOperación completada\n");
        }catch(IOException e){
            System.out.println("Error: Ha surgido un error relacionado con el archivo: "+e.getMessage());
        }
    }
}