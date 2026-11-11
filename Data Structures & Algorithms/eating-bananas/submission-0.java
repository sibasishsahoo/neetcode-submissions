class Solution {
    public int minEatingSpeed(int[] piles, int h) {
       int low = 1;
       int high = 0;
       for(int pile:piles){
        high = Math.max(high,pile);
       }
       while(low<high){
        int mid = low + (high-low)/2;
        if(canEat(piles,h,mid)){
            high = mid;
        }else{
            low = mid+1;
        }
       }
       return low;
    }
    public static boolean canEat(int[]piles,int h,int k){
        int hour = 0;
       for(int pile:piles){
        hour += (pile+k-1)/k;
        
       }
       return hour<=h;
    }
}