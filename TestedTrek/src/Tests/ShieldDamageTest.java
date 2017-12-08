package Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import StarTrek.Shield;

public class ShieldDamageTest {
	
	private Shield shield;
	
	@Before
	public void initialize() {
		shield = new Shield();
    	shield.AddEnergy(8000);    	
    	shield.raise();
	}
	
    @Test
    public void DepleteNotRaisedShield() {   	
    	shield.lower();
    	shield.DeductEnergy(3000);
	    Assert.assertEquals(8000, shield.GetEnergy());

    }

    @Test
    public void ReduceRaisedShield() {
    	shield.DeductEnergy(3000);
	    Assert.assertEquals(5000, shield.GetEnergy());
    }
    
    @Test
    public void DepleteRaisedShield() {
    	shield.DeductEnergy(8000);
	    Assert.assertFalse(shield.isUp());
    }  	

    @Test
    public void DepleteMoreRaisedShield() {
    	shield.DeductEnergy(8010);
	    Assert.assertEquals(0, shield.GetEnergy());
    }
    
    @Test
    public void DepleteMoreRaisedShieldState() {
    	shield.DeductEnergy(8010);
	    Assert.assertFalse(shield.isUp());
    }
    

}
