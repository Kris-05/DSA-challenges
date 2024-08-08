// 885. Spiral Matrix III

/*
Input: rows = 5, cols = 6, rStart = 1, cStart = 4
Output: [[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],
[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]
*/

class Solution {
    class Pair{
        int row;
        int col;

        public Pair(int i, int j){
            this.row = i;
            this.col = j;
        }
    }
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        List<Pair> list = new ArrayList<>();

        int top = rStart;
        int left = cStart;
        int bottom = top+1;
        int right = left+1;

        list.add(new Pair(top, left));
        while(list.size() < rows*cols){
            // move right
            for(int j=left+1; j<=right; j++){
                int i = top;
                if(i>=0 && i<rows && j>=0 && j<cols)
                    list.add(new Pair(i,j));
            }   
            left--; 
            // move down
            for(int i=top+1; i<=bottom; i++){
                int j = right;
                if(i>=0 && i<rows && j>=0 && j<cols)
                    list.add(new Pair(i,j));
            }
            top--;
            // move left
            for(int j=right-1; j>=left; j--){
                int i = bottom;
                if(i>=0 && i<rows && j>=0 && j<cols)
                    list.add(new Pair(i,j));
            }
            right++;
            // move top
            for(int i=bottom-1; i>=top; i--){
                int j = left;
                if(i>=0 && i<rows && j>=0 && j<cols)
                    list.add(new Pair(i,j));
            }
            bottom++;
        }

        int ans[][] = new int[rows*cols][2];
        for(int i=0; i<rows*cols; i++){
            ans[i][0] = list.get(i).row;
            ans[i][1] = list.get(i).col;
        }

        return ans;
    }
}
