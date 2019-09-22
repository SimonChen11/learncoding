import java.util.*;

class ReorderLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        
        if (logs == null || logs.length == 0) {
            return new String[0];
        }
        
        HashMap<String, Integer> sequence = new HashMap<>();
        
        for (int i = 0; i < logs.length; i++)
            sequence.put(logs[i], i);
    
        Arrays.sort(logs, (x, y) -> {
            Result a = parse(x);
            Result b = parse(y);
            
            if (!a.isDigit && !b.isDigit) {
                int compareResult = a.rest.compareTo(b.rest);
                if (compareResult == 0) {
                    return a.identifier.compareTo(b.identifier);
                } else {
                    return compareResult;
                }
            } else if (a.isDigit && b.isDigit) {
                return sequence.get(x) - sequence.get(y);
            } else {
                
                if (a.isDigit) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        return logs;
    }

    static class Result {
        boolean isDigit;
        String identifier;
        String rest;
        public Result(boolean isDigit, String identifier, String rest) {
            this.isDigit = isDigit;
            this.identifier = identifier;
            this.rest = rest;
        }
    }

    public Result parse(String input) {
        int firstIndex = input.indexOf(' ');
        
        String identifier = input.substring(0, firstIndex);
        String rest = input.substring(firstIndex + 1);
        
        boolean isDigit = Character.isDigit(rest.charAt(0));
        
        return new Result(isDigit, identifier, rest);
    }
}