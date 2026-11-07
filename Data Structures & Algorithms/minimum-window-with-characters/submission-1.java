class Solution {
    public String minWindow(String s, String t) {
       int[]need = new int[128];
       int[]window = new int[128];
       if(t.length()>s.length()){
        return "";
       } 
       int required = 0;
       for(char ch:t.toCharArray()){
        need[ch]++;
       }
       for(int i =0;i<128;i++){
        if(need[i]>0){
            required++;
        }
       }
       int formed = 0;
       int minlength = Integer.MAX_VALUE;
       int left = 0;
       int start = 0;
       for(int right = 0;right<s.length();right++){
         char c = s.charAt(right);
         window[c]++;
         if(need[c]>0 && need[c]==window[c]){
            formed++;
         }
         while(required == formed){
            if(right-left+1<minlength){
                minlength = right-left+1;
                start = left;
            }
            char leftchar = s.charAt(left);
            window[leftchar]--;
            if(need[leftchar]>0 && need[leftchar]>window[leftchar]){
                formed --;
            }
            left++;
         }
         
       }
       return minlength == Integer.MAX_VALUE ? "": s.substring(start,start+minlength);
    }
}
