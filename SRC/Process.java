
public class Process {
	
	public int PID;
	public int ArrivalTime;
	public int ServiceTime;
	public int BurstTime;
	public int CompletionTime;
	
	public Process(int PID, int ArrivalTime, int BurstTime) {
		this.PID = PID;
		this.ArrivalTime = ArrivalTime;
		this.BurstTime = BurstTime;
		this.ServiceTime = 0;
	}

}
