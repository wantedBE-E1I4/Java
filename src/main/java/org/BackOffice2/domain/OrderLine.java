package org.BackOffice2.domain;
import org.BackOffice.InMemoryData;

import java.time.LocalDateTime;
import java.util.List;

public record OrderLine(InMemoryData.Menu menu, int qty) {}