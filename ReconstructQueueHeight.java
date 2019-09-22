import java.util.*;

class ReconstructQueueHeight {
        public int[][] reconstructQueue(int[][] people) {
        // brute force
        Arrays.sort(people, (x, y) -> x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]);

        for(int[] num : people) {

            System.out.println(Arrays.toString(num));
        }

        int[][] result = new int[people.length][people[0].length];
        
        for (int i = 0; i < people.length; i ++) {
            
            int j = 0;
            int k = 0;
            while(j < people[i][1]) {
                if (result[k][0] == 0 || result[k][0] == people[i][0]) {
                    j++;
                }

                k++;
            }

            System.out.println("k: " + k);
            
            while(result[k][0] != 0) {
                k++;
            }

            System.out.println("k: " + k + " i:" + i);
            
            result[k] = people[i];
        }
        
        
        return result;
    }

    public static void main(String[] args) {
        ReconstructQueueHeight sol = new ReconstructQueueHeight();
        int[][] result = sol.reconstructQueue(new int[][] {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}});

                for(int[] num : result) {

            System.out.println(Arrays.toString(num));
        }
    }
}