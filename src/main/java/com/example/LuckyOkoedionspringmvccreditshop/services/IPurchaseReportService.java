package com.example.LuckyOkoedionspringmvccreditshop.services;

import com.example.LuckyOkoedionspringmvccreditshop.entities.PurchaseEntity;

import java.sql.Date;
import java.util.List;

public interface IPurchaseReportService {
    List<PurchaseEntity> generatePurchaseReport(Date startDate, Date endDate);
}
