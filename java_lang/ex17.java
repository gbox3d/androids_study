import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ex17 {
    public static void main(String[] args) {
        try {
            BufferedReader fr = new BufferedReader(new FileReader("./ex17.java"));

            String line = "";

            while( (line=fr.readLine()) != null ) 
            {
                System.out.println(line);
            }

            fr.close();


            
        } catch (IOException e) {
            //TODO: handle exception
            e.printStackTrace();

        }

    }
}
