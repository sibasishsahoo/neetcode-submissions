class TimeMap {
    HashMap<String,List<String>>values;
    HashMap<String,List<Integer>>timestamps;

    public TimeMap() {
        values = new HashMap<>();
        timestamps = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        values.putIfAbsent(key,new ArrayList<>());
        timestamps.putIfAbsent(key,new ArrayList<>());
        values.get(key).add(value);
        timestamps.get(key).add(timestamp);
        
    }
    
    public String get(String key, int timestamp) {
        if(!values.containsKey(key)){
            return "";
        }
        List<Integer>timelist = timestamps.get(key);
        List<String>valuelist = values.get(key);
        int left = 0;
        int right = timelist.size()-1;
        int ans = -1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(timelist.get(mid)<=timestamp){
                ans = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        } 
        if(ans == -1){
            return "";
        }
        return valuelist.get(ans);
    }
}
