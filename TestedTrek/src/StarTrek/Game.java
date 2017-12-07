package StarTrek;

import Untouchables.WebGadget;

import java.util.Random;

public class Game {

    private Ship ship = new Ship();
    private Weapons weapons = new Weapons();

    public int EnergyRemaining() {
        return ship.getShipEnergy();
    }

    public void fireWeapon(WebGadget wg) {
        weapons.fireWeapon(this, new Galaxy(wg), ship);
    }

	public void fireWeapon(Galaxy wg) {
        weapons.fireWeapon(this, wg, ship);
    }

    // note we made generator public in order to mock it
    // it's ugly, but it's telling us something about our *design!* ;-)
	public static Random generator = new Random();
	public static int rnd(int maximum) {
		return generator.nextInt(maximum);
	}

    public void setTorpedoes(int value) {
        weapons.setTorpedoes(value);
    }
    public int getTorpedoes() {
        return weapons.getTorpedoes();
    }
}
