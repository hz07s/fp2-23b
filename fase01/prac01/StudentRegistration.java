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
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentRegistration {
  static long initialTime, currentTime, timeElapsed;
  static double timesSearchBinary, timesSearchBinaryRc;
  static double[] timeData;
  static double[][] timesSaved;
  static Student[] listado = new Student[0];

    final static String[] date = {"CUI", "Email", "Nombre", "Apellido Materno", "Apellido Paterno", "Cumpleaños", "Género", "Estado"};
    static int orden = -1;
    final static String[] algorithm = {"BubbleSort", "SelectionSort", "InsertionSort", "MergeSort", "BubbleSort (recursive)", "SelectionSort (recursive)", "InsertionSort (recursive)"};
    static boolean[] algorithms = new boolean[8];

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
            Student[] arr = new Student[5 * (i + 1)];
            System.arraycopy(listado, 0, arr, 0, 5 * (i + 1));
            
            //iterativeBubbleSort
            if (algorithms[0]){
                initialTime = System.nanoTime();
                bubbleSortIterative(arr, 0);
                currentTime = System.nanoTime();
                timesSaved[0][i] = currentTime - initialTime;
            }

            //iterativeSelectionSort
            if (algorithms[1]){
                initialTime = System.nanoTime();
                selectionSort(arr, 0);
                currentTime = System.nanoTime();
                timesSaved[1][i] = currentTime - initialTime;
            }

            //iterativeInsertionSort
            if (algorithms[2]){
                initialTime = System.nanoTime();
                insertionSort(arr, 0);
                currentTime = System.nanoTime();
                timesSaved[2][i] = currentTime - initialTime;
            }

            //mergeSort
            if (algorithms[3]){
                initialTime = System.nanoTime();
                mergeSort(arr, 0, arr.length - 1, 0);
                currentTime = System.nanoTime();
                timesSaved[3][i] = currentTime - initialTime;
            }

            //recursiveBubbleSort
            if (algorithms[4]){
                initialTime = System.nanoTime();
                recursiveBubbleSort(arr, arr.length, 0);
                currentTime = System.nanoTime();
                timesSaved[4][i] = currentTime - initialTime;
            }
            
            //recursiveSelectionSort
            if (algorithms[5]){
                initialTime = System.nanoTime();
                recursiveSelectionSort(arr, arr.length, 0, orden);
                currentTime = System.nanoTime();
                timesSaved[5][i] = currentTime - initialTime;
            }

            //recursiveInsertionSort
            if (algorithms[6]){
                initialTime = System.nanoTime();
                recursiveInsertionSort(arr, arr.length, 0);
                currentTime = System.nanoTime();
                timesSaved[6][i] = currentTime - initialTime;
            }
        }
        
        graphic(timesSaved);

    }
    public static void sortingAlgorithms()throws IOException{
        int numLine = 0;
        String file = "StudentData.csv";
        String line;
        int numIntervals = 200;
        BufferedReader Lines = new BufferedReader(new FileReader(file));
        while (Lines.readLine() != null) {
            numLine++;
        }
        timesSaved = new double[7][numIntervals];
        //timesSaved = new double[][]; // colocar tamaño
        listado = new Student[numLine];
        BufferedReader data = new BufferedReader(new FileReader(file));
        int j = 0;
        while ((line = data.readLine()) != null){
            String[] dataS = line.split(",");
            listado[j] = new Student(dataS);
            j++;
        }
        int rangeIntervals = listado.length/numIntervals;
        //listado.length/5
        for (int i = 0; i < (numIntervals); i++){
            Student[] arr = new Student[rangeIntervals * (i + 1)];
            System.arraycopy(listado, 0, arr, 0, rangeIntervals * (i + 1));
            
            //iterativeBubbleSort
            if (algorithms[0]){
                Student[] arr0 = new Student[arr.length];
                System.arraycopy(arr, 0, arr0, 0, arr.length);
                initialTime = System.nanoTime();
                bubbleSortIterative(arr0);
                currentTime = System.nanoTime();
                timesSaved[0][i] = currentTime - initialTime;
            }

            //iterativeSelectionSort
            if (algorithms[1]){
                Student[] arr1 = new Student[arr.length];
                System.arraycopy(arr, 0, arr1, 0, arr.length);
                initialTime = System.nanoTime();
                selectionSort(arr1);
                currentTime = System.nanoTime();
                timesSaved[1][i] = currentTime - initialTime;
            }

            //iterativeInsertionSort
            if (algorithms[2]){
                Student[] arr2 = new Student[arr.length];
                System.arraycopy(arr, 0, arr2, 0, arr.length);
                initialTime = System.nanoTime();
                insertionSort(arr2);
                currentTime = System.nanoTime();
                timesSaved[2][i] = currentTime - initialTime;
            }

            //mergeSort
            if (algorithms[3]){
                Student[] arr3 = new Student[arr.length];
                System.arraycopy(arr, 0, arr3, 0, arr.length);
                initialTime = System.nanoTime();
                mergeSort(arr3, 0, arr3.length - 1);
                currentTime = System.nanoTime();
                timesSaved[3][i] = currentTime - initialTime;
            }

            //recursiveBubbleSort
            if (algorithms[4]){
                Student[] arr4 = new Student[arr.length];
                System.arraycopy(arr, 0, arr4, 0, arr.length);
                initialTime = System.nanoTime();
                recursiveBubbleSort(arr4, arr4.length);
                currentTime = System.nanoTime();
                timesSaved[4][i] = currentTime - initialTime;
            }
            
            //recursiveSelectionSort
            if (algorithms[5]){
                Student[] arr5 = new Student[arr.length];
                System.arraycopy(arr, 0, arr5, 0, arr.length);
                initialTime = System.nanoTime();
                recursiveSelectionSort(arr5, arr5.length, 0);
                currentTime = System.nanoTime();
                timesSaved[5][i] = currentTime - initialTime;
            }

            //recursiveInsertionSort
            if (algorithms[6]){
                Student[] arr6 = new Student[arr.length];
                System.arraycopy(arr, 0, arr6, 0, arr.length);
                initialTime = System.nanoTime();
                recursiveInsertionSort(arr6, arr6.length);
                currentTime = System.nanoTime();
                timesSaved[6][i] = currentTime - initialTime;
            }
        }
        
        graphic(timesSaved);

    }

    //Bubble
    public static void bubbleSortIterative(Student[] arr){
        for (int i = 1; i < arr.length; i++){
            for (int j = 0; j < arr.length - 1; j++){
                if (comparison(arr[j], arr[j + 1], orden) > 0){
                    Student temp;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    //Recursive Bubble
    public static void recursiveBubbleSort(Student arr[], int n){
        if (n == 1)
            return;

        int count = 0;

        for (int i = 0; i < n - 1; i++) {
            if (comparison(arr[i], arr[i + 1], orden) > 0) {
                Student temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                count = count + 1;
            }
        }
        if (count == 0)
            return;
        recursiveBubbleSort(arr, n - 1);
    }
    
    //Selection
    public static void selectionSort(Student[] arr){
        int n = arr.length;
        for (int i = 0; i < n-1; i++){
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (comparison(arr[min_idx], arr[j], orden) > 0)
                    min_idx = j;
            Student temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    //Recursive Selection 
    public static int minIndex(Student arr[], int i, int j) {
        if (i == j)
            return i;
        int k = minIndex(arr, i + 1, j);

        if (comparison(arr[i], arr[k], orden) < 0 || comparison(arr[i], arr[k], orden) != 1) {
            return i;
        } else {
            return k;
        }
    }
    public static void recursiveSelectionSort(Student[] arr, int n, int idx) {
        if (idx == n)
          return;

        int k = minIndex(arr, idx, n - 1);
        if (k != idx){
          Student temp = arr[k];
          arr[k] = arr[idx];
          arr[idx] = temp;
        }
        recursiveSelectionSort(arr, n, idx + 1);
    }

    //Insertion
    public static void insertionSort(Student[] arr){
        int j;
        Student key;
        for (int i = 1; i < arr.length; i++) {
            key = arr[i];
            j = i - 1; 
            while (j >= 0 && comparison(arr[j], key, orden) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    //Recursive Insertion
      private static void recursiveInsertionSort(Student[] arr, int n) {
        if (n <= 1)
            return;
            
        recursiveInsertionSort(arr, n - 1);
    
        Student key = arr[n - 1];
        int j = n - 2;
        while (j >= 0 && comparison(arr[j], key, orden) > 0) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }

    //Merge
    public static void merge(Student[] arr, int l, int m, int r) {
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
            if (comparison(L[i], R[j], orden) <= 0) {
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

    public static void mergeSort(Student arr[], int l, int r) {
        if (l < r){
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            
            merge(arr, l, m, r);
        }
    }
    

    public static int iterativeBinarySearch(Student arr[], String x) {
      int l = 0, r = arr.length - 1;
      while (l <= r) {
          int m = l + (r - l) / 2;
          if (comparisonSearch(arr[m], x) == 0)
              return m;
          if (comparisonSearch(arr[m], x) < 0)
              l = m + 1;
          else
              r = m - 1;
      }
      return -1;
  }

    // Busqueda binaria recursiva
    public static int binarySearchRecursive(Student arr[], int l, int r, String x){
        if (r >= l) {
            int mid = l + (r - l) / 2;

            if (comparisonSearch(arr[mid], x) == 0)
                return mid;

            if (comparisonSearch(arr[mid], x) > 0)
                return binarySearchRecursive(arr, l, mid - 1, x);

            return binarySearchRecursive(arr, mid + 1, r, x);
        }

        return -1;
    }
    public static int comparisonSearch(Student st, String data){
        int result = 0;
        switch (orden){
            case 0:
                if(st.getCUI() > Integer.parseInt(data)){
                    result = 1;
                } else if (st.getCUI() < Integer.parseInt(data)){
                    result = -1;
                }
                break;
            case 1:
                result = st.getEmail().compareTo(data);
                break;
            case 2:
                result = st.getName().compareTo(data);
                break;
            case 3:
                result = st.getLastNameF().compareTo(data);
                break;
            case 4:
                result = st.getLastNameM().compareTo(data);
                break;
            case 5:
                String cadena = data.substring(0, 4) + data.substring(5, 7) + data.substring(8);
                if(st.getDateBirth() > Integer.parseInt(cadena)){
                    result = 1;
                } else if (st.getDateBirth() < Integer.parseInt(cadena)){
                    result = -1;
                }
                break;
            case 6:
                result = (st.getGender()?"a":"z").compareTo((data.equals("1"))?"a":"z");
                break;
            case 7:
                result = (st.getStatus()?"a":"z").compareTo((data.equals("1"))?"a":"z");
                break; 
        }
        return result;
    } 

    /*
    private static void recursiveInsertionSort(Student[] listado, int n, int orden) {
        Student[] arr = new Student[listado.length];
        System.arraycopy(listado, 0, arr, 0, listado.length);
        if (n <= 1)
            return;
            
        recursiveInsertionSort(arr, n - 1, orden);
    
        Student key = arr[n - 1];
        int j = n - 2;
        while (j >= 0 && comparacion(arr[j], key, orden) > 0) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
     */
    
    
     public static int comparison(Student st1, Student st2, int orden){
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
                if(st1.getDateBirth() > st2.getDateBirth()) result = 1;
                break;
            case 6:
                result = (st1.getGender()?"a":"z").compareTo(st2.getGender()?"a":"z");
                break;
            case 7:
                result = (st1.getStatus()?"a":"z").compareTo(st2.getStatus()?"a":"z"); //cambiar
                break; 
        }
        return result;
    }
    
    public static void graphic(double[][] times) {
        XYSeries series1 = new XYSeries("Bubble");
        XYSeries series2 = new XYSeries("Selection");
        XYSeries series3 = new XYSeries("Insertion");
        XYSeries series4 = new XYSeries("Merge");

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
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public static void interfaz1(){
        
        JFrame ventana = new JFrame("Selección");
        ventana.setSize(600, 250);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelPrincipal = new JPanel(new BorderLayout());
        JPanel panelSuperior = new JPanel(new GridBagLayout());
        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel etiquetaDate = new JLabel("Seleccione una opción:");
        JComboBox<String> comboBoxDate = new JComboBox<>(date);
        JLabel etiquetaAlgorithm = new JLabel("Seleccione algoritmos:");

        JCheckBox[] checkBoxes = new JCheckBox[algorithm.length];
        for (int i = 0; i < algorithm.length; i++) {
            checkBoxes[i] = new JCheckBox(algorithm[i]);
            checkBoxes[i].setSelected(false);
            checkBoxes[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JCheckBox checkBox = (JCheckBox) e.getSource();
                    int index = Integer.parseInt(checkBox.getActionCommand());
                    algorithms[index] = checkBox.isSelected();
                }
            });
            checkBoxes[i].setActionCommand(Integer.toString(i));
        }

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panelSuperior.add(etiquetaDate, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panelSuperior.add(comboBoxDate, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelSuperior.add(etiquetaAlgorithm, gbc);

        JPanel panelCheckBoxes = new JPanel(new GridLayout(0, 2)); 
        for (int i = 0; i < algorithm.length; i++) {
            panelCheckBoxes.add(checkBoxes[i]);
        }
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panelSuperior.add(panelCheckBoxes, gbc);

        JButton boton = new JButton("Aceptar");
        boton.setPreferredSize(new Dimension(80, 30));

        boton.addActionListener((ActionEvent x) -> {
            int opcionSeleccionadaDate = comboBoxDate.getSelectedIndex();

            for (boolean b : algorithms) {
                System.out.println(b);
            }

            if (opcionSeleccionadaDate != -1) {
                orden = opcionSeleccionadaDate;
                System.out.println("orden: " + orden);
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una opción.", "Información", JOptionPane.INFORMATION_MESSAGE);
            }

            ventana.dispose();
        });

        panelBoton.add(boton);
        panelPrincipal.add(panelSuperior, BorderLayout.CENTER);
        panelPrincipal.add(panelBoton, BorderLayout.SOUTH);

        ventana.add(panelPrincipal);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true); 
    } 
    

    public static void Interfaz2(){
        
    }
}