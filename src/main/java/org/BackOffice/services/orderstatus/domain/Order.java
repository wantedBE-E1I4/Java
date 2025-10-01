package org.BackOffice.services.orderstatus.domain;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 한 건의 주문 전체 정보를 나타냅니다.
 * (예: "001|2025-09-22T09:05|강남|...")
 */
public record Order(
        String orderId,
        LocalDateTime dateTime,
        String branch,
        String userId,
        List<OrderItem> items,
        String couponCode,
        OrderStatus status
) {}