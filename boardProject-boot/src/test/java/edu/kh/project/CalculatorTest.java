package edu.kh.project;
// JUnit 테스트 코드는 반드시 src/test/java 경로에 위치해야함!

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import edu.kh.project.test.Calculator;

// src/main/java : 실제 애플리케이션 코드
// src/test/java : 테스트 코드 (JUnit 포함됨)

// 테스트 특징과 규칙
// 1. 기본적으로 JUnit5 는 테스트 메서드의 실행 순서를 보장 하지 않는다
// 2. 테스트는 순서에 의존하지 않도록 설계 하는 것이 권장된다
// 3. 테스트는 독립적이어야 하며, 순서에 따라 실패 or 통과하면 안된다
// -> 테스트가 순서에 의존하면 좋은 테스트가 아님
// 4. 그래도 순서를 따지고 싶다면 @TestMethodOrder / @Order 사용 할 수 있다

@TestMethodOrder(OrderAnnotation.class)
public class CalculatorTest {

	private static Calculator calculator;
	
	// @BeforeAll, @AfterAll - statuc 메서드에서 사용해야함!
	@BeforeAll
	static void initAll() {
		// 모든 테스트 실행 전에 1번만 실행
		calculator = new Calculator();
		System.out.println("@BeaforeAll - 테스트 시작 전 초기화");
	}
	
	@AfterAll
	static void end() {
		// 모든 테스트가 끝난 뒤 1번만 실행
		System.out.println("@AfterAll - 모든 테스트 완료");
	}
	
	@Test // 테스트 메서드 표시
	@Order(1)
	void testAdd() {
		System.out.println("testAdd 실행");
		assertEquals(5, calculator.add(2, 3), "2 + 3은 5여야 합니다");
		// assertEquals (expected, actual) : 두 값이 같은가?
	}
	
	@Test
	@Order(2)
	void testSubtract () {
		System.out.println("testSubtract 실행");
		assertEquals(6, calculator.subtract(12, 6), "12 -6 은 6이어야 합니다");
	}
	
	@Test
	@Order(3)
	void testMutiply() {
		System.out.println("testMultiply 실행");
		assertEquals(6, calculator.multiply(2, 3), "2 * 3 은 6 이어야 합니다");
	}
	
	@Test
	@Order(4)
	void testDivide() {
		System.out.println("testDivide 실행");
		assertEquals(2, calculator.divide(4, 2), "4 / 2는 2어야 합니다");
	}
	
	@Test
	@Order(5)
	void testTrueFalse() {
		int result = calculator.add(2, 2);
		assertTrue(result == 4, "결과가 4 이어야 합니다");
		assertFalse(result == 5, "결과가 5면 안됩니다");
	}
	
	@Test
	@Order(6)
	void testDivideByZero() {
		System.out.println("testDivideByZero 실행");
		
		// assertThrows(Exception.class, executable) : 예외 발생 여부
		Exception exception = assertThrows(IllegalAccessException.class, 
				() -> {
			calculator.divide(10, 0);
		});
		
		assertEquals("0으로 나눌 수 없음", exception.getMessage());
	}
	
}
