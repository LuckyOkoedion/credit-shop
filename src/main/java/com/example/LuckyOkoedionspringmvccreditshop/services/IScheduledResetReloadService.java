package com.example.LuckyOkoedionspringmvccreditshop.services;

import java.math.BigDecimal;

public interface IScheduledResetReloadService {
    Boolean setAllCreditToZeroAtReset();
    Boolean setCreditToLimitAtReload(Integer limitPercentage);
}
