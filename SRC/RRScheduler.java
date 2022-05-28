import java.util.*;
public class RRScheduler {
	
	public int timer;
	public int timeQuantum;
	public int contextSwitch;
	public int counter;
	
	ArrayList<Process> ProcessesList;
	ArrayList<Process> ReadyQueue;
	ArrayList<Process> EndProcesses;
	Process CPU;
	
	public RRScheduler(ArrayList<Process> ProcessesList, int TimeQuantum) {
		timeQuantum = TimeQuantum;
		this.ProcessesList = ProcessesList;
	}
	
	public void RoundRobin() {
		timer = 0;
		contextSwitch = 0;
		ReadyQueue = new ArrayList<>();
		EndProcesses = new ArrayList<>();
		CPU = null;
		
		while(!ReadyQueue.isEmpty() || !ProcessesList.isEmpty() || CPU != null) {
			
			for(int i = 0; i < ProcessesList.size(); i++) {
				
				if(ProcessesList.get(i).ArrivalTime == timer) {
					ReadyQueue.add(ProcessesList.remove(i));
				}
				
			}
			
			if(CPU == null) {
				CPU = ReadyQueue.remove(0);
			}
			
			counter++;
			CPU.ServiceTime++;
			
			if(CPU.BurstTime == CPU.ServiceTime) {
				CPU.CompletionTime = timer;
				EndProcesses.add(CPU);
				CPU = null;
				contextSwitch++;
				counter = 0;
			}
			
			else if(counter == timeQuantum) {
				ReadyQueue.add(CPU);
				CPU = null;
				contextSwitch++;
				counter = 0;
			}
			
			timer++;
			
			double sumTurnAroundTime = 0.0;
			double sumWaitingTime = 0.0;
			double sumUtil = 0.0;
			
			for(int j = 0; j < EndProcesses.size(); j++) {
				sumTurnAroundTime += EndProcesses.get(j).CompletionTime - EndProcesses.get(j).ArrivalTime;
				sumWaitingTime += (EndProcesses.get(j).CompletionTime - EndProcesses.get(j).ArrivalTime) 
						- EndProcesses.get(j).BurstTime;
				sumUtil += EndProcesses.get(j).BurstTime;
			}
			
			double AvgTurnAroundTime = sumTurnAroundTime / EndProcesses.size();
			double AvgWaitingTime = sumWaitingTime / EndProcesses.size();
			double CPUUtilization = (sumUtil - (contextSwitch * 0.01)) / timer;
			double Throughput = (double) EndProcesses.size() / timer;
			
			System.out.println();
			System.out.println("CPU Utilization: " + CPUUtilization);
			System.out.println("Throughput: " + Throughput);
			System.out.println("Average Waiting Time: " + AvgWaitingTime);
			System.out.println("Average Turnaround Time: " + AvgTurnAroundTime);
			
		}
		
	}
	
	
	

}
