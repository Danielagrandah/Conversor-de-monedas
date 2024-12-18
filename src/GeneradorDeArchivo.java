import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
public class GeneradorDeArchivo {
    public void guardarJson(String divisa) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escritura = new FileWriter(divisa.codePoints() + ".json");
        escritura.write(gson.toJson(divisa));
        escritura.close();
    }
}