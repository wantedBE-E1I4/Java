package org.BackOffice.services.loyalty.formatter;

import java.text.DecimalFormat;

/**
 * 무상태 - 메서드 호출 사이에 변하는 내부 상태를 갖지 않는다
 */
public class PointsFormatter {
    private final String pre = "+";
    private final String post = "P";

    public String formatPoints(int point) {
        DecimalFormat df = new DecimalFormat("###,###");
        String formatted = df.format(point);
        return pre + formatted + post;
    }
}
