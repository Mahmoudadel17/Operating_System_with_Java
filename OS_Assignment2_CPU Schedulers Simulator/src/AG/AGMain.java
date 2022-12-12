package AG;

import java.util.Arrays;
import java.util.Scanner;


public class AGMain {
	
	public static void Input() 
	{	
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter number of process :-");
		int n = input.nextInt();
		
		String name;
		int Arrival;
		int Brust;
		int Priority;
		int Quntam;
		
		Process process[] = new Process[n];
		
		
		for(int i = 0; i < n;i++)
		{
			input.nextLine();
			
			System.out.println("Please enter Name , Arrival Time , Brust Time, Priority Time, Quntam Time of process "+i+":-");
			name = input.next();
			Arrival = input.nextInt();
			Brust = input.nextInt();
			Priority = input.nextInt();
			Quntam = input.nextInt();
			
			process[i] = new Process(name, Arrival, Brust, Priority, Quntam);
		}
		
		Arrays.sort(process);

		AG obj = new AG();
		obj.simulation(process);
		
		
	}


}
