package Pet;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.xerces.impl.dv.util.Base64;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;


public class PetImageUploader {

    public static void uploadImage(String filename, int petID) throws IOException {

        String basicUrl = "https://petstore.swagger.io/v2";

        ByteArrayOutputStream baos = new ByteArrayOutputStream(1000);
        BufferedImage image = ImageIO.read(new File("./", filename));

        ImageIO.write(image, "jpg", baos);
        baos.flush();

        String base64String = Base64.encode(baos.toByteArray());
        baos.close();

        byte[] resByteArray = Base64.decode(base64String);


        MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(basicUrl + "/pet/" + petID + "/uploadImage");

        multipartEntityBuilder.addBinaryBody("file", resByteArray, ContentType.DEFAULT_BINARY, "filename");

        HttpEntity multipart = multipartEntityBuilder.build();
        httpPost.setEntity(multipart);

        try {
            System.out.println(client.execute(httpPost));
        } catch (IOException e) {
            e.printStackTrace();
        }
        client.close();
    }


}
