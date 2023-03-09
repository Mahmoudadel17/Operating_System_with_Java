import java.util.Scanner;
import java.util.LinkedList;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList<Process> processes = new LinkedList<Process>();
        LinkedList<Partition> partitions = new LinkedList<Partition>();
        int numproc , numpart;
        //inserting num of partions and each partion
        System.out.println("Enter number of partition:");
        numpart = input.nextInt();
        for (int i = 0 ; i < numpart ; i++){
            Partition p = new Partition();
            p.name = "Partition " + i ;
            System.out.println("partition name and its size:");
            p.size = input.nextInt();
            p.id = i ;
            partitions.add(p);
        }
        //inserting num of processes and each process
        System.out.println("Enter number of processes:");
        numproc = input.nextInt();
        for (int i = 0 ; i < numproc ; i++){
            Process p = new Process();
            p.name = "Process " + (i+1) ;
            System.out.println("process name and its size:");
            p.size = input.nextInt();
            processes.add(p);
        }
        //choose policy for allocating
            int choicepolicy ;
            AllocationPolicies policy = new AllocationPolicies(numpart,numproc,processes,partitions);
            System.out.println("Select the policy you want to apply:\n" +
                    "1. First fit\n" +
                    "2. Worst fit\n" +
                    "3. Best fit\n");
            //handling the choice input from user
        Scanner homeScan = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Select policy:");
                String s = homeScan.nextLine();
                choicepolicy = Integer.parseInt(s);
                if ( choicepolicy<1 ||  choicepolicy>3) {
                    System.out.println("invalid input \n");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("invalid input " + e.getMessage() + "\n");
            }
        }
        switch (choicepolicy){
                case 1:
                    policy.firstfit();
                    policy.compact();
                    break;
                case 2:
                    policy.worstfit();
                    policy.compact();
                    break;
                case 3:
                    policy.bestfit();
                    policy.compact();
                    break;
                default:
                    System.out.println("Enter valid choice");
            }
    }
}