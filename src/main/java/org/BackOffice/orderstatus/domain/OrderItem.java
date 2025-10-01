package org.BackOffice.orderstatus.domain;

/**
 * 주문에 포함된 개별 항목을 나타냅니다.
 * (예: "아메리카노x2")
 * @param menuName 메뉴 이름
 * @param quantity 수량
 */
public record OrderItem(String menuName, int quantity) {

}
