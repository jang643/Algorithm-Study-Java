import java.util.*;
import java.io.*;
/*
문제 요약: 이분 탐색
1. 입력 받기
2. 최대범위 e 구하기
3. 이분탐색
4. 출력
시간복잡도: O(NlogN)
*/
public class Main {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      
      int[] arr = new int[N];
      //1. 입력받기
      st = new StringTokenizer(br.readLine());
      int max = 0;
      for(int i = 0; i < N; i++){
        arr[i] = Integer.parseInt(st.nextToken());
        //2. 최댓범위 구하기
        max = Math.max(max, arr[i]);
      }
      long s = 1, e = max;
      int answer = 0;
      //3. 이분탐색
      while(s<=e){
        long mid = s + (e-s)/2;
        long sum = 0;
        for(int a : arr){
          if (a > mid) sum += a - mid;
        }
        if(sum >= M){
          answer = (int) mid;
          s = mid+1;
        } else {
          e = mid - 1;
        }
      }
      //4. 출력
      System.out.print(answer);
  }
}