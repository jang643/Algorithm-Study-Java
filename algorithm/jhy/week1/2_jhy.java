//문제 요약: 큰 수 구하기
//1. 1의 갯수 구하기
//2. 1의 갯수 맞을 때까지 ++
//3. 출력
//시간 복잡도: O(N)
import java.util.*;

class Solution {
    public int solution(int n) {
        //1. 1의 갯수 구하기(bitCount)
        int s = Integer.bitCount(0^n);
        int k = n+1;
        //2. 다음 큰 숫자 구하기
        while(Integer.bitCount(0^k) !=s){
            k++;
        }
        //3. 출력
        return k;
    }
}