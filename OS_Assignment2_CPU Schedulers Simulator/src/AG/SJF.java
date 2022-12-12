package AG;

public class SJF 
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
		

		for(int i = 0 ; i < Math.ceil(process[index].QuantumTime*0.5);i++)
		{
			if(process[index].BurstTime < Math.ceil(process[index].QuantumTime*0.5))
			{
				process[index].completionTime = (int) ((int) GCT + process[index].BurstTime);
				process[index].BurstTime -= process[index].BurstTime;
				break;
			}
			else 
			{
				process[index].completionTime = (int) ((int) GCT + 1);
				process[index].BurstTime -= 1;
			}
			
			if(AG.CheckSJF(process) && index != AG.index)
			{
				fsfc.i = AG.index;
				process[index].QuantumTime += (process[index].QuantumTime - (Math.ceil(process[index].QuantumTime*0.50)-Math.ceil(process[index].QuantumTime*0.25)) - Math.ceil(process[index].QuantumTime*0.25)); 

				break;
			}
		}

		

		return index;
	}
}
