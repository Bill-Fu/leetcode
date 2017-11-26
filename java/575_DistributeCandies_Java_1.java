class Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < candies.length; ++i) {
            set.add(candies[i]);
        }
        
        return set.size() > candies.length / 2 ? candies.length / 2 : set.size();
    }
}
