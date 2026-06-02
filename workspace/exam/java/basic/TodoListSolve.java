/*
[생성 가이드]
IntelliJ IDEA의 프로젝트 탐색기에서 workspace 폴더를 마우스 우클릭한 후
New > Java Class를 선택하고, 클래스명 입력란에 exam.java.basic.TodoList 를 입력하여 생성하세요.
파일을 생성한 후 아래의 문제 코드 전체를 붙여넣고 빈칸을 채워 완성해 주세요.
[문제 설명]
일일 할 일 목록(TodoList) 문자열 배열 데이터를 분석하고 번호를 매겨 출력하는 프로그램입니다.
아래의 코드에서 빈칸 1부터 10까지 채워 프로그램을 완성하세요.
[정답 제출 안내]
- 완성된 소스코드 전체를 복사하여 제출해 주세요.
- 채점 기준은 빈칸 1개당 6점입니다. (총 60점 만점)
- 컴파일 에러가 있더라도 코드 논리에 따라 부분 점수가 부여되니 최대한 작성하여 제출해 주세요.
- 정답을 제출하면 일단 0점으로 처리되고 수기로 채점이 완료되면 실제 점수가 입력됩니다.
[예상 출력 결과]
오늘의 할 일 개수: 3개
오늘의 할 일 목록
----------------
1. 자바 공부하기
2. 운동하기
3. 독서하기
내일의 할 일 개수: 5개
내일의 할 일 목록
----------------
1. 마트가기
2. 청소하기
3. 우편물찾기
4. 부모님께 전화하기
5. 저녁식사 준비하기
*/
package exam.java.basic;

public class TodoListSolve {
    // 1. 할 일 목록 배열을 전달받아 전체 할 일 개수를 반환하는 메서드
    int getTodoCount(String[] list) {
        return list.length;
    }

    // 2. 할 일 목록 배열을 전달받아 번호와 함께 목록을 출력하는 메서드
    void printTodoList(String[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.println("4/8.   " + (i + 1) + ". " + list[i]);
        }
    }

    void main() {
        // 3. 문자열 배열 변수 todayTodoList 선언
        String[] todayTodoList;
        // 4. 문자열 배열 생성 및 할 일 목록 초기화
        todayTodoList = new String[] {"자바 공부하기", "운동하기", "독서하기"};
        // 5. 전체 할 일 개수를 가져오는 메서드 호출
        int count = getTodoCount(todayTodoList);
        System.out.println("1. 오늘의 할 일 개수: " + count + "개");
        System.out.println("2. 오늘의 할 일 목록");
        System.out.println("3. ----------------");
        // 6. 할 일 목록을 출력하는 메서드 호출
        printTodoList(todayTodoList);
        System.out.println(); // 한 줄 개행
        // 5개짜리 내일의 할 일 목록 생성 및 출력
        String[] tomorrowTodoList = {"마트가기", "청소하기", "우편물찾기", "부모님께 전화하기", "저녁식사 준비하기"};
        count = getTodoCount(tomorrowTodoList);
        System.out.println("5. 내일의 할 일 개수: " + count + "개");
        System.out.println("6. 내일의 할 일 목록");
        System.out.println("7. ----------------");
        printTodoList(tomorrowTodoList);
    }
}
