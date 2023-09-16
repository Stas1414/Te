import java.util.ArrayList;

public class Present {
    private ArrayList<Sweets> sweets=new ArrayList<>();

    public ArrayList<Sweets> getSweets() {
        return sweets;
    }

    public void setSweets(Sweets sweets) {
        this.sweets.add(sweets);
    }
}
