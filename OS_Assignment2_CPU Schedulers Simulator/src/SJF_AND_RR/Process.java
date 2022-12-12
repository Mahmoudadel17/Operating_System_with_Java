package SJF_AND_RR;

public class Process {

    String Process_Name;
    int pid; // Process ID
    int bt; // Burst Time
    int art; // Arrival Time
    int Priority; //Process Priority
    int wt; //  Waiting time
    int tat; // Turn around time
    int Q; // quantum
    int bt_copy;
    static int RRTQ; // Round robin Time Quantum
    static int CS; //Context switching


    public Process(int pid,String pName, int bt, int art)
    {
        this.Process_Name=pName;
        this.pid = pid;
        this.bt = bt;
        this.bt_copy=bt;
        this.art = art;
    }
    public Process(int pid,String pName, int bt, int art,int priority,int q)
    {
        this.Process_Name=pName;
        this.pid = pid;
        this.bt = bt;
        this.bt_copy=bt;
        this.art = art;
        this.Priority = priority;
        this.Q = q;
    }
    public int getarrivalTime(){return art;}
    public int getTat(){return tat;}
    public static void setRound_robin_Time_Quantum(int rrtq){RRTQ=rrtq;}
    public static void setContext_switching(int cs){CS=cs;}

}