import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static final String RUTA = "src\\Resources\\car_sales.csv"; //ruta archivo texto
    public static String linea;
    public static List<String> listaCarSales;
    public static void main(String[] args) throws IOException {

        //Agregar valores del CSV a un ArrayList
        listaCarSales = new ArrayList<>();
        File f=new File(RUTA);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
        while ((linea = bufferedReader.readLine()) != null) {
            String[] valoresUnicos = linea.split("\\$");
            if (valoresUnicos.length > 1) {
                String ventas = valoresUnicos[1].trim();
                listaCarSales.add(ventas);
            }
        }

        //Meter los valores de una lista a un array simple
        float[] arrayCarSales = new float[listaCarSales.size()];
        for (int i = 0; i <arrayCarSales.length ; i++) {
           arrayCarSales[i] = Float.parseFloat(listaCarSales.get(i));
        }

        //Suma prefija y guardado en CSV
        System.out.println("Suma Prefija: ");
        String nombreCsvCreado = "csvSumaPrefija.csv";
        float paraSumarVentas = 0.0F;
        try (PrintWriter writer = new PrintWriter(nombreCsvCreado)) {
            writer.print("Suma Prefija");
            writer.println();
            //CSV se guarda dentro del mismo proyecto java
            for (int i = 0; i < arrayCarSales.length ; i++) {
                paraSumarVentas += arrayCarSales[i];
                System.out.println(i+1 + ". " +paraSumarVentas); //imprimir suma prefija en la consola
                writer.print(paraSumarVentas);
                if (i < arrayCarSales.length - 1) {
                    writer.println(",");
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }//end main
}