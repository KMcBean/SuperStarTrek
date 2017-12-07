package StarTrek;

public class Shield {
	private boolean isDamaged = false;

	int MAX_SHIELD = 10000;
    private boolean isUp = false;
    private int energy = 0;

	public void setDamaged() {
		isDamaged = true;
	}

	public boolean isDamaged() {
		return isDamaged;
	}

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
		if (energy > MAX_SHIELD)
			energy = 10000;
	}

	public void DeductEnergy(int value) {
		if (isUp)
		{
			energy -= value;
			if (energy <= 0)
			{
				energy = 0;
				isUp = false;
			}
		}
	}

}
