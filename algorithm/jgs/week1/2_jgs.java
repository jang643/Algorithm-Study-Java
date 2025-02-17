/* 문제 요약: 주어진 숫자보다 더 큰 숫자이면서 2진수일때 1의 개수가 같은 숫자중 가장 작은수
 의사 코드:
1. 입력받기
2. 입력수 2진수 변환
3. 1개수 세기
4. 더큰숫자중 1의 개수가 같은 수 찾기
5. 시간 복잡도: O(n · log n)라고 함
*/

class Solution {
    public int solution(int n) {
        int answer = n;
        int count = getCount(n);
        //입력값보다 1씩 더하면서 조건에 해당하는 값 찾기
        while(true){
            answer++;
            if(count == getCount(answer)) return answer;
        }
    }


    private static int getCount(int n) {
        //입력값 2진수 string으로 변환
        String str = Integer.toBinaryString(n);
        int count = 0;
        //반복분 돌면서 1개수 세기
        for(char c : str.toCharArray()){
            if(c == '1') count++;
        }
        //1 개수 반환
        return count;
    }
}