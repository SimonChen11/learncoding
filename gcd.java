class gcd {
    public static String gcdOfStrings(String str1, String str2) {
        String max = "";
        
        if (str1 == null || str2 == null) return max;
        
        if (str2.length() > str1.length()) {
            String temp = str2;
            str2 = str1;
            str1 = temp;
        }
        
        // ABCABC ABC
        for(int i = 0; i < str2.length(); i++) {
            
            if (isDivided(str2, str2, i+1) && isDivided(str1, str2, i + 1)) max = str2.substring(0, i+1);
        }
        
        return max;
    }
    
    public static boolean isDivided(String str1, String str2, int length) {
        
        if (str1.length() % length != 0) return false;
        
        for (int i = 0; i < str1.length(); i += length) {
            
            for (int j = 0; j < length; j++) {
                
                if (str1.charAt(i + j) != str2.charAt(j)) return false;
            }
        }
        
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isDivided("ABC", "ABC", 3));

        //System.out.println(gcdOfStrings("ABCABC", "ABC"));

    }
}