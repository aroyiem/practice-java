package com.practice.collections;

import java.util.List;

public interface TradeService {

    void indexTrades(List<Trade> trades);

    Trade getTrade(String tradeRef, int version);
}
