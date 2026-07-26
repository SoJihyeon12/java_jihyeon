package ch02.list;
// 이 코드는 자바의 ArrayList를 직접 만들어 본 클래스
// 배열(Object[])을 이용해서 추가(add), 삭제(remove), 조회(get), 크기(size) 기능을 구현한 것입니다.

/**
 * 배열의 불편한점은 다음과 같다.
 * 생성시 길이를 지정해야 함.
 * 생성된 배열의 길이는 수정 못함.
 * 요소 추가, 삭제, 삽입이 어려움.
 *
 * 이러한 불편한 점을 개선하여 배열을 쓰기 쉽게 만드는 클래스
 */
public class MyArray<E> implements MyList<E> { // MyArray라는 제네릭 클래스를 만들고, MyList 인터페이스를 구현하겠다. = MyArray의 E를 MyList에도 그대로 전달해서 사용하겠다
// <E>는 제네릭(Generic) 타입입니다. 아직 자료형을 정하지 않았다. 나중에 사용할 때 결정하겠다 라는 뜻이다. 즉, 하나의 클래스로 여러 자료형을 사용할 수 있습니다.
// implements는 인터페이스의 기능을 구현하겠다 라는 뜻, 만약 MyList 인터페이스 안에 메서드가 있다면 MyList에 있는 메서드를 MyArray에서 반드시 구현하겠습니다 라는 의미, 그러므로 메서드를 꼭 구현해야 한다.

    /**
     * 내부적으로 요소를 저장하는 배열 선언
     */
    private Object[] data; //중요한 실제 데이터를 저장하는 배열입니다. 클래스 내부에서 안전하게 관리하려고 만든, 모든 종류의 데이터(객체)를 다 담을 수 있는 배열 변수
    // Object : 최상위 부모 클래스, 어떤 형태의 객체든 다 담을 수 있습니다.
    /**
     * 배열의 실제 담겨있는 요소의 개수
     */
    private int count; // 외부에 드러내지 않고 안전하게 관리하는 '개수 카운터(정수 변수)

    /**
     * 기본 생성자
     * 초기 배열의 크기를 10개로 지정한다.
     */
    public MyArray(){ //기본 생성자(Default Constructor)로 객체를 만들 때, 초기 크기를 10으로 지정하면서 다른 생성자를 호출하는 코드
        this(10); //즉, 현재 객체의 data 변수에 크기가 size인 Object 배열을 저장한다는 뜻
    }

    /**
     * 초기 배열의 크기를 지정한 size로 생성한다.
     * @param size 배열의 초기 크기
     */
    public MyArray(int size){ //이 생성자는 배열의 초기 크기를 사용자가 원하는 크기로 만들 수 있게 해주는 생성자입니다.
        this.data = new Object[size];
    }

    /**
     * 배열의 마지막 위치에 지정한 elem를 추가한다.
     * @param elem 추가할 요소
     */
    public void add(E elem){ // E elem: E 타입의 변수 elem
        add(count, elem); // 같은 클래스 안에 있는 다른 add() 메서드를 호출하는 것, 바로 밑에 있는 add 메서드
    }
    // MyArray<String> arr = new MyArray<>();라고 만들었다면 E = String이 되어 arr.add("사과");를 호출하면 public void add(String elem)처럼 동작합니다. 즉, elem = "사과"가 됩니다.
    // MyArray<Integer> arr = new MyArray<>();라면 E = Integer가 되므로 arr.add(10);은 내부적으로 public void add(Integer elem)처럼 동작하고 elem = 10이 됩니다.
    // 현재 배열이 인텍스 0부터 5까지 있는데 데이터 개수 count가 3이라면 인덱스 0,1,2에 데이터가 들어있는 건데, add(count, "D");이라면 인덱스 3에 D를 넣어라라는 말로 연결된다는 것,
    // 왜 add 안에서 또 add를 호출하지?
    // 같은 이름의 add라도 매개변수가 다르면 다른 메서드이다. 이를 메서드 오버로딩이라고 합니다.

