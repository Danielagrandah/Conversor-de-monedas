import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {

    public Divisa consultarMoneda(String tipodeDivisa) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/5b5e0b4b3450713531c7202e/latest/" + tipodeDivisa);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Divisa.class);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo encontrar la moneda: " + tipodeDivisa, e);
        }
    }
}
