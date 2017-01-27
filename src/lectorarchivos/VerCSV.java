/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lectorarchivos;

import com.opencsv.CSVReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MGC
 */
public class VerCSV extends javax.swing.JPanel {
    File fichero = null;
    
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
        DefaultTableModel model = new DefaultTableModel(null,titulos);
        
        //Lectura del fichero
         try {
           reader = new CSVReader(new FileReader(rutaFichero),csvSplitBy,quote);
           String[] nextLine = null;

           while ((nextLine = reader.readNext()) != null) {
              //System.out.println(Arrays.toString(nextLine));
              //Asignar a cada fila el valor
              col[0] = nextLine[0];
              col[1] = nextLine[1];
              col[2] = nextLine[2];
              col[3] = nextLine[12];
              col[4] = nextLine[11];
              model.addRow(col);
           }
           
           //Editar el modelo de la tabla
           tabla.setModel(model);

        } catch (Exception e) {
           
        } finally {
           if (null != reader) {
              reader.close();
           } 
        }
        /*try{
            br = new BufferedReader(new FileReader(rutaFichero));
            
            //Empieza la lectura del csv
            while((line = br.readLine())!=null){
                //Usar el ';' como separador
                String[] datos = line.split(csvSplitBy);
                
                /*
                    Una vez tengamos los datos almacenados
                    en el array toca almacenarlos en la tabla
                */
                
                /*fila[0] = datos[0];
                fila[1] = datos[1];
                fila[2] = datos[2];
                fila[3] = datos[3];
                fila[4] = datos[4];
                
                model.addRow(fila);
            }
            tabla.setModel(model);
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(br!=null){
                try{
                    br.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }*/
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
        ));
        jScrollPane1.setViewportView(jTableInfoCSV);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jLabelRutaFichero, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabelRutaFichero, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JLabel jLabelRutaFichero;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable jTableInfoCSV;
    // End of variables declaration//GEN-END:variables

}
