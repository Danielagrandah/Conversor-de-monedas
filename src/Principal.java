import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();

        try {
            System.out.println("Escribe el nombre de la divisa que quieres consultar. Ejemplo; COP, EUR, MXN, COP: ");
            String divisaBase = lectura.nextLine().toUpperCase();
            Divisa resultado = consulta.consultarMoneda(divisaBase);

            System.out.println("Escribe el nombre de la divisa a la que deseas convertir. Ejemplo; USD: ");
            String divisaObjetivo = lectura.nextLine().toUpperCase();

            Double tasaCambio = resultado.conversion_rates().get(divisaObjetivo);


            System.out.println("Divisa: " + resultado.base_code());
            System.out.println("Ultima Actualización: " + resultado.time_last_update_utc());
            System.out.println("Conversion Rates: " + resultado.conversion_rates());

            if (tasaCambio != null) {
                // Solicitar el monto a convertir
                System.out.println("Escribe el monto que deseas convertir: ");
                double monto = Double.parseDouble(lectura.nextLine());

                // Realizar la conversión
                double montoConvertido = monto * tasaCambio;
                System.out.printf("El monto convertido de %s a %s es: %.2f%n", divisaBase, divisaObjetivo, montoConvertido);
            } else {
                System.out.println("No se encontró la tasa de cambio para " + divisaObjetivo);
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Entrada inválida - " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("\n****************");
            System.out.println("Finalizando la aplicación");

        }

    }
}
