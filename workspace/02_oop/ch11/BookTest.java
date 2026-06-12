package ch11;

// 하나의 소스코드(.java) 내에 여러개의 클래스를 정의할 수 있음
// 단, public class는 하나에만 지정 가능하고 파일명과 동일한 클래스에만 지정 가능함
class Book {
    String title;
    String author;

    // 생성자 작성
    Book() {
//        this.title = "제목미상";
//        this.author = "작가미상";
        this("제목미상", "작가미상"); // 자신의 생성자 호출
    }

    // 생성자 작성
    Book(String title, String author){
        this.title = title;
        this.author = author;
    }
}

public class BookTest {
    public static void main(){
        Book book1 = new Book();
        book1.title = "자바 기초";
        book1.author = "자바의신";

        Book book2 = new Book("자바를 자바라!", "용쌤");
        book2.title = "바뀐 제목";

        System.out.println("제목: " + book1.title + ", 작가: " + book1.author);
        System.out.println("제목: " + book2.title + ", 작가: " + book2.author);
    }
}
