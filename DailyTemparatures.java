
import java.util.*;

class DailyTemparatures {

    public int[] dailyTemperatures(int[] T) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        int[] result = new int[T.length];
        
        for(int i = 0; i < T.length; i++) {
            while(stack.size() > 0) {
                int top = stack.peek();

                System.out.println("top " + top);
                
                if(T[top] >= T[i]) {
                    stack.push(i);
                    break;
                } else {
                    result[top] = i - top;
                    stack.pop();
                }
            }
            
            if (stack.size() == 0) {
                stack.push(i);
            }
        }
        
        while(stack.size() > 0) {
            result[stack.pop()] = 0;
        }
        
        return result;
    }

 public static void main(String[] args) {
 	DailyTemparatures sol = new DailyTemparatures();

 	System.out.println(Arrays.toString(sol.dailyTemperatures(new int[] {3, 1, 4,3})));
 }
}

