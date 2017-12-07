package Tests;

import StarTrek.Game;
import StarTrek.Shield;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

//Test Git 2
public class ShieldTest {
    private Game game;
    private MockGalaxy context;

    @Before
    public void setUp() {
        game = new Game();
        context = new MockGalaxy();
    }

    @Test
    public void RaiseShield() {
        Shield shield = new Shield();

//        Assert.assertTrue(shield.statusUp());


//        shield.raise();





    }




}




