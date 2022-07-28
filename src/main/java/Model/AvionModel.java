/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Class.Avion;
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
public class AvionModel {
    
    Conn conexion = new Conn();
    
    public int Create(Avion a){
        Connection conn = conexion.getConnection();
        String query = "INSERT INTO avion(modelo, numero_asientos, numero_banios, Capacidad_maxima) VALUES(?, ?, ?, ?)";
        try{
            PreparedStatement statment = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statment.setString(1, a.getModelo());
            statment.setInt(2, (int) a.getNumeroAsientos());
            statment.setInt(3, (int) a.getNumeroBanios());
            statment.setInt(4, (int) a.getCapacidadPesoMaximo());
            statment.executeUpdate();
            return 1; // Todo salio bien
        }catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }  
        return 0; // SI algo sale mal
    }
    
    public int Delete(int id) {
        Connection conn = conexion.getConnection();
        String query = "DELETE FROM aeropuerto WHERE id = ?;";
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
    
    public ArrayList<Avion> Read() {
        Connection conn = conexion.getConnection();
        ArrayList<Avion> lista_Avion = new ArrayList();
        String query = "SELECT * FROM avion;";
        try {
            PreparedStatement newStatement = conn.prepareStatement(query);
            ResultSet resultados = newStatement.executeQuery();
            while (resultados.next()) {
                
                int id = resultados.getInt(1);
                String modelo = resultados.getString(2);
                int NumeroAsientos = resultados.getInt(3);
                int NumeroBanios = resultados.getInt(4);
                int CapacidadPesoMaximo = resultados.getInt(5);
                
                Avion avi = new Avion(id, modelo, NumeroAsientos, NumeroBanios, CapacidadPesoMaximo);
                lista_Avion.add(avi);
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return lista_Avion;
    }
    
    public int Update(Avion a, int id) {
        Connection conn = conexion.getConnection();
        String query = "UPDATE avion "
                + "SET modelo = ?, "
                + "numero_asientos = ?, "
                + "numero_banios = ?, "
                + "Capacidad_maxima = ? "
                + "WHERE id = ?";
         try {
            PreparedStatement newStatement = conn.prepareStatement(query);
            newStatement.setString(1, a.getModelo());
            newStatement.setInt(2, a.getNumeroAsientos());
            newStatement.setInt(3, a.getNumeroBanios());
            newStatement.setInt(4, a.getCapacidadPesoMaximo());
            newStatement.setInt(5, id);
            newStatement.executeUpdate();
            return 1;
        } catch (Exception exp) {
            System.out.println("Error: " + exp.getMessage());
        }
        return 0;
    }
    
        public ArrayList<Avion> GetByModelo() {
        Connection conn = conexion.getConnection();
        ArrayList<Avion> lista_avion = new ArrayList();
        String query = "SELECT modelo, COUNT(modelo) AS cantidad "
                     + "FROM avion "
                     + "GROUP BY modelo";
        try {
            PreparedStatement newStatement = conn.prepareStatement(query);
            ResultSet resultados = newStatement.executeQuery();
            while (resultados.next()) {
                String modelo = resultados.getString(1);
                int cantidad = resultados.getInt(2);
                Avion en = new Avion(modelo, cantidad);
                lista_avion.add(en);
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return lista_avion;
    }

}
