import java.io.*;
import java.util.*;

public class Main{
    /* 문제 요약: 칸토어 집합 출력하기
    1. 입력받기(EOF까지)
    2. 각 변수 재귀함수
    3. bw.flush();
    */
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        //1. 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line;
        int n;
        //2. 재귀함수 (EOF까지)
        while ((line = br.readLine()) != null) {
            n = Integer.parseInt(line);
            calc((int)Math.pow(3, n));
            bw.write(sb.toString());
            bw.newLine();
            sb.setLength(0); //sb 재활용
        }
        //3.출력(System.out은 시간초과)
        bw.flush();
    }
    //칸토어 집합 출력 -> 3등분 가운데 부분은 공백으로, 나머지는 다시 재귀 호출.
    static void calc(int n){
        if(n == 1) sb.append('-');
        else {
            calc(n/3);
            for(int i = 0; i < n/3; i++){
                sb.append(' ');
            }
            calc(n/3);
        }
    }
}