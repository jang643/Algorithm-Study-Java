/*
1. 문제 요약: 입력받은 n 사이의 소수 개수 찾기
2. 문제 풀이 과정
    2-1. 입력 받기
    2-2. 소수 찾는 메서드 만들기
    2-3. 만든 메서드를 활용해서 2부터 주어진 n까지 소수의 개수 구하기
    2-4. 출력하기
3. 시간 복잡도: O(n√n)

 */

class Solution {
    // 소수 찾는 메서드
    public boolean isPrime(int num) {
        //효율성을 위해 제곱근까지만 검사
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int solution(int n) {
        int answer = 0;
        // 2부터 주어진 n까지 소수의 개수 구하기
        for (int i = 2; i < n + 1; i++) {
            if (isPrime(i)) {
                answer++;
            }
        }
        return answer;
    }
}
