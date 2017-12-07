package StarTrek;

public class Weapons {
    private int numberOfTorpedoes = 8;
    final private static int PHASER_MAX_DISTANCE = 4000;
    final private static int TORPEDO_BASE_DAMAGE = 800;
    final private static int TORPEDO_ADJUSTED_DAMAGE = 50;
    final private static int HIT_CHECK = 7;
    final private static int DISTANCE_FACTOR = 500;
    final private static int HIT_RANDOMIZER = 4;
    private Game game;

    public void fireWeapon(Game _game, Galaxy wg, Ship ship) {
        game = _game;
        // get the target
        Klingon enemy = (Klingon) wg.variable("target");

        // determine which weapon was fired
        if (wg.parameter("command").equals("phaser")) {
            // get amount of energy to be fired
            int energyUsed = Integer.parseInt(wg.parameter("amount"));
            // see if ship has enough energy
            if (hasEnoughEnergyToFire(wg, ship, energyUsed)) {
                // see if the enemy is within range
                int distance = isInRange(wg, enemy, PHASER_MAX_DISTANCE);
                if (distance > 0) {
                    // calculate the amount of damage
                    int damage = amountOfPhaserDamage(wg, energyUsed, distance);
                    // asses the damage on enemy and see if destroyed
                    enemyShipEnergyRemaining(wg, damage, enemy);
                }
            }
            // update ships energy
            ship.reduceShipEnergy(energyUsed);
        } else if (wg.parameter("command").equals("photon")) {
            // see if there is a torpedoes to fire
            if (hasTorpedoes(wg)) {
                int distance = enemy.distance();
                // determine if the torpedo hit enemy
                if (didTorpedoHit(wg, distance)) {
                    int damage = amountOfTorpedoDamage(wg, distance);
                    // asses the damage on enemy and see if destroyed
                    enemyShipEnergyRemaining(wg, damage, enemy);
                }
                shootTorpedo();
            }
        }
    }

    private boolean hasEnoughEnergyToFire(Galaxy wg, Ship ship, int energyUsed) {
        if (ship.getShipEnergy() > energyUsed) {
            return true;
        } else {
            wg.writeLine("Insufficient energy to fire phasers!");
            return false;
        }
    }

    private int isInRange(Galaxy wg, Klingon enemy, int maxDistance) {
        int distance = enemy.distance();
        if (distance > maxDistance) {
            wg.writeLine("Klingon out of range of phasers at " + distance + " sectors...");
            distance = -1;
        }
        return distance;
    }

    private int amountOfPhaserDamage(Galaxy wg, int energyUsed, int distance) {
        int damage = energyUsed - (((energyUsed /20)* distance /200) + game.rnd(200));
        if (damage < 1)
            damage = 1;
        wg.writeLine("Phasers hit Klingon at " + distance + " sectors with " + damage + " units");
        return damage;
    }

    private int amountOfTorpedoDamage(Galaxy wg, int distance) {
        int damage = TORPEDO_BASE_DAMAGE + game.rnd(TORPEDO_ADJUSTED_DAMAGE);
        wg.writeLine("Photons hit Klingon at " + distance + " sectors with " + damage + " units");
        return damage;
    }

    private void enemyShipEnergyRemaining(Galaxy wg, int damage, Klingon enemy) {
        if (damage < enemy.getEnergy()) {
            enemy.setEnergy(enemy.getEnergy() - damage);
            wg.writeLine("Klingon has " + enemy.getEnergy() + " remaining");
        } else {
            wg.writeLine("Klingon destroyed!");
            enemy.delete();
        }
    }

    private boolean hasTorpedoes(Galaxy wg) {
        int numberOfTorpedoes = getNumberOfTorpedoes();
        if (getNumberOfTorpedoes() <= 0)
            wg.writeLine("No more photon torpedoes!");
        return numberOfTorpedoes > 0;
    }

    private boolean didTorpedoHit(Galaxy wg, int distance) {
        boolean hit = ((game.rnd(HIT_RANDOMIZER) + ((distance / DISTANCE_FACTOR) + 1) <= HIT_CHECK));
        if (!hit)
            wg.writeLine("Torpedo missed Klingon at " + distance + " sectors...");
        return hit;
    }

    private void shootTorpedo() {
        numberOfTorpedoes -= 1;
    }

    private int getNumberOfTorpedoes() {
        return numberOfTorpedoes;
    }

    public void setTorpedoes(int torpedoes) {
        numberOfTorpedoes = torpedoes;
    }

    public int getTorpedoes() {
        return numberOfTorpedoes;
    }

//    // note we made generator public in order to mock it
//    // it's ugly, but it's telling us something about our *design!* ;-)
//    private static Random generator = new Random();
//    private static int rnd(int maximum) {
//        return generator.nextInt(maximum);
//    }

}
