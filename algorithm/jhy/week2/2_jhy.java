import java.util.*;
import java.io.*;

public class Main{
    /*문제 요약: 병합 정렬 수도 코드 구현 및 저장 카운팅
    1. 입력 받기
    2. 병합 정렬 구현
    3. 저장 시 카운팅 및 비교
    4. 출력
    */
    static int count = 0;
    static int[] arr, tmp;
    static int n, k;
    public static void main(String[] args) throws IOException {
        //1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] f = br.readLine().split(" ");
        n = Integer.parseInt(f[0]);
        k = Integer.parseInt(f[1]);
        arr = new int[n];
        tmp = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int i = 0;
        while(st.hasMoreTokens()){
            arr[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        
        MergeSort(0, n-1);
        if(count < k) System.out.print(-1);
        return;
    }
    //2. 병합 정렬 구현
    static void MergeSort(int p, int r){
        if(p < r){
            int q = (p+r)/2;
            MergeSort(p, q);
            MergeSort(q+1, r);
            Merge(p, q, r);
        }
    }
    
    static void Merge(int p, int q, int r){
        int i = p, j = q+1, t = p;
        while(i <= q && j <= r){
            if(arr[i] <= arr[j]) tmp[t++] = arr[i++];
            else tmp[t++] = arr[j++];
        }
        while(i <= q) tmp[t++] = arr[i++];
        while(j <= r) tmp[t++] = arr[j++];
        i = p;
        t = p;
        //3. 저장 카운팅
        while(i <= r){
            arr[i++] = tmp[t++];
            count++;
            if(count == k) {
                System.out.print(arr[i-1]);
                System.exit(0);
            }
        }
    }
}