package AG;

public class Process implements Comparable<Process>
{
	String name;
	int ArrivalTime;
	int BurstTime;
	int TempAT;
	int TempBT;
	int PriorityTime;
	int QuantumTime;
	int completionTime;
	int WaitingTime;
	int TurnArroundTime;
	
	public Process(String name,int AT,int BT,int PT,int QT) 
	{
		this.name = name;
		this.ArrivalTime = AT;
		this.BurstTime = BT;
		this.PriorityTime = PT;
		this.QuantumTime = QT;
		this.TempAT = AT;
		this.TempBT = BT;
	}

	
	public int getArrivalTime() 
	{


		return ArrivalTime;
	}


	@Override
	public int compareTo(Process o) {
		// TODO Auto-generated method stub
		return this.ArrivalTime - o.ArrivalTime;
	}
	


	
}
