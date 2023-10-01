import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;

public class Prueba_graficoL {
    public static void main(String[] args) {
        // Crear un conjunto de datos (Dataset)
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1.0, "Serie 1", "Categoría 1");
        dataset.addValue(4.0, "Serie 1", "Categoría 2");
        dataset.addValue(3.0, "Serie 2", "Categoría 1");
        dataset.addValue(4.0, "Serie 2", "Categoría 2");

        // Crear un gráfico de líneas
        JFreeChart chart = ChartFactory.createLineChart(
                "Gráfico de Líneas Ejemplo",
                "Eje X",
                "Eje Y",
                dataset, // Tu conjunto de datos
                PlotOrientation.VERTICAL,
                true, // Mostrar leyenda
                true,
                false
        );

        // Crear un panel de gráfico y agregarlo a una ventana
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));

        JFrame frame = new JFrame("Gráfico de Líneas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
