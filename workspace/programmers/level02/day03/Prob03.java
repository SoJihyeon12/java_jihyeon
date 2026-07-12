/* 최빈값 구하기
 *
 * [문제 설명]
 * 최빈값은 주어진 값 중에서 가장 자주 나오는 값을 의미합니다.
 * 정수 배열 array가 매개변수로 주어질 때, 최빈값을 return 하도록 solution 함수를 완성해보세요.
 * 최빈값이 여러 개면 -1을 return 합니다.
 *
 * [제한사항]
 * 0 < array의 길이 < 100
 * 0 <= array의 원소 < 1000
 *
 * [입출력 예]
 * array | result
 * [1, 2, 3, 3, 3, 4] | 3
 * [1, 1, 2, 2] | -1
 * [1] | 1
 *
 * [입출력 예 설명]
 * 예제 1번: [1, 2, 3, 3, 3, 4]에서 1은 1개, 2는 1개, 3은 3개, 4는 1개로 최빈값은 3입니다.
 * 예제 2번: [1, 1, 2, 2]에서 1은 2개, 2는 2개로 최빈값이 1과 2 두 개이므로 -1을 return 합니다.
 * 예제 3번: [1]에서 1은 1개이므로 최빈값은 1입니다.
 */

package level02.day03;

public class Prob03 {
    public int solution(int[] array) {
        // 0부터 999까지의 원소 범위를 가질 수 있으므로 크기 1000의 빈도수 배열을 만듭니다.
        int[] count = new int[1000];

        // 각 숫자의 출현 횟수를 누적합니다.
        for (int num : array) {
            count[num]++;
        }

        int maxCount = 0;
        int answer = -1;

        // 빈도수 배열을 조사하여 최빈값을 도출합니다.
        for (int i = 0; i < count.length; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                answer = i;
            } else if (count[i] == maxCount && maxCount > 0) {
                // 동일한 최대 빈도수가 존재할 경우 -1을 리턴하도록 처리
                answer = -1;
            }
        }

        return answer;
    }

    void main() {
        System.out.println(solution(new int[]{1, 2, 3, 3, 3, 4}));
        System.out.println(solution(new int[]{1, 1, 2, 2}));
        System.out.println(solution(new int[]{1}));
    }
}