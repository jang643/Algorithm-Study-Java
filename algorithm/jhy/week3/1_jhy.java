import java.util.*;
import java.io.*;
/* 문제 요약: 이분탐색 카테고리에 있는 해시
1. 입력받기 + 해시맵 저장
2. getOrDefault 출력
시간복잡도: O(N + M)
*/
public class Main {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      int N = Integer.parseInt(br.readLine());
      //1. 입력받기 + 해시맵 저장
      HashMap<Integer, Integer> hm = new HashMap<>();
      StringTokenizer st = new StringTokenizer(br.readLine());
      while(st.hasMoreTokens()){
        int n = Integer.parseInt(st.nextToken());
        hm.put(n, hm.getOrDefault(n, 0)+1);
      }
      
      int M = Integer.parseInt(br.readLine());
      st = new StringTokenizer(br.readLine());
      StringBuilder sb = new StringBuilder();
      //getOrDefault 출력
      while(st.hasMoreTokens()){
        int c = Integer.parseInt(st.nextToken());
        sb.append(hm.getOrDefault(c, 0)).append(" ");
      }
      
      bw.write(sb.toString());
      bw.flush();
    }
}