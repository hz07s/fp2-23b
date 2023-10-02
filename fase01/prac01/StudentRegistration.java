import java.io.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;

public class StudentRegistration {
    static long initialTime, currentTime, timeElapsed;
    static long[] timeDataNano;
    static double[] timeData;

    static double[][] timesSaved;
    public static void main(String[] args) throws IOException{
        int numLine = 0;
        String file = "DatosEstudiantes.csv";
        String line;
        BufferedReader Lines = new BufferedReader(new FileReader(file));
        while (Lines.readLine() != null) {
            numLine++;
        }
        timeDataNano = new long[numLine];
        timeData = new double[numLine];
        //timesSaved = new double[][]; // colocar tamaño
        Student[] listado = new Student[numLine];
        BufferedReader data = new BufferedReader(new FileReader(file));
        int j = 0;
        while ((line = data.readLine()) != null){
            String[] dataS = line.split(";");
            listado[j] = new Student(dataS);
            j++;
        }
        insertionSort(listado, 2);
        //bubbleSortIterative(listado, 2);
        for (int i = 0; i < listado.length; i++){
            System.out.println(listado[i]);
        }
        
        for (int i = 0; i < timeDataNano.length; i++){
          timeData[i] = timeDataNano[i];
          System.out.println(i + ".-    " + timeData[i]);
        }
        graphic(timeData);
    }



    //Bubble.

    public static void bubbleSortIterative(Student[] arr, int orden){
        initialTime = System.nanoTime();
        for (int i = 1; i < arr.length; i++){
            for (int j = 0; j < arr.length-1; j++){
                if (comparacion(arr[j], arr[j+1], orden) > 0){
                    Student temp;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            currentTime = System.nanoTime();
            timeDataNano[i] = currentTime - initialTime;
        }
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
    
    public static void graphic(double[] times) {
        // Crear un conjunto de datos (Dataset) a partir de un arreglo de valores doubles
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for (int i = 0; i < times.length; i++) {
            dataset.addValue(times[i], "Serie 1", " "+ i );
        }

        /*
        for (int i = 0; i < times.length; i++){
            for (int k = 0; k < times[].length; k++){
                dataset.addValue(times[i][j], "Name..." + i, " " + j);
            }
        }
      
         */

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
/*
    //Selection
    public static void selectionSort(int arr[]){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    // ...intercambiarlos, es decir, mover el actual a la derecha y el de la derecha al actual
                    int temporal = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temporal;
                }
            }
        }
    }
*/

    //Insertion
    public static void insertionSort(Student arr[], int orden){
        initialTime = System.nanoTime();
        int j;
        Student key;
        for (int i = 1; i < arr.length; i++) {
            key = arr[i];
            j = i - 1; 
            while (j >= 0 && comparacion(arr[j], key, orden) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
            currentTime = System.nanoTime();
            timeDataNano[i] = currentTime - initialTime;
        }
    }
/*
    //Merge
    public static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
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
    public static void sort(int arr[], int l, int r ) {
        if (l < r){
            int m = l + (r - l) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            
            merge(arr, l, m, r);
        }
    }
    




*/
}