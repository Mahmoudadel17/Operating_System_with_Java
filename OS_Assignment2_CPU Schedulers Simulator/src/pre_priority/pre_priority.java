package pre_priority;

import java.util.*;

public class pre_priority {

    public static void Input() {

        int i, b;
        int no_Process, total_Burst_Time = 0;
        double totalwaitingTime = 0, totalturnaroundtime = 0;
        int count = 0;
        double small, averagewaitingTime, averageturnaroundtime;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number of processes: ");
        no_Process = s.nextInt();
        ArrayList<process> process = new ArrayList<>();
        for (i = 0; i < no_Process; i++) {
            process.add(new process());
        }
        for (i = 0; i < no_Process; i++) {
            total_Burst_Time += process.get(i).burstTime;
            process.get(i).burstTime1 = process.get(i).burstTime;
            process.get(i).completion = 0;
        }
        while (count <= total_Burst_Time) {
            b = 0;
            small = 100000;
            for (i = 0; i < no_Process; i++) {
                if (process.get(i).arrivalTime > count || process.get(i).burstTime <= 0) {
                    b++;
                }
            }

            if (b == no_Process) {
                count++;
                continue;
            }

            for (i = 0; i < no_Process; i++) {
                if (process.get(i).arrivalTime > count || process.get(i).burstTime <= 0) {
                    continue;
                } else {
                    if (process.get(i).priorityvalue < small) {
                        small = process.get(i).priorityvalue;
                    }
                }
            }
            for (i = 0; i < no_Process; i++) {
                if (small == process.get(i).priorityvalue) {
                    process.get(i).burstTime = process.get(i).burstTime - 1;
                    count++;
                    if (process.get(i).burstTime <= 0) {
                        process.get(i).completion = count;
                    }
                }
            }
        }
        System.out.println("Process\tWT\t\tTAT");
        for (i = 0; i < no_Process; i++) {
            process.get(i).waitingTime = process.get(i).completion - process.get(i).burstTime1 - process.get(i).arrivalTime;
            process.get(i).turnaroundtime = process.get(i).completion - process.get(i).arrivalTime;
            System.out.println(process.get(i).processName + "\t\t" + process.get(i).waitingTime + "\t\t" + process.get(i).turnaroundtime);

        }

        for (i = 0; i < no_Process; i++) {
            totalwaitingTime += process.get(i).waitingTime;
            totalturnaroundtime = totalturnaroundtime + process.get(i).turnaroundtime;
        }
        averagewaitingTime = totalwaitingTime / no_Process;
        averageturnaroundtime = totalturnaroundtime / no_Process;

        System.out.println("Average waiting time = " + averagewaitingTime);
        System.out.println("Average turnaround  time = " + averageturnaroundtime);

    }

    static class process {

        String processName;
        int arrivalTime;
        int burstTime;
        int burstTime1;
        int completion;
        int waitingTime;
        int turnaroundtime;
        int priorityvalue;
        Scanner s = new Scanner(System.in);

        process() {
            System.out.print("Enter the name of the process : ");
            processName = s.next();
            System.out.print("Enter the Arrival time of the process : ");
            arrivalTime = s.nextInt();
            System.out.print("Enter the Burst time  of the process : ");
            burstTime = s.nextInt();
            System.out.print("Enter the pririty of the process : ");
            priorityvalue = s.nextInt();
            System.out.println();
        }
    }
}