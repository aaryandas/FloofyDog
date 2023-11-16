package org.example;

//still in progress

public class LeaseContract extends Contract{
    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
    }

    @Override
    public double getTotalPrice(){
        double originalPrice = getVehicleSold().getPrice();
        double totalPrice = originalPrice + expectedEndingValue() + leaseFee();
        return totalPrice;
    }

    @Override
    public double getMonthlyPayment(){
        double leaseCost = getTotalPrice();
        double interestRate = 0.04;
        int leaseTerm = 36;

        double monthlyInterestRate = interestRate / 12.0;
        double monthlyPayment = leaseCost * (monthlyInterestRate / (1 - Math.pow(1 + monthlyInterestRate, -leaseTerm)));

        return monthlyPayment;
    }

    public double expectedEndingValue(){

        double endingValue = 0.5 * getVehicleSold().getPrice();
        return endingValue;
    }

    public double leaseFee(){

        double leaseFee = 0.07 * getVehicleSold().getPrice();
        return leaseFee;
    }

}
