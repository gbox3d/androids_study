//표준 입출력 
import java.io.*;

public class ex16 {
    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String _line = br.readLine();

            BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

            wr.write(_line , 0, _line.length());
            wr.write('\n');
            wr.flush();

            br.close();
            wr.close();

            // System.out.println(_line);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();

        }

    }
}
