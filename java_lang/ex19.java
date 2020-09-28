import java.io.*;

import java.net.Socket;

public class ex19 {
    final static int SERVERPORT = 10061;
    final static String SERVERIP = "ubiqos001.iptime.org";

    public static void main(String[] args) {

        try {

            Socket _socket = new Socket(SERVERIP, SERVERPORT);
            InputStream _in = _socket.getInputStream();

            OutputStream _out = _socket.getOutputStream(); //스트림 얻기 

            byte buffer[] = { 0x02, 0x05, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00 };
            _out.write(buffer);
            _out.flush();
            System.out.println("데이터 전송 완료!");

            byte _buff[] = new byte[512];

            int _count;// = _in.read(_buff, 0, _buff.length);
            while( (_count = _in.read(_buff, 0, _buff.length)) != -1)
            {
                System.out.println("num of data receved : " + _count);
                for (int i = 0; i < _count; i++) {
                    System.out.format("%d : %x \n", i, (byte) _buff[i]);
                }
            }

            _in.close();
            _out.close();
            _socket.close();

            System.out.println("connection close");

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }
}
