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

        Student[] listado = new Student[numLine];
        BufferedReader data = new BufferedReader(new FileReader(file));
        int j = 0;
        while ((line = data.readLine()) != null){
            String[] dataS = line.split(";");
            listado[j] = new Student(dataS);
            j++;
        }
        bubbleSortIterative(listado, 1);
        for (int i = 0; i < listado.length; i++){
            System.out.println(listado[i]);
        }
        
        for (int i = 0; i < timeDataNano.length; i++){
          timeData[i] = timeDataNano[i];
          System.out.println(i + ".-    " + timeData[i]);
        }
        graphic(timeData);
    }

    //Bubble

    public static void bubbleSortIterative(Student[] arr, int orden){
        initialTime = System.nanoTime();
        for (int i = 1; i < arr.length; i++){
            for (int j = 0; j < arr.length-1; j++){
                if (comparacion(arr, j, (j+1), orden) > 0){
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

    public static int comparacion(Student[] arr, int i, int j, int orden){
        int result = 0;
        switch (orden){
            case 0:
                result = arr[i].getCUI().compareTo(arr[j].getCUI());
                break;
            case 1:
                result = arr[i].getName().compareTo(arr[j].getName());
                break;
            case 2:
                result = arr[i].getBirth().compareTo(arr[j].getBirth());
                break;
            case 3:
                result = arr[i].getAddress().compareTo(arr[j].getAddress());
                break;
            case 4:
                result = arr[i].getLocality().compareTo(arr[j].getLocality());
                break;
            case 5:
                result = arr[i].getTelephone().compareTo(arr[j].getTelephone());
                break;
            case 6:
                result = arr[i].getEmail().compareTo(arr[j].getEmail());
                break;
            case 7:
                result = arr[i].getSemester().compareTo(arr[j].getSemester());
                break; 
        }
        return result;
    }
    
    public static void graphic(double[] args) {
        // Crear un conjunto de datos (Dataset) a partir de un arreglo de valores doubles
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int i = 0; i < args.length; i++) {
            dataset.addValue(args[i], "Serie 1", " "+i);
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
/*
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


    //Insertion
    public static void insertionNumeros(int numeros[]){
        int key, j;
        for (int i = 1; i < numeros.length; i++) {
            key = numeros[i];
            j = i - 1;
            while (j >= 0 && numeros[j] > key) {
                numeros[j + 1] = numeros[j];
                j = j - 1;
            }
            numeros[j + 1] = key;
        }
    }
    public static void insertionAlfabetico(String palabras[]){
        for (int i = 1; i < palabras.length; i++) {
            String key = palabras[i];
            int j = i - 1;
            while (j >= 0 && palabras[j].compareTo(key) > 0) {
                palabras[j + 1] = palabras[j];
                j = j - 1;
            }
            palabras[j + 1] = key;
        }
    }

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