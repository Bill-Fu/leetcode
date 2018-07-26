class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Map<Integer, Set<Integer>> obstacle_table = new HashMap<>();
        
        for (int i = 0; i < obstacles.length; ++i) {
            if (obstacle_table.containsKey(obstacles[i][0]) == false) {
                obstacle_table.put(obstacles[i][0], new HashSet());
            }
            
            obstacle_table.get(obstacles[i][0]).add(obstacles[i][1]);
        }
        
        int face = 0;
        int[] pos = new int[2];
        int res = 0;
        
        for (int command: commands) {
            switch(command) {
                case -2:
                    face = (face + 3) % 4;
                    break;
                case -1:
                    face = (face + 1) % 4;
                    break;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    int move = command;
                    switch(face) {
                        case 0:
                            if (obstacle_table.containsKey(pos[0])) {
                                for (int i = 1; i <= command; ++i) {
                                    if (obstacle_table.get(pos[0]).contains(pos[1] + i)) {
                                        move = i - 1;
                                        break;
                                    }
                                }
                            }
                            
                            pos[1] += move;

                            break;
                        case 1:
                            for (int i = 1; i <= command; ++i) {
                                if (obstacle_table.containsKey(pos[0] + i) && obstacle_table.get(pos[0] + i).contains(pos[1])) {
                                    move = i - 1;
                                    break;
                                }
                            }
                            
                            pos[0] += move;
                            
                            break;
                        case 2:
                            if (obstacle_table.containsKey(pos[0])) {
                                for (int i = 1; i <= command; ++i) {
                                    if (obstacle_table.get(pos[0]).contains(pos[1] - i)) {
                                        move = i - 1;
                                        break;
                                    }
                                }
                            }
                            
                            pos[1] -= move;
                            
                            break;
                        case 3:
                            for (int i = 1; i <= command; ++i) {
                                if (obstacle_table.containsKey(pos[0] - i) && obstacle_table.get(pos[0] - i).contains(pos[1])) {
                                    move = i - 1;
                                    break;
                                }
                            }
                            
                            pos[0] -= move;
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
            
            res = Math.max(res, pos[0] * pos[0] + pos[1] * pos[1]);
        }
        
        return res;
    }
}
