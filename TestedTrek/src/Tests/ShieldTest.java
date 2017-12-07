package Tests;

import StarTrek.Shield;
import org.junit.Assert;
import org.junit.Test;

public class ShieldTest {

    @Test
    public void RaiseShield() {
        Shield shield = new Shield();
        Assert.assertFalse(shield.isUp());
        shield.raise();
        Assert.assertTrue(shield.isUp());
    }

}




