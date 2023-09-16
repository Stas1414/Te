public class Chocolate extends Sweets{
    public Chocolate(String name, double weight) {
        super(name, weight);
    }
    @Override
    public String toString(){
        return "Шоколадные конфеты "+getName()+"("+getWeight()+" г.)";
    }
}
