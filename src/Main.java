import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    String Direc = System.getProperty("user.dir")+"\\data\\misDatos.csv";


    //Create print all data function field by field, with format
    private void exportarDatos(){
        String datos[], Expre;
        int regi = 0;

        try {
            //Create reader object from file
            BufferedReader br = new BufferedReader(new FileReader(Direc));

            //Print each record from buffer
            while((Expre = br.readLine())!=null) {
                datos = Expre.split(";");

                System.out.printf("%d │ %-15s │ %-15s │ %-15s │ %-4s │ %-8s │ %-10s\n",Integer.parseInt(datos[0]),datos[1],datos[2],datos[3],datos[4],datos[5],datos[6]);
                regi++;
            }

            //Close buffer
            br.close();
        }catch (IOException ex){
            //Print stack errors
            ex.printStackTrace();
        }
    }//End print_formatFields function


}