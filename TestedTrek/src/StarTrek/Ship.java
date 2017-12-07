package StarTrek;

public class Ship {
    private int shipEnergy = 10000;
    private Shield shield = new Shield();

    public int getShipEnergy() {
        return shipEnergy;
    }

    public void reduceShipEnergy(int energy) {
        shipEnergy -= energy;
    }



}
