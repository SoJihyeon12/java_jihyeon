package ch02.list;
// 이 코드는 앞에서 만든 배열(Array) 기반의 MyArray가 아니라, 연결 리스트(Linked List) 기반으로 만든 MyLinkedList입니다.
// 가장 큰 차이는 데이터를 저장하는 방식입니다. MyLinkedList는 노드(Node)를 연결해서 저장, 노드가 주소(참조)로 연결됨, 중간 삽입/삭제가 빠름

public class MyLinkedList implements MyList{
    // inner 클래스 정의
    private class Node { // Node는 연결 리스트의 한 칸을 의미합니다. 배열에서는 [A][B][C] 처럼 저장하지만, 연결 리스트에서는 [A] → [B] → [C] 처럼 저장합니다.
        /**
         * 저장할 객체
         */
        private Object data; // 노드 안에 저장되는 실제 데이터입니다.

        /**
         * 연결된 다음 노드를 참조하는 변수
         */
        private Node nextNode; // 다음 노드의 주소를 저장하는 변수입니다. 예를 들어 A → B → C 이라면 A.nextNode → B이다.

        Node(Object data){ //Node 객체를 만들 때 자동으로 실행되는 생성자 예를 들어 Node node = new Node("사과");를 실행하면 Node(Object data)가 자동실행됨, data = "사과"가 됨 (일반적으로 객체를 만들어야 생성자가 실행됨)
            this.data = data; // 객체 매개변수 data안에 사과를 넣는다.
            this.nextNode = null; // 다음노드에는 데이터가 없기 때문에 null로 만든다.
        }
    }

    /**
     * 첫번째 노드
     */
    private Node header; //헤더는 맨 앞에 있는 가짜 노드(Dummy Node) 입니다. 실제 데이터는 저장하지 않습니다.
    /**
     * 전체 요소의 수
     */
    private int size; // 현재 저장된 데이터 개수입니다.

    public MyLinkedList(){ // 리스트를 생성하면 null만 존재한다.
        header = new Node(null);
    }

    /**
     * data를 첫번째 요소로 추가한다.
     * @param data 추가할 요소
     */
    public void addFirst(Object data){ // 연결 리스트(LinkedList)의 맨 앞에 새로운 노드를 추가하는 메서드
        Node node = new Node(data);
        node.nextNode = header.nextNode; // header.nextNode는 첫 번째 노드(사과)를 가리키는 주소, node.nextNode = header.nextNode;를 실행하면 새 노드의 nextNode가 "사과"를 가리키게 됩니다.
        header.nextNode = node; // 이번에는 header가 첫 번째 노드로 포도를 가리키도록 변경합니다. header → 포도 → 사과
        size++; // 노드가 하나 늘어났으므로 사이즈를 늘려준다.
    }

    /**
     * data를 index 위치에 삽입한다.
     * @param index data가 삽입될 위치
     * @param data 삽입할 데이터
     */
    public void add(int index, Object data){ //이 메서드는 연결 리스트에서 원하는 위치(index)에 새로운 노드를 삽입하는 메서드
        if(index == 0){ // 생성자 값이 add(0, "수박");이라면 (index == 0)에 부합해서 addFirst(data)-> 연결리스트의 맨 앞에 노드를 추가한다. 수박 -> 포도 → 사과
            addFirst(data);
        }else{ // 그렇지 않으면, 생성자 값이 add(2, "딸기");라면
            Node newNode = new Node(data); // 새 노드 생성한다. 여기서는 new Node("딸기");가 실행된다. 아직 아무곳에도 연결되지 않았다.
            Node pNode = getNode(index-1); // 인덱스2-1=1 에 있는 포도 노드를 pNode가 가리키게 한다. 새 노드를 연결하려면 앞 노드의 nextNode를 수정해야 합니다.
            Node nNode = pNode.nextNode; // pNode(포도)의 다음 노드인 사과노드를 nNode로 가리키게 한다.
            newNode.nextNode = nNode; // 새 노드인 딸기의 다음노드를 nNode인 사과노드로 한다.  딸기-> 사과, 그러나 아직 포도는 딸기를 모른다.
            pNode.nextNode = newNode; // pNode(포도)의 다음노드를 newNode(딸기)로 가리키게 한다. 수박 -> 포도 -> 딸기 -> 사과 (완성)
            size++; // 크기 증가
        }
    }

    /**
     * data를 리스트의 마지막에 추가한다.
     * @param data 추가할 데이터
     */
    public void add(Object data){ // 맨 뒤에 데이터를 추가해라라는 메서드(생성자 아님)
        add(size, data); // 만약 현재 리스트가 수박 -> 포도 -> 딸기 -> 사과 라면 add("바나나");라는 메서드를 호출하면 실제로는 add(4, "바나나");가 호출된다. 즉, 맨 마지막 4에 삽입하는 것
    }

    /**
     * 리스트의 첫번째 요소를 삭제한다.
     */
    public void removeFirst() { // 첫 번째 노드를 삭제하는 메서드
        Node firstNode = header.nextNode; // 현재 리스트가 수박 -> 포도 -> 딸기 -> 사과 -> 바나나 라면 header.nextNode는 현재 첫 번째 노드(수박)를 가리킵니다. Node firstNode가 수박을 가리킨다는 것
        header.nextNode = firstNode.nextNode; //firstNode.nextNode: 첫번째 노드의 다음노드는 포도이다. header.nextNode가 포도를 가리키는 것. 헤더가 포도를 가리키니까 수박을 가리키는 것이 아무것도 없다. 아무도 안가리킨 수박을 가비지 컬렉터가 나중에 제거한다.
        // 사이즈 감소
        size--;
    }

