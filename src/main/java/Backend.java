import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Backend {
    public static void main(String[] args) {

        try {

            URL url = new URL("https://pokeapi.co/api/v2/pokemon/ditto");
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
