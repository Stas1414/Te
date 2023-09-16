import java.util.Scanner;

public class Main {
    static char[][] map;
    static final int Map_size=3;
    static final char Empty_field='*';
    static final char O='O';
    static final char X='X';
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        GAME();
    }
    public static void Turn_X(){
        System.out.println("Введите координаты X:");
        int x,y;
        while (true) {
            x = sc.nextInt();
            y = sc.nextInt();
            try {
                if (map[y-1][x-1] != O) {
                    map[y-1][x-1] = X;
                } else {
                    throw new Exceptions();
                }
                break;
            } catch (Exceptions e) {
                System.out.println("Введены недопустимые координаты,введите координаты заново");
            }
        }
    }
public static boolean Check_map(){
        for (int i = 0; i < Map_size; i++) {
            for (int j = 0; j <Map_size ; j++) {
                if (map[i][j]==Empty_field) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void GAME(){
        initializationMap();
        printMap();
        if(Chose_Turn()) {
            while (true) {
                Turn_X();
                printMap();
                if(CheckWin(X)){
                    System.out.println("Победил X!");
                    break;
                }
                if(Check_map()){
                    System.out.println("Ничья!");
                    break;
                }
                Turn_O();
                printMap();
                if(CheckWin(O)){
                    System.out.println("Победил O!");
                    break;
                }
                if(Check_map()){
                    System.out.println("Ничья!");
                    break;
                }
            }
        }
        else {
            while (true) {
                Turn_O();
                printMap();
                if(CheckWin(O)){
                    System.out.println("Победил O!");
                    break;
                }
                if(Check_map()){
                    System.out.println("Ничья!");
                    break;
                }
                Turn_X();
                printMap();
                if(CheckWin(X)){
                    System.out.println("Победил X!");
                    break;
                }
                if(Check_map()){
                    System.out.println("Ничья!");
                    break;
                }
            }
        }
    }
    public static boolean CheckWin(char symbol){
        if(map[0][0]==symbol && map[0][1]==symbol && map[0][2]==symbol){
            return true;
        }
        if(map[1][0]==symbol && map[1][1]==symbol && map[1][2]==symbol){
            return true;
        }
        if(map[2][0]==symbol && map[2][1]==symbol && map[2][2]==symbol){
            return true;
        }
        if(map[0][0]==symbol && map[1][0]==symbol && map[2][0]==symbol){
            return true;
        }
        if(map[0][1]==symbol && map[1][1]==symbol && map[2][1]==symbol){
            return true;
        }
        if(map[0][2]==symbol && map[1][2]==symbol && map[2][2]==symbol){
            return true;
        }
        if(map[0][0]==symbol && map[1][1]==symbol && map[2][2]==symbol){
            return true;
        }
        if(map[0][2]==symbol && map[1][1]==symbol && map[2][0]==symbol){
            return true;
        }
        return false;
    }
    public static boolean Chose_Turn() {
        int chose;
        while (true) {
            System.out.println("Кто первый ходит?");
            System.out.println("1.X         2.O");
            try {
                chose = Integer.parseInt(sc.next());
                if (chose < 1 || chose > 2) {
                    throw new Exceptions();
                }
                break;
            } catch (Exceptions | NumberFormatException e) {
                System.out.println("Введите корректно значение!");
            }
        }
        if(chose==1){
            return true;
        }
        else{
            return false;
        }
    }
    public static void Turn_O(){
        System.out.println("Введите координаты O:");
        int x,y;
        while (true) {
            x = sc.nextInt();
            y = sc.nextInt();
            try {
                if (map[y-1][x-1] != X) {
                    map[y-1][x-1] = O;
                } else {
                    throw new Exceptions();
                }
                break;
            } catch (Exceptions e) {
                System.out.println("Введены недопустимые координаты,введите координаты заново");
            }
        }
    }
    public static void printMap(){
        for (int i = 0; i <Map_size; i++) {
            for (int j = 0; j <Map_size ; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void initializationMap(){
        map=new char[Map_size][Map_size];
        for (int i = 0; i <Map_size ; i++) {
            for (int j = 0; j <Map_size ; j++) {
                map[i][j]=Empty_field;
            }
        }
    }
}