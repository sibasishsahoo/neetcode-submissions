class Solution {
    public boolean checkInclusion(String s1, String s2) {
       int m = s1.length();
       int n = s2.length(); 
       int left = 0;
       int[]s1count = new int[26];
       int[]windcount = new int[26];
       if(m>n){
        return false;
       }
       for(int i = 0;i<m;i++){
        s1count[s1.charAt(i)-'a']++;
       }
       for(int right = 0;right<n;right++){
        windcount[s2.charAt(right)-'a']++;
        if(right-left+1 > m){
            windcount[s2.charAt(left)-'a']--;
            left++;
        }
        if(Arrays.equals(s1count,windcount)){
            return true;
        }
       }
       return false;
    }
}
