/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lectorarchivos;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTable;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author MGC
 */
public class MostrarGraficaCSV extends javax.swing.JFrame {
    JPanel panel;
    /**
     * Creates new form MostrarGraficaCSV
     */
    public MostrarGraficaCSV(JTable jTableInfoCSV) {
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        panel = new JPanel();
        getContentPane().add(panel);
        
        //Fuente de datos
        DefaultCategoryDataset dataset =  new DefaultCategoryDataset();
        
        //Recorremos la columna del consumo de la tabla
        for(int i=jTableInfoCSV.getRowCount()-1;i>=0;i--){
            dataset.setValue(Double.parseDouble(jTableInfoCSV.getValueAt(i,4).toString()),"Consumo", jTableInfoCSV.getValueAt(i, 0).toString());
        }
        
        //Creando el gráfico
        JFreeChart chart = ChartFactory.createBarChart3D
                ("Consumo","Fecha","Consumo",
                dataset, PlotOrientation.VERTICAL, true,true, false);
                chart.setBackgroundPaint(Color.cyan);
                chart.getTitle().setPaint(Color.black);
                chart.setBackgroundPaint(Color.white);
                chart.removeLegend();
        
        
        // Mostrar Grafico
        ChartFrame frame = new ChartFrame("CONSUMO",chart);
        frame.pack();
        frame.setVisible(true);
        
        panel.add(frame);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}