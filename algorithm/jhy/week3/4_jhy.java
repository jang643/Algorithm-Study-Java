import java.util.*;
import java.io.*;
/* 문제 요약: 이분탐색, 카운팅을 곁들인.
1. 입력받기
2. 정렬
3. 범위 지정
4. 이분탐색
5. 출력
시간 복잡도: O(NlogN = 정렬 + O(log(max - min)) = 탐색)
*/
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());
    
    int[] arr = new int[N];
    //1. 입력받기
    for(int i = 0; i < N; i++){
      arr[i] = Integer.parseInt(br.readLine());
    }
    //2. 정렬
    Arrays.sort(arr);
    //3. 범위 지정
    long s = 1, e = arr[N-1] - arr[0], answer = 0;
    //4. 탐색
    while(s <= e){
      int c = 1;//설치하는 공유기 수, 최대 거리를 위해 i = 0부터 설치
      long mid = s + (e - s)/2;
      int last = arr[0];
      for(int i = 1; i < N; i++){
        if(arr[i] - last >= mid) {
          c++;
          last = arr[i]; //탐색 거리에 해당하는 구간에 다음 공유기 설치
        }
      }
      if(c >= C){
        answer = mid;
        s = mid+1;
      } else {
        e = mid-1;
      }
    }
    //5. 출력
    bw.write(String.valueOf(answer));
    bw.flush();
  }
}