import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        // System.out.println(body);

        JsonParse parse = new JsonParse();
        List<Map<String, String>> listaDeFilmes = parse.parse(body);
        // System.out.println(listaDeFilmes.get(0));

        var geradora = new GeradoraDeFigurinhas();
        for (int i = 0; i < 10; i++) {

            Map<String, String> filme = listaDeFilmes.get(i);

            String urlImagem = filme.get("image");
            String titulo = filme.get("title");

            InputStream inputStream = new URL(urlImagem).openStream();
            String nomeArquivo = "../saida/" + titulo + ".png";

            geradora.criar(inputStream, nomeArquivo);

            System.out.println(titulo);
            System.out.println(urlImagem);
            System.out.println(filme.get("imDbRating"));
            System.out.println();
        }
    }
}
