package AG;

import java.util.Formatter;
import java.util.LinkedList;

public class AG {
	public static LinkedList<String> list =  new LinkedList<>();
    public static int index = 0;

	public void simulation(Process process[]) 
	{
		while(true)
		{
			
			if(checkQT(process))
				break;
			
			
			int i = fsfc.simulation(process);
			Update(process);
			
			if(checkBT(process[i]))
			{
				process[i].QuantumTime = 0;
				continue;
			}
			
			
			if(CheckPR(process) && i != index)
			{
				fsfc.i = index;
				process[i].QuantumTime += Math.ceil((process[i].QuantumTime - Math.ceil(process[i].QuantumTime*0.25))/2);

				continue;
			}
			
			
			NonPrePriority.index = i;
			i = NonPrePriority.simulation(process);
			Update(process);
			
			if(checkBT(process[i]))
			{
				process[i].QuantumTime = 0;
				continue;
			}
			
			if(CheckSJF(process) && i != index)
			{
				fsfc.i = index;
				process[i].QuantumTime += (process[i].QuantumTime - (Math.ceil(process[i].QuantumTime*0.50)-Math.ceil(process[i].QuantumTime*0.25)) - Math.ceil(process[i].QuantumTime*0.25)); 

				continue;
			}
			
			SJF.index = i;
			i = SJF.simulation(process);
			
			Update(process);
			
			if(!checkBT(process[i]))
			{
				
				process[i].QuantumTime += 2;
			}
			else 
			{
				process[i].QuantumTime = 0;
			}
			

		}
		
		Update(process);
		ExecutionOrder();
		TAT(process);
		WaitTime(process);
		
		
		System.out.println("Aerage Turn Arround Time = "+AVGTurnArrTime(process));
		
		System.out.println("Aerage Waiting Time = "+AVGWaitTime(process));
		
		System.out.println(getMax(process));
	}
	
	
	public void ExecutionOrder() 
	{
		System.out.println("Processes execution order");
		
		for(int i = 1; i <= list.size(); i++)
		{
			System.out.println(i+": "+list.get(i-1));
		}
		System.out.println("\n");

	}
	
	@SuppressWarnings("resource")
	public void Update(Process process[]) 
	{
		Formatter fmt = new Formatter();
		fmt.format("%15s %15s %15s %15s\n", "Process name ", " Arrival time ", " Burst time ","Quantum time");
		for(int i = 0; i < process.length; i++)
		{
			fmt.format("%14s %14s %14s %14s\n", process[i].name,process[i].ArrivalTime,  process[i].BurstTime,process[i].QuantumTime);
		}
		System.out.println(fmt);
	}
	
	public boolean CheckPR(Process inputArray[]) 
	{
		int GCT = getMax(inputArray);

		boolean check = false;
	    int minValue = inputArray[0].PriorityTime; 
	    for(int i=1;i<inputArray.length;i++)
	    { 
	      if(inputArray[i].PriorityTime < minValue && inputArray[i].ArrivalTime <= GCT && inputArray[i].BurstTime > 0)
	      { 
	        minValue = inputArray[i].PriorityTime;
	        index = i;
	        check = true;
	        
	      } 
	    }


	    
	    return check;
	}
	
	
	public static boolean CheckSJF(Process inputArray[]) 
	{
		int GCT = getMax(inputArray);
		boolean check = false;

	    int minValue = inputArray[0].BurstTime; 
	    
	    for(int i=1;i<inputArray.length;i++)
	    { 
		  if(inputArray[i].BurstTime < minValue && inputArray[i].ArrivalTime <= GCT && inputArray[i].BurstTime > 0)
	      { 
	        minValue = inputArray[i].BurstTime;
	        index = i;
	        check = true;
	        
	      } 
	    }


	    
	    return check;
	}
	
	public static int getMax(Process inputArray[])
	{ 
	    int Max = inputArray[0].completionTime; 
	    
	    for(int i=1;i<inputArray.length;i++)
	    { 
	      if(inputArray[i].completionTime > Max)
	      { 
	        Max = inputArray[i].completionTime;
	        
	        
	      } 
	    } 
	    return Max; 
	  }
	
	public static boolean checkQT(Process inputArray[])
	{
		for(int i = 0;i < inputArray.length; i++)
		{
			if(inputArray[i].QuantumTime > 0)
				return false;
		}
		return true;
	}
	
	public static boolean checkBT(Process process)
	{

		if(process.BurstTime > 0)
			return false;
		return true;
	}
	
	public void TAT(Process process[]) 
	{
		System.out.println("Turn Arround Time Time for Each process");

		for(int i = 0; i < process.length; i++)
		{
			process[i].TurnArroundTime = process[i].completionTime - process[i].ArrivalTime;
			System.out.println(process[i].name +" = "+process[i].TurnArroundTime);

		}
		System.out.println("\n");

	}
	
	public void WaitTime(Process process[]) 
	{
		System.out.println("Waiting Time for Each process");
		for(int i = 0; i < process.length; i++)
		{
			process[i].WaitingTime = process[i].TurnArroundTime - process[i].TempBT;
			System.out.println(process[i].name +" = "+process[i].WaitingTime);
		}
		System.out.println("\n");
	}
	
	public float AVGTurnArrTime(Process process[]) 
	{
		float sum = 0;
		for(int i = 0; i < process.length; i++)
		{
			sum +=  process[i].TurnArroundTime;
		}
		sum /= process.length;
		
		return sum;
	}
	
	public float AVGWaitTime(Process process[]) 
	{
		float sum = 0;
		for(int i = 0; i < process.length; i++)
		{
			sum +=  process[i].WaitingTime;
		}
		sum /= process.length;
		return sum;
	}
}
