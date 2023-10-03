import java.io.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;

public class StudentRegistration {
    static long initialTime, currentTime, timeElapsed;
    static double[] timeData;

    static double[][] timesSaved;
    public static void main(String[] args) throws IOException{
        int numLine = 0;
        String file = "pruebaCUI.csv";
        String line;
        BufferedReader Lines = new BufferedReader(new FileReader(file));
        while (Lines.readLine() != null) {
            numLine++;
        }
        timesSaved = new double[4][200];
        //timesSaved = new double[][]; // colocar tamaño
        Student[] listado = new Student[numLine];
        BufferedReader data = new BufferedReader(new FileReader(file));
        int j = 0;
        while ((line = data.readLine()) != null){
            String[] dataS = line.split(";");
            listado[j] = new Student(dataS);
            j++;
        }
        //listado.length/5
        for (int i = 0; i < (listado.length/5); i++){
            Student[] arr = new Student[5*(i+1)];
            System.arraycopy(listado, 0, arr, 0, 5*(i+1));
            //for (int k = 0; k < arr.length; k++){
              //  System.out.println(arr[k]);
            //}

            initialTime = System.nanoTime();
            bubbleSortIterative(arr, 0);
            currentTime = System.nanoTime();
            timesSaved[0][i] = currentTime - initialTime;

            initialTime = System.nanoTime();
            selectionSort(arr, 0);
            currentTime = System.nanoTime();
            timesSaved[1][i] = currentTime - initialTime;

            initialTime = System.nanoTime();
            insertionSort(arr, 0);
            currentTime = System.nanoTime();
            timesSaved[2][i] = currentTime - initialTime;

            initialTime = System.nanoTime();
            mergeSort(arr, 0, arr.length-1, 0);
            currentTime = System.nanoTime();
            timesSaved[3][i] = currentTime - initialTime;
        }
        
        
        graphic(timesSaved);

    }

    //Bubble.

