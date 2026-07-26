package ch05.list;
// 이 코드는 리스트(List)가 반드시 가져야 하는 기능을 정의한 인터페이스
// 리스트를 만들려면 이 메서드들은 반드시 만들어야 한다. 라는 규칙(설계도)입니다.
// 인터페이스(Interface)란? 인터페이스는 메서드의 이름과 기능만 약속해 놓은 것입니다.

public interface MyList<E> { // MyList라는 제네릭 인터페이스를 만든 것입니다. <E>란? E는 Element(요소)의 약자, 어떤 자료형이 들어올지는 나중에 결정하겠다.라는 의미
    /**
     * 지정한 데이터를 마지막 요소로 추가한다.
     * @param obj 추가할 데이터
     */
    void add(E obj); // 리스트의 맨 뒤에 데이터를 추가하는 메서드입니다.

    /**
     * 지정한 데이터를 index 위치에 삽입한다.
     * @param index 삽입할 위치
     * @param obj 삽입할 데이터
     */
    void add(int index, E obj); // 원하는 위치에 데이터를 삽입합니다.

    /**
     * 지정한 index의 데이터를 삭제한다.
     * @param index 삭제할 위치
     */
    void remove(int index); // 지정한 위치의 데이터를 삭제합니다.

    /**
     * 지정한 index의 데이터를 조회한다.
     * @param index 조회할 데이터
     * @return
     */
    E get(int index); // 지정한 위치의 데이터를 가져옵니다. 반환형이 E인 이유는 저장된 데이터의 자료형을 그대로 반환하기 때문입니다.

    /**
     * 데이터의 수를 반환한다.
     * @return
     */
    int size(); // 리스트에 저장된 데이터 개수를 반환합니다.
}