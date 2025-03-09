/*
 * 문제 요약 : 타켓숫자를 만족하는 가장 큰 길이 구하기
 * 이분탐색 하면서 가장 큰 값구하기
 * 최대값이 int 최대값이기 때문에 long 사용
 * */

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            String[] ar = br.readLine().split(" ");
            int size = Integer.parseInt(ar[0]);
            long target = Long.parseLong(ar[1]);
            long[] arr = new long[size];


            ar = br.readLine().split(" ");

            for(int i = 0; i < size; i++){
                arr[i] = Long.parseLong(ar[i]);
            }

            Arrays.sort(arr);
            long l = 0;
            long r = arr[arr.length - 1];
            long answer = Integer.MIN_VALUE;
            while(l <= r){
                long mid = (l + r)/2;
                if(isPossible(arr, target, mid)){
                    answer = Math.max(answer, mid);
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }
            bw.write(String.valueOf(answer));
            bw.flush();
        }
    }
    static boolean isPossible(long[] arr, long target, long height){
        long sum = 0;
        for(long i : arr){
            if(i > height){
                sum += i - height;
            }
        }
        if(sum >= target) return true;
        return false;
    }
}