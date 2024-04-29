import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class ExchangeRateAPI {


    public double getExchangeRate(String sourceCurrency, String targetCurrency) {
        try {
            URL url = new URL("https://v6.exchangerate-api.com/v6/6719cc6b6126b94aa314abda/latest/"+sourceCurrency);

            // Abrir conexión HTTP
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Leer la respuesta
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Analizar la respuesta JSON
            JSONObject jsonResponse = new JSONObject(response.toString());
            if (jsonResponse.getString("result").equals("success")) {
                JSONObject rates = jsonResponse.getJSONObject("conversion_rates");
                double exchangeRate = rates.getDouble(targetCurrency);
                return exchangeRate;
            } else {
                System.out.println("Error: " + jsonResponse.getString("error"));
            }

            // Cerrar la conexión
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // En caso de error, retornar -1 como indicador de error
        return -1;
    }
}
