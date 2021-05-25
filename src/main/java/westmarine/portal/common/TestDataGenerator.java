package westmarine.portal.common;

import java.util.Date;

public class TestDataGenerator {

    public static User generateNewTestUser() {
        return new User(
                String.format("Acme%s Company", TestDataGenerator.getUniqueId()),
                "John",
                "Smith",
                "4085551111",
                "jsmith@acme.com",
                "90006.81",
                "CjousterKab1"
        );
    }

    public static long getUniqueId() {
        return new Date().getTime();
    }

}
