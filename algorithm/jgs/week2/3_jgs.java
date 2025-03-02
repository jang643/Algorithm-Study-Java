/* 문제 요약: 1/3 - 1/3 공백 1/3 -
 의사 코드:
 * 파일의 입력 끝까지 입력을 받는다.
 * 입력을 받을때마다 3의 n제곱으로 배열의 크기설정
 * 1/3 1/3 1/3으로 계속 쪼개기
 * 배열의 크기가 1만큼 되면 출력
 * */

import java.io.*;

public class Main {
    static char[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;

        while ((input = br.readLine()) != null && !input.isEmpty()) {
            int size = (int)Math.pow(3, Integer.parseInt(input));
            arr = new char[size];
            recursive(arr,0,size-1);
            bw.write(new String(arr) + "\n");
        }
        bw.flush();
    }
    static void recursive(char[] arr, int start, int end){
        if((start == end)){
            arr[start] = '-';
            return;
        }
        int n = end-start + 1;
        int centerStart = (n / 3) + start;
        int centerEnd = ((n * 2) / 3) - 1 + start;
        recursive(arr,start,centerStart-1);
        for(int i = centerStart; i <= centerEnd; i++){
            arr[i] = ' ';
        }
        recursive(arr,centerEnd+1,end);
    }
}