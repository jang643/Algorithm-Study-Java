/*
 * 문제 요약 : 숫자 개수 세기
 * 주어진 숫자가 몇개 존재하는지 판단하기
 * 주어진 숫자에 해당하는 숫자 반환
 * 시간 복잡도 O(N)
 * */


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            Map<Integer, Integer> map = new HashMap<>();
            StringBuilder sb = new StringBuilder();
            int n = Integer.parseInt(br.readLine());

            String[] str = br.readLine().split(" ");

            for(String s : str){
                map.put(Integer.parseInt(s), map.getOrDefault(Integer.parseInt(s), 0) + 1);
            }

            n = Integer.parseInt(br.readLine());
            str = br.readLine().split(" ");
            for(String s: str){
                int num = map.get(Integer.parseInt(s)) == null ? 0 : map.get(Integer.parseInt(s));
                sb.append(num).append(" ");
            }
            bw.write(sb.toString());
            bw.flush();
        }
    }
}