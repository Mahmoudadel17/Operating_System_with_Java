import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Collections;
import java.util.*;
public class AllocationPolicies {
    int numproc , numpart;
    Scanner input = new Scanner(System.in);
    LinkedList<Process> proc ;
    LinkedList<Partition> part ;
    AllocationPolicies( int numpart , int numproc , LinkedList<Process> proc , LinkedList<Partition> part){
        this.numpart = numpart;
        this.numproc = numproc;
        this.part = new LinkedList<Partition>();
        this.part = part;
        this.proc = new LinkedList<Process>();
        this.proc = proc;
    }
    public void firstfit(){
        //to store the reminder space of partition
        int reminder;
        //to make counter to rename new partitions
        int counternewpart = numpart;
        //looping for each process
        for (int i = 0 ; i < numproc ; i++){
            for (int j = 0 ; j < part.size() ; j++){
                if(proc.get(i).size < part.get(j).size){
                    proc.get(i).isdone = true;
                    Partition p = new Partition();
                    reminder = part.get(j).size - proc.get(i).size;
                    part.get(j).size = proc.get(i).size;
                    part.get(j).isfull = true;
                    part.get(j).itsprocess = proc.get(i).name;
                    //set data of new partition
                    p.size = reminder;
                    p.name = "partition "+ counternewpart;
                    part.add(j+1,p);
                    //increase counter for next new partition
                    counternewpart++;
                    break;
                }
                else if(proc.get(i).size == part.get(j).size){
                    proc.get(i).isdone = true;
                    part.get(j).isfull = true;
                    part.get(j).itsprocess = proc.get(i).name;
                    break;
                }
            }
        }
        //printing each partition with its process
        for (int j = 0 ; j < part.size() ; j++){
            if (part.get(j).isfull == true){
                System.out.println(part.get(j).name + " (" + part.get(j).size + " KB)"
                        + " => " + part.get(j).itsprocess);
            }
            else {
                System.out.println(part.get(j).name + " (" + part.get(j).size + " KB)"
                        + " => External fragment ");
            }
        }
        //printing any process didn't allocat
        for (int i = 0 ; i < numproc ; i++){
            if(proc.get(i).isdone == false)
                System.out.println(proc.get(i).name + " can not be allocated");
        }
    }
    public void bestfit() {
        LinkedList<Partition> sortedpart = new LinkedList<Partition>();
        sortedpart = part;
        //sort the list by its size
        Collections.sort(sortedpart, new Comparator<Partition>() {
            @Override
            public int compare(Partition o1, Partition o2) {
                    return o1.size-o2.size;
            }
        });
        //to store the reminder space of partition
        int reminder;
        //to make counter to rename new partitions
        int counternewpart = numpart;
        //looping for each process and allocate it first fit after sorting the partition
        for (int i = 0 ; i < numproc ; i++){
            for (int j = 0 ; j < sortedpart.size() ; j++){
                if(proc.get(i).size < sortedpart.get(j).size){
                    proc.get(i).isdone = true;
                    Partition p = new Partition();
                    reminder = sortedpart.get(j).size - proc.get(i).size;
                    sortedpart.get(j).size = proc.get(i).size;
                    sortedpart.get(j).isfull = true;
                    sortedpart.get(j).itsprocess = proc.get(i).name;
                    //set data of new partition
                    p.size = reminder;
                    p.name = "partition "+ counternewpart;
                    p.id = sortedpart.get(j).id;
                    sortedpart.add(j+1,p);
                    //increase counter for next new partition
                    counternewpart++;
                    break;
                }
                else if(proc.get(i).size == sortedpart.get(j).size){
                    proc.get(i).isdone = true;
                    sortedpart.get(j).isfull = true;
                    sortedpart.get(j).itsprocess = proc.get(i).name;
                    break;
                }
            }
        }
        //sorting partitions by id
        Collections.sort(sortedpart, new Comparator<Partition>() {
            @Override
            public int compare(Partition o1, Partition o2) {
                return o1.id-o2.id;
            }
        });
        //printing each partition with its process
        for (int j = 0 ; j < sortedpart.size() ; j++){
            if (sortedpart.get(j).isfull == true){
                System.out.println(sortedpart.get(j).name + " (" + sortedpart.get(j).size + " KB)"
                        + " => " + sortedpart.get(j).itsprocess);
            }
            else {
                System.out.println(sortedpart.get(j).name + " (" + sortedpart.get(j).size + " KB)"
                        + " => External fragment ");
            }
        }
        //printing any process didn't allocat
        for (int i = 0 ; i < numproc ; i++){
            if(proc.get(i).isdone == false)
                System.out.println(proc.get(i).name + " can not be allocated");
        }
    }
    public void worstfit(){
        LinkedList<Partition> sortedpart = new LinkedList<Partition>();
        sortedpart = part;
        //sort the list by its size
        Collections.sort(sortedpart, new Comparator<Partition>() {
            @Override
            public int compare(Partition o1, Partition o2) {
                return o2.size-o1.size;
            }
        });
        //to store the reminder space of partition
        int reminder;
        //to make counter to rename new partitions
        int counternewpart = numpart;
        //looping for each process and allocate it first fit after sorting the partition
        for (Process process : proc)
        {
            if (!process.isdone)
            {
                for (int i = 0; i < sortedpart.size(); i++)
                {
                    if (!sortedpart.get(i).isfull && sortedpart.get(i).size >= process.size)
                    {
                        sortedpart.get(i).itsprocess=process.name;
                        sortedpart.get(i).isfull = true;
                        reminder = sortedpart.get(i).size - process.size;

                        if (reminder > 0)
                        {
                            Partition p = new Partition();
                            p.size = reminder;
                            p.name = "partition " + counternewpart;
                            p.id = sortedpart.get(i).id;
                            sortedpart.add(i + 1, p);
                            counternewpart++;
                        }
                        sortedpart.get(i).size = process.size;
                        process.isdone = true;
                        break;
                    }
                }
            }
        }
        //sort the list by its id
        Collections.sort(sortedpart, new Comparator<Partition>() {
            @Override
            public int compare(Partition o1, Partition o2) {
                return o1.id-o2.id;
            }
        });
        //printing each partition with its process
        for (int j = 0 ; j < sortedpart.size() ; j++){
            if (sortedpart.get(j).isfull == true){
                System.out.println(sortedpart.get(j).name + " (" + sortedpart.get(j).size + " KB)"
                        + " => " + sortedpart.get(j).itsprocess);
            }
            else {
                System.out.println(sortedpart.get(j).name + " (" + sortedpart.get(j).size + " KB)"
                        + " => External fragment ");
            }
        }
        //printing any process didn't allocat
        for (int i = 0 ; i < numproc ; i++){
            if(proc.get(i).isdone == false)
                System.out.println(proc.get(i).name + " can not be allocated");
        }
    }
    public void compact(){
        int choicecompact , oldsize = part.size();
        Partition newpart = new Partition();
        System.out.println("Do you want to compact? 1.yes 2.no");
        choicecompact = input.nextInt();
        if (choicecompact == 1){
            //compact all empty partitions
            newpart.name= "Partition " + oldsize;
            newpart.size = 0;
            for(int i = 0 ; i < part.size() ; i++){
                if (part.get(i).isfull == false){
                    newpart.size += part.get(i).size ;
                    part.remove(i);
                    i--;
                }
            }
            if(newpart.size>0){
                part.add(newpart);
                //check if any process not allocated
                for (int i = 0 ; i < numproc ; i++){
                    int rem;
                    Partition newpart2 = new Partition();
                    if(proc.get(i).isdone == false){
                        if(proc.get(i).size < newpart.size){
                            oldsize++;
                            proc.get(i).isdone = true;
                            newpart.isfull = true;
                            rem = newpart.size - proc.get(i).size;
                            newpart.size = proc.get(i).size;
                            newpart.itsprocess = proc.get(i).name;
                            newpart2.size = rem;
                            newpart2.name = "Partition " + oldsize;
                            part.add(newpart2);
                            newpart = newpart2;
                        }
                        else if(proc.get(i).size == newpart.size){
                            oldsize++;
                            proc.get(i).isdone = true;
                            newpart.isfull = true;
                            newpart.itsprocess = proc.get(i).name;
                            part.add(newpart2);
                            newpart = newpart2;
                        }
                    }
                }
            }
            //print partitions after compacting
            for (int j=0 ; j < part.size() ; j++){
                if (part.get(j).isfull == true){
                    System.out.println(part.get(j).name + " (" + part.get(j).size + " KB)"
                            + " => " + part.get(j).itsprocess);
                }
                else {
                    System.out.println(part.get(j).name + " (" + part.get(j).size + " KB)"
                            + " => External fragment ");
                }
            }
        }
        System.out.println("\n");
    }


}
