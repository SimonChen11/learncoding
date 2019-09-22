import java.util.*;

class FourSum {

    public static void main(String[] args) {
        FourSum sol = new FourSum();
        sol.fourSum(new int[] {-493,-470,-464,-453,-451,-446,-445,-407,-406,-393,-328,-312,-307,-303,-259,-253,-252,-243,-221,-193,-126,-126,-122,-117,-106,-105,-101,-71,-20,-12,3,4,20,20,54,84,98,111,148,149,152,171,175,176,211,218,227,331,352,389,410,420,448,485
}, 1057);

    }


    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        if (nums.length < 4) {
            return new ArrayList<List<Integer>>();
        }
        
        HashMap<Integer, List<Pair>> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                
                map.put(sum, map.getOrDefault(sum, new ArrayList<>()));
                map.get(sum).add(new Pair(i, j));
            }
        
        
        List<List<Integer>> result = new ArrayList<>();
        
        for(Map.Entry<Integer, List<Pair>> entry : map.entrySet()) {
            
            if (map.containsKey(target - entry.getKey())) {
                
                for (Pair left : entry.getValue()) {
                    
                    for (Pair right: map.get(target - entry.getKey())) {
                        
                        if (left.left != right.left && left.left != right.right &&
                           left.right != right.left && left.right != right.right) {
                            List<Integer> part = new ArrayList<>();
                            
                            part.add(nums[left.left]);
                            part.add(nums[left.right]);
                            part.add(nums[right.left]);
                            part.add(nums[right.right]);
                            
                            Collections.sort(part);
                            
                            result.add(part);
                        }
                    }
                }
            }
        }
        
        Collections.sort(result, (x, y) -> {
            if (x.get(0) != y.get(0))
                return x.get(0) - y.get(0);
            
            if (x.get(1) != y.get(1)) {
                return x.get(1) - y.get(1);
            }
            
            if (x.get(2) != y.get(2)) {
                return x.get(2) - y.get(2);
            }
            
            return x.get(3) - y.get(3);
            
        });


        List<List<Integer>> dedup = new ArrayList<>();
            
        for (List<Integer> item : result) {
            System.out.println(Arrays.toString(item.toArray()));


            if (dedup.size() == 0 || !dedup.get(dedup.size() -1).equals(item)) {
                dedup.add(item);
            }
            
        }
            
        
        return dedup;
    }
    
    static class Pair {
        int left;
        int right;
        
        Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}