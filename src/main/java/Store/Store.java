package Store;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;

public class Store {
    public static void createOrder(long petId, long quantity, long status) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        String uri = "https://petstore.swagger.io/v2/store/order";
        LocalDate localDate = LocalDate.now();
        String requestBody = "{\n" +
                "  \"id\": 0,\n" +
                "  \"petId\": " + petId + ",\n" +
                "  \"quantity\": " + quantity + ",\n" +
                "  \"shipDate\": " + localDate.toString() + ",\n" +
                "  \"status\": " + status + ",\n" +
                "  \"complete\": true\n" +
                "}";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();


        System.out.println(httpClient.send(request, HttpResponse.BodyHandlers.ofString()));

    }

    public static void getOrderByID(long id) throws IOException, InterruptedException {
        String uri = "https://petstore.swagger.io/v2/store/order/" + id;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        System.out.println(client.send(request, HttpResponse.BodyHandlers.ofString()));
    }
    public static void petDeleteById(long id) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        String uri = "https://petstore.swagger.io/v2/store/order/" + id;



        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type", "application/json")
                .DELETE()
                .build();

        final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
    public static void getInventory() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        String uri = "https://petstore.swagger.io/v2/store/inventory";


        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

    }


}
