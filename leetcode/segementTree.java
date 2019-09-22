class NumArray {
    
    SegmentTree tree;

    public NumArray(int[] nums) {
        tree = new SegmentTree(nums);
    }
    
    public void update(int i, int val) {
        tree.update(i, val);
    }
    
    public int sumRange(int i, int j) {
        return tree.query(i, j);
    }
    
    private static class SegmentTree {
        Node root;
        int length;
        int[] nums;
        
        public SegmentTree(int[] nums) {
            root = buildNode(nums, 0, nums.length -1);
            length = nums.length;
            this.nums= nums;
        }
        
        public int query(int i, int j) {
            return query(i, j, root, 0, length - 1);
        }

        private int query(int i, int j, Node node, int left, int right) {
            if (node == null) {
                return 0;
            }
            
            if (i <= left && right <= j) {
                return node.sum;
            }
            
            if (j < left || i > right) {
                return 0;
            }
            
            return query(i, j, node.left, left, left + (right - left) /2)
                + query(i, j, node.right, left + (right - left) /2 + 1, right);
        }
        
        public void update(int i, int val) {
            update(root, val - nums[i], i, 0, length - 1);
            nums[i] = val;
        }
        
        private void update(Node node, int del, int i, int left, int right) {
            
                if (left > right || node == null) {
                    return;
                }
               
                node.sum += del;
            
            if ( left + (right - left) /2 >= i) {
                update(node.left, del, i, left, left + (right - left) /2);
            } else {
                update(node.right, del, i, left + (right - left) /2 + 1, right);
            }
        }
        
        
        private Node buildNode(int[] nums, int left, int right) {
            if (left == right) {
                Node newNode = new Node();
                newNode.sum = nums[left];
                return newNode;
            }
            
            if (left > right) {
                return null;
            }
            
            Node newNode = new Node();
            Node leftNode = buildNode(nums, left, left + (right - left) /2 );
            Node rightNode = buildNode(nums, left + (right - left) /2 + 1, right);
            newNode.left = leftNode;
            newNode.right = rightNode;
            newNode.sum = (newNode.left != null ? newNode.left.sum : 0) + (newNode.right != null ? newNode.right.sum : 0);
            return newNode;
        }
    
        private static class Node {
            public int sum;

            public Node left;
            public Node right;
        }   
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */