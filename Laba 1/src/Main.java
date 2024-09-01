import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        long y =  922337203685477580L;
        System.out.println("long nubmer is: " + y);
//        ifel();
//        swtch();
//        whl();
        fr();
    }
    public static void  ifel() {
        System.out.println("Put 3 numbers: ");
        Scanner console = new Scanner(System.in);
        int x = console.nextInt();
        int y = console.nextInt();
        int z = console.nextInt();
        if(x < y && x < z){
            System.out.println("Answer is: " +x);
        } else if (y < x && y < z) {
            System.out.println("Answer is: " +y);
        } else if (z < x && z < y) {
            System.out.println("Answer is: " +z);
        } else if (x == y && x < z) {
            System.out.println("Answer is: " +x);
        }
        else if (x == z && x < y) {
            System.out.println("Answer is: " +x);
        }
        else if (y == z && y < x) {
            System.out.println("Answer is: " +y);
        } else if (y == z &&  y == x) {
            System.out.println("All numbers are equal");
        }
    }
    public static void swtch(){
        System.out.println("Enter type of vehicle: ");
        System.out.println("A - Car");
        System.out.println("B - Bike");
        System.out.println("C - Bus");
        Scanner console = new Scanner(System.in);
        String type = console.nextLine();
        switch(type){
            case "A":
                System.out.println("You have chosen:Car");
                break;
            case "B":
                System.out.println("You have chosen:Bike");
                break;
            case "C":
                System.out.println("You have chosen:Bus");
                break;
            default:System.out.println("Error!");
        }
    }
    public static void whl(){
        int count = 0;
        int number = 2;
        System.out.println("The first 10 prime numbers:");
        while(count < 10){
            boolean isrght = true;
            for(int i = 2; i < number; i++){
                if(number % i == 0){
                    isrght = false;
                    break;
                }
            }
            if(isrght){
                System.out.println(number);
                count++;
            }
            number++;
        }
    }
    public static void fr(){
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int max = array[0];
        int min = array[0];
        for(int i = 0; i < array.length; i++){
            if(min > array[i]){
                min = array[i];
            }
            if (max < array[i]){
                max = array[i];
            }
        }

        System.out.print(min + " " + max);
    }
}