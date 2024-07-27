// 2976. Minimum Cost to Convert String I

/*
Input: source = "abcd", target = "acbe", original = ["a","b","c","c","e","d"], changed = ["b","c","b","e","b","e"], cost = [2,5,5,1,2,20]
Output: 28
Explanation: To convert the string "abcd" to string "acbe":
- Change value at index 1 from 'b' to 'c' at a cost of 5.
- Change value at index 2 from 'c' to 'e' at a cost of 1.
- Change value at index 2 from 'e' to 'b' at a cost of 2.
- Change value at index 3 from 'd' to 'e' at a cost of 20.
The total cost incurred is 5 + 1 + 2 + 20 = 28.
It can be shown that this is the minimum possible cost.
*/

class Solution {
    private static int COUNT = 26;

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][] weight = new int[COUNT][COUNT];

        for(int i=0; i<COUNT; i++){
            Arrays.fill(weight[i], Integer.MAX_VALUE);
            weight[i][i] = 0;
        }

        for(int i=0; i<cost.length; i++){
            int from = (int)(original[i] - 'a');
            int to = (int)(changed[i] - 'a');
          // because there might be multiple ways to convert. So we keep the min of those
          // original = ['a', 'a'] changed = ['b', 'b'] cost = [5, 3]
            weight[from][to] = Math.min(weight[from][to], cost[i]);
        }

        for(int k=0 ; k<COUNT; k++){
            for(int i=0; i<COUNT; i++){
                for(int j=0; j<COUNT; j++){
                    if(weight[i][k] < Integer.MAX_VALUE && weight[k][j] < Integer.MAX_VALUE)
                        weight[i][j] = Math.min(weight[i][j], weight[i][k] + weight[k][j]);
                }
            }
        }

        long res = 0;
        for(int i=0; i<source.length(); i++){
            int from = (int)(source.charAt(i) - 'a');
            int to = (int)(target.charAt(i) - 'a');
            if(weight[from][to] == Integer.MAX_VALUE){
                res = -1L;
                break;
            }
            res += weight[from][to];
        }

        return res;
    }
}
