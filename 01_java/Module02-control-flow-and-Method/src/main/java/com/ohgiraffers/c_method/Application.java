package com.ohgiraffers.c_method;

public class Application {
    //메서드 사용 가능
    public static void main(String[] args) {
        int num1 = 1;
        int num2 = 2;
        int result = 0;

        if (num1 % 2 == 0)

        System.out.println("1번 연산: " + (num1 + num2));

        int num3 = 3;
        int num4 = 4;

        System.out.println("3번 연산: " + (num3 + num4));

        int num7 = 7;
        int num8 = 8;

        System.out.println("4번 연산: " + (num7 + num8));
    }
    //메서드 사용 가능

    /**
     * 메서드
     * 메서드는 특정 작업을 수행하는 코드 블록으로, 코드 재사용과 가독성을 향상시키기 위해 사용한다. 
     * 메서드는 입력값(매개변수)를 받고, 결과값(리턴값)을 반환한다. 
     * 메서드는 프로그램의 구조를 체계적으로 만들고, 유지보수를 용이하게 한다. 
     * 
     * 형식
     * [접근 제어자] [반환 타입] 메서드명(매개변수 타입 매개변수 명) {
     *     //실행할 코드
     * }
     * 접근 제어자: 외부에서 해당 메서드에 접근할 수 있는 범위를 지정한다. 
     * - public: 모든 클래스에서 접근 가능
     * - protected: 같은 패키지 또는 자식 클래스에서 접근 가능
     * - private: 같은 클래스 내에서만 접근 가능
     *
     * 반환 타입: 메서드가 작업을 완료하고 반환할 데이터의 타입이다. (기본 자료형 또는 참조 자료형일 수 있다)
     * - void: 반환값이 없을 때 사용
     * - String: 문자열을 반환하는 경우
     * - int, char, short 등의 기본 자료형도 반환 타입으로 사용할 수 있다.
     *
     * 매개변수: 메서드가 호출될 떄 외부에서 전달받은 입력값을 정의한다.
     * - 매개변수는 여러 개를 가질 수 있으며 함수 내부에서 사용될 변수를 의미한다.
     * - 이는 일반 변수와 동일하게 타입과 이름을 갖는다.
     */
    //접근 제어자 / 반환 타입 / 이름


    Application app = new Application(); //class -> 코드 덩어리를 메모리에 올려줘야함 heap// heap에 올리는 명령어가 new다.
    /**
     * 입력값 a와 b를 더하고 둘 다 2의 배수인 경우 결과를 반환
     * @param a 좌항의 값
     * @param b 우항의 값
     * @return a와 b의 합산 결과
     */
    public int add(int a, int b) {
        if (a % b == 0 && b % 2 == 0) {
            return a + b;
        }
        //조건이 false가 될 때의 return이 없으면 에러남
        return 0; // 뭐든 반환해줘야함
    }
    //Application안에  add, a, b // main은 없음(정적메서드)
    //.은 참조연산자이다. heap에 있는 공간





}
