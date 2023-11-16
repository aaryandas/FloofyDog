package org.example;

//still in progress

public class SalesContract extends Contract{

    private double salesTaxAmount = 0.05;
    private double recordingFee = 100;

    private double processingFee;
    private double totalAmount;
    private boolean isFinance;
    private double interestRate;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
        this.salesTaxAmount = calculateSalesTax();
        this.recordingFee = 100.0;
        this.processingFee = calculateProcessingFee();
        this.totalAmount = calculateTotalAmount();
        this.isFinance = askForFinanceOption();
        this.interestRate = calculateInterestRate();
    }

    public double getSalesTaxAmount() {
        return 0.05 * getVehicleSold().getPrice();
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public double getProcessingFee() {
        return (getVehicleSold().getPrice() < 10000) ? 295 : 495;
    }

    public boolean isFinance() {
        return isFinance;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public void setFinance(boolean finance) {
        isFinance = finance;
    }

    @Override
    public double getTotalPrice(){
        double totalPrice = getVehicleSold().getPrice();

        totalPrice += totalPrice * getSalesTaxAmount();
        totalPrice += getRecordingFee();
        totalPrice += getProcessingFee();

        return totalPrice;
    }

    @Override
    public double getMonthlyPayment() {
        if(!isFinance()){
            return 0;
        }

        double loanAmount = getVehicleSold().getPrice();
        double interestRate = (loanAmount >= 10000) ? 0.0425 : 0.0525; //ternary operator replaces if/else statement, if(loanAmount >= 10000) {interestRate = 0.0425} else {interestRate = 0.0525}
        int loanTerm = (loanAmount >= 10000) ? 48 : 24;

        double monthlyInterestRate = interestRate / 12.0;
        double monthlyPayment = (loanAmount * monthlyInterestRate) / (1- Math.pow(1 + monthlyInterestRate, -loanTerm));

        return monthlyPayment;

    }

    public double interestRate(){
        return (getVehicleSold().getPrice() >= 10000) ? 0.0425 : 0.0525;
    }
}
