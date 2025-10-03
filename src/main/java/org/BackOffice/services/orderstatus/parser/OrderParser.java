package org.BackOffice.services.orderstatus.parser;

import org.BackOffice.services.orderstatus.domain.Order;
import org.BackOffice.services.orderstatus.domain.OrderItem;
import org.BackOffice.services.orderstatus.domain.OrderStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 텍스트 형식의 주문 데이터를 Order 객체 목록으로 파싱(변환)하는 클래스입니다.
 */
public class OrderParser {

    /**
     * 전체 주문 데이터 문자열을 파싱하여 List<Order>로 반환합니다.
     * @param rawData 파싱할 원본 텍스트 데이터
     * @return 변환된 Order 객체의 리스트
     */
    public static List<Order> parseOrders(String rawData) {
        List<Order> orders = new ArrayList<>();
        String[] lines = rawData.split("\\n"); // 1. 줄바꿈(\n)을 기준으로 각 라인을 분리

        for (String line : lines) {
            // 2. 비어있거나 주석(#)으로 시작하는 라인은 건너뜀
            if (line.trim().isEmpty() || line.trim().startsWith("#")) {
                continue;
            }

            // 3. '|'를 기준으로 각 필드를 분리
            String[] fields = line.split("\\|");

            // 4. 각 필드를 Order 객체의 필드에 맞게 변환
            String orderId = fields[0];
            LocalDateTime dateTime = LocalDateTime.parse(fields[1]);
            String branch = fields[2];
            String userId = fields[3];
            List<OrderItem> items = parseOrderItems(fields[4]); // items는 별도 메서드로 처리
            String couponCode = fields[5];
            OrderStatus status = OrderStatus.valueOf(fields[6]); // 문자열을 OrderStatus enum으로 변환

            // 5. 완성된 Order 객체를 리스트에 추가
            orders.add(new Order(orderId, dateTime, branch, userId, items, couponCode, status));
        }

        return orders;
    }

    /**
     * "메뉴x수량;메뉴x수량" 형식의 문자열을 List<OrderItem>으로 파싱합니다.
     * @param itemsData "아메리카노x2;라떼x1"과 같은 형식의 문자열
     * @return 변환된 OrderItem 객체의 리스트
     */
    private static List<OrderItem> parseOrderItems(String itemsData) {
        List<OrderItem> items = new ArrayList<>();
        String[] itemTokens = itemsData.split(";"); // 1. ';'를 기준으로 개별 아이템 분리

        for (String token : itemTokens) {
            String[] itemDetails = token.split("x"); // 2. 'x'를 기준으로 메뉴명과 수량 분리
            String menuName = itemDetails[0];
            int quantity = Integer.parseInt(itemDetails[1]);
            items.add(new OrderItem(menuName, quantity)); // 3. OrderItem 객체로 만들어 리스트에 추가
        }

        return items;
    }
}