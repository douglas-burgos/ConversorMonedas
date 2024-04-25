import java.util.Map;
import java.util.Scanner;

public class MaIn {
    public static void main(String[] args) {

        var menuCurrency = new ExchangeRateApi();
        Conversion menu = menuCurrency.divisa("AED");
        System.out.println("""
                Conversor de divisas.
                Las divisas disponibles son:""");
        for (String div : menu.conversion_rates().keySet()) {
            System.out.println(div);

        }

        Scanner scanner = new Scanner(System.in);
        String answer;

        do {

            try {
                var lectura = new Scanner(System.in);
                ExchangeRateApi exchangeRateApi = new ExchangeRateApi();
                System.out.println("Escribe la moneda a convertir:");
                String option = lectura.nextLine().toUpperCase().replace(" ", "");
                Conversion conversion = exchangeRateApi.divisa(option);

                Map<String, Double> currrency = conversion.conversion_rates();
                if (currrency != null) {
                    System.out.println("¿A que divisa deseas convertir");

                    String toCurrency = lectura.nextLine().toUpperCase().replace(" ", "");
                    if (currrency.containsKey(toCurrency)) {
                        System.out.println("Ingrese la cantidad");
                        Operation operation = new Operation();
                        Double coin = (double) lectura.nextInt();
                        operation.setCoin(coin);
                        operation.setCurrency(currrency.get(toCurrency));

                        Double result = operation.oper();
                        System.out.println(operation.getCoin() + " " +
                                option +
                                "equivale a: " +
                                result + " " +
                                toCurrency + " ");
                    } else {
                        System.out.println("Divisa no encontrada");
                    }
                } else{
                    System.out.println("Moneda no encontrada");
                }
            } catch (Exception e) {
                System.out.println("Error!");
            }
            System.out.println("Otra consulta?");
            answer = scanner.nextLine().toLowerCase().replace(" ", "");
        } while (!answer.equals("no"));
        System.out.println("Aplicacion Finalizada");
    }
}
