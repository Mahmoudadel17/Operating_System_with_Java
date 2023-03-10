# Operating_System_with_Java

                                                      Assignment 1
# i) Threads

Given N numbers and one file, our system simulates a real-life of how
buffering is run where a user will decide N to get the prime numbers from
0 to N. Somehow, the producer schedules the primes in a queue and
consumer will use this queue to write them in the file, so do an
application using multiple threads to do multiple actions simultaneously
which will reduce the time elapsed.

Note: The Consumer thread will hold a lock when it start and release it when the
ready queue is Empty and must notify all other threads.

                                                      Assignment 2
# ii) CPU Schedulers Simulator

Write a java program to simulate the following schedulers:

1) preemptive Shortest- Job First (SJF) Scheduling with context switching

2) Round Robin (RR) with context switching

3) preemptive Priority Scheduling (with the solving of starvation problem)
4) AG Scheduling :

    a) Each process is provided a static time to execute called quantum.

    b) Once a process is executed for given time period, it’s called FCFS till the finishing of (ceil(52%)) of its Quantum time then it’s converted to nonpreemptive Priority till the finishing of the next (ceil(52%)), after that it’s converted to preemptive Shortest- Job First (SJF). 

    c. We have 3 scenarios of the running process

            i. The running process used all its quantum time and it still have job to do (add this process to the end of the queue, then increases its Quantum time by Two).

            ii. The running process was execute as non-preemptive Priority and didn’t use all its quantum time based on another process converted from ready to running (add this process to the end of the queue, and then increase its Quantum time by ceil(the remaining Quantum time/2) ).

            iii. The running process was execute as preemptive Shortest- Job First (SJF) and didn’t use all its quantum time based on another process converted from ready to running (add this process to the end of the queue, and then increase its Quantum time by the remaining Quantum time).

            iv. The running process didn’t use all of its quantum time because it’s no longer need that time and the job was completed (set it’s quantum time to zero).



                                                       Assignment 3
# iii) Processes Allocation Management

You will develop a memory allocation simulator to allocate
variable-sized partitions of the memory to a given sequence of
processes requests. Apply different allocation policies:

1) First-Fit policy.
2) Best-Fit policy.
3) Worst-Fit policy.

Add compaction (as option for the user): in compaction you shuffle
the memory contents so as to place all free memory together in one
large block.

Input will be as follows:
- Number of partition
- Partition name and its size.
- Number of process requests.
- Process name and its size.
- Selected policy by the user.



## Authors

- [@Mahmoudadel17](https://www.github.com/Mahmoudadel17)
