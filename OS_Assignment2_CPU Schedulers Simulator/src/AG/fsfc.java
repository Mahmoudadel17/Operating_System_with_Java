package AG;

public class fsfc {
	
	public static int i = -1;
	
	public static int getMin(Process inputArray[])
	{
		    int GCT = getMax(inputArray);
		    int minValue = inputArray[0].ArrivalTime; 
		    int mini = 0;
		    for(int i=1;i<inputArray.length;i++)
		    { 
		      if(inputArray[i].ArrivalTime < minValue && inputArray[i].ArrivalTime <= GCT && inputArray[i].BurstTime > 0)
		      { 
		        minValue = inputArray[i].ArrivalTime;
		        mini = i;
		        
		      } 
		    } 
		    return mini; 
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
	
	
	public static int simulation(Process process[]) 
	{
		int index;
		
		if(i == -1)
		{
			index = getMin(process);
		}
		else 
		{
			index = i;
		}
		
		AG.list.add(process[index].name);
		
		int GCT = getMax(process);
		
		if(process[index].BurstTime < Math.ceil(process[index].QuantumTime*0.25))
		{
			process[index].completionTime = (int) ((int) GCT + process[index].BurstTime);
			process[index].BurstTime -= process[index].BurstTime;
		}
		else 
		{
			process[index].completionTime = (int) ((int) GCT + Math.ceil(process[index].QuantumTime*0.25));
			process[index].BurstTime -= Math.ceil(process[index].QuantumTime*0.25);
		}
		


		i = -1;
		
		return index;
	}
}	
