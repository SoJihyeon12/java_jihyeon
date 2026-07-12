package ch05.list;

public interface MyList<E> {
    /**
     * 지정한 데이터를 마지막 요소로 추가한다.
     * @param obj 추가할 데이터
     */
    void add(E obj);

    /**
     * 지정한 데이터를 index 위치에 삽입한다.
     * @param index 삽입할 위치
     * @param obj 삽입할 데이터
     */
    void add(int index, E obj);

    /**
     * 지정한 index의 데이터를 삭제한다.
     * @param index 삭제할 위치
     */
    void remove(int index);

    /**
     * 지정한 index의 데이터를 조회한다.
     * @param index 조회할 데이터
     * @return
     */
    E get(int index);

    /**
     * 데이터의 수를 반환한다.
     * @return
     */
    int size();
}