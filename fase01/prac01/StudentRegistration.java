import java.io.*;

public class StudentRegistration {
    public static void main(String[] args) throws IOException{
        int numLine = 0;
        String file = "DatosEstudiantes.csv";
        String line;
        BufferedReader Lines = new BufferedReader(new FileReader(file));
        while (Lines.readLine() != null) {
            numLine++;
        }
        Student[] listado = new Student[numLine];
        BufferedReader data = new BufferedReader(new FileReader(file));
        int j = 0;
        while ((line = data.readLine()) != null){
            String[] dataS = line.split(";");
            listado[j] = new Student(dataS);
            j++;
        }
        for (int i = 0; i < listado.length; i++){
            System.out.println(listado[i]);
        }
    }
}