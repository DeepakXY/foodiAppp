package niit.jdp.Auth2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String useremail;
    private String password;
    private String firstname;
    private String lastname;
    private String gender;
    private long userMobileNumber;
    private String date;

}