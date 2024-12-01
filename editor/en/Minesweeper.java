/**
 * <p>Let's play the minesweeper game (<a href="https://en.wikipedia.org/wiki/Minesweeper_(video_game)" target="_blank">Wikipedia</a>, <a href="http://minesweeperonline.com" target="_blank">online game</a>)!</p>
 *
 * <p>You are given an <code>m x n</code> char matrix <code>board</code> representing the game board where:</p>
 *
 * <ul>
 * <li><code>'M'</code> represents an unrevealed mine,</li>
 * <li><code>'E'</code> represents an unrevealed empty square,</li>
 * <li><code>'B'</code> represents a revealed blank square that has no adjacent mines (i.e., above, below, left, right, and all 4 diagonals),</li>
 * <li>digit (<code>'1'</code> to <code>'8'</code>) represents how many mines are adjacent to this revealed square, and</li>
 * <li><code>'X'</code> represents a revealed mine.</li>
 * </ul>
 *
 * <p>You are also given an integer array <code>click</code> where <code>click = [click<sub>r</sub>, click<sub>c</sub>]</code> represents the next click position among all the unrevealed squares (<code>'M'</code> or <code>'E'</code>).</p>
 *
 * <p>Return <em>the board after revealing this position according to the following rules</em>:</p>
 *
 * <ol>
 * <li>If a mine <code>'M'</code> is revealed, then the game is over. You should change it to <code>'X'</code>.</li>
 * <li>If an empty square <code>'E'</code> with no adjacent mines is revealed, then change it to a revealed blank <code>'B'</code> and all of its adjacent unrevealed squares should be revealed recursively.</li>
 * <li>If an empty square <code>'E'</code> with at least one adjacent mine is revealed, then change it to a digit (<code>'1'</code> to <code>'8'</code>) representing the number of adjacent mines.</li>
 * <li>Return the board when no more squares will be revealed.</li>
 * </ol>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img src="https://assets.leetcode.com/uploads/2023/08/09/untitled.jpeg" style="width: 500px; max-width: 400px; height: 269px;" />
 * <pre>
 * <strong>Input:</strong> board = [["E","E","E","E","E"],["E","E","M","E","E"],["E","E","E","E","E"],["E","E","E","E","E"]], click = [3,0]
 * <strong>Output:</strong> [["B","1","E","1","B"],["B","1","M","1","B"],["B","1","1","1","B"],["B","B","B","B","B"]]
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 * <img src="https://assets.leetcode.com/uploads/2023/08/09/untitled-2.jpeg" style="width: 489px; max-width: 400px; height: 269px;" />
 * <pre>
 * <strong>Input:</strong> board = [["B","1","E","1","B"],["B","1","M","1","B"],["B","1","1","1","B"],["B","B","B","B","B"]], click = [1,2]
 * <strong>Output:</strong> [["B","1","E","1","B"],["B","1","X","1","B"],["B","1","1","1","B"],["B","B","B","B","B"]]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>m == board.length</code></li>
 * <li><code>n == board[i].length</code></li>
 * <li><code>1 &lt;= m, n &lt;= 50</code></li>
 * <li><code>board[i][j]</code> is either <code>'M'</code>, <code>'E'</code>, <code>'B'</code>, or a digit from <code>'1'</code> to <code>'8'</code>.</li>
 * <li><code>click.length == 2</code></li>
 * <li><code>0 &lt;= click<sub>r</sub> &lt; m</code></li>
 * <li><code>0 &lt;= click<sub>c</sub> &lt; n</code></li>
 * <li><code>board[click<sub>r</sub>][click<sub>c</sub>]</code> is either <code>'M'</code> or <code>'E'</code>.</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Array</li><li>Depth-First Search</li><li>Breadth-First Search</li><li>Matrix</li></div></div><br><div><li>👍 1996</li><li>👎 1072</li></div>
 */

package com.shuzijun.leetcode.editor.en;

public class Minesweeper {
    public static void main(String[] args) {
        Solution solution = new Minesweeper().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char[][] updateBoard(char[][] board, int[] click) {
            int r = click[0], c = click[1];
            if (board[r][c] == 'M') {
                board[r][c] = 'X';
                return board;
            }
            if (board[r][c] == 'E') {
                changeEmptyBoard(board, r, c);
            }
            return board;
        }

        private void changeEmptyBoard(char[][] board, int r, int c) {
            int MineNum = 0;
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (c + j >= 0 && c + j < board[0].length && r + i >= 0 && r + i < board.length && board[r + i][c + j] == 'M')
                        MineNum++;
                }
            }
            if (board[r][c] == 'E') {
                if (MineNum == 0) {
                    board[r][c] = 'B';
                    for (int i = -1; i < 2; i++) {
                        for (int j = -1; j < 2; j++) {
                            if (i == 0 && j == 0) continue;
                            if (c + j >= 0 && c + j < board[0].length && r + i >= 0 && r + i < board.length) {
                                changeEmptyBoard(board, r + i, c + j);
                            }
                        }
                    }
                } else board[r][c] = (char) (MineNum+'0');
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}