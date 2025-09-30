package org.BackOffice.orderstatus.domain;

/**
 *
 * * 주문의 상태를 나타내는 열거 타입입니다.
 *  * (COMPLETED, CANCELLED, REFUNDED 등)
 */
public enum OrderStatus {
    PLACED,      // 주문 접수
    IN_PROGRESS, // 처리 중
    READY,       // 준비 완료
    COMPLETED,   // 전달 완료
    CANCELLED,   // 취소
    REFUNDED     // 환불
}