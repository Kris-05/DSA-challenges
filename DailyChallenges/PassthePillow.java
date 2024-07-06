class Solution {
    public int passThePillow(int n, int time) {
        int parts = time / (n-1);
        int remain = time % (n-1);
        return parts % 2 == 0 ? remain + 1 : n - remain;
    }
}
