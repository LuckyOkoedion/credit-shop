package com.example.LuckyOkoedionspringmvccreditshop;

import com.example.LuckyOkoedionspringmvccreditshop.entities.CreditPolicyEntity;
import com.example.LuckyOkoedionspringmvccreditshop.services.ICreditPolicyService;
import com.example.LuckyOkoedionspringmvccreditshop.services.IScheduledResetReloadService;
import com.example.LuckyOkoedionspringmvccreditshop.services.impl.CreditPolicyService;
import com.example.LuckyOkoedionspringmvccreditshop.services.impl.ScheduledResetReloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.List;

@Component
public class ScheduledTasks {

    private IScheduledResetReloadService resetReloadService;
    private ICreditPolicyService creditPolicyService;

    public ScheduledTasks(ScheduledResetReloadService scheduledResetReloadService, CreditPolicyService creditPolicyService) {
        this.resetReloadService = scheduledResetReloadService;
        this.creditPolicyService = creditPolicyService;
    }

    @Scheduled(cron = "0 0 0 1 * *")
    public void setCreditEveryFirstDayOfMonth() {
        List<CreditPolicyEntity> policies = creditPolicyService.getAll();
        CreditPolicyEntity thePolicy = policies.get(0);
        Integer currentCreditLimitPercentage = thePolicy.getCredit_limit();
        this.resetReloadService.setCreditToLimitAtReload(currentCreditLimitPercentage);
    }

    @Scheduled(cron = "0 0 0 L * *")
    public void clearCreditEveryLastDayOfMonth() {
            this.resetReloadService.setAllCreditToZeroAtReset();
    }
}
