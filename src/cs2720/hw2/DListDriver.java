package cs2720.hw2;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class DListDriver {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a list type (i - int, d - double, s - string)");
        String list = sc.nextLine();
        switch (list) {
        case "i" : { //each case will be its own thing based on list choice

            DoublyLinkedList<Integer> original = new DoublyLinkedList<Integer>();
            try {
                sc = new Scanner(new File(args[0]));
                while (sc.hasNextInt()) {
                    int num = sc.nextInt();
                    original.insertItem(num);
                }
            }
            catch(FileNotFoundException fnf) {
                System.out.println("file not found");
                System.exit(0);
            }
            sc = new Scanner(System.in);
            System.out.println("Commands:");
            System.out.println("(i) - Insert Value");
            System.out.println("(d) - Delete Value");
            System.out.println("(p) - Print List");
            System.out.println("(l) - Print Length");
            System.out.println("(t) - print reverse");
            System.out.println("(r) - Reverse List");
            System.out.println("(b) - Delete Subsection");
            System.out.println("(s) - Swap Alternate");
            System.out.println("(q) - Quit Program");

            String comm = "";
            boolean running = true;
            while (running) {
                System.out.println("Enter a command");
                comm = sc.nextLine();
                int tempNum;
                switch (comm) {
                case "i":
                    System.out.print("Enter a number to insert: ");
                    tempNum = sc.nextInt();
                    sc.nextLine();
                    System.out.print("the list is: ");
                    original.print();
                    sc.nextLine();
                    original.insertItem(tempNum);
                    System.out.print("the list is : ");
                    original.print();
                    sc.nextLine();
                    System.out.print("the reverse list: ");
                    original.printReverse();
                    sc.nextLine();
                    break;
                case "d":
                    System.out.print("Enter a number to delete: ");
                    tempNum = sc.nextInt();
                    sc.nextLine();
                    System.out.print("The list is: ");
                    original.print();
                    sc.nextLine();
                    original.deleteItem(tempNum);
                    System.out.print("The list is: ");
                    original.print();
                    sc.nextLine();
                    System.out.print("the reverse list: ");
                    original.printReverse();
                    sc.nextLine();
                    break;

                case "p":
                    System.out.print("the list is: ");
                    original.print();
                    sc.nextLine();
                    break;
                case "l":
                    System.out.print("the length of the list is: " + original.length());
                    sc.nextLine();
                    break;
                    //the rest of the commands
                case "b" :
                    System.out.print("Enter a lower bound: ");
                    int lb = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter an upper bound: ");
                    int ub = sc.nextInt();
                    sc.nextLine();
                    System.out.print("the original list: ");
                    original.print();
                    sc.nextLine();
                    original.deleteSubsection(lb, ub);
                    System.out.print("The modified list: ");
                    original.print();
                    sc.nextLine();
                    System.out.print("the reverse list: ");
                    original.printReverse();
                    sc.nextLine();
                    break;
                case "r" :
                    System.out.print("Input list: ");
                    original.print();
                    sc.nextLine();
                    original.reverseList();
                    System.out.print("reversed list :");
                    original.print();
                    sc.nextLine();
                    break;
                case "t" :
                    System.out.print("the reverse list: ");
                    original.printReverse();
                    sc.nextLine();
                    break;
                case "s" :
                    System.out.print("original list: ");
                    original.print();
                    sc.nextLine();
                    original.swapAlternate();
                    System.out.print("swapped list: ");
                    original.print();
                    sc.nextLine();
                    break;
                case "q":
                    System.out.print("Exiting the program...");
                    System.exit(0);
                    break;
                default :
                    System.out.print("invalid command");
                }
            }
            break;
        }
        case "d" : {
            DoublyLinkedList<Double> original = new DoublyLinkedList<Double>();
            try {
                sc = new Scanner(new File(args[0]));
                while (sc.hasNextDouble()) {
                    double num = sc.nextDouble();
                    original.insertItem(num);
                }
            }
            catch(FileNotFoundException fnf) {
                System.out.println("file not found");
                System.exit(0);
            }
            sc = new Scanner(System.in);
            System.out.println("Commands:");
            System.out.println("(i) - Insert Value");
            System.out.println("(d) - Delete Value");
            System.out.println("(p) - Print List");
            System.out.println("(l) - Length");
            System.out.println("(t) - print reverse");
            System.out.println("(r) - Reverse List");
            System.out.println("(b) - Delete Subsection");
            System.out.println("(s) - Swap Alternate");
            System.out.println("(q) - Quit Program");

            String comm = "";
            boolean running = true;
            while (running) {
                System.out.println("Enter a command");
                comm = sc.nextLine();
                double tempNum;
                switch (comm) {
                case "i":
                    System.out.print("Enter a number to insert: ");
                    tempNum = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Original list: ");
                    original.print();
                    sc.nextLine();
                    original.insertItem(tempNum);
                    System.out.print("New list: ");
                    original.print();
                    sc.nextLine();
                    break;
                case "d":
                    System.out.print("Enter a number to delete: ");
                    tempNum = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("The list is: ");
                    original.print();
                    sc.nextLine();
                    original.deleteItem(tempNum);
                    System.out.print("The list is: ");
                    original.print();
                    sc.nextLine();
                    System.out.print("the reverse list: ");
                    original.printReverse();
                    sc.nextLine();
                    break;

                case "p":
                    System.out.print("the list is: ");
                    original.print();
                    sc.nextLine();
                    break;
                case "l":
                    System.out.print("the length of the list is: " + original.length());
                    sc.nextLine();
                    break;
                    //the rest of the commands
                case "b" :
                    System.out.print("Enter a lower bound: ");
                    double lb = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter an upper bound: ");
                    double ub = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("the original list: ");
                    original.print();
                    sc.nextLine();
                    original.deleteSubsection(lb, ub);
                    System.out.print("The modified list: ");
                    original.print();
                    sc.nextLine();
                    System.out.print("the reverse list: ");
                    original.printReverse();
                    sc.nextLine();
                    break;
                case "r" :
                    System.out.print("Input list: ");
                    original.print();
                    sc.nextLine();
                    original.reverseList();
                    System.out.print("reversed list :");
                    original.print();
                    sc.nextLine();
                    break;
                case "t" :
                    System.out.print("the reverse list: ");
                    original.printReverse();
                    sc.nextLine();
                    break;
                case "s" :
                    System.out.print("original list: ");
                    original.print();
                    sc.nextLine();
                    original.swapAlternate();
                    System.out.print("swapped list: ");
                    original.print();
                    sc.nextLine();
                    break;
                case "q":
                    System.out.print("Exiting the program...");
                    System.exit(0);
                    break;
                default :
                    System.out.print("invalid command");
                }
            }
            break;
        }
        case "s" : {
            DoublyLinkedList<String> original = new DoublyLinkedList<String>();
            try {
                sc = new Scanner(new File(args[0]));
                while (sc.hasNext()) {
                    String s = sc.next();
                    original.insertItem(s);
                }
            }
            catch(FileNotFoundException fnf) {
                System.out.println("file not found");
                System.exit(0);
            }
            sc = new Scanner(System.in);
            System.out.println("Commands:");
            System.out.println("(i) - Insert Value");
            System.out.println("(d) - Delete Value");
            System.out.println("(p) - Print List");
            System.out.println("(l) - Print Length");
            System.out.println("(t) - print reverse");
            System.out.println("(r) - Reverse List");
            System.out.println("(b) - Delete Subsection");
            System.out.println("(s) - Swap Alternate");
            System.out.println("(q) - Quit Program");

            String comm = "";
            boolean running = true;
            while (running) {
                System.out.println("Enter a command");
                comm = sc.nextLine();
                String tempStr;
                switch (comm) {
                case "i":
                    System.out.print("Enter a String to insert: ");
                    tempStr = sc.next();
                    sc.nextLine();
                    System.out.print("Original list: ");
                    original.print();
                    sc.nextLine();
                    original.insertItem(tempStr);
                    System.out.print("New list: ");
                    original.print();
                    sc.nextLine();
                    break;
                case "d":
                    System.out.print("Enter a String to delete: ");
                    tempStr = sc.nextLine();
                    sc.nextLine();
                    System.out.print("Original list: ");
                    original.print();
                    sc.nextLine();
                    original.deleteItem(tempStr);
                    System.out.print("new list: ");
                    original.print();
                    sc.nextLine();
                    break;
                case "p":
                    System.out.print("the list is: ");
                    original.print();
                    sc.nextLine();
                    break;
                case "l":
                    System.out.print("the length of the list is: " + original.length());
                    sc.nextLine();
                    break;
                case "b" :
                    System.out.print("Enter a lower bound: ");
                    String lb = sc.nextLine();
                    sc.nextLine();
                    System.out.print("Enter an upper bound: ");
                    String ub = sc.nextLine();
                    sc.nextLine();
                    System.out.print("the original list: ");
                    original.print();
                    sc.nextLine();
                    original.deleteSubsection(lb, ub);
                    System.out.print("The modified list: ");
                    original.print();
                    sc.nextLine();
                    System.out.print("the reverse list: ");
                    original.printReverse();
                    sc.nextLine();
                    break;
                case "r" :
                    System.out.print("Input list: ");
                    original.print();
                    sc.nextLine();
                    original.reverseList();
                    System.out.print("reversed list :");
                    original.print();
                    sc.nextLine();
                    break;
                case "t" :
                    System.out.print("the reverse list: ");
                    original.printReverse();
                    sc.nextLine();
                    break;
                case "s" :
                    System.out.print("original list: ");
                    original.print();
                    sc.nextLine();
                    original.swapAlternate();
                    System.out.print("swapped list: ");
                    original.print();
                    sc.nextLine();
                    break;
                case "q":
                    System.out.print("Exiting the program...");
                    System.exit(0);
                    break;
                default :
                    System.out.print("invalid command");
                }
            }
            break;
        }
        default: {
            System.out.println("not a correct list type");
        }
        }//switch

    }
}
