package AG;

public class NonPrePriority 
{
	public static int index = -1;
	
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
		
		
		AG.list.add(process[index].name);
		int GCT = getMax(process);

//		System.out.println(GCT);

		
		if(process[index].BurstTime < (Math.ceil(process[index].QuantumTime*0.50)- Math.ceil(process[index].QuantumTime*0.25)))
		{
			process[index].completionTime = (int) ((int) GCT + process[index].BurstTime);
			process[index].BurstTime -= process[index].BurstTime;
		}
		else 
		{
			process[index].completionTime = (int) (GCT + (Math.ceil(process[index].QuantumTime*0.50)-(Math.ceil(process[index].QuantumTime*0.25))));
			process[index].BurstTime -= (Math.ceil(process[index].QuantumTime*0.50)- Math.ceil(process[index].QuantumTime*0.25));
		}


		return index;
	}
}
