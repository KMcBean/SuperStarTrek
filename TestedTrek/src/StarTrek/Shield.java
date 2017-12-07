package StarTrek;

public class Shield {

    private boolean isUp = false;

    public void raise() {
        isUp = true;
    }

    public void lower() {
        isUp = false;
    }

    public boolean isUp() {
        return isUp;
    }

}