    /**
     * 배열의 index에 elem를 삽입한다.
     * @param index 삽입할 위치
     * @param elem 삽입할 요소
     */
    public void add(int index, E elem){ // 원하는 위치(index)에 데이터를 삽입하는 메서드, int index : 데이터를 넣을 위치, E elem : 넣을 데이터
        if(index < 0){ // 인덱스가 0보다 작으면 ArrayIndexOutOfBoundsException(배열의 인덱스가 범위를 벗어났습니다) 예외를 발생시키고, 현재 인덱스 < 0"이라는 오류 메시지를 함께 출력하는 코드입니다.
            throw new ArrayIndexOutOfBoundsException(index + " < 0"); // throw는 강제로 예외를 발생시켜라 라는 뜻, new는 새로운 객체를 만드는 키워드, 여기서는 새로운 예외 객체를 만들고 있습니다.
        }else if(index > count){ // 이 코드는 삽입하려는 위치(index)가 현재 저장된 데이터 개수(count)보다 크면 예외를 발생시키는 코드, count는 현재 저장된 데이터의 개수인데 count가 3이면 인덱스 0부터 2까지 3개의 데이터가 있고 넣을 수 있는 인덱스 위치는 (데이터 개수인) 3인데 인덱스 5에다 사과를 넣는다고 하면 예외 발생하는 것
            throw new ArrayIndexOutOfBoundsException(index + " > " + count); // throw는 강제로 예외를 발생시켜라 라는 뜻, new는 새로운 객체를 만드는 키워드, 여기서는 새로운 예외 객체를 만들고 있습니다.
        }
        // ArrayIndexOutOfBoundsException은 배열의 인덱스가 허용된 범위를 벗어났다는 예외, index + " > " + count 이건 오류메시지 만드는 코드, index가 5라면 5>3 으로 나와서 인덱스가 크다는 표시를 함

        if(count >= data.length) { // 이 부분은 배열이 꽉 찼을 때 더 큰 배열을 만들어 기존 데이터를 옮기는 코드(1.5배), (count >= data.length): 배열이 꽉 찼는지 확인, count : 현재 저장된 데이터 개수, data.length : 배열의 전체 크기
            Object[] temp = new Object[data.length + data.length/2]; // 새로운 배열을 만듭니다. 기존 배열이 길이 10이라면 10 + 10/2 = 15로 나온 것을 new Object[15]를 만든다. 기존보다 1.5배 큰 배열입니다.
            for(int i=0; i<data.length; i++){ //새 배열은 비어 있으므로 기존 배열의 데이터를 하나씩 복사합니다. data.length만큼 반복
                temp[i] = data[i]; //data 배열의 i번째 값을 temp 배열의 i번째 위치에 저장한다.
            }
            System.out.println(data.length + " -> " + temp.length); //이 코드는 배열 크기가 얼마나 늘어났는지 확인하기 위한 출력입니다.
            data = temp; //이 줄이 가장 중요합니다. data가 옛날배열을 가리키고 있던 걸, data가 새 배열을 가리키도록 변경한다. 기존 작은 배열은 더이상 사용되지 않으므로 나중에 가비지 컬렉터가 메모리에서 정리함
        }

        // 새로운 데이터를 중간에 삽입하기 위해 index부터 마지막 데이터까지를 한 칸씩 뒤로 밀고, 빈 자리에 데이터를 넣는 코드입니다.
        System.arraycopy(data, index, data, index+1, count-index); // 인덱스 0부터 3까지 A,B,C,D가 있는데 add(1, "X");를 실행한다고 하면 index 1 자리에다가 X를 넣는다는 것, index=1부터 자리잡고 있는 B,C,D는 한칸씩 뒤로 이동함, 2,3,4자리에 안착함. 1번 자리가 비니까 거기에 X들어감, count-index는 복사(이동시킬)할 개수
        data[index] = elem; //이제 빈 자리에 새로운 데이터를 넣습니다.
        count++; // 데이터를 하나 추가했으므로 저장된 데이터 개수도 1 증가시킵니다.
    }

