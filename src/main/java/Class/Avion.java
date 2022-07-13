/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author pablo
 */
public class Avion {

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the numeroAsientos
     */
    public int getNumeroAsientos() {
        return numeroAsientos;
    }

    /**
     * @param numeroAsientos the numeroAsientos to set
     */
    public void setNumeroAsientos(int numeroAsientos) {
        this.numeroAsientos = numeroAsientos;
    }

    /**
     * @return the numeroBanios
     */
    public int getNumeroBanios() {
        return numeroBanios;
    }

    /**
     * @param numeroBanios the numeroBanios to set
     */
    public void setNumeroBanios(int numeroBanios) {
        this.numeroBanios = numeroBanios;
    }

    /**
     * @return the CapacidadPesoMaximo
     */
    public int getCapacidadPesoMaximo() {
        return CapacidadPesoMaximo;
    }

    /**
     * @param CapacidadPesoMaximo the CapacidadPesoMaximo to set
     */
    public void setCapacidadPesoMaximo(int CapacidadPesoMaximo) {
        this.CapacidadPesoMaximo = CapacidadPesoMaximo;
    }
    private int id;
    private String modelo;
    private int numeroAsientos;
    private int numeroBanios;
    private int CapacidadPesoMaximo;

    public Avion(int id, String modelo, int numeroAsientos, int numeroBanios, int CapacidadPesoMaximo) {
        this.id = id;
        this.modelo = modelo;
        this.numeroAsientos = numeroAsientos;
        this.numeroBanios = numeroBanios;
        this.CapacidadPesoMaximo = CapacidadPesoMaximo;
    }

    public Avion() {
    }
    
    
}
