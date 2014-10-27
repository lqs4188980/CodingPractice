package com.leetcode.surroundedRegions;

import java.util.LinkedList;

public class SurroundedRegions {
	// A stupid implementation. Scan each edge of the whole region, when reaching any point is "O", we clear it to "Y" and start bfs from that point, then clear every point to "Y" that is on the BFS path.
    LinkedList<Integer> xIndex;
    LinkedList<Integer> yIndex;
    
    public void solve(char[][] board) {
        
        if (board == null || board.length == 0 || (board.length == 1 || board[0].length == 1)){
            return;
        }
        
        int width = board.length;
        int height = board[0].length;
        
        xIndex = new LinkedList<Integer>();
        yIndex = new LinkedList<Integer>();
        
        int rightEdge = width - 1;
        int downEdge = height - 1;
        
        // UP
        
        for (int i = 0; i < width; i++){
            if (board[i][0] == 'O'){
                addIndexToQueue(i, 0);
                board[i][0] = 'Y';
                
                while(xIndex.size() != 0){
                    
                    int x = xIndex.poll();
                    int y = yIndex.poll();
                    
                    // up
                    if (y - 1 >= 0 && board[x][y - 1] == 'O'){
                        addIndexToQueue(x, y - 1);
                        board[x][y - 1] = 'Y';
                    }
                    
                    // right
                    if (x + 1 < width && board[x + 1][y] == 'O'){
                        addIndexToQueue(x + 1, y);
                        board[x + 1][y] = 'Y';
                    }
                    
                    // down
                    if (y + 1 < height && board[x][y + 1] == 'O'){
                        addIndexToQueue(x, y + 1);
                        board[x][y + 1] = 'Y';
                    }
                    
                    // left
                    if (x - 1 >= 0 && board[x - 1][y] == 'O'){
                        addIndexToQueue(x - 1, y);
                        board[x - 1][y] = 'Y';
                    }
                }
            }
        }
        
        // Right
        
        for (int i = 0; i < height; i++){
            if (board[rightEdge][i] == 'O'){
                addIndexToQueue(rightEdge, i);
                board[rightEdge][i] = 'Y';
                
                while(xIndex.size() != 0){
                    
                    int x = xIndex.poll();
                    int y = yIndex.poll();
                    
                    // up
                    if (y - 1 >= 0 && board[x][y - 1] == 'O'){
                        addIndexToQueue(x, y - 1);
                        board[x][y - 1] = 'Y';
                    }
                    
                    // right
                    if (x + 1 < width && board[x + 1][y] == 'O'){
                        addIndexToQueue(x + 1, y);
                        board[x + 1][y] = 'Y';
                    }
                    
                    // down
                    if (y + 1 < height && board[x][y + 1] == 'O'){
                        addIndexToQueue(x, y + 1);
                        board[x][y + 1] = 'Y';
                    }
                    
                    // left
                    if (x - 1 >= 0 && board[x - 1][y] == 'O'){
                        addIndexToQueue(x - 1, y);
                        board[x - 1][y] = 'Y';
                    }
                }
            }
        }
        
        // Down
        for (int i = 0; i < width; i++){
            if (board[i][downEdge] == 'O'){
                addIndexToQueue(i, downEdge);
                board[i][downEdge] = 'Y';
                
                while(xIndex.size() != 0){
                    
                    int x = xIndex.poll();
                    int y = yIndex.poll();
                    
                    // up
                    if (y - 1 >= 0 && board[x][y - 1] == 'O'){
                        addIndexToQueue(x, y - 1);
                        board[x][y - 1] = 'Y';
                    }
                    
                    // right
                    if (x + 1 < width && board[x + 1][y] == 'O'){
                        addIndexToQueue(x + 1, y);
                        board[x + 1][y] = 'Y';
                    }
                    
                    // down
                    if (y + 1 < height && board[x][y + 1] == 'O'){
                        addIndexToQueue(x, y + 1);
                        board[x][y + 1] = 'Y';
                    }
                    
                    // left
                    if (x - 1 >= 0 && board[x - 1][y] == 'O'){
                        addIndexToQueue(x - 1, y);
                        board[x - 1][y] = 'Y';
                    }
                }
            }
        }
        
        // Left
        for (int i = 0; i < height; i++){
            if (board[0][i] == 'O'){
                addIndexToQueue(0, i);
                board[0][i] = 'Y';
                
                while(xIndex.size() != 0){
                    
                    int x = xIndex.poll();
                    int y = yIndex.poll();
                    
                    // up
                    if (y - 1 >= 0 && board[x][y - 1] == 'O'){
                        addIndexToQueue(x, y - 1);
                        board[x][y - 1] = 'Y';
                    }
                    
                    // right
                    if (x + 1 < width && board[x + 1][y] == 'O'){
                        addIndexToQueue(x + 1, y);
                        board[x + 1][y] = 'Y';
                    }
                    
                    // down
                    if (y + 1 < height && board[x][y + 1] == 'O'){
                        addIndexToQueue(x, y + 1);
                        board[x][y + 1] = 'Y';
                    }
                    
                    // left
                    if (x - 1 >= 0 && board[x - 1][y] == 'O'){
                        addIndexToQueue(x - 1, y);
                        board[x - 1][y] = 'Y';
                    }
                }
            }
        }
        
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                    continue;
                }
                else if (board[i][j] == 'Y'){
                    board[i][j] = 'O';
                    continue;
                }
                
            }
        }
        
    }
    
    private void addIndexToQueue(int x, int y){
        xIndex.add(x);
        yIndex.add(y);
    }
}
