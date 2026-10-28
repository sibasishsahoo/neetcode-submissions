class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String>set = new HashSet<>();
        for(int row = 0;row<9;row++){
            for(int col = 0;col<9;col++){
                char num = board[row][col];
                if(num == '.'){
                    continue;
                }
                String rowkey = num+"in row"+row;
                String colkey = num+"in col"+col;
                String box    = num+"in box"+row/3+","+col/3;

                if(!set.add(rowkey) || !set.add(colkey) || !set.add(box)){
                    return false;
                }
            }
        }
    return true;
    }
}
