/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;
import Class.*;
import Model.AeropuertoModel;
import Model.AvionModel;
import Model.RutaModel;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.*;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author pablo
 */
public class Index extends javax.swing.JFrame {

    /**
     * Creates new form Index
     */
    AeropuertoModel aeropuerto_model = new AeropuertoModel();
    ArrayList<Aeropuerto> listaAeropuertos = aeropuerto_model.Read();
    AvionModel avion_model = new AvionModel();
    ArrayList<Avion> listaAvion = avion_model.Read();
    RutaModel ruta_model = new RutaModel();
    ArrayList<Ruta> listaRuta = ruta_model.Read();
    
    
    public Index() {
        initComponents();
        cargarListaTablaAeropuerto();
        cargarListaTablaAvion();
        cargarListaTablaRuta();
        cargarGraficoAeropuertoPie();
    }

    
    
    public void cargarListaTablaAvion() {
        DefaultTableModel tab = new DefaultTableModel();
        String[] cabecera2 = {"Id", "Modelo", "numeroAsientos", "numeroBanios", "CapacidadPesoMaximo"};
        Object[] datos = new Object[cabecera2.length];
        tab.setColumnIdentifiers(cabecera2);
        for (int i = 0; i < listaAvion.size(); i++) {
            datos[0] = listaAvion.get(i).getId();
            datos[1] = listaAvion.get(i).getModelo();
            datos[2] = listaAvion.get(i).getNumeroAsientos();
            datos[3] = listaAvion.get(i).getNumeroBanios();
            datos[4] = listaAvion.get(i).getCapacidadPesoMaximo();
            
            tab.addRow(datos);
        }
        tableAvion.setModel(tab);
    }
    
     public void limpiarCamposAvion(){
        txtIdAvion.setValue(0);
        txtModeloAvion.setText("");
        txtnumAsientosAvion.setValue(0);
        txtnumBaniosAvion.setValue(0);
    }
    
    public void cargarListaTablaAeropuerto() {
        DefaultTableModel tab = new DefaultTableModel();
        String[] cabecera = {"Id", "Nombre",  "Ciudad", "Pais", "CoordX", "CoordY"};
        Object[] datos = new Object[cabecera.length];
        tab.setColumnIdentifiers(cabecera);
        for (int i = 0; i < listaAeropuertos.size(); i++) {
            datos[0] = listaAeropuertos.get(i).getId();
            datos[1] = listaAeropuertos.get(i).getNombre();
            datos[2] = listaAeropuertos.get(i).getCiudad();
            datos[3] = listaAeropuertos.get(i).getPais();
            datos[4] = listaAeropuertos.get(i).getCoord_x();
            datos[5] = listaAeropuertos.get(i).getCoord_y();
            tab.addRow(datos);
        }
        tableAeropuertos.setModel(tab);
        cargarComboOrigen();
    }
    
    public void limpiarCamposAeropuerto(){
        txtIdAeropuerto.setValue(0);
        txtNombreAeropuerto.setText("");
        txtCiudadAeropuerto.setText("");
        txtPaisAeropuerto.setText("");
        txtCoordenadaXAeropuerto.setValue(0);
        txtCoordenadaYAeropuerto.setValue(0);
    }

    
    
      public void cargarListaTablaRuta() {
        DefaultTableModel tab = new DefaultTableModel();
        String[] cabecera = {"Id", "Origen", "Destino", "Tiempo Estimado"};
        Object[] datos = new Object[cabecera.length];
        tab.setColumnIdentifiers(cabecera);
        for (int i = 0; i < listaRuta.size(); i++) {
            datos[0] = listaRuta.get(i).getId();
            datos[1] = listaRuta.get(i).getNombre_origen();
            datos[2] = listaRuta.get(i).getNombre_destino();
            datos[3] = listaRuta.get(i).getTiempo_estimado();
            tab.addRow(datos);
        }
        tableRuta.setModel(tab);
    }
      
       
      public void cargarComboOrigen() {
        comboRutaOrigen.removeAllItems();
        comboRutaOrigen.addItem("");
        comboRutaDestino.removeAllItems();
        comboRutaDestino.addItem("");
        for (Aeropuerto aeropuerto : listaAeropuertos) {
            comboRutaOrigen.addItem(aeropuerto.getId() + "-" + aeropuerto.getNombre());
            comboRutaDestino.addItem(aeropuerto.getId() + "-" + aeropuerto.getNombre());
        }
        comboRutaOrigen.setSelectedIndex(0);
        comboRutaDestino.setSelectedIndex(0);
        
        
    }
       public void limpiarcamposRutas(){
        txtIdRuta.setValue(0);
        comboRutaOrigen.setSelectedItem("");
        comboRutaDestino.setSelectedItem("");
        txtTiempoEstimadoRuta.setValue(0);
    }
    
