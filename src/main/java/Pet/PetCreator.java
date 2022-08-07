package Pet;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PetCreator {

    public static void createNewPet(long id, String name, String status) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        String uri = "https://petstore.swagger.io/v2/pet";

        String requestBody = "{\n" +
                "  \"id\": " + id + ",\n" +
                "  \"category\": {\n" +
                "    \"id\": " + id + ",\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"doggie\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": " + id + ",\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"" + status + "\"\n" +
                "}";


        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();


        System.out.println(client.send(request, HttpResponse.BodyHandlers.ofString()));
    }

    public static void updatePet(long id, String name, String status) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        String uri = "https://petstore.swagger.io/v2/pet";

        String requestBody = "{\n" +
                "  \"id\": " + id + ",\n" +
                "  \"category\": {\n" +
                "    \"id\": " + id + ",\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"doggie\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": " + id + ",\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"" + status + "\"\n" +
                "}";
        


        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();


        System.out.println(client.send(request, HttpResponse.BodyHandlers.ofString()));
    }
    public static void petDeleteById(long id) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        String uri = "https://petstore.swagger.io/v2/pet/";



        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri+id))
                .header("Content-Type", "application/json")
                .DELETE()
                .build();

        final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }



}
