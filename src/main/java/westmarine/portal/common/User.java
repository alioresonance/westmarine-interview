package westmarine.portal.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class User {
    String company;
    String firstName;
    String lastName;
    String phone;
    String email;
    String userID;
    String password;
}
