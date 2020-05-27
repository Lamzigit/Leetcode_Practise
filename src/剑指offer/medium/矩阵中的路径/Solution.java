package 剑指offer.medium.矩阵中的路径;

public class Solution {
    public boolean exist(char[][] board, String word) {
        int r = board.length, c = board[0].length, x=0, y=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(board[i][j] == word.charAt(0) && dfs(board, word, i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int x, int y) {
        int r = board.length, c = board[0].length, c_idx = 0, len = word.length();
        int[][] path = new int[word.length()][];
        int[] dir_idx = new int[word.length()];
        int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        path[0] = new int[]{x, y};
        for(int i=1;i<len;path[i++]=new int[]{-1, -1});
        for(int i=0;i<len;dir_idx[i++]=-1);
        while(c_idx+1<len && c_idx > -1){
            int i = dir_idx[c_idx]+1;
            while(i<4){
                x = path[c_idx][0] + dir[i][0];
                y = path[c_idx][1] + dir[i][1];
                if(x<0 || x>r-1 || y<0 || y>c-1) {
                    i++;
                    continue;
                }
                if(word.charAt(c_idx+1) == board[x][y]){
                    path[c_idx + 1] = new int[]{x, y};
                    dir_idx[c_idx] = i;
                    c_idx++;
                    break;
                }
                i++;
            }
            if(i == 4){
                path[c_idx] = new int[]{-1, -1};
                dir_idx[c_idx] = -1;
                c_idx--;
            }

        }
        return c_idx+1 == len;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
//        String word = "AB";
        String word = "ABCCED";
        boolean flag = new Solution().exist(board, word);
        System.out.println(flag);
    }
}
