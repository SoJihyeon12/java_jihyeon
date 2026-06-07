package ch10;

public class TodoListTest {
    void printTodoList(String[] list){ // 2번, 전달받은 배열을 이 메서드 안에서는 list라고 부를게 라는 뜻
        for(String todo : list){
            System.out.println(todo);
        }

    }
//  for(String todo : list)는 아래와 같다.
//  for(int i = 0; i < list.length; i++){
//      String todo = list[i];
//      System.out.println(todo);
//  }


    void main(){ // 1번
        String[] todoList = {"자바 시험", "2주차 수업 복습", "객체 공부"};
        printTodoList(todoList);
    }
}
//  todoList는 main()의 변수 이름이고,
//  list는 printTodoList() 메서드 안에서 사용하는 매개변수 이름이다.
//  호출할 때 todoList가 list로 전달된다. todoList와 list는 이름만 다르고 같은 배열을 가리킨다.

// 자바 프로그램의 시작점은 반드시 public static void main(String[] args) 형태의 main 메서드이다.
// 1. 그러므로 main()이 먼저 시작
// 2. main() 안에서 printTodoList(todoList)를 호출, 호출은 "이 메서드를 실행해!"라고 "요청"하는 것
// 3. printTodoList() 실행
// 4. 끝나면 다시 main()으로 돌아옴