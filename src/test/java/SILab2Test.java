import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {
    SILab2 siLab2 = new SILab2();
    private static Collection<Object[]> everyStatementCriteriaParams() {
        return Arrays.asList(new Object[][] {
                {null, false },
                {new User("Username", "Password", null), false },
                {new User(null, "Password", null), false },
                {new User("Username1", "Password1", "email1@mail.com"), true  },
                {new User("Username2", "Password2", "email1@mail"),     false },
                {new User("Username3", "Password3", "email1.mail.com"), false },
                {new User("Username4", "Password4", "email1@mail.com"), false }
        });
    }

    @ParameterizedTest
    @MethodSource("everyStatementCriteriaParams")
    void functionTest (User user, Boolean result) {
        List<String> allUsers = new ArrayList<>();
        allUsers.add("Username4");
        assertEquals(result, siLab2.function(user, allUsers));
    }
}
