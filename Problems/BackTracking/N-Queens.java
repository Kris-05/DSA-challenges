//51. N-Queens

class Solution {
    public void addAnswer(char[][] board, List<List<String>> allBoards){
        int n = board.length;
        String row = "";
        List<String> answer = new ArrayList<>();

        for(int i=0; i<n; i++){
            row = "";
            for(int j=0; j<n; j++){
                if(board[i][j] == 'Q') row += 'Q';
                else row += '.';
            }
            answer.add(row);
        }
        allBoards.add(answer);
    }

    public boolean isSafe(int row, int col, char[][] board){
        int n = board.length;
        int r, c;
    //Horizontal
        for(int j=0; j<n; j++){
            if(board[row][j] == 'Q') return false;
        }
    //Vertical
        for(int i=0; i<n; i++){
            if(board[i][col] == 'Q') return false;
        }
    //Upper Left
        r = row;
        for(c = col; c>=0 && r>=0; c--, r--){
            if(board[r][c] == 'Q') return false;
        }
    //Upper Right
        r = row;
        for(c = col; c<n && r>=0; c++, r--){
            if(board[r][c] == 'Q') return false;
        }
    //Lower Left
        r = row;
        for(c = col; c>=0 && r < n;c--, r++){
            if(board[r][c] == 'Q') return false;
        }
    //Lower Right
        r = row;
        for(c = col; c<n && r<n; c++, r++){
            if(board[r][c] == 'Q') return false;
        }

        return true;
    }
    public void solve(char[][] board, List<List<String>> allBoards, int col){
        int n = board.length;
        if(col == n){
            addAnswer(board, allBoards);
            return;
        }

        for(int row=0; row<n; row++){
            if(isSafe(row, col, board)){
                board[row][col] = 'Q';
                solve(board, allBoards, col+1);
                board[row][col] = '.';
            }
        }

    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> allBoards = new ArrayList<>();
        char[][] board = new char[n][n];

        solve(board, allBoards, 0);

        return allBoards;
    }
}
