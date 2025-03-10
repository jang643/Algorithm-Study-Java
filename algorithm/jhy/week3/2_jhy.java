import java.util.*;
import java.io.*;
/*문제 요약: 늘 하는 이분탐색
1. 입력받기 + 최대 범위 구하기
2. 이분탐색
3. 출력
시간복잡도: O(log(max))
*/
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  
    StringTokenizer st = new StringTokenizer(br.readLine());
    int K = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    
    int[] arr = new int[K];
    long max = 0;
    //1. 입력받기 + 최대 범위 구하기
    for(int i = 0; i < K; i++){
      arr[i] = Integer.parseInt(br.readLine());
      max = Math.max(max, arr[i]);
    }
    //2. 이분탐색
    long s = 1, e = max + 1;
    while(s < e - 1){
      long mid = s + (e - s) / 2;
      long count = 0;
      for(int i = 0; i < K; i++){
        count += arr[i] / mid;
      }
      if(count >= N) {
        s = mid;
      }
      else {
        e = mid;
      }
    }
    //3. 출력
    bw.write(String.valueOf(s));
    bw.flush();
  }
}