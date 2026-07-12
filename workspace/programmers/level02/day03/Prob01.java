/* 나머지 구하기
 *
 * [문제 설명]
 * 정수 num1과 num2가 매개변수로 주어질 때, num1을 num2로 나눈 나머지 값을 return 하도록 solution 함수를 완성해주세요.
 *
 * [제한사항]
 * 0 < num1 <= 100
 * 0 < num2 <= 100
 *
 * [입출력 예]
 * num1 | num2 | result
 * 3 | 2 | 1
 * 10 | 5 | 0
 *
 * [입출력 예 설명]
 * 예제 1번: num1이 3, num2가 2이므로 3을 2로 나눈 나머지 1을 return 합니다.
 * 예제 2번: num1이 10, num2가 5이므로 10을 5로 나눈 나머지 0을 return 합니다.
 */

package level02.day03;

public class Prob01 {
    public int solution(int num1, int num2) {
        int answer = num1 % num2;
        return answer;
    }

    void main() {
        System.out.println(solution(3, 2));
        System.out.println(solution(10, 5));
    }
}