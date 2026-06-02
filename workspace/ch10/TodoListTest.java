package ch10;

public class TodoListTest {
    void printTodoList(String[] list){
        for(String todo : list){
            System.out.println(todo);
        }

    }
    void main(){
        String[] todoList = {"자바 시험", "2주차 수업 복습", "객체 공부"};
        printTodoList(todoList);
    }
}
