class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people.length == 0) {
            return people;
        }
        else {
            Arrays.sort(people, new Comparator<int[]>() {
                public int compare(int[] i1, int[] i2) {
                    if (i1[0] != i2[0]) {
                        return i2[0] - i1[0];
                    }
                    else {
                        return i1[1] - i2[1];
                    }
                }
            });

            List<int[]> list = new LinkedList<>();

            for (int[] cur: people) {
                list.add(cur[1], cur);
            }

            return list.toArray(new int[people.length][people[0].length]);            
        }

    }
}
