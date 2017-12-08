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
		if (energy > 0)
			isUp = true;
		else
			isUp = false;
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

	public int AddEnergy(int value) {
		int excess = 0;
		energy += value;
		if (energy > MAX_SHIELD)
		{
			excess = energy - MAX_SHIELD;
			energy = MAX_SHIELD;
		}
		return excess;
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
