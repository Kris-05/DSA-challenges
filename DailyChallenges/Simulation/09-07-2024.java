//1701. Average Waiting Time

/*
There is a restaurant with a single chef. You are given an array customers, where customers[i] = [arrivali, timei]:

When a customer arrives, he gives the chef his order, and the chef starts preparing it once he is idle. The customer waits till the chef finishes preparing his order.
The chef does not prepare food for more than one customer at a time. The chef prepares food for customers in the order they were given in the input.

Input: customers = [[1,2],[2,5],[4,3]]
Output: 5.00000

Return the average waiting time of all customers. Solutions within 10-5 from the actual answer are considered accepted.
*/

class Solution {
    public double averageWaitingTime(int[][] customers) {
        double waitingTime = 0;
        int startTime = 0;                     // Starting Time of CPU scheduling

        for(int[] ele : customers){
            int arrival = ele[0];              // Arrival time in CPU scheduling
            int burst = ele[1];                // Burst time in CPU scheduling
            if(startTime < arrival)
                startTime = arrival;          // checks whether there is a stall or CPU stays idle
            waitingTime += (startTime - arrival + burst);
            startTime += burst;
        }
        
        return waitingTime / customers.length;  // average WT
    }
}
