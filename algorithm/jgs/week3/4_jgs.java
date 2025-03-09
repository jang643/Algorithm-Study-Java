/*
 * 문제 요약 : 가능한 가장 긴 서로간의 거리
 * 입력, 정렬
 * 최솟값 1 최대값 끝값 빼기 첫번째값
 * 중간값 이상의 거리마다 하나씩 카운트
 * 카운트의 숫자가 목표값보다 크면 값 저장
 * 중간값 늘리기
 * 아니면 중간값 줄이기
 * 반복
 * */

import java.io.*;
import java.util.*;
import java.util.logging.Logger;


public class Main {

    Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            String[] ar = br.readLine().split(" ");
            int size = Integer.parseInt(ar[0]);
            int count = Integer.parseInt(ar[1]);
            int[] arr = new int[size];

            for(int i = 0; i < size; i++){
                arr[i] = Integer.parseInt(br.readLine());
            }

            int position = 0;

            Arrays.sort(arr);
            int l = 1;
            int r = arr[arr.length-1] - arr[0];
            int answer = 0;

            while(l <= r){
                int mid = (l+r)/2;
                int check = 1;
                position = arr[0];
                for(int i = 0; i < size; i++){
                    if(arr[i] - position >= mid){
                        check++;
                        position = arr[i];
                    }
                }
                if (check >= count){
                    answer = mid;
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
            bw.write(String.valueOf(answer));
            bw.flush();
        }
    }
}