    /**
     * 지정한 index 요소를 삭제한다.
     * @param index 삭제한 요소의 index
     */
    public void remove(int index) { // 연결 리스트에서 원하는 위치(index)의 노드를 삭제하는 메서드
        if (index < 0 || index >= size) { // 리스트가 포도 -> 딸기 -> 사과 -> 바나나 인데 remove(2);를 한다면, 사과를 삭제하는 것. (index < 0 || index >= size): 인덱스가 0보다 작거나 인덱스(만약 4라면)가 리스트 크기(4라면 인덱스는 3이니까)보다 크거나 같으면 삭제할 수 없다.
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size); // 잘못된 인덱스라고 알려주고 메시지 표시
        } else if (index == 0) { //첫 번째 노드 삭제인지 확인, 인덱스가 0이라면
            removeFirst(); //이미 만들어 둔 removeFirst() 사용
            // ai가 여기에 return; 넣어야 인덱스 0을 넣은 메서드가 아래로 안내려가고 바로 끝난대
        }

        Node pNode = getNode(index-1); // pNode(딸기), 삭제할 노드(인덱스 2):사과의 이전 노드(인덱스 1):딸기, 왜 index-1일까? 삭제하려면 삭제할 노드의 앞 노드(nextNode)를 수정해야 하기 때문
        Node rNode = pNode.nextNode; // 삭제할 노드, pNode(딸기)의 다음 노드인 사과
        Node nNode = rNode.nextNode; // 삭제할 노드rNode(사과)의 다음 노드인 바나나를 nNode가 가리키게 함.

        pNode.nextNode = nNode; // pNode(딸기)의 다음노드를 바나나로 한다. 그러면 리스트는 포도 -> 딸기 -> 바나나가 됨, 사과는 아무도 가리키지 않아서 가비지컬렉터가 나중에 제거함
        size--; // 사이즈 감소
    }

    /**
     * 지정한 index의 요소를 반환한다.
     * @param index 요소의 index
     * @return index 위치의 요소
     */
    public Object get(int index){ //이 메서드는 연결 리스트에서 원하는 위치(index)에 있는 데이터를 가져오는 메서드, Object obj = get(2);를 실행하면 인덱스2의 데이터 가져오라는 것, 바나나 가져와
        return getNode(index).data; // getNode(2)의 결과는 바나나 노드, 데이터가 아닌 노드를 반환하므로 뒤에.data 붙여주면 바나나라는 데이터만 반환함
    }

    /**
     * 전체 요소의 수를 반환한다.
     * @return 전체 요소의 수
     */
    public int size(){ // 이 메서드는 연결 리스트에 현재 저장된 노드(데이터)의 개수(int정수로 반환)를 반환하는 메서드
        return this.size; //this는 현재 객체 자신을 의미, 리스트가 포도 -> 딸기 -> 바나나라면 객체 사이즈 3을 반환
    }

    public String toString() { // 연결 리스트의 모든 데이터를 문자열(String)로 만들어 반환하는 메서드, 리스트가 포도 -> 딸기 -> 바나나라면 [포도, 딸기, 바나나] 라는 문자열 반환
        StringBuffer result = new StringBuffer("["); //여기서는 문자열을 하나씩 이어 붙일 준비를 합니다. 처음에는 result에 [ 만 들어 있다. StringBuffer는 기존 문자열 뒤에 계속 붙일 수 있어서 효율적입니다.
        Node node = header.nextNode; //첫 번째 노드 찾기, 현재 리스트 포도 -> 딸기 -> 바나나이므로 포도를 가리킨다.
        if (node != null) { //리스트에 데이터가 있는지 확인
            result.append(node.data); // 첫 번째 데이터 추가, 포도 추가, 왜 첫 번째는 따로 처리할까? while문으로 만들면 [,포도]가 되기 때문
            node = node.nextNode; // 다음 노드로 이동
            while (node != null) { //리스트에 데이터가 있는지 확인, 이제 리스트에는 딸기 -> 바나나가 남아있음, true가 false(데이터 없음)가 될때까지 실행
                result.append(", ");
                result.append(node.data); // 딸기, 바나나 순으로 데이터 추가
                node = node.nextNode; // 다음 노드 가리킨다.
            }
        }
        result.append("]"); // 노드가 null이라면 []만 반환한다.
        return result.toString(); //result는 StringBuffer 자료형 객체입니다. 하지만 메서드는 public String toString()이므로 String을 반환해야 해서 result.toString() 호출해서 [사과, 바나나, 포도]라는 스트링 객체로 바꿔 반환
    }

    /**
     * index 위치의 Node를 찾아서 반환한다.
     * @param index 찾을 index
     * @return 찾아낸 Node
     */
    private Node getNode(int index){ //이 메서드는 연결 리스트에서 원하는 위치(index)의 노드(Node)를 찾아 반환하는 메서드
        if(index < 0 || index >= size){ // 리스트가 포도 -> 딸기 -> 바나나라면,  getNode(2);라면 2번노드 바나나를 찾는다. (index < 0 || index >= size): 인덱스가 0보다 작거나 인덱스(만약 4라면)가 리스트 크기(4라면 인덱스는 3이니까)보다 크거나 같으면 삭제할 수 없다.
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size); // 잘못된 인덱스라고 알려주고 메시지 표시
        }
        Node node = header.nextNode; // 첫 번째 노드부터 시작, 노드는 포도를 가리킴, 이 메서드는 항상 첫번째 노드부터 출발
        for(int i=0; i<index; i++){ //i<index; i가 0부터 시작, 0인 현재 포도임, **i가 2<index 2는 false일 때 return node; 바나나 반환
            node = node.nextNode; // 다음 노드인 딸기 가리킴
        }
        return node; //**i가 2<index 2는 false일 때 return node; 바나나 반환
    }
}