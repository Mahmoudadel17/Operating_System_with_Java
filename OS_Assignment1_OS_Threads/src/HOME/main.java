//package HOME;
//
//import java.util.Scanner;
//
//public class main {
//    public  static void main(String arg[]){
//        Scanner scan = new Scanner(System.in);
//        int num;int Buffer_Size;
//        String fileName;
//
//
//        while (true) {
//            try {
//                System.out.print("Enter number n: ");
//                String n  = scan.nextLine();
//                num = Integer.parseInt(n);
//                break;
//            } catch (NumberFormatException e) {
//                System.out.println("invalid input " + e.getMessage() + "\n");
//            }
//
//        }
//        // Enter Buffer size
//        while (true) {
//            try {
//                System.out.print("Enter Buffer siz:  ");
//                String n  = scan.nextLine();
//                Buffer_Size = Integer.parseInt(n);
//                break;
//            } catch (NumberFormatException e) {
//                System.out.println("invalid input " + e.getMessage() + "\n");
//            }
//
//        }
//        // Enter file name
//        System.out.print("Enter file name:  ");
//        while (true) {
//            fileName  = scan.nextLine();
//            boolean s = fileName.contains(".txt");
//            if (!s){System.out.print("Enter a valid file name: ");}
//            else {break;}
//        }
//
//        Primes.Number = num;
//        Buffer buff = new Buffer(Buffer_Size);
//        Primes.fileName = fileName;
//
//        producer p1 = new producer(buff);
//        consumer c1 = new consumer(buff);
//        p1.start();
//        c1.start();
//
//
//
//
//    }
//}
