package greedy;

import java.util.*;

public class JobSchedulingProblems {

    public static void main(String[] args) {
        int[] deadline={2, 1, 2, 1, 1};
        int[] profit = {100, 19, 27, 25, 15};
        System.out.println(jobSequencing(deadline,profit));
    }

    public static ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        int n = deadline.length;

        Jobs[] jobs = new Jobs[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Jobs(deadline[i],profit[i]);
        }

        Arrays.sort(jobs,(a,b) ->
                Integer.compare(b.profit, a.profit));

        int maxDeadline = 0;
        for (int d : deadline) {
            maxDeadline = Math.max(d,maxDeadline);
        }

        boolean[] slots = new boolean[maxDeadline+1];

        int count = 0;
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            for (int j =jobs[i].deadlines; j > 0 ; j--) {

                if(!slots[j]){
                    slots[j] = true;
                    count++;
                    maxProfit += jobs[i].profit;
                    break;
                }

            }

        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(count);
        ans.add(maxProfit);
        return ans;
    }
    //this solution with heap
    public static ArrayList<Integer> jobSequencing2(int[] deadline, int[] profit) {
        // code here
        int n = deadline.length;

        Jobs[] jobs = new Jobs[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Jobs(deadline[i],profit[i]);
        }

        Arrays.sort(jobs,(a,b) ->
                Integer.compare(a.deadlines, b.deadlines));

        //min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(Jobs job : jobs){
            pq.add(job.profit);

            if(pq.size() > job.deadlines){
                pq.poll();
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(pq.size());
        int maxProfit = 0;
        while(!pq.isEmpty()){
            maxProfit += pq.poll();
        }
        ans.add(maxProfit);
        return ans;
    }

}
class Jobs{

    int deadlines;
    int profit;

    Jobs(int deadlines,int profit){
        this.deadlines = deadlines;
        this.profit = profit;
    }

}

