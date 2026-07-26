package ch05.list;
// 이 코드는 **MyArray<E>**라는 배열(Array)을 더 편리하게 사용할 수 있도록 만든 사용자 정의(ArrayList와 비슷한) 클래스입니다.
// Java의 ArrayList를 직접 구현한 것과 거의 비슷한 구조입니다.
// 배열은 다음과 같은 불편한 점이 있습니다.
//생성할 때 크기를 정해야 한다.
//크기를 바꿀 수 없다.
//중간에 데이터를 삽입하거나 삭제하기 어렵다.
//
//그래서 이 클래스는 이러한 문제를 해결하여
//자동으로 크기를 늘리고
//중간 삽입과 삭제가 가능하도록
//만든 클래스입니다.

/**
 * 배열의 불편한점은 다음과 같다.
 * 생성시 길이를 지정해야 함.
 * 생성된 배열의 길이는 수정 못함.
 * 요소 추가, 삭제, 삽입이 어려움.
 *
 * 이러한 불편한 점을 개선하여 배열을 쓰기 쉽게 만드는 클래스
 */
public class MyArray<E> implements MyList<E> { // MyArray라는 이름의 제네릭 클래스입니다. <E>는 데이터의 자료형을 나중에 결정하겠다는 의미입니다. implements MyList<E>: MyList 인터페이스를 구현하겠다는 뜻입니다.

    /**
     * 내부적으로 요소를 저장하는 배열 선언
     */
    private Object[] data; // 실제 데이터를 저장하는 배열입니다.
    /**
     * 배열의 실제 담겨있는 요소의 개수
     */
    private int count; // 현재 저장된 데이터 개수입니다.

    /**
     * 기본 생성자
     * 초기 배열의 크기를 10개로 지정한다.
     */
    public MyArray(){ // 기본 생성자, new MyArray<>()를 하면 자동으로 this(10);이 실행됨
        this(10);
    }

    /**
     * 초기 배열의 크기를 지정한 size로 생성한다.
     * @param size 배열의 초기 크기
     */
    public MyArray(int size){ // 생성자, 배열을 생성합니다.
        this.data = new Object[size];
    }

    /**
     * 배열의 마지막 위치에 지정한 elem를 추가한다.
     * @param elem 추가할 요소
     */
    public synchronized void add(E elem){ // add(E elem): 맨 뒤에 데이터를 추가합니다. list.add("사과");이면 실제로는 add(count, "사과");가 호출됨
        add(count, elem);
    }

    /**
     * 배열의 index에 elem를 삽입한다.
     * @param index 삽입할 위치
     * @param elem 삽입할 요소
     */
    // 원하는 위치에 데이터를 삽입하는 메서드입니다.
    public synchronized void add(int index, E elem){ // 여러 스레드가 동시에 add()를 호출해도 한 번에 하나의 스레드만 이 메서드를 실행하도록 합니다. 스레드1만 add()하고 스레드2는 기다려서 데이터가 꼬이지 않게끔 하는 것
        if(index < 0){ // 인덱스 검사, 음수면 예외 발생
            throw new ArrayIndexOutOfBoundsException(index + " < 0");
        }else if(index > count){ // 현재 데이터 개수보다 큰 위치도 예외 발생
            throw new ArrayIndexOutOfBoundsException(index + " > " + count);
        }

        if(count >= data.length) { // 내부 배열의 공간이 다 찼을 경우 배열의 크기를 늘린다.(1.5배), 배열이 꽉 찼는지 확인
            Object[] temp = new Object[data.length + data.length/2]; // 배열을 1.5배로 늘립니다.
            for(int i=0; i<data.length; i++){ // 새 배열에 기존 데이터를 복사합니다.
                temp[i] = data[i];
            }
//            System.out.println(data.length + " -> " + temp.length);
            data = temp; // 새 배열을 사용합니다.
        }

        // index부터 끝까지 하나씩 뒤로 미는 작업
        System.arraycopy(data, index, data, index+1, count-index); // 인덱스 0~2가 사과, 포도, 수박인데 add(1,"바나나");하면 사과 포도 포도 수박처럼 뒤로 한칸씩 밀고 data[index]=elem;를 실행하여 사과 바나나 포도 수박이 됨
        data[index] = elem; //새 데이터를 저장합니다.
        count++; // 개수 증가
    }

    /**
     * 지정한 index의 요소를 삭제한다.
     * @param index
     */
    public synchronized void remove(int index){ // 데이터를 삭제하는 메서드입니다.
        if(index >= count){ // 인덱스 범위 검사
            throw new ArrayIndexOutOfBoundsException(index + " >= " + count);
        }else if(index < 0){ // 인덱스 범위 검사
            throw new ArrayIndexOutOfBoundsException(index + " < 0");
        }

        // index부터 끝까지 하나씩 앞으로 당기는 작업
        System.arraycopy(data, index+1, data, index, count-index-1); // 사과 바나나 포도 수박 remove(1);하면 사과 포도 수박 수박처럼 당겨지고
        count--; // 개수 감소 시키고
        data[count] = null; // 마지막 데이터 제거
    }

    /**
     * 지정한 위치의 데이터를 반환한다.
     * @param index 반환할 데이터의 위치
     * @return 지정한 위치의 데이터
     */
    public E get(int index){ //원하는 위치의 데이터를 반환합니다.
        if(index >= count){ // 인덱스 범위 검사
            throw new ArrayIndexOutOfBoundsException(index + " >= " + count);
        }else if(index < 0){ // 인덱스 범위 검사
            throw new ArrayIndexOutOfBoundsException(index + " < 0");
        }
        // 이 코드는 배열에서 원하는 위치(index)의 데이터를 꺼내서 반환하는 코드입니다. 사용할 때 MyArray<String> arr = new MyArray<>();라고 하면 E->String이 된다. 그래서 (String) data[index]처럼 동작함
        return (E)data[index]; // data는 Object[]이므로 원래 타입으로 바꿔야 합니다. 예를들어 Object -> String
    }

    public int size(){ // 저장된 데이터 개수를 반환합니다.
        return this.count;
    }

    @Override
    public String toString(){ // 리스트를 문자열로 출력하는 메서드입니다. [사과, 포도, 수박]처럼 출력됨
//        StringBuffer str = new StringBuffer("["); // 멀티 스레드 환경에서 사용
        StringBuilder str = new StringBuilder("["); // 싱글 스레드 환경에서 사용, StringBuilder : 문자열을 효율적으로 이어 붙이기 위해 사용합니다.

        if(count > 0) { // 리스트에 데이터가 1개 이상 있는지 확인하는 것입니다.
            str.append(data[0]); // 첫 번째 데이터를 문자열에 추가합니다. 왜 첫 번째 요소를 따로 추가할까? for문 돌리면 [, 사과, 바나나, 포도]처럼 돼서
        }

        for(int i=1; i<count; i++){ // 나머지 데이터 문자열에 추가
            str.append(", ").append(data[i]);
        }

        str.append("]"); //count가 0보다 작으면 이거 실행하고, 모든 데이터 다 for문 돌렸을 때 이거 닫아준다.

        return str.toString(); // StringBuilder를 String(문자열)로 변환해서 반환합니다. 예를 들어 System.out.println(list);를 실행하면 toString()이 자동으로 호출되어 [사과, 바나나, 포도]가 출력됨
    }

}