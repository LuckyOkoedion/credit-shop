package com.example.LuckyOkoedionspringmvccreditshop.services.impl;

import com.example.LuckyOkoedionspringmvccreditshop.entities.PurchaseEntity;
import com.example.LuckyOkoedionspringmvccreditshop.services.IPurchaseReportService;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseReportService implements IPurchaseReportService {

    private PurchaseService purchaseService;

    public PurchaseReportService(PurchaseService thePurchaseService) {
        super();
        this.purchaseService = thePurchaseService;
    }

    @Override
    public List<PurchaseEntity> generatePurchaseReport(Date startDate, Date endDate) {

        List<PurchaseEntity> allPurchases = this.purchaseService.getAll();
        List<PurchaseEntity> requestedPurchases = allPurchases.stream()
                .filter(p -> p.getDate().after(startDate) && p.getDate().after(endDate))
                .collect(Collectors.toList());

        return requestedPurchases;
    }
}
