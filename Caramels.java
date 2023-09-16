public class Caramels extends Sweets{
    public Caramels(String name, double weight) {
        super(name, weight);
    }
    @Override
    public String toString(){
        return "Карамельки "+getName()+"("+getWeight()+" г.)";
    }
}
