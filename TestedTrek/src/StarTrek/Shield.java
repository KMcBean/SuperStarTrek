package StarTrek;

public class Shield {

    private boolean isUp = false;
    private int energy = 0;

    public void raise() {
        isUp = true;
    }

    public void lower() {
        isUp = false;
    }

    public boolean isUp() {
        return isUp;
    }

	public int GetEnergy() {
		return energy;
	}

	public void AddEnergy(int value) {
		energy += value;
		
	}

}
