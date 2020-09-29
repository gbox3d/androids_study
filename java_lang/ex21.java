import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ex21 {
    final static String HOST_URL = "http://ubiqos001.iptime.org:10062/new";

    public static void main(String[] args) {
        // String token = "YOUR_ACCESS_TOKEN";// 네아로 접근 토큰 값";
        // String header = "Bearer " + token; // Bearer 다음에 공백 추가
        try {
            // String apiURL = "https://";
            URL url = new URL(HOST_URL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            // con.setRequestProperty("Authorization", header);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println(response.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
