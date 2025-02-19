/*
1. 문제 요약: 조건에 따른 n의 다음 큰 숫자 찾기
2. 조건
    2-1. 조건1: n의 다음 큰 숫자는 n보다 큰 자연수
    2-2. 조건2: n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같음(***)
    2-3  조건3: n의 다음 큰 숫자는 조건 1,2를 만족하는 가장 작은 수
3. 문제 풀이 과정
    3-1. 입력 받기
    3-2. bitCount를 사용해서 주어진 정수 n의 2진수의 1의 개수 구하기
    3-3. n보다 큰 숫자 중에서 1의 개수가 같은 숫자 찾기
    3-4. 출력하기
4. 시간 복잡도: O(log n)

 */

class Solution {
    public int solution(int n) {

        // Integer.bitCount -> 정수를 매개변수로 넣었을때 그 정수의 2진수의 1의 개수를 반환
        int oneCount = Integer.bitCount(n);

        // n보다 큰 숫자 중에서 1의 개수가 같은 숫자 찾기
        while (true) {
            n++;
            if (Integer.bitCount(n) == oneCount) {
                return n;
            }
        }
    }
}
