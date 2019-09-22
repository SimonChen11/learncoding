class NumDistinct {
    public static int numDistinct(String s, String t) {
        int[][] count = new int[s.length() + 1][t.length() + 1];
       
        
        //bag t
        //babgbag s
        
        // 4
        count[0][0] = 1;

        for (int i = 1; i <= t.length(); i++) {
            
            int sum = 0;
            
            for (int j = i; j <= s.length(); j++) {
                
                if (s.charAt(j - 1) == t.charAt(i - 1)) {
                    sum += count[j-1][i-1];
                }
                
                count[j][i] = sum;
                System.out.print(sum + " ");
            }

            System.out.println("");

        }
        
        return count[s.length()][t.length()];
    }

    public static void main(String[] args) {
        System.out.println(numDistinct("babgbag", "bag"));
    }
}