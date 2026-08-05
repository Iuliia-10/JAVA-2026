import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.ArrayList;

public class PasswordValidationNegativeTest extends HelperClass {

    @Test(groups = {"smoke"})
    public void testInvalidPasswordSmoke() {
        String invalidPassword = "admin";
        ArrayList<String> errors = validations.validate(invalidPassword);

        Assert.assertTrue(errors.contains("Password length must be between 8 and 32 characters."));
        Assert.assertTrue(errors.contains("Password must contain at least one uppercase letter."));
        Assert.assertTrue(errors.contains("Password must contain at least one digit."));
        Assert.assertTrue(errors.contains("Password must contain at least one special character."));
        Assert.assertTrue(errors.contains("Password contains forbidden sequence."));
    }

    @DataProvider(name = "invalidPasswordProvider")
    public Object[][] getInvalidPasswordsData() {
        return new Object[][] {
                // { невалидный_пароль, ожидаемый_текст_ошибки }
                { "Anna1!", "Password length must be between 8 and 32 characters." },
                { "annabel1!", "Password must contain at least one uppercase letter." },
                { "ANNABEL1!", "Password must contain at least one lowercase letter." },
                { "Annabel!", "Password must contain at least one digit." },
                { "Annabel1", "Password must contain at least one special character." },
                { "Password1!", "Password contains forbidden sequence." }
        };
    }

    @Test(groups = {"regression"}, dataProvider = "invalidPasswordProvider")
    public void testInvalidPasswordVariations(String password, String expectedError) {
        ArrayList<String> errors = validations.validate(password);

        Assert.assertTrue(
                errors.contains(expectedError),
                "Expected error '" + expectedError + "' not found: " + errors
        );
    }
}
