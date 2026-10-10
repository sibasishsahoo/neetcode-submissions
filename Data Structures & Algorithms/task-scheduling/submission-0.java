class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[]freq = new int[26];
        for(char task:tasks){
            freq[task-'A']++;
        }
        PriorityQueue<Integer>pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int count:freq){
            if(count>0){
                pq.offer(count);
            }
        }
        int time = 0;
        while(!pq.isEmpty()){
           List<Integer>remain = new ArrayList<>();
           int cycle = n+1;
           while(!pq.isEmpty() && cycle>0){
               int count = pq.poll();
               if(count>1){
                 remain.add(count-1);
               }
               cycle--;
               time++;
           }
          for(int count:remain){
            pq.offer(count);
          }
          if(!pq.isEmpty()){
            time+=cycle;
          }
        }
        return time;
    }
}
