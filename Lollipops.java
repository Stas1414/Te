public class Lollipops extends Sweets {
    public Lollipops(String name,double weight){
        super(name,weight);
    }
    @Override
    public String toString(){
        return "Леденцы "+getName()+"("+getWeight()+" г.)";
    }
}
