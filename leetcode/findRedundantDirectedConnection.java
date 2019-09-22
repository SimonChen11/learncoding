import java.io.*;

class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        // case 1: two parents, 
        // case 2: cycle, no two parents
        // cas3 3: two parents and cycle
        
        Map<Integer, Integer> reverseMap = new HashMap<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        int[] candiate = new int[2];
//        int[] candiate1 = new int[2];
        boolean hasTwoParents = false;
        
        for (int[] edge : edges) {
            if (reverseMap.containsKey(edge[1])) {
                hasTwoParents = true;
                candiate = new int[] {edge[0], edge[1]};
                // candiate1 = new int[] {reverseMap.get(edge[0]), edge[1]};
                edge[0] = -1;
                edge[1] = -1;
            } else {
                reverseMap.put(edge[1], edge[0]);
            }
        }
        
        for (int[] pair : edges) {
            if (pair[0] != -1) {
                map.put(pair[0], map.getOrDefault(pair[0], new ArrayList<Integer>()).add(pair[1]));
                
                int[] cycle = findCycle(map, new HashSet<Integer>(), pair[0]);
                
                if (cycle != null) {
                    return hasTwoParents ? candiate : pair;
                }
                
            }
        }
        
        return candiate;
    }
    
    int[] findCycle(HashMap<Integer, List<Integer>> graph, Set<Integer> stack, Integer startPoint) {
      
        stack.add(startPoint);
        
        int[] result;
        
        if (graph.containsKey(startPoint)) {
            for(Integer child : graph.get(startPoint)) {
                if (stack.contains(child)) {
                    result = new int[] {startPoint, child};
                    break;
                } else {
                    result = findCycle(graph, visited, stack, child);
                    if (result != null) {
                        break;
                    }
                }
            }
        }
        
        stack.remove(startPoint);
        
        return result;
    }
}


public class findRedundantDirectedConnection {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static int[][] stringToInt2dArray(String input) {
        JsonArray jsonArray = JsonArray.readFrom(input);
        if (jsonArray.size() == 0) {
          return new int[0][0];
        }
    
        int[][] arr = new int[jsonArray.size()][];
        for (int i = 0; i < arr.length; i++) {
          JsonArray cols = jsonArray.get(i).asArray();
          arr[i] = stringToIntegerArray(cols.toString());
        }
        return arr;
    }
    
    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }
    
        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    
    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[][] edges = stringToInt2dArray(line);
            
            int[] ret = new Solution().findRedundantDirectedConnection(edges);
            
            String out = integerArrayToString(ret);
            
            System.out.print(out);
        }
    }
}