package com.roisimulator.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Scenario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String scenarioName;
    private int monthlyInvoiceVolume;
    private int numApStaff;
    private double avgHoursPerInvoice;
    private double hourlyWage;
    private double errorRateManual;
    private double errorCost;
    private int timeHorizonMonths;
    private double oneTimeImplementationCost;

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getScenarioName() { return scenarioName; }
    public void setScenarioName(String scenarioName) { this.scenarioName = scenarioName; }
    public int getMonthlyInvoiceVolume() { return monthlyInvoiceVolume; }
    public void setMonthlyInvoiceVolume(int monthlyInvoiceVolume) { this.monthlyInvoiceVolume = monthlyInvoiceVolume; }
    public int getNumApStaff() { return numApStaff; }
    public void setNumApStaff(int numApStaff) { this.numApStaff = numApStaff; }
    public double getAvgHoursPerInvoice() { return avgHoursPerInvoice; }
    public void setAvgHoursPerInvoice(double avgHoursPerInvoice) { this.avgHoursPerInvoice = avgHoursPerInvoice; }
    public double getHourlyWage() { return hourlyWage; }
    public void setHourlyWage(double hourlyWage) { this.hourlyWage = hourlyWage; }
    public double getErrorRateManual() { return errorRateManual; }
    public void setErrorRateManual(double errorRateManual) { this.errorRateManual = errorRateManual; }
    public double getErrorCost() { return errorCost; }
    public void setErrorCost(double errorCost) { this.errorCost = errorCost; }
    public int getTimeHorizonMonths() { return timeHorizonMonths; }
    public void setTimeHorizonMonths(int timeHorizonMonths) { this.timeHorizonMonths = timeHorizonMonths; }
    public double getOneTimeImplementationCost() { return oneTimeImplementationCost; }
    public void setOneTimeImplementationCost(double oneTimeImplementationCost) { this.oneTimeImplementationCost = oneTimeImplementationCost; }
}
