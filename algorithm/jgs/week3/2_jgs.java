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
            String[] str = br.readLine().split(" ");
            long size = Long.parseLong(str[0]);
            long target = Long.parseLong(str[1]);

            long[] arr = new long[(int)size];

            for(int i = 0; i < (int)size; i++){
                arr[i] = Long.parseLong(br.readLine());
            }

            Arrays.sort(arr);

            long l = 1;
            long r = arr[arr.length - 1];
            long answer = 0;

            while(l <= r){
                long mid = (l + r) / 2;
                if(counting(arr, arr.length, mid) >= target){
                    answer = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            System.out.println(answer);
        }
    }

    static int counting(long[] arr, long size, long mid){
        int count = 0;
        for(int i = 0; i < (int)size; i++){
            count += arr[i] / mid;
        }
        return count;
    }
}