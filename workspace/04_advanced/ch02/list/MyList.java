package ch02.list;
// 이 코드는 **MyList라는 인터페이스(interface)**입니다. 이 기능들은 반드시 만들어라.라고 약속하는 설계도입니다
// 인터페이스는 "무슨 기능이 있어야 하는지"만 정의하고, 실제 동작은 적지 않는 설계도이다.
// MyList는 "리스트라면 반드시 갖춰야 할 기능들"을 정의한 인터페이스이고, MyLinkedList는 그 기능들을 실제 코드로 구현한 클래스입니다.

public interface MyList<E> { //public "interface" MyList<E>, <E>는 String이 될수도 있고 Integer가 될 수도 있따. 하나의 인터페이스를 여러 자료형에 사용 가능
    /**
     * 지정한 데이터를 마지막 요소로 추가한다.
     * @param obj 추가할 데이터
     */
    void add(E obj); //데이터를 맨 뒤에 추가하는 메서드를 반드시 만들어라.

    /**
     * 지정한 데이터를 index 위치에 삽입한다.
     * @param index 삽입할 위치
     * @param obj 삽입할 데이터
     */
    void add(int index, E obj); // 원하는 위치(index)에 데이터를 삽입하는 기능

    /**
     * 지정한 index의 데이터를 삭제한다.
     * @param index 삭제할 위치
     */
    void remove(int index); //원하는 위치의 데이터를 삭제하는 기능

    /**
     * 지정한 index의 데이터를 조회한다.
     * @param index 조회할 데이터
     * @return
     */
    E get(int index); // 원하는 위치의 데이터를 가져오는 기능

    /**
     * 데이터의 수를 반환한다.
     * @return
     */
    int size(); //현재 저장된 데이터 개수를 반환하는 기능
}