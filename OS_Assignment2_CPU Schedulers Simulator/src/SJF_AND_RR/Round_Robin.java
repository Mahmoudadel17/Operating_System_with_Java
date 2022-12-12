package SJF_AND_RR;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Formatter;

public class Round_Robin {


        // Method to calculate average time
        public void findavgTime(ArrayList<Process> proc, int n)
        {


            int total_wt = 0, total_tat = 0;

            int rem_bt[] = new int[n];
            for (int i =0;i<n;i++){
                rem_bt[i]= proc.get(i).bt;
            }

            int t = 0; // Current time
            while(true)
            {
                for (int i = 0 ; i < n; i++)
                {
                    if (rem_bt[i] > 0 && proc.get(i).art<=t)
                    {
                        if (rem_bt[i] > Process.RRTQ)
                        {
                            t += Process.RRTQ+Process.CS;
//                            System.out.println(i);
//                            System.out.println(t);
                            rem_bt[i] -= Process.RRTQ;
                        }
                        else
                        {
                            t += rem_bt[i]+Process.CS;
//                            System.out.println("f "+i);
//                            System.out.println("f "+t);
                            proc.get(i).tat = t - proc.get(i).art;
                            proc.get(i).wt = proc.get(i).tat - proc.get(i).bt ;
                            rem_bt[i] = 0;
                        }
                    }
                }

                int count_sleep=0;
                for (int x=0;x<n;x++){
                    if(rem_bt[x]==0){
                        count_sleep++;
                    }
                }

                // If all processes are done
                if (count_sleep==n){
                    break;
                }
                t++;

            }

            // calculating turnaround time by adding
//            for (int i = 0; i < n ; i++)
//                proc[i].tat = proc[i].bt + proc[i].wt;

            // Sort Process with first end
            proc.sort(Comparator.comparing(Process::getTat));

            // Display processes along with all details
            Formatter fmt = new Formatter();
            fmt.format("%15s %15s %15s %15s  %15s\n", "Process name ", " Arrival time ", " Burst time "," Waiting time " , " Turn around time");

            // Calculate total waiting time and total turn
            // around time
            for (int i=0; i<n; i++)
            {
                total_wt = total_wt + proc.get(i).wt;
                total_tat = total_tat + proc.get(i).tat;
                fmt.format("%14s %14s %14s %14s %17s\n", proc.get(i).Process_Name, proc.get(i).art,  proc.get(i).bt, proc.get(i).wt, proc.get(i).tat);
            }System.out.println(fmt);

            System.out.println("Average waiting time = " + (float)total_wt / (float)n);
            System.out.println("Average turn around time = " + (float)total_tat / (float)n);
        }


}
