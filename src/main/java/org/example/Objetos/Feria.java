package org.example.Objetos;

import org.example.Objetos.CasetaFeria;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "feria")
public class Feria {

    @XmlElement(name = "casetaFeria")
    private ArrayList<CasetaFeria> listaCasetas;

    public Feria(){}

    public Feria(ArrayList<CasetaFeria> listaCasetas) {
        this.listaCasetas = listaCasetas;
    }

    public ArrayList<CasetaFeria> getListaCasetas() {
        return listaCasetas;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Feria {\n");
        for (CasetaFeria caseta : listaCasetas) {
            sb.append(caseta.toString()).append("\n");
        }
        sb.append("}");
        return sb.toString();
    }
}