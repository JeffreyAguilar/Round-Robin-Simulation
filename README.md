# Round Robin CPU Scheduling Project

The program is used to generate a schedule of processes. The processes are stored in a plaintext file. The program accepts two parameters. The 
first parameter is the path of the processes file. The second parameter is the time quantum. 

The simulation includes the following:

Clock: timestamps all events for processes, such as creation time, completion time, 
etc.

Process Creator: creates processes at arrival time

CPU: runs processes for a time slice (time quantum)

Queue: FIFO ready queue used by both the process creator and CPU

Process Arrival Time: arrival time of new processes into the ready queue

Process Service Time: amount of time required by the processes to complete execution

Time Quantum: time each process can spend in the CPU, before it is removed

Context Switch: number of times a process is switched

The program then prints out the following performance evaluation criteria:

CPU Utilization
Throughput
Average Waiting Time
Average Turnaround Time
