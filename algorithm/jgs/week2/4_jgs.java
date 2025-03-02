/*
* 이중배열 입력값 크기 만들기
* 1/3씩 쪼개가며 정중앙을 빼고 출력하는 재귀함수 만들기
* */

import java.io.*;
import java.util.*;

public class Main {
    static char[][] board;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            int size = Integer.parseInt(br.readLine());
            board = new char[size][size];
            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){
                    board[i][j] = ' ';
                }
            }
            recursive(0,0,size);

            for(char[] cArr : board){
                for(char c : cArr){
                    bw.write(String.valueOf(c));
                }
                bw.newLine();
            }
            bw.flush();
        }
    }

    static void recursive(int x, int y, int size){
        if(size == 1){
            board[x][y] = '*';
            return;
        }

        int nSize = size/3;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(i==1 && j == 1){
                    continue;
                }
                recursive(x + i * nSize, y + j * nSize, nSize);
            }
        }
    }

}