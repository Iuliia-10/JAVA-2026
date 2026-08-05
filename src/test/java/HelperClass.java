import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.ArrayList;
import hw_1.Validations;

public class HelperClass {
    protected ArrayList<Player> players;
    protected Validations validations;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        players = new ArrayList<>();
        validations = new Validations();

        players.add(new Player("player1", "Hello56789!"));
        players.add(new Player("player2", "Secure#2026"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (players != null) {
            players.clear();
        }
    }
}
