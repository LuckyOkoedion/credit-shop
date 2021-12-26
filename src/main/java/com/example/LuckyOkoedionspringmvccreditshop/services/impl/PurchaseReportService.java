package com.example.LuckyOkoedionspringmvccreditshop.services.impl;

import com.example.LuckyOkoedionspringmvccreditshop.entities.PurchaseEntity;
import com.example.LuckyOkoedionspringmvccreditshop.services.IPurchaseReportService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PurchaseReportService implements IPurchaseReportService {

    private PurchaseService purchaseService;

    public PurchaseReportService(PurchaseService thePurchaseService) {
        super();
        this.purchaseService = thePurchaseService;
    }

    @Override
    public List<PurchaseEntity> generatePurchaseReport(Date startDate, Date endDate) {
        return null;
    }
}
