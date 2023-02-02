import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Backend {
    public static void main(String[] args) {

        try {

            URL url = new URL("https://www.7timer.info/bin/astro.php?lon=113.2&lat=23.1&ac=0&unit=metric&output=json&tzshift=0");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();
            int respCode = con.getResponseCode();
            if (respCode != 200) {
                throw new RuntimeException("API Response was not OK: " + respCode);
            }
            StringBuilder sb = new StringBuilder();
            Scanner scan = new Scanner(url.openStream());
            while (scan.hasNext()) {
                sb.append(scan.nextLine());
            }
            scan.close();
            System.out.println("UnParsed: " + sb);
            JSONParser JSONparser = new JSONParser();
            JSONObject data = (JSONObject) JSONparser.parse(sb.toString());
            System.out.println("Data Object: " + data);
        } catch (Exception e) {
            System.out.println("Broke when trying to access API");
            e.printStackTrace();
        }
    }
}
