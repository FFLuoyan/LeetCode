package org.zongjieli.leetcode.algorithm.primary.array;

/**
 * @ClassName: IsValidSudoku
 * @Description: TODO
 * @Author: Zongjie.Li
 * @Date: 2019/12/26
 * @Version: 1.0
 **/
public class IsValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        boolean[][][] numberValid = new boolean[3][9][9];
        // 第一个下标为校验类型,行、列、块
        // 第二个下标为校验位置,第几行、列、块
        // 第三个下标为校验数据,表示该位置第几个参数是否存在
        for (int rowIndex = 0; rowIndex < 9; rowIndex++) {
            for (int columnIndex = 0; columnIndex < 9; columnIndex++) {
                // 0 的 ASCII 码为48,所以char类型的实际值为 numberChar - 48
                // 0 下标存放 1,1 放 2,8 的下标放 9
                if (board[rowIndex][columnIndex] == '.'){
                    continue;
                }
                int numberChar = board[rowIndex][columnIndex] - 49;
                int blockIndex = (rowIndex / 3) * 3 + columnIndex / 3;
                if (numberValid[0][rowIndex][numberChar]  || numberValid[1][columnIndex][numberChar]  || numberValid[2][blockIndex][numberChar] ) {
                    return false;
                } else {
                    numberValid[0][rowIndex][numberChar] = true;
                    numberValid[1][columnIndex][numberChar] = true;
                    numberValid[2][blockIndex][numberChar] = true;
                }
            }
        }
        return true;


//        int[] rows=new int[9];
//        int[] columns=new int[9];
//        int[] blocks=new int[9];
//        for(int i=0;i<9;i++) {
//            for(int j=0;j<9;j++) {
//                if(board[i][j]=='.') {
//                    continue;
//                }
//                int nump=1<<(board[i][j]-48-1);
//                int blockLocation=(i/3)*3+j/3;
//                //join in row
//                int preR=rows[i];
//                rows[i]=preR^nump;
//                if(rows[i]<preR) {
//                    return false;
//                }
//                //join in column
//                int preC=columns[j];
//                columns[j]=preC^nump;
//                if(columns[j]<preC) {
//                    return false;
//                }
//                //join in block
//                int preB=blocks[blockLocation];
//                blocks[blockLocation]=preB^nump;
//                if(blocks[blockLocation]<preB) {
//                    return false;
//                }
//
//            }
//        }
//        return true;
    }

    public static void main(String[] args) {
        char[][] sudoku = new char[][]{
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '7', '.', '.', '6'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}};

//        String testString = "[[\".\",\".\",\".\",\".\",\"5\",\".\",\".\",\"1\",\".\"],[\".\",\"4\",\".\",\"3\",\".\",\".\",\".\",\".\",\".\"],[\".\",\".\",\".\",\".\",\".\",\"3\",\".\",\".\",\"1\"],[\"8\",\".\",\".\",\".\",\".\",\".\",\".\",\"2\",\".\"],[\".\",\".\",\"2\",\".\",\"7\",\".\",\".\",\".\",\".\"],[\".\",\"1\",\"5\",\".\",\".\",\".\",\".\",\".\",\".\"],[\".\",\".\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\"],[\".\",\"2\",\".\",\"9\",\".\",\".\",\".\",\".\",\".\"],[\".\",\".\",\"4\",\".\",\".\",\".\",\".\",\".\",\".\"]]";
//        String change = testString.replace('\"','\'');
//        change = change.replace("[","{");
//        change = change.replace("]","}");
//        System.out.println(change);
//        StringBuilder soduku = new StringBuilder("{");
//        for (int i = 0; i < 9; i++) {
//            StringBuilder stringBuilder = new StringBuilder("{");
//            for (int j = 0; j < 9; j++) {
//                int number = i + j + 1;
//                if (number > 9) {
//                    number -= 9;
//                }
//                stringBuilder.append(number + ",");
//            }
//            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
//            stringBuilder.append("},");
//            soduku.append(stringBuilder);
//        }
//        soduku.deleteCharAt(soduku.length() - 1);
//        soduku.append("}");
//        System.out.println(soduku);
        System.out.println(isValidSudoku(sudoku));
    }
}
