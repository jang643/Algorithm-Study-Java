import java.io.*;
import java.util.*;

public class Main{
    /*문제 요약: 3등분 후 가운데 빼고 재귀
    1. 입력받기
    2. 배열 선언 및 fill
    3. 재귀함수 호출
    4. 배열 출력
    */
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        //1. 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        for(char[] a : arr){
            Arrays.fill(a, '*'); //2. 배열 미리 채우기
        }
        calc(0, 0, n-1, n-1);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                bw.write(arr[i][j]);
            }
            bw.newLine();
        }
        bw.flush();
    }
    //3. 재귀함수 호출(시작 좌표, 사각형 우측 하단 좌표)
    static void calc(int sr, int sc, int er, int ec){
        if(er - sr == 2){ //종료 조건: 3*3이면 가운데 비우고 종료
            arr[sr+1][sc+1] = ' ';
        } else {
            //가운데 제외하고 호출하기
            for(int i = sr; i <= sr + (er - sr+1)*2/3; i+= (er - sr+1)/3){
                for(int j = sc; j <= sc + (ec - sc+1)*2/3; j+= (ec - sc+1)/3){
                    if(i == sr + (er - sr+1)/3 && j == sc + (ec - sc+1)/3) continue;
                    calc(i, j, i + (er - sr+1)/3 -1, j+ (ec - sc+1)/3 -1);
                }
            }
            //가운데 공백만들기
            for(int i = sr + (er - sr+1)/3; i < sr+(er - sr+1)*2/3; i++){
                for(int j = sc + (ec - sc+1)/3; j < sc+(ec - sc+1)*2/3; j++){
                    arr[i][j] = ' ';
                }
            }
        }
        
    }
}