    /**
     * 지정한 index의 요소를 삭제한다.
     * @param index
     */
    public void remove(int index){ // 이 remove() 메서드는 배열에서 지정한 위치(index)의 데이터를 삭제하는 메서드, remove : 데이터를 삭제하는 메서드, int index : 삭제할 위치
        if(index >= count){ //삭제할 위치가 올바른지 확인합니다. 삭제할 인덱스가 3인데(인덱스0~3) 카운트가 3이면(인덱스0~2) 인덱스3에는 아무런 데이터가 없는것, 인덱스 3에는 삭제할 데이터가 없기 때문에 예외 발생
            throw new ArrayIndexOutOfBoundsException(index + " >= " + count); // throw는 강제로 예외를 발생시켜라 라는 뜻, new는 새로운 객체를 만드는 키워드, 여기서는 새로운 예외 객체를 만들고 있습니다. ArrayIndexOutOfBoundsException은 배열의 인덱스가 허용된 범위를 벗어났다는 예외, 예외메시지도 함께 내보냄
        }else if(index < 0){ // 삭제할 인덱스가 0보다 작으면, 예를 들어 -1이라면
            throw new ArrayIndexOutOfBoundsException(index + " < 0"); // 강제 예외 객체 생성, 예외 메시지 표시
        }
        // ArrayIndexOutOfBoundsException은 배열의 인덱스가 허용된 범위를 벗어났다는 예외

        // 삭제할 위치 다음(index+1)부터 마지막 데이터까지를 한 칸 앞으로 당겨 복사하는 작업
        // System.arraycopy(data(원본배열), index+1(원본시작위치), data(대상배열=원본배열), index(대상위치), count-index-1(복사할 개수));
        System.arraycopy(data, index+1, data, index, count-index-1); // 예를들어 인덱스 0~3까지 A~D가 있는데 remove(1);을 실행하면 삭제할 것은 B이다. 그러면 인덱스 2~3에 있던 C,D가 앞으로 당겨 복사되어 인덱스 0부터 2까지 A,C,D가 된다. B는 삭제됨
        count--; // 데이터 개수 감소
        data[count] = null; // 마지막 칸을 null로 만들기, 마지막 칸(인덱스)에 있던 D를 지우려고 NULL처리함
    }

    /**
     * 지정한 위치의 데이터를 반환한다.
     * @param index 반환할 데이터의 위치
     * @return 지정한 위치의 데이터
     */
    public E get(int index){ // 이 get() 메서드는 지정한 위치(index)에 있는 데이터를 꺼내서 반환하는 메서드, E : 반환하는 데이터의 자료형(제네릭 타입), get : 데이터를 가져오는 메서드, int index : 가져올 위치
        if(index >= count){ // 첫 번째 범위 검사, 데이터 개수가 3개인데(인덱스 0~2) 인덱스 3에 있는 걸 꺼내려고 한다면 TRUE 발생해서 예외 발생시킴
            throw new ArrayIndexOutOfBoundsException(index + " >= " + count); // ArrayIndexOutOfBoundsException은 배열의 인덱스가 허용된 범위를 벗어났다는 예외, 예외 메시지 표시
        }else if(index < 0){ // 두 번째 범위 검사, 인덱스가 -1인 데이터를 꺼내려고 한다면 TRUE 발생해서 예외 발생시킴
            throw new ArrayIndexOutOfBoundsException(index + " < 0"); // ArrayIndexOutOfBoundsException은 배열의 인덱스가 허용된 범위를 벗어났다는 예외, 예외 메시지 표시
        }
        return (E)data[index]; //데이터 반환, 왜 (E)를 붙일까요? data는 private Object[] data;입니다. Object 타입으로 저장되어 있습니다. 하지만 get()은 public E get(...)이므로 반환형은 E여야 한다. 반환형 E가 String 이면 반환값도 String으로 형변환해서 나타난다.
    }
    // public E get(int index)가 예를 들어 MyArray<String> arr = new MyArray<>();라면 E = String이므로 public String get(int index)처럼 동작한다.

