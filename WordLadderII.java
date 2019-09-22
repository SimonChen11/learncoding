class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        if (!wordSet.contains(endWord)) return res;
        Map<String, Set<String>> map = new HashMap<>();
        getChildren(beginWord, endWord, wordSet, map);
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        getLadders(beginWord, endWord, map, path, res);
        return res;
    }
    
    private void getLadders(String beginWord, String endWord, Map<String, Set<String>> map, List<String> path, List<List<String>> res) {
        if (path.size() > 0 && path.get(path.size() - 1).equals(endWord)) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (!map.containsKey(beginWord)) return;
        for (String next: map.get(beginWord)) {
            path.add(next);
            getLadders(next, endWord, map, path, res);
            path.remove(path.size() - 1);
        }
        return;
    }
    
    private void getChildren(String beginWord, String endWord, Set<String> wordSet, Map<String, Set<String>> map) {
        Set<String> begin = new HashSet<String>();
        Set<String> end = new HashSet<String>();
        Set<String> visited = new HashSet<String>();
        begin.add(beginWord);
        end.add(endWord);
        boolean found = false, isBackward = false;
        while (found == false && !begin.isEmpty()) {
            if (begin.size() > end.size()) {
                Set<String> temp = begin;
                begin = end;
                end = temp;
                isBackward = !isBackward;
            }
            Set<String> temp = new HashSet<>();
            for (String word: begin) {
                visited.add(word);
                for (String next: getNext(word, wordSet)) {
                    if (end.contains(next)) found = true;
                    if (begin.contains(next) || visited.contains(next)) continue;
                    String parent = (isBackward) ? next: word;
                    String child = (isBackward)? word: next;
                    if (!map.containsKey(parent)) map.put(parent, new HashSet<>());
                    map.get(parent).add(child);
                    temp.add(next);
                }
            }
            begin = temp;
        }
    }
    private List<String> getNext(String word, Set<String> wordSet) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            StringBuilder sb = new StringBuilder(word);
            for (char ch = 'a'; ch <= 'z'; ch++) {
                sb.setCharAt(i, ch);
                if (wordSet.contains(sb.toString())) res.add(sb.toString());
            }
        }
        return res;
    }
}