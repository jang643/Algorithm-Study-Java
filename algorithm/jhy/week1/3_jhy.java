//문제 요약: 비트카운트
//1. 비트카운트 출력
//시간복잡도: O(k), k는 비트수 -> 사실상 O(1)
import java.util.*;

public class Solution {

    public int solution(int n) {
        //1. 비트카운트 출력
        //도달 방식: n/2에서 순간이동 -> n/2에 도달하려면 n/4에서 순간이동...  홀수면 + 1
        //=> 이진수 변환 = 비트카운트
        return Integer.bitCount(n);
    }
    
}