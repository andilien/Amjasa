/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lectorarchivos;

/*Se ha creado una libreria la cual tiene el jar
 para que a la hora de abrir el proyecto en otro pc
no tengamos que importar la libreria.
*/

import com.opencsv.CSVReader;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author MGC
 */
public class VerCSV extends javax.swing.JPanel {
    File fichero = null;
    private static DefaultTableModel model;
    
    /**
     * Creates new form VerCSV
     */
    public VerCSV(File fichero) throws IOException {
        initComponents();
        this.fichero = fichero;
        jLabelRutaFichero.setText(fichero.getAbsolutePath().toString());
        
        //LLamamos al metodo para llenar la tabla
        /*
            Tendremos que pasarle la tabla y el la ruta
            del fichero
        */
        llenarTabla(jTableInfoCSV,fichero);        
    }
    
    public static void llenarTabla(JTable tabla, File fichero) throws FileNotFoundException, IOException{
        //Almacenamos la direccion donde se encuenta el fichero en un String
        String rutaFichero = fichero.getAbsolutePath().toString();
        BufferedReader br = null;
        String line = "";
        //Asignar un separador
        char csvSplitBy = ';';
        char quote = '"';
        CSVReader reader = null;
       
        //Realizar lectura del fichero para coger los titulos
        String  titulos [] = new String[5];

                titulos[0] = "Fecha";
                titulos[1] = "Hora";
                titulos[2] = "Número de serie";
                titulos[3] = "Lectura";
                titulos[4] = "Consumo";
        
        //Array de filas
        String col[] = new String[5];
        
        //Creacion del modelo
        model = new DefaultTableModel(null,titulos);
        
        //Recoger fecha del item actual en string
        String fechaActual = null;
        //Recoger la fecha anterior en un string
        String fechaAnterior = null;
        
        //Recoger las lecturas
        String lecturaActual = null;
        String lecturaAnterior = null;
        
        //Consumo
        double consumo = 0;
        
        
        //Lectura del fichero
        try {
            reader = new CSVReader(new FileReader(rutaFichero),csvSplitBy,quote);
            String[] nextLine = null;

            while ((nextLine = reader.readNext()) != null) {
                //System.out.println(Arrays.toString(nextLine));
                //Asignar a cada fila el valor
                col[0] = nextLine[0];//Línea de la fecha Actual
                col[1] = nextLine[1];
                col[2] = nextLine[2];
                col[3] = nextLine[12];//Lectura
                col[4] = nextLine[11];//Consumo
                
                
                if(fechaActual == null && lecturaActual == null){
                   //Aquí se asigna la fecha actual;
                   fechaActual = col[0];
                   //Aquí se le asigna la lectura actual
                   //lecturaActual = col[3];
                }else{
                    //Se le asigna la fecha a fechaAnterior
                    fechaAnterior = col[0];
                    //Aquí se le asigna la lectura anterior
                    //lecturaAnterior = col[3];
                    
                    //Comprobar fechActual con anterior
                    if(fechaActual.compareTo(fechaAnterior) == 1){
                        //La fecha sera menor
                    }else if(fechaActual.compareTo(fechaAnterior) == -1){
                        //Es que la fecha es mayor
                    }else{
                        //La fecha es menor
                    }
                    
                    //Mostrar fecha actual y menor
                    System.out.println("Fecha actual --> "+fechaActual);
                    System.out.println("Fecha anterior --> "+fechaAnterior);
                    System.out.println("----------------------------------------");
                    
                    //Antes de vaciar nada sacamos el consumo de cada cosa
                    //consumo = Double.parseDouble(lecturaActual)-Double.parseDouble(lecturaAnterior);
                    
                    //Ahora asignamos el consumo a la col[4];
                    //col[4] = String.valueOf(consumo);
                    
                    //Vaciamos las acturales fecha y lectura
                    fechaActual = null;

                }
                
                //Añadimos la columna al modelo
                model.addRow(col);
            }
           
            ArrayList <Double> consumoRecogido = new ArrayList<Double>();
            
            //Recorrer el modelo
            for(int i=0;i<model.getRowCount();i++){
                if(lecturaActual == null){
                    lecturaActual = model.getValueAt(i, 3).toString();
                    System.out.println("Lectura actual --> "+lecturaActual);
                }else{
                    lecturaAnterior = model.getValueAt(i, 3).toString();
                    System.out.println("Lectura anterior --> "+lecturaAnterior);

                    //Lectura anterior - actual = consumo
                    consumo = Double.parseDouble(lecturaActual) - Double.parseDouble(lecturaAnterior);
                    System.out.println("Consumo = "+consumo);
                    
                    //Insertamos el consumo dentro de un arraylist
                    consumoRecogido.add(consumo);
                    
                    //model.setValueAt(consumo, i, 4);
                    
                    
                    System.out.println("---------------------------------------------------");
                    
                    lecturaActual = lecturaAnterior;
                }     
            }
            consumoRecogido.add(0.0);
            
            System.out.println(consumoRecogido.toString());
            System.out.println(model.getRowCount());
            
            //Ahora vamos metiendo el consumo recogido dentro del modelo
            for(int i=0;i<consumoRecogido.size();i++){
                model.setValueAt(consumoRecogido.get(i).toString(), i, 4);
            }
                
            //Editar el modelo de la tabla
            tabla.setModel(model);

        } catch (Exception e) {
           
        } finally {
           if (null != reader) {
              reader.close();
           } 
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelRutaFichero = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableInfoCSV = new javax.swing.JTable();
        jButtonVerGrafica = new javax.swing.JButton();

        jLabelRutaFichero.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelRutaFichero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRutaFichero.setText("Ruta del fichero");

        jTableInfoCSV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Fecha", "Hora", "Número de serie", "Lectura", "Contador"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableInfoCSV);

        jButtonVerGrafica.setText("Ver Gráfica");
        jButtonVerGrafica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerGraficaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(jLabelRutaFichero, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(278, 278, 278)
                                .addComponent(jButtonVerGrafica)))
                        .addGap(0, 127, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabelRutaFichero, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(jButtonVerGrafica)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVerGraficaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerGraficaActionPerformed
        MostrarGraficaCSV grafica = new MostrarGraficaCSV(jTableInfoCSV);
        grafica.setResizable(false);
        grafica.setVisible(true);
    }//GEN-LAST:event_jButtonVerGraficaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonVerGrafica;
    private static javax.swing.JLabel jLabelRutaFichero;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable jTableInfoCSV;
    // End of variables declaration//GEN-END:variables

}
