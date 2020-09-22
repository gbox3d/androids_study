import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class ex18 {
    public static void main(String[] args) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("bufferdwriter.txt"));
            bw.write("Hello Writer");
            bw.flush();
            bw.close();
            
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
