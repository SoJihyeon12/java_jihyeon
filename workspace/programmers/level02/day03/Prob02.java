/* 중앙값 구하기
 *
 * [문제 설명]
 * 중앙값은 어떤 주어진 값들을 크기의 순서대로 정렬했을 때 가장 중앙에 위치하는 값입니다.
 * 예를 들어 1, 2, 7, 10, 11의 중앙값은 7입니다.
 * 정수 배열 array가 매개변수로 주어질 때, 중앙값을 return 하도록 solution 함수를 완성해보세요.
 *
 * [제한사항]
 * array의 길이는 홀수입니다.
 * 0 < array의 길이 < 100
 * -1000 < array의 원소 < 1000
 *
 * [입출력 예]
 * array | result
 * [1, 2, 7, 10, 11] | 7
 * [9, -1, 0] | 0
 *
 * [입출력 예 설명]
 * 예제 1번: 본문 설명과 같습니다.
 * 예제 2번: 9, -1, 0을 정렬하면 -1, 0, 9가 되므로 중앙값은 0입니다.
 */

package level02.day03;

import java.util.Arrays;

public class Prob02 {
    public int solution(int[] array) {
        // 배열을 오름차순으로 정렬합니다.
        Arrays.sort(array);
        // 배열의 중간 인덱스의 값을 찾아 반환합니다.
        int answer = array[array.length / 2];
        return answer;
    }

    void main() {
        System.out.println(solution(new int[]{1, 2, 7, 10, 11}));
        System.out.println(solution(new int[]{9, -1, 0}));
    }
}