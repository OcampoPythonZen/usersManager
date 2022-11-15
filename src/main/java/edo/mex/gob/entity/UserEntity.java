package edo.mex.gob.entity;

import java.time.LocalDateTime;
import java.util.Date;

public class UserEntity {

    String firstName = "";
    String secondFirstName = "";
    String lastName = "";
    String secondLastName = "";
    Date bornDate = null;
    String gender = "NO_GENDER";
    String emailAddress = "";
    String phone = "";

    String street = "";
    String interiorNumber = "";
    String exteriorNumber = "";
    String suburb = "";
    String zipCode = "";
    String municipality = "";
    String state = "";
    String country = "";

    LocalDateTime createdAt = LocalDateTime.now();
    LocalDateTime updatedAt = null;
    Boolean deleted = false;
}
