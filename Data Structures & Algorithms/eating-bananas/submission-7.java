class Solution {
    public int minEatingSpeed(int[] piles, int h) {
      int low = 1;
      int high = 0;
      for(int pile:piles){
        high = Math.max(high,pile);
      }
      while(low<=high){
        int mid = low+(high-low)/2;
        if(Eattime(piles,h,mid)){
            high = mid-1;
        }else{
            low = mid+1;
        }
      }
      return low;
    }
}
private boolean Eattime(int[]piles,int h,int mid){
    long hour = 0;
    for(int pile:piles){
        hour += (pile+mid-1)/mid;
    }
    return hour<=h;
}