class RandomizedSet {

    List<Integer> list;
    Set<Integer> set;
    int val, total;
    Random random;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        set = new HashSet<>();
        val = total = 0;
        random = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (set.add(val)){
            list.add(val);
            val++;
            total++;
            return true;
        }
        else {
            return false;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (set.remove(val)) {
            val--;
            if (val > 0 && total/val > 2) {
                list = new ArrayList(set);
                total = val;
            }
            return true;
        }
        else {
            return false;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int s = random.nextInt(total);
        while (set.contains(list.get(s)) == false) {
            s = random.nextInt(total);
        }
        val--;
        return list.get(s);
    }
}

/**
 *  * Your RandomizedSet object will be instantiated and called as such:
 *   * RandomizedSet obj = new RandomizedSet();
 *    * boolean param_1 = obj.insert(val);
 *     * boolean param_2 = obj.remove(val);
 *      * int param_3 = obj.getRandom();
 *       */
