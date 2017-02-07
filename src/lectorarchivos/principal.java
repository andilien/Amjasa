/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lectorarchivos;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author MGC
 */
public class principal extends javax.swing.JFrame {

    /**
     * Creates new form principal
     */
   
    //Crear variable para guardar la ruta del fichero
    private static String rutaFichero;
    private static File fichero;
    private JInternalFrame internalFrame;
    
    //Cuenta la cantidad de JInternalFrame
    public static int openFrameCount = 0;
    //Marca la posición "x" e "y"
    public static final int xOffset = 30, yOffset = 30; 
    
    
    public principal() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
 
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                close();
            }
        });
    }
    
    private void close(){
        if(openFrameCount!=0){
            if (JOptionPane.showConfirmDialog(rootPane, "Quedan ficheros abiertos, \n¿Seguro que quiere salir?",
                "Salir", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                System.exit(0);
        }else{
            System.exit(0);
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

        jFileChooser1 = new javax.swing.JFileChooser();
        jFrame1 = new javax.swing.JFrame();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuBar4 = new javax.swing.JMenuBar();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenuBar5 = new javax.swing.JMenuBar();
        jMenu9 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jMenuBar6 = new javax.swing.JMenuBar();
        jMenu11 = new javax.swing.JMenu();
        jMenu12 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jDesktopPanePrincipal = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemOpenFile = new javax.swing.JMenuItem();
        jMenu13 = new javax.swing.JMenu();
        jMenuItemXML = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jMenuItem1.setText("jMenuItem1");

        jMenu2.setText("jMenu2");

        jMenuItem2.setText("jMenuItem2");

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("File");
        jMenuBar3.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar3.add(jMenu6);

        jMenuItem3.setText("jMenuItem3");

        jMenuItem4.setText("jMenuItem4");

        jMenuItem5.setText("jMenuItem5");

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        jMenuItem6.setText("jMenuItem6");

        jMenuItem7.setText("jMenuItem7");

        jMenu7.setText("File");
        jMenuBar4.add(jMenu7);

        jMenu8.setText("Edit");
        jMenuBar4.add(jMenu8);

        jMenu9.setText("File");
        jMenuBar5.add(jMenu9);

        jMenu10.setText("Edit");
        jMenuBar5.add(jMenu10);

        jMenuItem8.setText("jMenuItem8");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jMenuItem9.setText("jMenuItem9");

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jMenu11.setText("File");
        jMenuBar6.add(jMenu11);

        jMenu12.setText("Edit");
        jMenuBar6.add(jMenu12);

        jMenuItem10.setText("jMenuItem10");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPanePrincipal.setBackground(new java.awt.Color(210, 230, 230));

        javax.swing.GroupLayout jDesktopPanePrincipalLayout = new javax.swing.GroupLayout(jDesktopPanePrincipal);
        jDesktopPanePrincipal.setLayout(jDesktopPanePrincipalLayout);
        jDesktopPanePrincipalLayout.setHorizontalGroup(
            jDesktopPanePrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 815, Short.MAX_VALUE)
        );
        jDesktopPanePrincipalLayout.setVerticalGroup(
            jDesktopPanePrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 491, Short.MAX_VALUE)
        );

        jMenu1.setText("Archivo");

        jMenuItemOpenFile.setText("Abrir");
        jMenuItemOpenFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemOpenFileActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemOpenFile);

        jMenuBar1.add(jMenu1);

        jMenu13.setText("Cargar");

        jMenuItemXML.setText("XML Contadores");
        jMenuItemXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemXMLActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItemXML);

        jMenuBar1.add(jMenu13);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPanePrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPanePrincipal)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemOpenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemOpenFileActionPerformed
        try {
            //Aquí integraremos el código para abrir un archivo de tipo csv, xls o txt.+
            abrirSelector();
        } catch (IOException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItemOpenFileActionPerformed

    //Opción para cargar el XML
    private void jMenuItemXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemXMLActionPerformed
        /*File ficheroXML = new File("C:/Users/agl/Desktop/DescargaContadores0.xml");
        if(ficheroXML==null){
             JOptionPane.showMessageDialog(null, "Sin ruta", "No se ha encontado la ruta del fichero", JOptionPane.ERROR);
            //System.out.println("No se ha encontrado el fichero");
        }else{
            JOptionPane.showMessageDialog(null, "Ruta", "Se ha encontado la ruta del fichero", JOptionPane.ERROR);
            //System.out.println("Se ha encontado el fichero");
            
        }*/
        LeerXML xml = new LeerXML("C:/Users/agl/Desktop/DescargaContadores0.xml");
        Enumeration e = xml.leerXML().keys();
        Object clave;
        Object valor;
        while( e.hasMoreElements() ){
          clave = e.nextElement();
          valor = xml.leerXML().get( clave );
          System.out.println(clave + " " + valor);
        }
        
        //Abrir un frame para mostrar los datos en una tabla
    }//GEN-LAST:event_jMenuItemXMLActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principal().setVisible(true);
            }
        });
    }
    
    //Crear método para abrir selector
    public void abrirSelector() throws IOException{
        JFileChooser selector = new JFileChooser();
        FileNameExtensionFilter filtroArchivo=new FileNameExtensionFilter("csv & xls & txt","csv","xls","txt");
        selector.setFileFilter(filtroArchivo);
        selector.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if(!selector.isMultiSelectionEnabled()){
            selector.setMultiSelectionEnabled(true);
        }
        
        int r=selector.showOpenDialog(this);
        
        
        if(r==JFileChooser.APPROVE_OPTION){
            //Recorremos el array de ficheros seleccionados
            for(int i=0;i<selector.getSelectedFiles().length;i++){
                rutaFichero = selector.getSelectedFiles()[i].toPath().toAbsolutePath().toString();
                fichero = selector.getSelectedFiles()[i];
                
                openFrameCount += 1;

                System.out.println("Ruta del fichero --> "+rutaFichero);

                //Ahora averiguaremos que extension es
                /*** 
                 Para ello llamaremos al método getExtension
                 Como devuelve un String lo meteremos dentro
                 de una variable de tipo String
                 ***/

                //Creación de la ventana interna
                makeInternal(fichero);
            }
            
            
        }else{
            System.out.println("Yo devuelvo nullo");
        }
        
      
        
    }
    
   
    //Crear método para recoger la extensión del fichero
    public static String getExtension(File fichero){
        String fileName = fichero.getName().toString();
        int index = fileName.lastIndexOf('.');
        if(index == -1){
            return "";
        }else{
            return fileName.substring(index + 1);
        }
    }
    
    //Crear ventana interna
    public void makeInternal(File archivo) throws IOException{
        String titulo = null;
        boolean csv = false;
        String recogerExtension = getExtension(fichero);
        if(recogerExtension.equals("xls")){
            titulo = "XLS - "+fichero.getName().toString();
            csv = false;
        }else if(recogerExtension.equals("csv")){
            titulo = "CSV - "+fichero.getName().toString();
            csv = true;
        }
        internalFrame = new JInternalFrame(titulo,true,true,true,true);
        internalFrame.setBounds(100,100,600,400);
        
        
        jDesktopPanePrincipal.add(internalFrame);
        //internalFrame.getContentPane().setLocation(200, sumaLoc+=1000);
        internalFrame.show();
        
        if(csv){
            //Crear JPanel enviandole la ruta del archivo
            VerCSV csvFichero = new VerCSV(fichero);
            
            //Cambiar localizacion del frame interno
            
            internalFrame.setLocation(xOffset*openFrameCount, yOffset*openFrameCount);
            
            //Añadimos el JPanel a internalframe
            internalFrame.add(csvFichero);
            
            //mostrar el jpanel
            csvFichero.setVisible(true);
        }else{
            
        }
        //Insertar un JPanel dentro de internalFrame
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JDesktopPane jDesktopPanePrincipal;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JMenuBar jMenuBar5;
    private javax.swing.JMenuBar jMenuBar6;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem jMenuItemOpenFile;
    private static javax.swing.JMenuItem jMenuItemXML;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.MenuBar menuBar1;
    // End of variables declaration//GEN-END:variables
}
