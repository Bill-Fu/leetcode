class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        String result = "";
        int[] licenseVec = licenseVecGen(licensePlate);
        
        for (int i = 0; i < words.length; ++i) {
            if (result.equals("") == true || (result.length() > words[i].length())) {
                if (cmpVect(licenseVec, wordVecGen(words[i])) == true) {
                    result = words[i];
                }
            }
        }
        
        return result;
    }
    
    public int[] licenseVecGen(String licensePlate) {
        int[] licenseVec = new int[26];
        
        for (char c: licensePlate.toCharArray()) {
            if (c - 'a' >= 0 && c - 'a' < 26) {
                licenseVec[c - 'a']++;
            }
            else if (c - 'A' >= 0 && c - 'A' < 26) {
                licenseVec[c - 'A']++;
            }
        }
        
        return licenseVec;
    }
    
    public int[] wordVecGen(String word) {
        int[] wordVec = new int[26];
        
        for (char c: word.toCharArray()) {
            wordVec[c - 'a']++;
        }
        
        return wordVec;
    }
    
    public boolean cmpVect(int[] licenseVec, int[] wordVec) {
        for (int i = 0; i < 26; ++i) {
            if (licenseVec[i] > wordVec[i]) {
                return false;
            }
        }
        
        return true;
    }
}
