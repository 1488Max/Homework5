package Pet;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PetFinder {
    public static void findPetByStatus(String status) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        String uri = "https://petstore.swagger.io/v2/pet/findByStatus?status=";



        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri+status))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    public static void findPetById(long id) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        String uri = "https://petstore.swagger.io/v2/pet/";



        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri+id))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
