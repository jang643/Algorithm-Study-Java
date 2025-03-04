/* 문제 요약: 펠린드롬 판단 확인
 의사 코드:
1. 기존 코드 복붙하기
2. 입력 받기
3. 펠린드롭 여부와 카운트를 저장하기 위한 객체 만들기
4. 순서대로 출력을 위한 큐 선언
5. 펠린드롬 메서드 결과를 큐에 넣기
6. 큐 내용 출력
*/
public class Main {
    static Queue<index> q = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int length = Integer.parseInt(br.readLine());
        for(int i = 0; i < length; i++){
            isPalindrome(br.readLine());
        }

        for(index i : q){
            bw.write(i + "\n");
        }
        bw.flush();
    }

    static void recursion(final String str, int l, int r, int count){
        if(l >= r) q.add(new index(1, count));
        else if(str.charAt(l) != str.charAt(r))  q.add(new index(0,count));
        else recursion(str, l+1, r-1,count + 1);
    }

    static void isPalindrome(final String str){
        recursion(str, 0, str.length()-1, 1);
    }

    static class index{
        int result;
        int count;

        public index(int result, int count){
            this.result = result;
            this.count = count;
        }

        @Override
        public String toString() {
            return result + " " + count;
        }
    }
}