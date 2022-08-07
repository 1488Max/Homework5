import Pet.PetCreator;
import Pet.PetFinder;
import Pet.PetImageUploader;
import Store.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        PetImageUploader.uploadImage("Dog.jpg",3);
        PetCreator.createNewPet(5,"John","available");
        PetCreator.updatePet(5,"John","sold");
        PetFinder.findPetByStatus("available");
        PetCreator.petDeleteById(5);
        PetFinder.findPetById(5);
        Store.getInventory();

    }
}