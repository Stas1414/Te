import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Sweets> sweet=new ArrayList<>();
        ArrayList<Present> presents=new ArrayList<>();
        sweet.add(new Chocolate("Аленка",100));
        sweet.add(new Lollipops("zxc",57.8));
        sweet.add(new Caramels("lol",154));
        int chose;
        while(true){
            System.out.println("1.Добавить конфеты");
            System.out.println("2.Создать подарок");
            System.out.println("3.Определить суммарный вес подарка");
            System.out.println("4.Выйти");
            chose=sc.nextInt();
            if (chose==1){
                Add_Sweets(sweet);
            }
            if(chose==2){
                Create_Present(sweet,presents);
            }
            if(chose==3){
                Find_weight(presents);
            }
            if(chose==4) {
                break;
            }
        }
    }
    public static void Add_Sweets(ArrayList<Sweets> sweets){
        System.out.println("Выберите какие конфеты добавить:");
        System.out.println("1.Шоколадные   2.Леденцы   3.Карамельки");
        int chose=sc.nextInt();
        switch (chose){
            case 1->{
                String a=sc.nextLine();
                System.out.println("Введите название");
                String name=sc.nextLine();
                System.out.println("Вес:");
                double weight=sc.nextDouble();
                Sweets sweets1=new Chocolate(name,weight);
                sweets.add(sweets1);
            }
            case 2->{
                String a=sc.nextLine();
                System.out.println("Введите название");
                String name=sc.nextLine();
                System.out.println("Вес:");
                double weight=sc.nextDouble();
                Sweets sweets1=new Lollipops(name,weight);
                sweets.add(sweets1);
            }
            case 3->{
                String a=sc.nextLine();
                System.out.println("Введите название");
                String name=sc.nextLine();
                System.out.println("Вес:");
                double weight=sc.nextDouble();
                Sweets sweets1=new Caramels(name,weight);
                sweets.add(sweets1);
            }
            default -> System.out.println("Введите корректно значение!");
        }
    }
    public static void Create_Present(ArrayList<Sweets> sweets,ArrayList<Present> presents){
        Present present=new Present();
        System.out.println("Выберите конфеты");
        for (int i=0;i< sweets.size();i++){
            System.out.println((i+1)+"."+sweets.get(i));
        }
        System.out.println("Чтобы выйти,нажмите 0");
        int chose;
        do{
            chose=sc.nextInt();
            if(chose!=0) {
                present.setSweets(sweets.get(chose - 1));
            }
        }while(chose!=0);
        presents.add(present);
    }
    public static void Find_weight(ArrayList<Present> presents){
        System.out.println("Выберите подарок:");
        for (int i=0;i<presents.size();i++){
            System.out.println((i+1)+"."+presents.get(i));
        }
        int chose=sc.nextInt();
        Function function=(list)->{
            double FinalCost=0;
            List<Double> list1=new ArrayList<>();
            list.forEach(sweets -> list1.add(sweets.getWeight()));
            for(double price:list1){
                FinalCost+=price;
            }
            return FinalCost;
        };
        if(chose>0 && chose<= presents.size()){
            System.out.println("Суммарный вес подарка "+function.FinalWeight(presents.get(chose-1).getSweets()));
        }
        else{
            System.out.println("Введите корректно значение");
        }
    }
}