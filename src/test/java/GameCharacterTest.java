import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameCharacterTest {


    @Test
    public void testNameGetter() {
        Player p = new Player(10, 100, "foo");

        assertEquals("foo", p.getName(), "Dethär namnet borde vara 'foo'");
    }


    @Test
    public void testTakeDamage() {
        Player p = new Player(10, 100, "foo");

        p.takeDamage(30);

        assertEquals(70, p.getHp(), "Efter 30 damage tagen borde hitpoints vara 70!");
    }
}
