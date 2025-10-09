package org.BackOffice.services.sales;

import java.util.List;

public record SalesReport(
        int totalSales,
        List<String> topMenus,
        double profitMargin
) {}
