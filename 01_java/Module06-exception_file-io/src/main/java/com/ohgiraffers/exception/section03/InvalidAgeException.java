package com.ohgiraffers.exception.section03;

/**
 * 사용자 정의 예외란
 * - 자바에서 제공하는 기본 예외 클래스(Exception, runtimeException 등)을 상속받아.
 * 직접 예외를 정의할 수 없음 (에러를 구체화)
 *
 * 왜 사용자 정의 예외를 만들까?
 * - 특정 비지니스 로직에 맞는 예외 처리를 할 수 있음
 * - 예외를 더 의미 있게 만들고, 유지보수를 쉬게 하기 위함
 * - 서비스에서 자주 발생하는 오류를 발견할 수 있음
 *
 */
public class InvalidAgeException extends Exception{
    /// 나이에 관련
    public InvalidAgeException(String message) {
        super();
    }

}
