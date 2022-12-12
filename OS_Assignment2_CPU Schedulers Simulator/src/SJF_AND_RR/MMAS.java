package SJF_AND_RR;// Java program to implement Shortest Remaining Time First
// Shortest Remaining Time First (SRTF)


import java.util.ArrayList;
import java.util.Scanner;

import AG.AGMain;
import pre_priority.pre_priority;

public class MMAS
{


    public static void roundRobinHomeScreen(){
        int process_Num,Round_robin_Time_Quantum,Context_switching;

        Scanner homeScan = new Scanner(System.in);
        while (true) {
            try {

                System.out.print("Enter number of process : ");
                String s1 = homeScan.nextLine();
                process_Num = Integer.parseInt(s1);
                System.out.print("Enter Round robin Time Quantum : ");
                String s2 = homeScan.nextLine();
                Round_robin_Time_Quantum = Integer.parseInt(s2);
                System.out.print("Enter Context switching : ");
                String s3 = homeScan.nextLine();
                Context_switching = Integer.parseInt(s3);

                Process.setContext_switching(Context_switching);
                Process.setRound_robin_Time_Quantum(Round_robin_Time_Quantum);

                break;
            } catch (NumberFormatException e) {
                System.out.println("invalid input " + e.getMessage() + "\n");
            }

        }

        ArrayList<Process> pro = new ArrayList<>();
        for (int i=0;i<process_Num;i++){
            String Process_Name;
            int  Burst_Time;
            int Arrival_Time;

            while (true) {
                try {
                    System.out.println("--------------------------------------");
                    System.out.print("Enter process Name : ");
                    Process_Name = homeScan.nextLine();
                    System.out.print("Enter Process Arrival Time : ");
                    String s2 = homeScan.nextLine();
                    Arrival_Time = Integer.parseInt(s2);
                    System.out.print("Enter Process Burst Time : ");
                    String s3 = homeScan.nextLine();
                    Burst_Time = Integer.parseInt(s3);
                    pro.add(new Process(i + 1, Process_Name, Burst_Time, Arrival_Time));

                    break;
                } catch (NumberFormatException e) {
                    System.out.println("invalid input " + e.getMessage() + "\n");
                }

            }



        }
        System.out.println("--------------------------------------");

        Round_Robin RR = new Round_Robin();
        RR.findavgTime(pro,process_Num);
    }


    public static void SJFHomeScreen(){
        int process_Num,Context_switching;

        Scanner homeScan = new Scanner(System.in);
        while (true) {
            try {

                System.out.print("Enter number of process : ");
                String s1 = homeScan.nextLine();
                process_Num = Integer.parseInt(s1);
                System.out.print("Enter Context switching : ");
                String s3 = homeScan.nextLine();
                Context_switching = Integer.parseInt(s3);

                Process.setContext_switching(Context_switching);

                break;
            } catch (NumberFormatException e) {
                System.out.println("invalid input " + e.getMessage() + "\n");
            }

        }
//        Process pro[] = new Process[process_Num];
        ArrayList<Process> pro = new ArrayList<>();
        for (int i=0;i<process_Num;i++){
            String Process_Name;
            int  Burst_Time;
            int Arrival_Time;

            while (true) {
                try {
                    System.out.println("--------------------------------------");
                    System.out.print("Enter process Name : ");
                    Process_Name = homeScan.nextLine();
                    System.out.print("Enter Process Arrival Time : ");
                    String s2 = homeScan.nextLine();
                    Arrival_Time = Integer.parseInt(s2);
                    System.out.print("Enter Process Burst Time : ");
                    String s3 = homeScan.nextLine();
                    Burst_Time = Integer.parseInt(s3);
                    pro.add(new Process(i + 1, Process_Name, Burst_Time, Arrival_Time));

                    break;
                } catch (NumberFormatException e) {
                    System.out.println("invalid input " + e.getMessage() + "\n");
                }

            }



        }
        System.out.println("--------------------------------------");

        PSJF sjf = new PSJF();
        sjf.findavgTime(pro,process_Num);

    }


    // Driver Method
    public static void main(String[] args)
    {
        int Num;
        Scanner homeScan = new Scanner(System.in);
        while (true) {
            try {

                System.out.println("Enter Type of CPU Schedulers Simulator ");
                System.out.println("1. preemptive Shortest- Job First ");
                System.out.println("2. Round Robin ");
                System.out.println("3. preemptive Priority Scheduling");
                System.out.println("4. AG Scheduling ");
                System.out.print("choice: ");
                String s1 = homeScan.nextLine();
                Num = Integer.parseInt(s1);
                if ( Num < 1||  Num > 4) {
                    System.out.println("invalid input \n");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("invalid input " + e.getMessage() + "\n");
            }

        }
        if (Num==1){
            SJFHomeScreen();
        }else if (Num==2){
            roundRobinHomeScreen();
        }else if (Num==3){
            pre_priority.Input();
        }else {
            AGMain.Input();
        }

    }
}

