/*
Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.

The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.
*/
class Solution {
public:
    bool judgeCircle(string moves) {
        int UD = 0, RL = 0;
        for (int i = 0; i < moves.length(); ++i) {
            switch (moves[i]){
                case 'U':
                    UD++;
                    break;
                case 'D':
                    UD--;
                    break;
                case 'R':
                    RL++;
                    break;
                case 'L':
                    RL--; 
                    break;
            }
        }
        if (UD == 0 && RL == 0) {
            return true;
        }
        else{
            return false;
        }
    }
};
}
}
}
}
}
}
