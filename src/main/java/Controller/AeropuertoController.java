/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import Class.Aeropuerto;
import Model.AeropuertoModel;
import java.io.FileOutputStream;
import java.util.ArrayList;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellStyle;
/**
 *
 * @author pablo
 */
public class AeropuertoController {
    
    AeropuertoModel modelo_aeropuerto = new AeropuertoModel();
    ArrayList<Aeropuerto> lista_aeropuertos = modelo_aeropuerto.Read();
    
    public void ExportData(){
    
    HSSFWorkbook book = new HSSFWorkbook();
    HSSFSheet sheet = book.createSheet();
    book.setSheetName(0, "Lista de Aeropuertos");
    String[] headers = new String[]{
        "Id", 
        "Nombre", 
        "Ciudad", 
        "Pais", 
        "CoordX", 
        "CoordY"
    };
    
    CellStyle headerStyle = book.createCellStyle();
    HSSFFont font = book.createFont();
    font.setBold(true);
    headerStyle.setFont(font);
    
    HSSFRow headersRow = sheet.createRow(0);
    //Actualizo el estilo del encabezado
    for (int i = 0; i < headers.length; i++) {
        String header = headers[i];
        HSSFCell cell = headersRow.createCell(i); 
        cell.setCellStyle(headerStyle);
        cell.setCellValue(header);
    }

     // Llenar el Excel
        for (int i = 0; i < lista_aeropuertos.size(); i++) {
            HSSFRow row = sheet.createRow(i+1); 
            int id = lista_aeropuertos.get(i).getId();
            String nombre = lista_aeropuertos.get(i).getNombre();
            String pais = lista_aeropuertos.get(i).getPais();
            String ciudad = lista_aeropuertos.get(i).getCiudad();
            double coordX = lista_aeropuertos.get(i).getCoord_x();
            double coordY = lista_aeropuertos.get(i).getCoord_y();
           
            row.createCell(0).setCellValue(id);
            row.createCell(1).setCellValue(nombre);
            row.createCell(2).setCellValue(pais);
            row.createCell(3).setCellValue(ciudad);
            row.createCell(4).setCellValue(coordX);
            row.createCell(5).setCellValue(coordY);
        }

        //Exportar la informacion
        try{
            FileOutputStream file = new FileOutputStream("Aeropuertos.xls");
            book.write(file);
            file.close();
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
        }   
    }
}
