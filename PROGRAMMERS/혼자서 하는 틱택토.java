import java.util.*;
import java.io.*;
​
class Solution {
    public int solution(String[] board) {
        int answer = 1;
        int O = 0; 
        int X = 0;
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length(); j++) {
                if((board[i].substring(j, j+1)).equals("O")) O++;
                if((board[i].substring(j, j+1)).equals("X")) X++;
            }
        }
        
        System.out.printf("%d %d \n", O, X);
        
        int find_O = find(board, "O");
        int find_X = find(board, "X");
        System.out.printf("%d %d \n", find_O, find_X);
        
        if(O-X>1 || O<X ) return 0;
        
        if(find_O!=0 && find_X!=0) return 0;
        
        if(find_O>0 && O<=X) return 0;
        
        if(find_X>0 && O>X) return 0;
        
        
        // if(find_O>1 || find_X>1) return 0;
        
        // if(Math.abs(find_O-find_X)!=1) return 0;
        
        // if(O+X==9) return 1;
        
        return answer;
    }
    
    
    public int find(String[] board, String s) {
        int count = 0;