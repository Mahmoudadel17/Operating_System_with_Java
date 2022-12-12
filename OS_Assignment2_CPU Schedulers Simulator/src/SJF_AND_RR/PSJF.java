package SJF_AND_RR;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Formatter;

public class PSJF {
    // Method to find the waiting time for all processes
    private void findWaitingTime(ArrayList<Process> proc, int n)
    {
        int rt[] = new int[n];

        // Copy the burst time into rt[]
        for (int i = 0; i < n; i++)
            rt[i] = proc.get(i).bt;

        int complete = 0, t = 0, minm = Integer.MAX_VALUE;
        int shortest = 0, finish_time;
        boolean check = false;

        // Process until all processes gets
        // completed
        while (complete != n) {

            // Find process with minimum
            for (int j = 0; j < n; j++)
            {
                if ((proc.get(j).art <= t) && (rt[j] < minm) && rt[j] > 0) {
                    minm = rt[j];
                    shortest = j;
                    check = true;
                }
            }
            // no process
            if (!check) {
                t++;
                continue;
            }

            // Reduce remaining time by one
            rt[shortest]--;

            // Update minimum
            minm = rt[shortest];
            if (minm == 0)
                minm = Integer.MAX_VALUE;

            // If a process gets completely
            // executed
            if (rt[shortest] == 0) {

                // Increment complete
                complete++;
                check = false;

                // Find finish time of current
                // process
                finish_time = t + 1+Process.CS;
                t+=Process.CS;
                // Calculate waiting time
                proc.get(shortest).wt = finish_time - proc.get(shortest).bt - proc.get(shortest).art;

                if ( proc.get(shortest).wt < 0)
                    proc.get(shortest).wt = 0;
            }
            // Increment time
            t++;

        }
    }



    // Method to calculate average time
    public void findavgTime( ArrayList<Process> proc, int n)
    {
        int total_wt = 0, total_tat = 0;

        findWaitingTime(proc,n);
        // calculating turnaround time by adding
        for (int i = 0; i < n; i++)
            proc.get(i).tat = proc.get(i).bt + proc.get(i).wt;

        // Sort Process with first end
        proc.sort(Comparator.comparing(Process::getTat));
        // Display processes along with all
        // details
        Formatter fmt = new Formatter();
        fmt.format("%15s %15s %15s %15s  %15s\n", "Process name ", " Arrival time ", " Burst time "," Waiting time " , " Turn around time");
        // Calculate total waiting time and
        // total turnaround time
        for (int i = 0; i < n; i++) {
            total_wt = total_wt + proc.get(i).wt;
            total_tat = total_tat + proc.get(i).tat;
            fmt.format("%14s %14s %14s %14s %17s\n", proc.get(i).Process_Name, proc.get(i).art,  proc.get(i).bt, proc.get(i).wt, proc.get(i).tat);

        }System.out.println(fmt);

        System.out.println("Average waiting time = " +
                (float)total_wt / (float)n);
        System.out.println("Average turn around time = " +
                (float)total_tat / (float)n);
    }
}
