package Tests;

import StarTrek.Shield;
import org.junit.Assert;
import org.junit.Test;

public class ShieldTest {

    @Test
    public void ShieldDownAtStart() {
        Shield shield = new Shield();
        Assert.assertFalse(shield.isUp());
    }

    @Test
    public void RaiseDepletedShield() {
        Shield shield = new Shield();
        shield.raise();
        Assert.assertFalse(shield.isUp());
    }

    @Test
    public void RaiseShield() {
        Shield shield = new Shield();
        shield.AddEnergy (5000);
        shield.raise();
        Assert.assertTrue(shield.isUp());
    }

    @Test
    public void InitialShieldEnergy() {
	   Shield shield = new Shield ();
	   Assert.assertEquals(0, shield.GetEnergy());
    }
    
    @Test
    public void TransferEnergyToShield() {
		   Shield shield = new Shield ();
		   shield.AddEnergy (5000);
	       Assert.assertEquals(5000, shield.GetEnergy());   	
    }
    
    @Test
    public void ShieldEnergyLimit() {
		   Shield shield = new Shield ();
		   shield.AddEnergy (11000);
	       Assert.assertEquals(10000, shield.GetEnergy());	
    }

    @Test
    public void ShieldEnergyExcess() {
		   Shield shield = new Shield ();
		   int excess = shield.AddEnergy (11000);
	       Assert.assertEquals(1000, excess);
    }

}




