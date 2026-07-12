/* 문자열 섞기
 *
 * [문제 설명]
 * 길이가 같은 두 문자열 str1과 str2가 주어집니다.
 * 두 문자열의 각 문자가 앞에서부터 서로 번갈아가면서 한 번씩 등장하는 문자열을 만들어 return 하는 solution 함수를 완성해 주세요.
 *
 * [제한사항]
 * 1 <= str1의 길이 = str2의 길이 <= 10
 * str1과 str2는 알파벳 소문자로 이루어진 문자열입니다.
 *
 * [입출력 예]
 * str1 | str2 | result
 * "aaaaa" | "bbbbb" | "ababababab"
 */

package level01.day03;

public class Prob01 {
    public String solution(String str1, String str2) {
        // 결과 문자열을 조립할 StringBuilder를 생성합니다.
        StringBuilder sb = new StringBuilder();
        // 번갈아가며 문자를 하나씩 가져와 빌더에 추가합니다.
        for (int i = 0; i < str1.length(); i++) {
            sb.append(str1.charAt(i));
            sb.append(str2.charAt(i));
        }

        String answer = sb.toString();
        return answer;
    }

    void main() {
        System.out.println(solution("aaaaa", "bbbbb"));
    }
}