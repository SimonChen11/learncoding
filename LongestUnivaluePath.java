/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

public class LongestUnivaluePath {
    public int longestUnivaluePath(TreeNode root) {
        Pair result =  longestPath(root);
        //System.out.println(result.longest + " " + result.longestIncluding);
        return result.longest - 1;
        
        //
        //
        //  3
        // 1 1
        //1 2
    }
    
    public Pair longestPath(TreeNode root) {
        if (root == null) {
            return new Pair(0, 0);
        }
        
        Pair left = longestPath(root.left);
        Pair right = longestPath(root.right);

        if (root.right != null) {
            System.out.println(right.longestIncluding);
        }
        
        int longestIncluding = 1;
        int longest = 1;
        
        if (root.left != null && root.right != null) {
            int bigger = 0;
            if (root.left.val == root.val) {
                longest += left.longestIncluding;
                bigger = left.longestIncluding;
            }
            
            if (root.right.val == root.val) {
               //                  System.out.println(root.val);

                longest += right.longestIncluding;
                bigger = Math.max(bigger, right.longestIncluding);
            }
            
            
            longestIncluding += bigger;
            
        } else if (root.left != null) {
            
            if (root.left.val == root.val) {
                longest += left.longestIncluding;
                longestIncluding += left.longestIncluding;
            }
            
        } else if (root.right != null){
            
             if (root.right.val == root.val) {
                System.out.println("here " + right.longestIncluding);


                longest += right.longestIncluding;
                longestIncluding += right.longestIncluding;
            }
        }
        
        longest = Math.max(right.longest, Math.max(longest, left.longest));
        System.out.println(longest + " " + longestIncluding);

        
        return new Pair(longest, longestIncluding);
    }
    
    
    class Pair {
        int longest;
        int longestIncluding;
        Pair(int longest, int longestIncluding) {
            this.longest = longest;
            this.longestIncluding = longestIncluding;
        }
    }

    public static void main(String[] args) {
    	LongestUnivaluePath sol = new LongestUnivaluePath();
        TreeNode node = new TreeNode(5);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(5);
        node.right = node1;
        node1.right = node2;

        System.out.println(sol.longestUnivaluePath(node));

    }
}