    public static void bubbleSortIterative(Student[] listado, int orden){
        Student[] arr = new Student[listado.length];
        System.arraycopy(listado, 0, arr, 0, listado.length);
        for (int i = 1; i < arr.length; i++){
            for (int j = 0; j < arr.length-1; j++){
                if (arr[j].getCUI() > arr[j+1].getCUI()){
                    Student temp;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        /*for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }*/
    }

    public static void bubbleSortRecursive(int arr[], int n){
        
        if (n == 1)
            return;
  
        int count = 0;
        for (int i=0; i<n-1; i++)
            if (arr[i] > arr[i+1])
            {
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                count = count+1;
            }
        if (count == 0)
            return;
        
        bubbleSortRecursive(arr, n-1);
    }


    public static int comparacion(Student st1, Student st2, int orden){
        int result = 0;
        switch (orden){
            case 0:
                if(st1.getCUI() > st2.getCUI()) result = 1;
                break;
            case 1:
                result = st1.getEmail().compareTo(st2.getEmail());
                break;
            case 2:
                result = st1.getName().compareTo(st2.getName());
                break;
            case 3:
                result = st1.getLastNameF().compareTo(st2.getLastNameF());
                break;
            case 4:
                result = st1.getLastNameM().compareTo(st2.getLastNameM());
                break;
            case 5:
                result = st1.getDateBirth().compareTo(st2.getDateBirth());
                break;
            case 6:
                result = st1.getGender().compareTo(st2.getGender());
                break;
            case 7:
                result = (st1.getStatus()?"a":"z").compareTo(st2.getStatus()?"a":"z"); //cambiar
                break; 
        }
        return result;
    }
    
    public static void graphic1(double[][] times) {
        // Crear un conjunto de datos (Dataset) a partir de un arreglo de valores doubles
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        /*for (int i = 0; i < times.length; i++) {
            dataset.addValue(times[i], "Serie 1", " "+ i );
        }*/

        String[] series = {"Bubble", "Selection", "Insertion", "Merge"};
        for (int i = 0; i < times.length; i++){
            for (int j = 0; j < times[i].length; j++){
                dataset.addValue(times[i][j], series[i], " " + j);
            }
        }
         

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

    public static void graphic(double[][] times) {
        XYSeries series1 = new XYSeries("Bubble");
        XYSeries series2 = new XYSeries("Selection");
        XYSeries series3 = new XYSeries("Insertion");
        XYSeries series4 = new XYSeries("Merge");

        /* Agrega datos de ejemplo con intervalo de 5 en el eje X
        for (int i = 0; i <= 100; i += 1) {
            series1.add(i, Math.random() * 100);
            series2.add(i, Math.random() * 100);
            series1.add(i, Math.random() * 100);
            series2.add(i, Math.random() * 100);
        }*/

        for (int i = 0; i < times[0].length; i++){
            series1.add(i, times[0][i]);
            series2.add(i, times[1][i]);
            series3.add(i, times[2][i]);
            series4.add(i, times[3][i]);
        }
         

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        dataset.addSeries(series3);
        dataset.addSeries(series4);

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Gráfico de Líneas con Intervalo en Eje X",
                "Eje X",
                "Eje Y",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        XYPlot plot = chart.getXYPlot();
        NumberAxis xAxis = (NumberAxis) plot.getDomainAxis();

        // Define el intervalo de las etiquetas del eje X (cada 5 unidades)
        xAxis.setTickUnit(new NumberTickUnit(20.0));

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));

        JFrame frame = new JFrame("Gráfico de Líneas con Intervalo en Eje X");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }

    //Selection
    public static void selectionSort(Student[] listado, int orden){
        Student[] arr = new Student[listado.length];
        System.arraycopy(listado, 0, arr, 0, listado.length);
        int n = arr.length;
        for (int i = 0; i < n-1; i++){
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[min_idx].getCUI() > arr[j].getCUI())
                    min_idx = j;
            Student temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
        /*for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }*/
    }

    /*public static void selectionSort(Student[] listado, int orden){
        Student[] arr = new Student[listado.length];
        System.arraycopy(listado, 0, arr, 0, listado.length);
        initialTime = System.nanoTime();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].getCUI() > arr[j].getCUI()) {
                    Student temporal = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temporal;
                }
            }
            currentTime = System.nanoTime();
            timesSaved[1][i] = currentTime - initialTime;
        }
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }*/

    //Insertion
    public static void insertionSort(Student[] listado, int orden){
        Student[] arr = new Student[listado.length];
        System.arraycopy(listado, 0, arr, 0, listado.length);
        int j;
        Student key;
        for (int i = 1; i < arr.length; i++) {
            key = arr[i];
            j = i - 1; 
            while (j >= 0 && arr[j].getCUI() > key.getCUI()) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        //for (int i = 0; i < arr.length; i++){
           // System.out.println(arr[i]);
        //}
    }
/*
    //InsertionRecursive
    public static void insertionSortRecursive(int[] arr, int n) {
        // Base case: If n is 1 or less, the array is already sorted.
        if (n <= 1)
            return;

        // Sort first n-1 elements
        insertionSortRecursive(arr, n - 1);

        // Insert the nth element at the correct position in the sorted part
        int lastElement = arr[n - 1];
        int j = n - 2;

        while (j >= 0 && arr[j] > lastElement) {
            arr[j + 1] = arr[j];
            j--;
        }

        arr[j + 1] = lastElement;
    }

static void insertionSortRecursive(int arr[], int n)
    {
        // Base case
        if (n <= 1)
            return;
       
        // Sort first n-1 elements
        insertionSortRecursive( arr, n-1 );
       
        // Insert last element at its correct position
        // in sorted array.
        int last = arr[n-1];
        int j = n-2;
       
        Move elements of arr[0..i-1], that are
          greater than key, to one position ahead
          of their current position
        while (j >= 0 && arr[j] > last)
        {
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = last;
    }
*/

    //Merge
    public static void merge(Student[] arr, int l, int m, int r, int orden) {
        
        int n1 = m - l + 1;
        int n2 = r - m;

        Student L[] = new Student[n1];
        Student R[] = new Student[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (comparacion(L[i], R[j], orden) <= 0) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    
    }
    public static void mergeSort(Student listado[], int l, int r, int orden) {
        Student[] arr = new Student[listado.length];
        System.arraycopy(listado, 0, arr, 0, listado.length);
        initialTime = System.nanoTime();
        if (l < r){
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m, orden);
            mergeSort(arr, m + 1, r, orden);
            
            merge(arr, l, m, r, orden);
        }
    }
}