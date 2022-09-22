package edo.mex.gob.entity;

import java.time.LocalDateTime;
import java.util.Date;

public class UserEntity {
    String firstName = "";
    String secondFirstName = "";
    String lastName = "";
    String secondLastName = "";
    Date bornDate = null;
    String emailAddress = "";
    String street = "";
    String interiorNumber = "";
    String exteriorNumber = "";
    String suburb = "";
    String zipCode = "";
    String municipality = "";
    String state = "";
    String country = "";
    String phone = "";
    LocalDateTime createdAt = LocalDateTime.now();
    LocalDateTime updatedAt = null;
    Boolean deleted = false;
}
