//문제 요약: 소수 세기
//1. 에라토스테네스 체 만들기
//2. 거르기
//3. 배열 탐색
//4. 반환
//시간복잡도: O(NloglogN)
class Solution {
    public int solution(int n) {
        //1.에라토스테네스 체 만들기
        if (n < 2) return 0;
        boolean[] arr = new boolean[n + 1];
        int result = 1;
        //2. 소수 발견 시 소수의 배수에 대해 true 값 설정(거르기)
        for (int i = 3; i * i <= n; i += 2) {
            if (!arr[i]) {
                for (int j = i * i; j <= n; j += 2 * i) {
                    arr[j] = true;
                }
            }
        }
        //3. 배열 순회
        for (int i = 3; i <= n; i += 2) {
            if (!arr[i]) result++;
        }
        //4. 반환
        return result;
    }
}