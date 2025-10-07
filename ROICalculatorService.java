package com.roisimulator.service;

import com.roisimulator.model.Scenario;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ROICalculatorService {

    // Internal constants
    private final double automatedCostPerInvoice = 0.2;
    private final double errorRateAuto = 0.001; // 0.1%
    private final double minRoiBoostFactor = 1.1;

    public Map<String, Double> calculateROI(Scenario scenario) {
        double laborCostManual = scenario.getNumApStaff() * scenario.getHourlyWage() *
                scenario.getAvgHoursPerInvoice() * scenario.getMonthlyInvoiceVolume();

        double errorSavings = (scenario.getErrorRateManual()/100 - errorRateAuto) *
                scenario.getMonthlyInvoiceVolume() * scenario.getErrorCost();

        double autoCost = scenario.getMonthlyInvoiceVolume() * automatedCostPerInvoice;

        double monthlySavings = (laborCostManual + errorSavings - autoCost) * minRoiBoostFactor;

        double cumulativeSavings = monthlySavings * scenario.getTimeHorizonMonths();
        double netSavings = cumulativeSavings - scenario.getOneTimeImplementationCost();
        double paybackMonths = scenario.getOneTimeImplementationCost() / monthlySavings;
        double roiPercentage = (netSavings / scenario.getOneTimeImplementationCost()) * 100;

        Map<String, Double> result = new HashMap<>();
        result.put("monthlySavings", monthlySavings);
        result.put("cumulativeSavings", cumulativeSavings);
        result.put("netSavings", netSavings);
        result.put("paybackMonths", paybackMonths);
        result.put("roiPercentage", roiPercentage);

        return result;
    }
}
