package com.practice.collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TradeServiceImpl implements TradeService {

    private final Map<String, Trade> cachedTrades;
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private Lock readLock = lock.readLock();
    private Lock writeLock = lock.writeLock();

    public TradeServiceImpl() {
        cachedTrades = new HashMap<>();
    }

    @Override
    public void indexTrades(List<Trade> trades) {
        if(null == trades || trades.isEmpty()) {
            return;
        }
        writeLock.lock();
        trades.forEach(trade -> cachedTrades.put(trade.getTradeRef() + "_" + trade.getVersion(), trade));
        writeLock.unlock();
    }

    @Override
    public Trade getTrade(String tradeRef, int version) {
        Objects.requireNonNull(tradeRef, "Invalid trade ref no.");
        readLock.lock();
        StringBuilder key = new StringBuilder();
        key.append(tradeRef).append("_").append(version);
        Optional<Trade> trade = Optional.ofNullable(cachedTrades.get(key.toString()));
        readLock.unlock();
        return trade.orElseThrow(() -> new TradeNotFoundException("Trade not found; traderef=" + tradeRef + " ; version=" + version));
    }
}
