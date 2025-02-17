/* 문제 요약: 주어진 정수까지의 소수 개수 구하기
 의사 코드:
1. 입력받기
2. 소수 판단하기
3. 소수 개수 세기
4. 개수 출력
5. 시간 복잡도: (O(n log log n)) 라고 하네요
*/
class Solution {
    public int solution(int n) {
        //입력받은 값을 인덱스로 사용하기 위해 입력값 + 1 배열 생성
        boolean[] isNotPrime = new boolean[n+1];  //boolean 기본값 false
        //0과 1은 소수가 아니니 true
        isNotPrime[0] = true;
        isNotPrime[1] = true;

        for(int i = 2; i <= Math.sqrt(n); i++){
            if(isNotPrime[i] == false){ // 처음 작은수는 소수
                for(int j = i * i; j <= n; j+= i){ // 해당수의 배수들은 소수가 아님
                    isNotPrime[j] = true;
                }
            }
        }

        int sum = 0;
        for(boolean check : isNotPrime){ // 개수 세기
            if(!check) sum++;
        }

        return sum;
    }
}