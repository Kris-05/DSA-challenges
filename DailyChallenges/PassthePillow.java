//Pass the Pillow

/*
There are n people standing in a line labeled from 1 to n. The first person in the line is holding a pillow initially. Every second, the person holding the 
pillow passes it to the next person standing in the line. Once the pillow reaches the end of the line, the direction changes, and people continue passing 
the pillow in the opposite direction.

For example, once the pillow reaches the nth person they pass it to the n - 1th person, then to the n - 2th person and so on.
Given the two positive integers n and time, return the index of the person holding the pillow after time seconds
*/

class Solution {
    public int passThePillow(int n, int time) {
        /* for n=5 => 1 2 3 4 | 5 4 3 2 | 1 2 3 4 | 5 4 3 2 | 1 2 3 4 |.. for each 2*(n-1) part pattern repeats
        finding the part, we get how much completed
        finding the remain, we get the exact person
        if he completed even parts then pillow will be with n-remain (NOTE: even starts from reverse)
        if he completed odd parts then pillow will be with remain+1 (NOTE: odd starts from 1)
        */
        int parts = time / (n-1);
        int remain = time % (n-1);
        return parts % 2 == 0 ? remain + 1 : n - remain;
    }
}
