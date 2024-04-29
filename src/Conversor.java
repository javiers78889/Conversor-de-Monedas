import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Scanner;

import org.json.JSONObject;

public class Conversor {
    public static void main(String[] args) {
        int continuar=1;
        while (continuar!=0) {
            ExchangeRateAPI conver = new ExchangeRateAPI();
            DecimalFormat df = new DecimalFormat("#.#####");
            Scanner scanner = new Scanner(System.in);
            System.out.println("****************************************");
            System.out.println("Sea Bienvenid@ al conversor de monedas");
            System.out.println("1) Dólar >>> Peso Argentino");
            System.out.println("2) Peso Argentino >>> Dólar ");
            System.out.println("3) Dólar >>> Real Brasileño ");
            System.out.println("4) Real Brasileño >>> Dólar");
            System.out.println("5) Dólar >>> Peso Colombiano");
            System.out.println("6) Peso Colombiano >>> Dólar ");
            System.out.println("7) Salir");
            System.out.println("****************************************");
            int captura = scanner.nextInt();
            String resultado = "";
            String orn = "";
            switch (captura) {
                case 1:
                    orn = "USD";
                    resultado = "ARS";
                    break;

                case 2:
                    orn = "ARS";
                    resultado = "USD";
                    break;
                case 3:
                    orn = "USD";
                    resultado = "BRL";
                    break;
                case 4:
                    orn = "BRL";
                    resultado = "USD";
                    break;
                case 5:
                    orn = "USD";
                    resultado = "COP";
                    break;
                case 6:
                    orn = "COP";
                    resultado = "USD";
                    break;

            }
            double rate = conver.getExchangeRate(orn, resultado);
            double Conversion;
            System.out.println("Ingrese el monto a convertir");
            double monto = scanner.nextDouble();
            Conversion = (rate * monto);
            System.out.println(String.format("El tipo de cambio es: " + df.format(Conversion)));
            System.out.println("****************************************");
            System.out.println("****************************************");
            System.out.println("Convertir nuevamente? 1=si , 0=no");
            continuar=scanner.nextInt();
        }

        System.out.println("Que tenga un excelente dia!!!");

    }
}
