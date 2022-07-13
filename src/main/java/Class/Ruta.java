/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author pablo
 */
public class Ruta {

    private int id;
    private Aeropuerto origen;
    private Aeropuerto destino;
    private int timpoEstimado;

    public Ruta(int id, Aeropuerto origen, Aeropuerto destino, int timpoEstimado) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.timpoEstimado = timpoEstimado;
    }

    public Ruta() {
    }
    
    
    

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
     * @return the origen
     */
    public Aeropuerto getOrigen() {
        return origen;
    }

    /**
     * @param origen the origen to set
     */
    public void setOrigen(Aeropuerto origen) {
        this.origen = origen;
    }

    /**
     * @return the destino
     */
    public Aeropuerto getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(Aeropuerto destino) {
        this.destino = destino;
    }

    /**
     * @return the timpoEstimado
     */
    public int getTimpoEstimado() {
        return timpoEstimado;
    }

    /**
     * @param timpoEstimado the timpoEstimado to set
     */
    public void setTimpoEstimado(int timpoEstimado) {
        this.timpoEstimado = timpoEstimado;
    }
    
    
    
}
