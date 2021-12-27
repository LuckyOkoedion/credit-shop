package com.example.LuckyOkoedionspringmvccreditshop.services;

import java.math.BigDecimal;

public interface IScheduledResetReloadService {
    void setAllCreditToZeroAtReset();
    void setCreditToLimitAtReload(Integer limitPercentage);
}
