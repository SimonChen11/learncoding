import java.util.*;
class NumRescueBoats {
    public int numRescueBoats(int[] people, int limit) {
       // each boat at most 2
       // treemap
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for (int item : people) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        
        int count = 0;
        while(map.size() != 0) {
            
            Map.Entry<Integer, Integer> first = map.firstEntry();
            
            if (first.getValue() == 1) {
                map.remove(first.getKey());
            } else {
                map.put(first.getKey(), first.getValue() - 1);
            }
            
            Map.Entry<Integer, Integer> ceiling = map.floorEntry(limit - first.getKey());
            
            count ++;
            
            if (ceiling != null) {
                 if (ceiling.getValue() == 1) {
                    map.remove(ceiling.getKey());
                } else {
                    map.put(ceiling.getKey(), ceiling.getValue() - 1);
                }
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        NumRescueBoats sol = new NumRescueBoats();
        System.out.println(sol.numRescueBoats(new int[] {1, 3,1,4}, 4));
    }
}