    public int size(){ // 현재 MyArray에 저장되어 있는 데이터의 개수(count)를 반환하는 메서드입니다. 배열의 전체 크기(data.length)가 아니라 실제로 들어 있는 데이터 개수(count)를 돌려줍니다.
        return this.count;
    }

    @Override // @Override는 부모 클래스(Object)의 toString() 메서드를 새롭게 재정의(오버라이드)하겠다는 의미, toString() : 객체를 문자열로 변환하는 메서드
    public String toString(){ // 이 메서드는 MyArray 객체를 문자열(String) 형태로 보기 좋게 출력하기 위해 오버라이드한 메서드, 원래 Object의 toString()은 ch02.list.MyArray@4eec7777처럼 객체의 주소 비슷한 값을 출력합니다. 하지만 우리는 [사과, 바나나, 포도]처럼 출력하고 싶기 때문에 toString()을 다시 작성한 것입니다.
//        StringBuffer str = new StringBuffer("["); // 멀티 스레드 환경에서 사용, 멀티 스레드 환경(Multi-threaded Environment)이란 여러 개의 스레드(Thread)가 동시에 하나의 프로그램에서 실행되는 환경, 스레드는 직원이라고 생각하면 됨, 직원이 많으면 여러일 동시에 처리가능하지만 서로의 작업이 겹칠수도 있고 어느것이 먼저 실행될지 예측불가하다는 문제있음, 그래서 StringBuffer가 있다
        // StringBuffer는 내부적으로 동기화(synchronized)를 사용하여, 한 스레드가 작업 중일 때 다른 스레드가 동시에 접근하지 못하게 합니다. 스트링빌더보다 조금 느리지만 더 효율적이다. 스레드가 안전하다는 장점이 있다.
        StringBuilder str = new StringBuilder("["); // 싱글 스레드 환경에서 사용, 하나의 스레드에서 사용, 더 빠름, 여기서는 혼자 사용하는(직원이 하나) 프로그램이므로 StringBuilder를 사용했습니다.
        // StringBuilder는 문자열을 효율적으로 이어 붙이는 클래스입니다.

        // 이 부분은 배열에 있는 데이터를 [A, B, C] 형태의 문자열로 만드는 핵심 코드
        if(count > 0) { //count > 0은 데이터가 1개 이상 있으면 이라는 뜻, 데이터가 있을 때만 첫 번째 값을 출력합니다.
            str.append(data[0]); // str은 앞에서 StringBuilder str = new StringBuilder("[");를 실행했으므로 str = "["이다. data[0]이 만약 사과라면 "[사과" 가 된다.
        }

        // 여기서는 두 번째 데이터부터 마지막 데이터까지 출력합니다.
        for(int i=1; i<count; i++){ // 왜 i = 1부터 시작할까요? 첫 번째 데이터(data[0])는 이미 위에서 출력했기 때문입니다.
            str.append(", ").append(data[i]); //,를 붙이고 다음 값을 붙인다. 왜 첫 번째"[사과"를 따로 출력할까요? 이 두번째 방식대로 하면 "[,사과"가 되기 때문에
        }

        str.append("]"); //마지막 ] 붙이기,

        return str.toString();
        //str은 StringBuilder 객체이다. str은 (int 자료형처럼) StringBuilder 자료형이라는 소리, 반면 toString() 메서드는 반환형이 String입니다. 이 toString() 메서드는 String을 반환해야한다는 말, 그래서 str.toString()으로 형변환 시켜줌, str.toString(): StringBuilder 안에 만들어 놓은 내용을 진짜 문자열(String)로 바꿔 달라는 의미입니다.
    }

}