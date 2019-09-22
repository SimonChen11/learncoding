import java.util.*;

class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        // for every character, check its longest substring
        // O(n2)
        
       // left count> right 
       // left count < right 重新计数
        
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        char[] allChar = s.toCharArray();
        
        for(int i = 0; i < s.length(); i++) {
            // is it push and pop 
            // poll and offer peek

            System.out.println(allChar[i]);
            
            if (allChar[i] == ')') {
                if (stack.size() != 0) {
                    System.out.println("TOP " + allChar[stack.peekLast()]);
                }

                if (stack.size() != 0 && allChar[stack.peekLast()] == '(') {
                    stack.pollLast();

                } else {
                    stack.offerLast(i);
                }
            } else {
                
                stack.offerLast(i);
            }

            System.out.println(stack);
        }
        
        if (stack.size() == 0)
            return s.length();
        
        int max = 0;
        int b = allChar.length;
        
        System.out.println(stack);
        
        while(stack.size() != 0) {
            
            int result = stack.pollLast();
            
            max = Math.max(max, b- result - 1);
            
            b = result;
        }
        
        
        return max;
    }

    public static void main(String[] args) {
        LongestValidParentheses solution = new LongestValidParentheses();

        System.out.println(solution.longestValidParentheses(")()())"));
    }
}