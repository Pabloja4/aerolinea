/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Class.*;
import Controller.Conn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author pablo
 */
public class RutaModel {
    
    Conn conexion = new Conn();
    
    public int Create(Ruta r){
        Connection conn = conexion.getConnection();
        String query = "INSERT INTO ruta(origen, destino, tiempo_estimado) VALUES(?, ?, ?)";
        try{
            PreparedStatement statment = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statment.setInt(1, r.getOrigen());
            statment.setInt(2, r.getDestino());
            statment.setInt(3, r.getTimpoEstimado());
            statment.executeUpdate();
            ResultSet generatedKey = statment.getGeneratedKeys();
            if (generatedKey.next()) {
                return generatedKey.getInt(1); // Todo salio bien
            }
        }catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        return 0; // SI algo sale mal
    }
    
    public ArrayList<Ruta> Read() {
        Connection conn = conexion.getConnection();
        ArrayList<Ruta> lista_ruta = new ArrayList();
        String query = "SELECT ruta.*, origen.nombre AS nombre_origen, destino.nombre AS nombre_destino "
                     + "FROM ruta "
                     + "INNER JOIN aeropuerto AS origen ON ruta.origen = origen.id "
                     + "INNER JOIN aeropuerto as destino ON ruta.destino = destino.id";
        try {
            PreparedStatement newStatement = conn.prepareStatement(query);
            ResultSet resultados = newStatement.executeQuery();
            while (resultados.next()) {
                int id = resultados.getInt(1);
                int origen = resultados.getInt(2);
                int destino = resultados.getInt(3);
                int tiempo_estimado = resultados.getInt(4);
                String nombre_origen = resultados.getString(5);
                String nombre_destino = resultados.getString(6);
                
                Ruta r = new Ruta(id, origen, destino, tiempo_estimado, nombre_origen, nombre_destino, tiempo_estimado);
                lista_ruta.add(r);
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return lista_ruta;
    }
            public int Update(Ruta a, int id) {
        Connection conn = conexion.getConnection();
        String query = "UPDATE ruta "
                + "SET origen = ?, "
                + "destino = ?, "
                + "tiempo_estimado = ? "
                + "WHERE id = ?";
         try {
            PreparedStatement newStatement = conn.prepareStatement(query);
            newStatement.setInt(1, a.getOrigen());
            newStatement.setInt(2, a.getDestino());
            newStatement.setInt(3, a.getTiempo_estimado());
            newStatement.setInt(4, id);
            newStatement.executeUpdate();
            return 1;
        } catch (Exception exp) {
            System.out.println("Error: " + exp.getMessage());
        }
        return 0;
        }
            
            
        public int Delete(int id) {
        Connection conn = conexion.getConnection();
        String query = "DELETE FROM ruta WHERE id = ?;";
        try {
            PreparedStatement newStatement = conn.prepareStatement(query);
            newStatement.setInt(1, id);
            newStatement.executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return 0;
    }
}
