package User;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class UserQuery {
    public static void createUser(long id, String username, String firstName, String lastName, String email, String password, String phone, int userStatus) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        String uri = "https://petstore.swagger.io/v2/user/createWithArray";

        String requestBody = "\"id\":" + id + " ,\n" +
                "    \"username\":" + username + ",\n" +
                "    \"firstName\": " + firstName + ",\n" +
                "    \"lastName\": " + lastName + ",\n" +
                "    \"email\": " + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "    \"phone\": " + phone + ",\n" +
                "    \"userStatus\": " + userStatus + "";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();


        System.out.println(client.send(request, HttpResponse.BodyHandlers.ofString()));
    }


    public static void getUserByName(String name) throws IOException, InterruptedException {
        String uri = "https://petstore.swagger.io/v2/user/" + name;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type", "application/json")
                .GET()
                .build();


        System.out.println(client.send(request, HttpResponse.BodyHandlers.ofString()));


    }

    public static void updateUserByName(String updatedUserName, long id, String username, String firstName, String lastName, String email, String password, String phone, int userStatus) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        String uri = "'https://petstore.swagger.io/v2/user/" + updatedUserName;

        String requestBody = "\"id\":" + id + " ,\n" +
                "    \"username\":" + username + ",\n" +
                "    \"firstName\": " + firstName + ",\n" +
                "    \"lastName\": " + lastName + ",\n" +
                "    \"email\": " + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "    \"phone\": " + phone + ",\n" +
                "    \"userStatus\": " + userStatus + "";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();


        System.out.println(client.send(request, HttpResponse.BodyHandlers.ofString()));
    }

    public static void deleteUserByName(String userName) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        String uri = "'https://petstore.swagger.io/v2/user/" + userName;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type", "application/json")
                .DELETE()
                .build();


        System.out.println(client.send(request, HttpResponse.BodyHandlers.ofString()));
    }

    public static void userLogin(String username, String password) throws IOException, InterruptedException {
        String uri = "https://petstore.swagger.io/v2/user/login?username="+username+"&password="+password;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type", "application/json")
                .GET()
                .build();


        System.out.println(client.send(request, HttpResponse.BodyHandlers.ofString()));
    }

    public static void userLogout() throws IOException, InterruptedException {
        String uri = "https://petstore.swagger.io/v2/user/logout";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type", "application/json")
                .GET()
                .build();


        System.out.println(client.send(request, HttpResponse.BodyHandlers.ofString()));
    }
}
