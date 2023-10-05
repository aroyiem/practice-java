package com.practice.collections;

import java.util.Objects;

public final class Trade {
    private final String tradeRef;
    private final int version;

    public Trade(String tradeRef, int version) {
        this.tradeRef = tradeRef;
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trade trade = (Trade) o;
        return version == trade.version && Objects.equals(tradeRef, trade.tradeRef);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tradeRef, version);
    }

    public String getTradeRef() {
        return tradeRef;
    }

    public int getVersion() {
        return version;
    }
}
