package entities;

public class SavingsAccount extends Account {
    private Double interestRate;

    public SavingsAccount(){
        super();
    }

   



    public Double getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public void updateBalance(){}


    
}