       public void cargarGraficoAeropuertoPie() {
        ArrayList<Aeropuerto> lista_aeropuerto_p = aeropuerto_model.GetByPais();       
        DefaultPieDataset dataset = new DefaultPieDataset();
      
        for (Aeropuerto index : lista_aeropuerto_p) {
            dataset.setValue(index.getPais(), index.getCantidad());
        }
        JFreeChart chart = ChartFactory.createPieChart("Grafico de Aeropuertos por Pais", dataset, true, true, true);       
        ChartPanel panel = new ChartPanel(chart);
        panelPaises.setLayout(new java.awt.BorderLayout());
        panelPaises.add(panel);
        panelPaises.validate();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAeropuertos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        labIdAvion = new javax.swing.JLabel();
        txtIdAvion = new javax.swing.JSpinner();
        labModeloAvion = new javax.swing.JLabel();
        labNumAsientosAvion = new javax.swing.JLabel();
        btnGuardarAvion = new javax.swing.JButton();
        btnBuscarAvion = new javax.swing.JButton();
        btnEditarAvion = new javax.swing.JButton();
        btnEliminarAvion = new javax.swing.JButton();
        txtModeloAvion = new javax.swing.JTextField();
        labNumbaniosAvion = new javax.swing.JLabel();
        labCapacidadAvion = new javax.swing.JLabel();
        txtnumBaniosAvion = new javax.swing.JSpinner();
        txtnumAsientosAvion = new javax.swing.JSpinner();
        txtCapacidadMaxAvion = new javax.swing.JSpinner();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableAvion = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        labIdRuta = new javax.swing.JLabel();
        labOrigenRuta = new javax.swing.JLabel();
        labDestinoRuta = new javax.swing.JLabel();
        labTiempoEstimadoRuta = new javax.swing.JLabel();
        txtIdRuta = new javax.swing.JSpinner();
        btnGuardarRuta = new javax.swing.JButton();
        btnBuscarRuta = new javax.swing.JButton();
        btnEditarRuta = new javax.swing.JButton();
        btnEliminarRuta = new javax.swing.JButton();
        txtTiempoEstimadoRuta = new javax.swing.JSpinner();
        comboRutaOrigen = new javax.swing.JComboBox<>();
        comboRutaDestino = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableRuta = new javax.swing.JTable();
        panelPaises = new javax.swing.JPanel();
        tabAeropuerto = new javax.swing.JPanel();
        labIdAeropuerto = new javax.swing.JLabel();
        labNombreAeropuerto = new javax.swing.JLabel();
        labCiudadAeropuerto = new javax.swing.JLabel();
        labPaisAeropuerto = new javax.swing.JLabel();
        labCoordAeropuerto = new javax.swing.JLabel();
        labCoordYAeropuerto = new javax.swing.JLabel();
        txtIdAeropuerto = new javax.swing.JSpinner();
        txtNombreAeropuerto = new javax.swing.JTextField();
        txtPaisAeropuerto = new javax.swing.JTextField();
        txtCiudadAeropuerto = new javax.swing.JTextField();
        btnGuardarAeropuerto = new javax.swing.JButton();
        btnBuscarAeropuerto = new javax.swing.JButton();
        btnEditarAeropuerto = new javax.swing.JButton();
        btnEliminarAeropuerto = new javax.swing.JButton();
        txtCoordenadaXAeropuerto = new javax.swing.JSpinner();
        txtCoordenadaYAeropuerto = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel7.setText("Sistema de gestion de aerolineas");

        tableAeropuertos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableAeropuertos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("ListarAeropuertos", jPanel2);

        labIdAvion.setText("ID");

        labModeloAvion.setText("Modelo");

        labNumAsientosAvion.setText("Numero_asientos");

        btnGuardarAvion.setText("Guardar");
        btnGuardarAvion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarAvionActionPerformed(evt);
            }
        });

        btnBuscarAvion.setText("Buscar");
        btnBuscarAvion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAvionActionPerformed(evt);
            }
        });

        btnEditarAvion.setText("Editar");
        btnEditarAvion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarAvionActionPerformed(evt);
            }
        });

        btnEliminarAvion.setText("Eliminar");
        btnEliminarAvion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarAvionActionPerformed(evt);
            }
        });

        labNumbaniosAvion.setText("Numero_baños");

        labCapacidadAvion.setText("Capacidad maxima");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labCapacidadAvion)
                    .addComponent(labNumAsientosAvion)
                    .addComponent(labIdAvion, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labModeloAvion)
                    .addComponent(labNumbaniosAvion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addComponent(txtIdAvion, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtModeloAvion, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(txtnumAsientosAvion, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCapacidadMaxAvion, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEditarAvion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminarAvion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBuscarAvion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGuardarAvion, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(75, 75, 75))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtnumBaniosAvion, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(labIdAvion)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labModeloAvion)
                            .addComponent(txtModeloAvion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labNumAsientosAvion)
                            .addComponent(txtnumAsientosAvion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labNumbaniosAvion, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnumBaniosAvion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labCapacidadAvion, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminarAvion)
                            .addComponent(txtCapacidadMaxAvion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtIdAvion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnGuardarAvion))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(btnBuscarAvion)
                        .addGap(28, 28, 28)
                        .addComponent(btnEditarAvion)))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Avion", jPanel3);

        tableAvion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tableAvion);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("ListarAviones", jPanel4);

        labIdRuta.setText("ID");

        labOrigenRuta.setText("Origen");

        labDestinoRuta.setText("Destino");

        labTiempoEstimadoRuta.setText("Tiempo estimado");

        btnGuardarRuta.setText("Guardar");
        btnGuardarRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarRutaActionPerformed(evt);
            }
        });

        btnBuscarRuta.setText("Buscar");
        btnBuscarRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarRutaActionPerformed(evt);
            }
        });

        btnEditarRuta.setText("Editar");
        btnEditarRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarRutaActionPerformed(evt);
            }
        });

        btnEliminarRuta.setText("Eliminar");
        btnEliminarRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarRutaActionPerformed(evt);
            }
        });

        comboRutaOrigen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboRutaOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboRutaOrigenActionPerformed(evt);
            }
        });

        comboRutaDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labDestinoRuta)
                    .addComponent(labIdRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labOrigenRuta)
                    .addComponent(labTiempoEstimadoRuta))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(txtTiempoEstimadoRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIdRuta, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                            .addComponent(comboRutaOrigen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboRutaDestino, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEditarRuta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminarRuta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBuscarRuta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardarRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(labIdRuta)
                        .addGap(31, 31, 31)
                        .addComponent(labOrigenRuta)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labDestinoRuta)
                            .addComponent(comboRutaDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGuardarRuta))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(btnBuscarRuta)
                                .addGap(19, 19, 19)
                                .addComponent(btnEditarRuta))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(comboRutaOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminarRuta)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labTiempoEstimadoRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTiempoEstimadoRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(129, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Rutas", jPanel5);

        tableRuta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tableRuta);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("ListarRutas", jPanel6);

        javax.swing.GroupLayout panelPaisesLayout = new javax.swing.GroupLayout(panelPaises);
        panelPaises.setLayout(panelPaisesLayout);
        panelPaisesLayout.setHorizontalGroup(
            panelPaisesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 526, Short.MAX_VALUE)
        );
        panelPaisesLayout.setVerticalGroup(
            panelPaisesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 322, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Grafica", panelPaises);

        labIdAeropuerto.setText("ID");

        labNombreAeropuerto.setText("Nombre");

        labCiudadAeropuerto.setText("Ciudad");

        labPaisAeropuerto.setText("Pais");

        labCoordAeropuerto.setText("Coordenada_X");

        labCoordYAeropuerto.setText("Coordenada_y");

        txtPaisAeropuerto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPaisAeropuertoActionPerformed(evt);
            }
        });

        txtCiudadAeropuerto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCiudadAeropuertoActionPerformed(evt);
            }
        });

        btnGuardarAeropuerto.setText("Guardar");
        btnGuardarAeropuerto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarAeropuertoActionPerformed(evt);
            }
        });

        btnBuscarAeropuerto.setText("Buscar");
        btnBuscarAeropuerto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAeropuertoActionPerformed(evt);
            }
        });

        btnEditarAeropuerto.setText("Editar");
        btnEditarAeropuerto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarAeropuertoActionPerformed(evt);
            }
        });

        btnEliminarAeropuerto.setText("Eliminar");
        btnEliminarAeropuerto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarAeropuertoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabAeropuertoLayout = new javax.swing.GroupLayout(tabAeropuerto);
        tabAeropuerto.setLayout(tabAeropuertoLayout);
        tabAeropuertoLayout.setHorizontalGroup(
            tabAeropuertoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabAeropuertoLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(tabAeropuertoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabAeropuertoLayout.createSequentialGroup()
                        .addGroup(tabAeropuertoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labNombreAeropuerto)
                            .addComponent(labIdAeropuerto, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labPaisAeropuerto, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addGroup(tabAeropuertoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdAeropuerto, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(tabAeropuertoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNombreAeropuerto, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtPaisAeropuerto, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))))
                    .addGroup(tabAeropuertoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, tabAeropuertoLayout.createSequentialGroup()
                            .addGroup(tabAeropuertoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(labCoordYAeropuerto)
                                .addComponent(labCoordAeropuerto))
                            .addGap(18, 18, 18)
                            .addGroup(tabAeropuertoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCoordenadaXAeropuerto)
                                .addComponent(txtCoordenadaYAeropuerto)))
                        .addGroup(tabAeropuertoLayout.createSequentialGroup()
                            .addComponent(labCiudadAeropuerto, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(52, 52, 52)
                            .addComponent(txtCiudadAeropuerto, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addGroup(tabAeropuertoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEditarAeropuerto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminarAeropuerto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBuscarAeropuerto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardarAeropuerto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(101, 101, 101))
        );
        tabAeropuertoLayout.setVerticalGroup(
            tabAeropuertoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabAeropuertoLayout.createSequentialGroup()
                .addGroup(tabAeropuertoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabAeropuertoLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(tabAeropuertoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labIdAeropuerto)
                            .addComponent(txtIdAeropuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tabAeropuertoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labNombreAeropuerto)
                            .addComponent(txtNombreAeropuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(tabAeropuertoLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(btnGuardarAeropuerto)))
                .addGroup(tabAeropuertoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabAeropuertoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tabAeropuertoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labPaisAeropuerto)
                            .addComponent(txtPaisAeropuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarAeropuerto))
                        .addGap(18, 18, 18)
                        .addGroup(tabAeropuertoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCiudadAeropuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labCiudadAeropuerto))
                        .addGap(13, 13, 13)
                        .addGroup(tabAeropuertoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labCoordAeropuerto)
                            .addComponent(txtCoordenadaXAeropuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(tabAeropuertoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCoordenadaYAeropuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labCoordYAeropuerto)))
                    .addGroup(tabAeropuertoLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(btnEditarAeropuerto)
                        .addGap(27, 27, 27)
                        .addComponent(btnEliminarAeropuerto)))
                .addContainerGap(101, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Aeropuerto", tabAeropuerto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPaisAeropuertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPaisAeropuertoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaisAeropuertoActionPerformed

    private void txtCiudadAeropuertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCiudadAeropuertoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCiudadAeropuertoActionPerformed

    private void btnGuardarAeropuertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarAeropuertoActionPerformed
      // TODO add your handling code here:
      
      
        int id = (int) txtIdAeropuerto.getValue(); // Spinner
        String nombre = txtNombreAeropuerto.getText(); // TextField
        String ciudad = txtCiudadAeropuerto.getText();
        String pais = txtPaisAeropuerto.getText();
        int coord_x = (int) txtCoordenadaXAeropuerto.getValue();
        int coord_y = (int) txtCoordenadaYAeropuerto.getValue();
       
        if(id == 0 || nombre.equals("") || ciudad.equals("") || pais.equals("") || coord_x == 0 || coord_y == 0){
            JOptionPane.showMessageDialog(null, "Error: debe llenar todos los campos");
        }else {
            Aeropuerto aero = new Aeropuerto(id, nombre, ciudad, pais, coord_x, coord_y);
            
            int resultado = aeropuerto_model.Create(aero);
            aero.setId(resultado);
            aeropuerto_model.Create(aero);
            
            JOptionPane.showMessageDialog(this, "Aeropuerto " + nombre + " fue creado correctamente");
            cargarListaTablaAeropuerto();
        }

    }//GEN-LAST:event_btnGuardarAeropuertoActionPerformed

    private void btnGuardarAvionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarAvionActionPerformed
            // TODO add your handling code here:
        int id = (int) txtIdAvion.getValue(); // Spinner
        String modelo = txtModeloAvion.getText(); // TextField
        int numeroAsientos =  (int)txtnumAsientosAvion.getValue();
        int numeroBanio = (int)txtnumBaniosAvion.getValue();
        int CapacidadPesoMaximo = (int)txtCapacidadMaxAvion.getValue();
       
        if (id == 0 || modelo.equals("") || numeroAsientos == 0 || numeroBanio == 0 || CapacidadPesoMaximo == 0) {
            JOptionPane.showMessageDialog(null, "Error: debe llenar todos los campos");
        } else {
            Avion avi = new Avion(id, modelo, numeroAsientos, numeroBanio, CapacidadPesoMaximo);
            avion_model.Create(avi);
            listaAvion.add(avi);
            JOptionPane.showMessageDialog(this, "El avion " + modelo + " fue creado correctamente");
            cargarListaTablaAvion();
        }
    }//GEN-LAST:event_btnGuardarAvionActionPerformed

    private void btnBuscarAeropuertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAeropuertoActionPerformed
        // TODO add your handling code here:
        int id = (int) txtIdAeropuerto.getValue();
        boolean existe = false;
        for (int i = 0; i < listaAeropuertos.size(); i++) {
            if (listaAeropuertos.get(i).getId() == id) {
                txtNombreAeropuerto.setText(listaAeropuertos.get(i).getNombre());
                txtCiudadAeropuerto.setText(listaAeropuertos.get(i).getCiudad());
                txtPaisAeropuerto.setText(listaAeropuertos.get(i).getPais());
                txtCoordenadaXAeropuerto.setValue(listaAeropuertos.get(i).getCoord_x());
                txtCoordenadaYAeropuerto.setValue(listaAeropuertos.get(i).getCoord_y());
          
                existe = true;
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(this, "El aeropuerto no esta registrado");
        }

    }//GEN-LAST:event_btnBuscarAeropuertoActionPerformed

    private void btnEditarAeropuertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarAeropuertoActionPerformed
        // TODO add your handling code here:
        
        int id = (int) txtIdAeropuerto.getValue(); // Spiner
        String nombre = txtNombreAeropuerto.getText(); // Text Field
        String ciudad = txtCiudadAeropuerto.getText();
        String pais = txtPaisAeropuerto.getText();
        int coord_x = (int) txtCoordenadaXAeropuerto.getValue();
        int coord_y = (int) txtCoordenadaYAeropuerto.getValue();
        boolean existe = false;
        //Valido que los valores no esten vacios
        if(id == 0 || nombre.equals("") || ciudad.equals("") || pais.equals("") || coord_x == 0 || coord_y == 0){
            JOptionPane.showMessageDialog(null, "Error: debe llenar todos los campos");
        }else{
            for (int i = 0; i < listaAeropuertos.size(); i++) {
            if (listaAeropuertos.get(i).getId() == id) {
                    listaAeropuertos.get(i).setNombre(nombre);
                    listaAeropuertos.get(i).setCiudad(ciudad);
                    listaAeropuertos.get(i).setPais(pais);
                    listaAeropuertos.get(i).setCoord_x(coord_x);
                    listaAeropuertos.get(i).setCoord_y(coord_y);
                    existe = true;
                    cargarListaTablaAeropuerto();
                    Aeropuerto aer = new Aeropuerto(id, nombre, ciudad, pais, coord_x, coord_y);
                    aeropuerto_model.Update(aer, id);
                    JOptionPane.showMessageDialog(this, "Aeropuerto editado correctamente");
                    break;
                }
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(this, "El Aeropuerto no esta registrado");
        }  

    }//GEN-LAST:event_btnEditarAeropuertoActionPerformed

    private void btnEliminarAeropuertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarAeropuertoActionPerformed
        // TODO add your handling code here:
        
        int id = (int) txtIdAeropuerto.getValue(); // Spiner
        boolean existe = false;
        for (int i = 0; i < listaAeropuertos.size(); i++) {
            if (listaAeropuertos.get(i).getId() == id) {
                    listaAeropuertos.remove(listaAeropuertos.get(i));
                    JOptionPane.showMessageDialog(this, "Aeropuerto eliminado correctamente");
                existe = true;
                aeropuerto_model.Delete(id);
                cargarListaTablaAeropuerto();
                limpiarCamposAeropuerto();
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(this, "El Aeropuerto no esta registrado");
            
        }

        
        
    }//GEN-LAST:event_btnEliminarAeropuertoActionPerformed

    private void btnGuardarRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarRutaActionPerformed
        // TODO add your handling code here:
         int id = (int) txtIdRuta.getValue(); // Spinner
         String origen = comboRutaOrigen.getSelectedItem().toString();
         String[] partes_origen = origen.split("-");
         int id_origen = Integer.parseInt(partes_origen[0]);
         String nombre_origen = partes_origen[1];
         
         String destino = comboRutaDestino.getSelectedItem().toString();
         String[] partes_destino = destino.split("-");
         int id_destino = Integer.parseInt(partes_destino[0]);
         String nombre_destino = partes_destino[1];
        
        int tiempoEstimado = (int) txtTiempoEstimadoRuta.getValue();
        
       
        if (origen.equals("") || destino.equals("") || tiempoEstimado == 0 || destino == origen) {
            JOptionPane.showMessageDialog(null, "Error: debe llenar todos los campos");
        } else{
            Ruta ruta = new Ruta(id, id_origen, id_destino, tiempoEstimado, nombre_origen, nombre_destino, tiempoEstimado);
            int result = ruta_model.Create(ruta);
            ruta.setId(result);
            listaRuta.add(ruta);
            JOptionPane.showMessageDialog(this, "Ruta " + result + " fue creado correctamente");
            cargarListaTablaRuta();
            
        }
    }//GEN-LAST:event_btnGuardarRutaActionPerformed

    private void btnBuscarAvionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAvionActionPerformed
        // TODO add your handling code here:
        int id = (int) txtIdAvion.getValue();
        boolean existe = false;
        for (int i = 0; i < listaAvion.size(); i++) {
            if (listaAvion.get(i).getId() == id) {
                txtModeloAvion.setText(listaAvion.get(i).getModelo());
                txtnumAsientosAvion.setValue(listaAvion.get(i).getNumeroAsientos());
                txtnumBaniosAvion.setValue(listaAvion.get(i).getNumeroBanios());
                txtCapacidadMaxAvion.setValue(listaAvion.get(i).getCapacidadPesoMaximo());
          
                existe = true;
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(this, "El avion no esta registrado");
        }
    }//GEN-LAST:event_btnBuscarAvionActionPerformed

    private void btnEditarAvionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarAvionActionPerformed
        // TODO add your handling code here:
        int id = (int) txtIdAvion.getValue(); // Spiner
        String modelo = txtModeloAvion.getText(); // Text Field
        int numAsientosAvion = (int)txtnumAsientosAvion.getValue();
        int numBaniosAvion = (int)txtnumBaniosAvion.getValue();
        int CapacidadMaxAvion = (int) txtCapacidadMaxAvion.getValue();
        
        boolean existe = false;
        //Valido que los valores no esten vacios
        if(id == 0 || modelo.equals("") || numAsientosAvion == 0 || numBaniosAvion == 0 || CapacidadMaxAvion == 0){
            JOptionPane.showMessageDialog(null, "Error: debe llenar todos los campos");
        }else{
            for (int i = 0; i < listaAvion.size(); i++) {
            if (listaAvion.get(i).getId() == id) {
                    listaAvion.get(i).setModelo(modelo);
                    listaAvion.get(i).setNumeroAsientos(numAsientosAvion);
                    listaAvion.get(i).setNumeroBanios(numBaniosAvion);
                    listaAvion.get(i).setCapacidadPesoMaximo(CapacidadMaxAvion);
                    
                    existe = true;
                    cargarListaTablaAvion();
                    Avion avi = new Avion(id, modelo, numAsientosAvion, numBaniosAvion, CapacidadMaxAvion);
                    avion_model.Update(avi, id);
                    JOptionPane.showMessageDialog(this, "Avion editado correctamente");
                    break;
                }
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(this, "El Avion no esta registrado");
        }  
    }//GEN-LAST:event_btnEditarAvionActionPerformed

    private void btnEliminarAvionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarAvionActionPerformed
        // TODO add your handling code here:
        int id = (int) txtIdAvion.getValue(); // Spiner
        boolean existe = false;
        for (int i = 0; i < listaAvion.size(); i++) {
            if (listaAvion.get(i).getId() == id) {
                    listaAvion.remove(listaAvion.get(i));
                    JOptionPane.showMessageDialog(this, "Avion eliminado correctamente");
                existe = true;
                cargarListaTablaAvion();
                avion_model.Delete(id);
                limpiarCamposAvion();
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(this, "El Avion no esta registrado");
        }
        
    }//GEN-LAST:event_btnEliminarAvionActionPerformed

    private void btnBuscarRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarRutaActionPerformed
        // TODO add your handling code here:
        int id = (int) txtIdRuta.getValue();
        boolean existe = false;
        for (int i = 0; i < listaRuta.size(); i++) {
            if (listaAvion.get(i).getId() == id) {
                comboRutaOrigen.addItem(listaRuta.get(i).getNombre_origen());
                comboRutaDestino.addItem(listaRuta.get(i).getNombre_destino());
                txtTiempoEstimadoRuta.setValue(listaRuta.get(i).getTimpoEstimado());
          
                existe = true;
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(this, "La ruta no esta registrada");
        }
////        
    }//GEN-LAST:event_btnBuscarRutaActionPerformed

    private void btnEditarRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarRutaActionPerformed
        // TODO add your handling code here:
         int id = (int) txtIdRuta.getValue(); // Spinner
         String origen = comboRutaOrigen.getSelectedItem().toString();
         String[] partes_origen = origen.split("-");
         int id_origen = Integer.parseInt(partes_origen[0]);
         String nombre_origen = partes_origen[1];
         
         String destino = comboRutaDestino.getSelectedItem().toString();
         String[] partes_destino = destino.split("-");
         int id_destino = Integer.parseInt(partes_destino[0]);
         String nombre_destino = partes_destino[1];
        
        int tiempoEstimado = (int) txtTiempoEstimadoRuta.getValue();
        
       
        
        boolean existe = false;
        //Valido que los valores no esten vacios
        if (origen.equals("") || destino.equals("") || tiempoEstimado == 0 || destino == origen) {
            JOptionPane.showMessageDialog(null, "Error: debe llenar todos los campos");
        }else{
            for (int i = 0; i < listaRuta.size(); i++) {
            if (listaRuta.get(i).getId() == id) {
                    listaRuta.get(i).setOrigen(id_origen);
                    listaRuta.get(i).setDestino(id_destino);
                    listaRuta.get(i).setTiempo_estimado(tiempoEstimado);
                    
                    existe = true;
                    cargarListaTablaRuta();
                    Ruta r = new Ruta(id, id_origen, id_destino, tiempoEstimado, nombre_origen, nombre_destino, tiempoEstimado);
                    ruta_model.Update(r, id);
                    JOptionPane.showMessageDialog(this, "Ruta editada correctamente");
                    break;
                }
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(this, "La ruta no esta registrado");
        }
    }//GEN-LAST:event_btnEditarRutaActionPerformed

    private void comboRutaOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboRutaOrigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboRutaOrigenActionPerformed

    private void btnEliminarRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarRutaActionPerformed
        // TODO add your handling code here:
        int id = (int) txtIdRuta.getValue(); // Spiner
        boolean existe = false;
        for (int i = 0; i < listaRuta.size(); i++) {
            if (listaRuta.get(i).getId() == id) {
                    listaRuta.remove(listaRuta.get(i));
                    JOptionPane.showMessageDialog(this, "Ruta eliminada correctamente");
                existe = true;
                cargarListaTablaRuta();
                ruta_model.Delete(id);
                limpiarcamposRutas();
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(this, "El Avion no esta registrado");
        }
    }//GEN-LAST:event_btnEliminarRutaActionPerformed

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("Convert2Lambda")
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Index().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarAeropuerto;
    private javax.swing.JButton btnBuscarAvion;
    private javax.swing.JButton btnBuscarRuta;
    private javax.swing.JButton btnEditarAeropuerto;
    private javax.swing.JButton btnEditarAvion;
    private javax.swing.JButton btnEditarRuta;
    private javax.swing.JButton btnEliminarAeropuerto;
    private javax.swing.JButton btnEliminarAvion;
    private javax.swing.JButton btnEliminarRuta;
    private javax.swing.JButton btnGuardarAeropuerto;
    private javax.swing.JButton btnGuardarAvion;
    private javax.swing.JButton btnGuardarRuta;
    private javax.swing.JComboBox<String> comboRutaDestino;
    private javax.swing.JComboBox<String> comboRutaOrigen;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labCapacidadAvion;
    private javax.swing.JLabel labCiudadAeropuerto;
    private javax.swing.JLabel labCoordAeropuerto;
    private javax.swing.JLabel labCoordYAeropuerto;
    private javax.swing.JLabel labDestinoRuta;
    private javax.swing.JLabel labIdAeropuerto;
    private javax.swing.JLabel labIdAvion;
    private javax.swing.JLabel labIdRuta;
    private javax.swing.JLabel labModeloAvion;
    private javax.swing.JLabel labNombreAeropuerto;
    private javax.swing.JLabel labNumAsientosAvion;
    private javax.swing.JLabel labNumbaniosAvion;
    private javax.swing.JLabel labOrigenRuta;
    private javax.swing.JLabel labPaisAeropuerto;
    private javax.swing.JLabel labTiempoEstimadoRuta;
    private javax.swing.JPanel panelPaises;
    private javax.swing.JPanel tabAeropuerto;
    private javax.swing.JTable tableAeropuertos;
    private javax.swing.JTable tableAvion;
    private javax.swing.JTable tableRuta;
    private javax.swing.JSpinner txtCapacidadMaxAvion;
    private javax.swing.JTextField txtCiudadAeropuerto;
    private javax.swing.JSpinner txtCoordenadaXAeropuerto;
    private javax.swing.JSpinner txtCoordenadaYAeropuerto;
    private javax.swing.JSpinner txtIdAeropuerto;
    private javax.swing.JSpinner txtIdAvion;
    private javax.swing.JSpinner txtIdRuta;
    private javax.swing.JTextField txtModeloAvion;
    private javax.swing.JTextField txtNombreAeropuerto;
    private javax.swing.JTextField txtPaisAeropuerto;
    private javax.swing.JSpinner txtTiempoEstimadoRuta;
    private javax.swing.JSpinner txtnumAsientosAvion;
    private javax.swing.JSpinner txtnumBaniosAvion;
    // End of variables declaration//GEN-END:variables
}
