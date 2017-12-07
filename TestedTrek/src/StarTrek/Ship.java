package StarTrek;

public class Ship {
    private int shipEnergy = 10000;
    private int numberOfTorpedoes = 8;

    public int getShipEnergy() {
        return shipEnergy;
    }

    public void shootTorpedo() {
        numberOfTorpedoes -= 1;
    }

    public int getNumberOfTorpedoes() {
        return numberOfTorpedoes;
    }

    public void reduceShipEnergy(int energy) {
        shipEnergy -= energy;
    }

    public void setTorpedoes(int torpedoes) {
        numberOfTorpedoes = torpedoes;
    }

    public int getTorpedoes() {
        return numberOfTorpedoes;
    }


}
