import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameCharacterTest {


    @Test
    public void testNameGetter() {
        GameCharacter g = new GameCharacter(10, 100, "foo");

        assertEquals("foo", g.getName(), "Dethär namnet borde vara 'foo'");
    }


    @Test
    public void testTakeDamage() {
        GameCharacter g = new GameCharacter(10, 100, "foo");

        g.takeDamage(30);

        assertEquals(70, g.getHp(), "Efter 30 damage tagen borde hitpoints vara 70!");
    }
}
