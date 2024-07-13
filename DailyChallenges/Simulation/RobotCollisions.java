//2751. Robot Collisions

/*
There are n 1-indexed robots, each having a position on a line, health, and movement direction.
You are given 0-indexed integer arrays positions, healths, and a string directions (directions[i] is either 'L' for left or 'R' for right).
All integers in positions are unique. All robots start moving on the line simultaneously at the same speed in their given directions. 
If two robots ever share the same position while moving, they will collide. If two robots collide, the robot with lower health is removed from the line,
and the health of the other robot decreases by one. The surviving robot continues in the same direction it was going.
If both robots have the same health, they are both removed from the line.

Your task is to determine the health of the robots that survive the collisions, in the same order that the robots were given, 
i.e. final heath of robot 1 (if survived), final health of robot 2 (if survived), and so on. If there are no survivors, return an empty array.


Input: positions = [3,5,2,6], healths = [10,10,15,12], directions = "RLRL"
Output: [14]
Explanation: There are 2 collisions in this example. Firstly, robot 1 and robot 2 will collide, and since both have the same health, they will be removed from the line.
Next, robot 3 and robot 4 will collide and since robot 4's health is smaller, it gets removed, and robot 3's health becomes 15 - 1 = 14. 
Only robot 3 remains, so we return [14].
*/

class Solution {
    static class Robot{
        int index;      //to return in the same order i.e acts as key
        int pos;
        int hp;
        char dir;

        Robot(int index, int pos, int hp, char dir){
            this.index = index;
            this.pos = pos;
            this.hp = hp;
            this.dir = dir;
        }
    }
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
    //populate the given data in Robot class
        int n = positions.length;
        List<Robot> bots = new ArrayList<>();
        for(int i=0; i<n; i++)
            bots.add(new Robot(i, positions[i], healths[i], directions.charAt(i)));
    //sort them based on position
        bots.sort((a,b) -> a.pos - b.pos);

        List<Robot> stack = new ArrayList<>();
        for(Robot robot : bots){
            if(robot.dir == 'R'){
                stack.add(robot);       //adding Robot with dir "R"
                continue;
            }

            boolean destroyed = false;
        //CASE 1: stack top robot hp <= current robot hp
            while(!stack.isEmpty() && stack.get(stack.size()-1).hp <= robot.hp && stack.get(stack.size()-1).dir == 'R'){
                //CASE 1: if equal, then destroy the top and go to nxt iteration
                if(stack.get(stack.size()-1).hp == robot.hp){
                    stack.remove(stack.size()-1);
                    destroyed = true;   //means current robot can't be added to stack
                    break;
                }
                //CASE 2: if lesser, then add the current robot to the stack (at the end)
                robot.hp--;
                stack.remove(stack.size()-1);
            }
        //CASE 2: stack top robot hp > current robot hp
            if(!destroyed && !stack.isEmpty() && stack.get(stack.size()-1).hp > robot.hp && stack.get(stack.size()-1).dir == 'R'){
                stack.get(stack.size()-1).hp--;    
                destroyed = true;       //means current robot can't be added to stack
            }

            if(!destroyed)
                stack.add(robot);       //adding Robot with dir "L"
        }
        stack.sort((a,b) -> a.index - b.index);

        //collect remaining robot's hp from the stack 
        List<Integer> list = new ArrayList<>();
        for(Robot robot : stack)
            list.add(robot.hp);

        return list;
    }
}
