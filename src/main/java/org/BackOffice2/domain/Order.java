package org.BackOffice2.domain;

import java.time.LocalDateTime;
import java.util.List;


public record Order(Long id, LocalDateTime orderedAt, List<OrderLine> lines) {}

/**
 * record
 * record로 클래스를 만들면, Java가 여러 가지 귀찮은 코드를 알아서 자동으로 만들어 줍니다. (Java 14부터 정식 도입)
 * 한번 데이터가 정해지면 바뀌지 않는(불변, Immutable) 데이터 묶음을 표현할 때
 * // Before: record가 없던 시절의 코드
 * public final class OldOrderLine { // final: 상속 불가
 *     private final Menu menu; // private final: 한번 정해지면 변경 불가
 *     private final int qty;
 *     // 1. 생성자 (데이터를 처음 넣기 위해 필요)
 *     public OldOrderLine(Menu menu, int qty) {
 *         this.menu = menu;
 *         this.qty = qty;
 *     }
 *     // 2. Getter (데이터를 읽기 위해 필요)
 *     public Menu menu() {
 *         return menu;
 *     }
 *     public int qty() {
 *         return qty;
 *     }
 *     // 3. equals(), hashCode(), toString() ... (객체 비교, 출력을 위해 필요)
 * }
 */
