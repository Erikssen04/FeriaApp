package org.example.Logica;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.example.Objetos.CasetaFeria;
import org.example.Objetos.Feria;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;

public class Marshalling {

    // Método que procesara el marshalling del fichero XML
    public static void mXML(ArrayList<CasetaFeria> listaObjetosCasetas){

        // Creación del fichero XML a utilizar para el Marshalling
        File xmlFilePath = new File("src/main/java/org/example/Ficheros/casetas.xml");

        try {
            // Crear un contexto JAXB para la clase
            JAXBContext jaxbContext = JAXBContext.newInstance(Feria.class);

            // Crear un marshaller para convertir la lista de objetos a XML
            Marshaller marshaller = jaxbContext.createMarshaller();

            // Formatear el XML para que sea más legible
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Creación del objeto Feria que contendrá la lista de objetos CasetaFeria pasado por parámetro al método
            Feria feria = new Feria(listaObjetosCasetas);

            // Serializar el objeto Feria a una cadena XML
            StringWriter sw = new StringWriter();
            marshaller.marshal(feria, sw);
            String xmlString = sw.toString();

            // Serializar el objeto Feria a un fichero
            marshaller.marshal(feria, xmlFilePath);

            // Mostrar el XML resultante
            System.out.println("Objeto Feria, que contiene los objetos CasetaFeria, serializado correctamente a XML:");
            System.out.println(xmlString);

            System.out.println("\nOperación completada\n");

        }catch(JAXBException e){
            System.out.println("Error: Ha surgido un error relacionado con JAXB: "+e.getMessage());
        }
    }

    // Método que procesara el marshalling del fichero JSON
    public static void mJSON(ArrayList<CasetaFeria> listaObjetosCasetas){

        // Creación del fichero JSON
        File jsonFilePath = new File("src/main/java/org/example/Ficheros/casetas.json");

        try {
            // Creamos un objeto que utiliza la biblioteca Jackson para convertir objetos Java a formatos como JSON
            ObjectMapper objectMapper = new ObjectMapper();

            // Habilitar opción del objectMapper para formatear el fichero JSON adecuadamente.
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            // Serializar la lista de objetos CasetaFeria a JSON
            objectMapper.writeValue(jsonFilePath, listaObjetosCasetas);

            // Mostrar fichero JSON creado.
            String jsonString = objectMapper.writeValueAsString(listaObjetosCasetas);
            System.out.println("Objetos CasetaFeria después de deserializar:");
            System.out.println(jsonString);

            System.out.println("\nOperación completada\n");

        } catch (IOException e) {
            System.out.println("Error: Ha surgido un error relacionado con el archivo: "+e.getMessage());
        }
    }
}

