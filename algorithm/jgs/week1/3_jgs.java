/* 문제 요약: 최소값 찾기
 의사 코드:
1. 입력받기
2. 짝수면 반 나누기
3. 홀수면 카운트 +1 값 -1
4. 0되면 종료
5. 시간 복잡도: O(log n)
*/

public class Solution {
    public int solution(int n) {
        int answer = 0;
        while (n > 0) {
            // n이 홀수면 점프해야
            if (n % 2 == 1) {
                answer++;
            }
            // 순간이동 계산
            n /= 2;
        }
        return answer;
    }
}