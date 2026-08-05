import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;

public class PasswordValidationPositiveTest extends HelperClass {

    @Test(groups = {"smoke"})
    public void testValidPasswordSmoke() {

        String password = players.get(0).getPassword();
        ArrayList<String> errors = validations.validate(password);

        Assert.assertEquals(errors.size(), 0, "Positive test failed.");
    }
}
