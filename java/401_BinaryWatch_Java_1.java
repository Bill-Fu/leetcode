class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();
        if (num == 0) {
            String t = "0:00";
            result.add(t);
            return result;
        }
        else {
            List<List<Integer>> list = new ArrayList<>();
            
            for (int i = 0; i < 10; ++i) {
                List<Integer> newlist = new ArrayList<>();
                newlist.add(i);
                readBinaryWatch(num - 1, list, newlist);
            }
            
            for (int i = 0; i < list.size(); ++i) {
                int hr = 0;
                int min = 0;
                
                for (int ele: list.get(i)) {
                    switch (ele) {
                        case 0:
                            hr += 8;
                            break;
                        case 1:
                            hr += 4;
                            break;
                        case 2:
                            hr += 2;
                            break;
                        case 3:
                            hr += 1;
                            break;
                        case 4:
                            min += 32;
                            break;
                        case 5:
                            min += 16;
                            break;
                        case 6:
                            min += 8;
                            break;
                        case 7:
                            min += 4;
                            break;
                        case 8:
                            min += 2;
                            break;
                        case 9:
                            min += 1;
                            break;
                    }
                }
                if (hr < 12 && min < 60) {
                    String time = "";
                    time += Integer.toString(hr);
                    time += ":";
                    if (min < 10) {
                        time += "0";
                    }
                    time += Integer.toString(min);
                    result.add(time);
                }
            }
            
            return result;
        }
    }
    
    public void readBinaryWatch(int num, List<List<Integer>> list, List<Integer> tmp) {
        if (num == 0) {
            list.add(tmp);
        }
        else {
            for (int i = tmp.get(tmp.size() - 1) + 1; i < 10; ++i) {
                List<Integer> newlist = new ArrayList<>(tmp);
                newlist.add(i);
                readBinaryWatch(num - 1, list, newlist);
            }
        }
    }
}
