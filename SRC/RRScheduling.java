import java.io.*;
import java.util.*;
public class RRScheduling {

	public static void main(String[] args) throws IOException {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please enter the path to the processes text file.");
		
		String path = in.nextLine();
		
		System.out.println("Please enter the time quantum.");
		
		int tq = in.nextInt();
		
		System.out.println();
		
		Scanner inputStream = new Scanner(new File(path));
		
		inputStream.useDelimiter("(,|\\v+)");
		inputStream.nextLine();
		
		ArrayList<Process> CSVFile = new ArrayList<>();
		
		while(inputStream.hasNext()) {
			Process process = new Process(inputStream.nextInt(), inputStream.nextInt(), inputStream.nextInt());
			CSVFile.add(process);
		}
		
		RRScheduler scheduler = new RRScheduler(CSVFile, tq);
		scheduler.RoundRobin();
		in.close();
		inputStream.close();

	}

}
