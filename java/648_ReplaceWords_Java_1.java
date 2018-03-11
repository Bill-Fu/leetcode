class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        String result = "";
        Tier root = new Tier();
        
        for (String str: dict) {
            root.add(str);
        }
        
        for (String str: sentence.split("\\s+")) {
            result += root.find(str) + " ";
        }
        
        return result.substring(0, result.length() - 1);
    }
}

class Tier {
    Map<Character, Tier> map;
    boolean isWord;
    
    public Tier() {
        map = new HashMap<>();
        isWord = false;
    }
    
    public void add(String word) {
        if (word.equals("")) {
            this.isWord = true;
        }
        else {
            if (map.containsKey(word.charAt(0)) == false) {
                map.put(word.charAt(0), new Tier());
            }
            
            map.get(word.charAt(0)).add(word.substring(1, word.length()));
        }
    }
    
    public String find(String word) {
        if (isWord == true || word.equals("")) {
            return "";
        }
        else if (map.containsKey(word.charAt(0))) {
            return word.charAt(0) + map.get(word.charAt(0)).find(word.substring(1, word.length()));
        }
        else {
            return word;
        }
    }
}
