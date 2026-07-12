/* 배열 두배 만들기
 *
 * [문제 설명]
 * 정수 배열 numbers가 매개변수로 주어집니다.
 * numbers의 각 원소에 두배한 원소를 가진 배열을 return하도록 solution 함수를 완성해주세요.
 *
 * [제한사항]
 * -10,000 <= numbers의 원소 <= 10,000
 * 1 <= numbers의 길이 <= 1,000
 *
 * [입출력 예]
 * numbers | result
 * [1, 2, 3, 4, 5] | [2, 4, 6, 8, 10]
 * [1, 2, 100, -99, 1, 2, 3] | [2, 4, 200, -198, 2, 4, 6]
 *
 * [입출력 예 설명]
 * 예제 1번: [1, 2, 3, 4, 5]의 각 원소에 두배를 한 배열 [2, 4, 6, 8, 10]을 return합니다.
 * 예제 2번: [1, 2, 100, -99, 1, 2, 3]의 각 원소에 두배를 한 배열 [2, 4, 200, -198, 2, 4, 6]을 return합니다.
 */

package level02.day02;

public class Prob04 {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        // 배열의 각 원소를 순회하며 2배를 곱해 새로운 배열에 저장합니다.
        for (int i = 0; i < numbers.length; i++) {
            answer[i] = numbers[i] * 2;
        }
        return answer;
    }

    void main() {
        System.out.println(java.util.Arrays.toString(solution(new int[]{1, 2, 3, 4, 5})));
        System.out.println(java.util.Arrays.toString(solution(new int[]{1, 2, 100, -99, 1, 2, 3})));
    }
}