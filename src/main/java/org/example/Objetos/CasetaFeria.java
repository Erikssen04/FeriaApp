package org.example.Objetos;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "casetaFeria")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "id", "nombre", "titular", "aforo", "tipoCaseta" })
public class CasetaFeria {

    @XmlAttribute(name = "id")
    private int id;

    @XmlElement(name = "nombre")
    private String nombre;

    @XmlElement(name = "titular")
    private String titular;

    @XmlElement(name = "aforo")
    private int aforo;

    @XmlElement(name = "tipoCaseta")
    private String tipoCaseta;

    private static int contadorId = 0;

    public CasetaFeria(){}

    public CasetaFeria(String nombre, String titular, int aforo, String tipoCaseta) {
        this.id = ++contadorId;
        this.nombre = nombre;
        this.titular = titular;
        this.aforo = aforo;
        this.tipoCaseta = tipoCaseta;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTitular() {
        return titular;
    }

    public int getAforo() {
        return aforo;
    }

    public String getTipoCaseta() {
        return tipoCaseta;
    }

    @Override
    public String toString() {
        return "CasetaFeria {" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", titular='" + titular + '\'' +
                ", aforo=" + aforo +
                ", tipoCaseta='" + tipoCaseta + '\'' +
                '}';
    }
}
