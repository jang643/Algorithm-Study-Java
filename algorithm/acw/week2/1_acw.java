/*
1. 문제 요약: 펠린드롬문제(앞뒤가 같은 문자열)
2. 문제 풀이 과정
    2-1. 테케 입력 받기
    2-2. isPalindrom 함수에서 recursion을 호출하여 재귀적으로 검사
    2-3. recursion은 양끝에서부터 문자를 비교하며 팰린드롬 여부를 확인
    2-4. s.charAt(start)==s.charAt(end) => 다음 문자열 비교하기 위해 recursion(s, start+1, end-1) 재귀호출
    2-5. 결과(0 or 1)와 cnt 출력
 */
import java.io.*;

public class Main {
    static int cnt = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<T;i++){
            String s = br.readLine();
            cnt = 0;
            sb.append(isPalindrom(s)).append(" ").append(cnt).append("\n");
        }
        br.close();
        System.out.print(sb);

    }
    static int isPalindrome(String s){
        return recursion(s, 0, (s.length()-1));
    }
    static int recursion(String s, int start, int end){
        cnt ++;
        if(start>=end){
            return 1;
        }
        else if(s.charAt(start)!=s.charAt(end)){
            return 0;
        }else{
            return recursion(s, (start+1),(end-1));
        }
    }
}