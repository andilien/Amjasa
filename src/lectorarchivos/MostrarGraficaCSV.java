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
        String fecha;
        for(int i=0;i<jTableInfoCSV.getRowCount();i++){
            fecha = jTableInfoCSV.getValueAt(i,4).toString();
            dataset.setValue(Double.parseDouble(fecha),"Consumo", jTableInfoCSV.getValueAt(i, 0).toString());
        }
        
        //Creando el gráfico
        JFreeChart chart = ChartFactory.createBarChart3D
                ("Consumo","Fecha","Consumo",
                dataset, PlotOrientation.VERTICAL, true,true, false);
                chart.setBackgroundPaint(Color.cyan);
                chart.getTitle().setPaint(Color.black);
                chart.setBackgroundPaint(Color.white);
                chart.removeLegend();
        
        /*panel = new JPanel();
        getContentPane().add(panel);
        // Fuente de Datos
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(8, "Mujeres", "Lunes");
        dataset.setValue(7, "Hombres", "Lunes");
        dataset.setValue(9, "Mujeres", "Martes");
        dataset.setValue(4, "Hombres", "Martes");
        dataset.setValue(4, "Mujeres", "Miercoles");
        dataset.setValue(5, "Hombres", "Miercoles");
        dataset.setValue(8, "Mujeres", "Jueves");
        dataset.setValue(9, "Hombres", "Jueves");
        dataset.setValue(7, "Mujeres", "Viernes");
        dataset.setValue(8, "Hombres", "Viernes");
        // Creando el Grafico
        JFreeChart chart = ChartFactory.createBarChart3D
        ("Participacion por Genero","Genero", "Dias", 
        dataset, PlotOrientation.VERTICAL, true,true, false);
        chart.setBackgroundPaint(Color.cyan);
        chart.getTitle().setPaint(Color.black); 
        CategoryPlot p = chart.getCategoryPlot(); 
        p.setRangeGridlinePaint(Color.red); */
        
        // Mostrar Grafico
        ChartFrame frame = new ChartFrame("CONSUMO",chart);
        frame.pack();
        frame.setVisible(true);
        
        //panel.add(frame);
        
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
