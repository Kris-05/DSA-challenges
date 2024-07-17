//1598. Crawler Log Folder

/*
    "../" : Move to the parent folder of the current folder. (If you are already in the main folder, remain in the same folder).
    "./" : Remain in the same folder.
    "x/" : Move to the child folder named x (This folder is guaranteed to always exist).
*/

class Solution {
    public int minOperations(String[] logs) {
        int steps = 0;
        for(String str : logs){
            if(str.equals("../"))
                steps = steps > 0 ? steps-1 : steps;
            else if(str.equals("./"))
                continue;
            else
                steps++;
        }
        return steps;
    }
}
