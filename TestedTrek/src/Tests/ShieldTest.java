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

    @Test
    public void TransferEnergyToShield() {
		   Shield shield = new Shield ();
		   int currentEnergy = shield.GetEnergy();
		   shield.AddEnergy (5000);
	       Assert.assertEquals(currentEnergy + 5000, shield.GetEnergy());
	       currentEnergy = shield.GetEnergy();
		   shield.AddEnergy (1000);
	       Assert.assertEquals(currentEnergy + 1000, shield.GetEnergy());
    	
    }
    
    @Test
    public void ShieldEnergyLimit() {
		   Shield shield = new Shield ();
		   int currentEnergy = shield.GetEnergy();
		   shield.AddEnergy (5000);
	       Assert.assertEquals(currentEnergy + 5000, shield.GetEnergy());
		   shield.AddEnergy (6000);
	       Assert.assertEquals(10000, shield.GetEnergy());	
    }


}




