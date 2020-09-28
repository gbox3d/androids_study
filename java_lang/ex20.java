import java.io.BufferedReader;
import java.io.IOException;
import java.net.*;

public class ex20 {
    final static int SERVERPORT = 10060;
    final static String SERVERIP = "ubiqos001.iptime.org";

    public static void main(String[] args) {

        try {
            InetAddress ia = InetAddress.getByName(SERVERIP);
            DatagramSocket ds = new DatagramSocket(SERVERPORT); //소켓 만들기
            byte buffer[] = { 0x02, 0x05, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00 };

            DatagramPacket dp = new DatagramPacket(buffer, buffer.length, ia, SERVERPORT);
            ds.send(dp); // 데이터 전송

            buffer = new byte[512];
            dp = new DatagramPacket(buffer, buffer.length);
            ds.receive(dp); // 데이터 받기 , 블러킹 함수

            for (int i = 0; i <dp.getLength(); i++) {
                System.out.format("%d : %x\n", i, buffer[i]);
            }

            ds.close();

        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }
}
