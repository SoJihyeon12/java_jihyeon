package ch07;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorJUnitTest {
    private static Calculator calc;

    @BeforeAll
    static void setUp(){
        calc = new Calculator();
    }

//    @BeforeEach
//    void setUp(){
//        calc = new Calculator();
//    }

    @Test
    @DisplayName("두 정수의 덧셈 검증 2, 3")
    void add(){
        int result = calc.add(2, 3);
        assertEquals(5, result, "덧셈의 결과는 5여야 함");
    }

    @Test
    @DisplayName("두 정수의 덧셈 검증 3, 4")
    void add_3_4(){
        int result = calc.add(3, 4);
        assertEquals(7, result, "덧셈의 결과는 7이여야 함");
    }

    @Test
    @DisplayName("두 정수의 나눗셈 검증 10, 6")
    @Disabled
    void divide(){
        double result = calc.divide(10, 6); // 소수 세째자리에서 반올림
        assertEquals(1.67, result);
    }

    @Test
    @DisplayName("0으로 나누기 테스트")
    void divide_byZero(){
        assertThrows(ArithmeticException.class, () -> {
            calc.divide(10, 0);
        });
    }
}