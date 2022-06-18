/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uap;

/**
 *
 * @author farrelreginaldo
 */
public class Ayam extends Hewan implements TreatmentInterface {
    private int eggPerDay; // Telur yang dihasilkan oleh satu ayam
    private double eggPrice; // Harga satu butir telur
    private Medicine medicine;

    public Ayam(){

    }

    public Ayam(int quantitiy, double expensePerDay, int eggPerDay, double eggPrice, double pricePerUnit){
        super("Ayam", quantitiy, expensePerDay, pricePerUnit);
        setEggPerDay(eggPerDay);
        setEggPrice(eggPrice);
    }


    public void setEggPerDay(int eggPerDay){
        this.eggPerDay = eggPerDay;
    }

    public void setEggPrice(double eggPrice){
        this.eggPrice = eggPrice;
    }

    public void setMedicine(Medicine medicine){
        // Roundabout way to clone
        Medicine newMedicine = medicine;
        this.medicine = newMedicine;
    }

    public int getEggPerDay(){
        return isBoosted()? 2 * eggPerDay : eggPerDay;
    }

    public double getEggPrice(){
        return eggPrice;
    }

    public Medicine getMedicine(){
        return medicine;
    }

 // Method to return total of daily sell
    // For "Ayam" instance, it can be written as following:
    // the total of egg per day (of all chickens) * the price of per egg
    public double dailySell(){
        // Code here
        return getQuantity()*getEggPerDay()*getEggPrice();
    }

    // Method to return total of profit for "Ayam" instance
    // It can be written as following:
    // the total of daily sell - the total of expense
    public double dailyProfit(){
        // Code here
        return dailySell()-getTotalExpense();
    }

    // Method to return if "Ayam" instance in drug effect (booster)
    // PS: If medicine is null, return false. If it exist, return the status from medicine instances
    public boolean isBoosted(){
        // Code here
        if(medicine==null){
            return false;
        }else return true;

    }

    // Method to return string if it boosted
    // In this case, if this instance is boosted return "Booster"
    // If not, return "Normal"
    public String getStatus(){
        // Code here
        if(isBoosted()==false){
        return "notBoosted";}
        else return "boosted";
    }

    // Method to apply drug to this instance
    public void treatment(Medicine medicine){
        setMedicine(medicine);
    }

    // Method to apply reduce duration
    public void reduceDrugDuration(){
        if (isBoosted()) {
            this.medicine.reduceDuration();
        }
    }

    // To String return a formatted string of ayam consisted of
    // Its name, quantitiy, and expese per day (you can get this with "super")
    // Ex:
    //  Nama        : Ayam
    //  Jumlah      : 500 ekor
    //  Pengeluaran : Rp. 500,000 (per hari)
    //  Telur/hari  : 3 butir (per ekor)
    //  Harga telur : Rp. 3,000 (per butir)
    //  Penjualan   : Rp. 4,500,000 (per hari)
    //  Profit      : Rp. 4,000,000 (per hari)
    //  Status      : Boosted / Normal
    //  (Status depends whether the instance got medicine or not)
    @Override public String toString(){
        // Code here
        return super.toString()
                +"Telur/hari  : "+getEggPerDay()+"\n" +
                "Harga telur : "+getEggPrice()+"\n" +
                "Penjualan   : "+dailySell()+"\n" +
                "Profit      : "+dailyProfit()+"\n" +
                "Status      : "+getStatus();
    }
}
