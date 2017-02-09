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

import Clases.Contador;
import com.opencsv.CSVReader;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
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
    private static Set codigoContadores = new HashSet();
    private static Set nombreContadores = new HashSet();
    private static String rutaFichero;
    
    /**
     * Creates new form VerCSV
     */
    public VerCSV(File fichero) throws IOException {
        initComponents();
        this.fichero = fichero;
        //jLabelRutaFichero.setText(fichero.getAbsolutePath().toString());
        
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
                col[2] = nextLine[2];//Número de serire
                
                
                
                
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
                codigoContadores.add(model.getValueAt(i, 2).toString());
                
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
            
            //Recorrer array de codigoContadores
            System.out.println("Tamaño de la lista de numContadores: "+codigoContadores.size());
            System.out.println("Datos del array: " + codigoContadores.toString());
            
            //Ahora insertamos los datos del set dentro del combo
            /*Iterator iterator = codigoContadores.iterator();
            while(iterator.hasNext()){
                String codigo = (String) iterator.next();
                //Insertar el código en el combo
                jComboBoxContador.addItem(codigo);
            }*/
            
            //Leer el XML para mostrar el nombre del contador
            leerXML();
            
            //Editar el modelo de la tabla
            tabla.setModel(model);

        } catch (Exception e) {
           
        } finally {
           if (null != reader) {
              reader.close();
           } 
        }
    }
    
    public static void leerXML(){
        LeerXML xml = new LeerXML("C:/Users/mgc/Desktop/DescargaContadores0.xml");
        Enumeration e = xml.leerXML().keys();
        Object clave;
        Object valor;
        
        if(!xml.equals(null)){
            while( e.hasMoreElements() ){
                clave = e.nextElement();
                valor = xml.leerXML().get(clave);
                System.out.println(clave + " " + valor);
                Contador cont = new Contador(clave.toString(), valor.toString());
                //Ver si algun elemento del array de codigoContadores coincide con el codigo del objeto contador
                Iterator iterator = codigoContadores.iterator();
                while(iterator.hasNext()){
                     //String codigo = (String) iterator.next();
                     //Comprobar el codigo coincide con el objeto
                     if(cont.getNumSerie().equals((String) iterator.next())){
                         //Ahora meter el nombre en otro iterator con los nombres
                         //jComboBoxContador.addItem(cont.getNombrePila());
                         nombreContadores.add(cont.getNombrePila());
                     }
                }
            }
            
            Iterator iter = nombreContadores.iterator();
            while(iter.hasNext()){
                String codigo = (String) iter.next();
                jComboBoxContador.addItem(codigo);
            }
        }else{
            System.out.println("No se ha podido encontrar el archivo xml");
            try {
                //Insertaremos un browser file para que el usuario pueda buscar el fichero
                xml = new LeerXML(abrirSelectorXML());
                while( e.hasMoreElements() ){
                    clave = e.nextElement();
                    valor = xml.leerXML().get( clave );
                    System.out.println(clave + " " + valor);
                }
            } catch (IOException ex) {
                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    //Crear método para abrir selector
    public static String abrirSelectorXML() throws IOException{
        JFileChooser selector = new JFileChooser();
        FileNameExtensionFilter filtroArchivo=new FileNameExtensionFilter("csv & xls & txt","csv","xls","txt");
        selector.setFileFilter(filtroArchivo);
        selector.setFileSelectionMode(JFileChooser.FILES_ONLY);
        selector.setMultiSelectionEnabled(false);
        
        //int r=selector.showOpenDialog(this);
        
        
        /*if(r==JFileChooser.APPROVE_OPTION){
            //Recorremos el array de ficheros seleccionados
            rutaFichero = selector.getSelectedFile().toPath().toAbsolutePath().toString(); 
        }else{
            System.out.println("Yo devuelvo nullo");
        }*/
        return rutaFichero;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableInfoCSV = new javax.swing.JTable();
        jButtonVerGrafica = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxContador = new javax.swing.JComboBox<>();

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

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Seleccionar contador");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(922, Short.MAX_VALUE)
                        .addComponent(jButtonVerGrafica))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxContador, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxContador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 294, Short.MAX_VALUE)
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
    public static javax.swing.JComboBox<String> jComboBoxContador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable jTableInfoCSV;
    // End of variables declaration//GEN-END:variables

}
