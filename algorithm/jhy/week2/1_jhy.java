import java.io.*;
import java.util.*;

public class Main{
    /* 문제 요약: 팰린드롬 함수 구현
    1. 입력받기
    2. 카운팅 추가
    3. 팰린드롬 여부 확인 및 출력
    */
    public static void main(String[] args) throws IOException{
        //1. 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            String input = br.readLine();
            StringBuilder sb = new StringBuilder();
            int k = isPalindrome(input);
            //3. 여부 확인 및 출력 -> 양수일 시 성공 (1) + 횟수 / 음수일 시 실패(0) + 횟수
            if(k > 0) sb.append(1).append(" ").append(k);
            else sb.append(0).append(" ").append(k*-1);
            System.out.println(sb.toString());
        }
    }
    
    public static int recursion(String s, int l, int r){
        //2. 카운팅 -> 0부터 l까지 = 시행 횟수와 같음
        if(l >= r) return l+1; //0부터 시작이므로
        else if(s.charAt(l) != s.charAt(r)) return (l+1)*-1;
        else return recursion(s, l+1, r-1);
    }
    
    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }
}