public class SavingsAccount implements Comparable<SavingsAccount>{
    Employee e;
    Bank bank;
    int months;
    public SavingsAccount(Employee e, Bank bank, int months) {
        this.e = e;
        this.bank = bank;
        this.months = months;
    }

    public double compute(int months) {
        double amount = 0;
        double currentSal = e.salary;
        for(int i = 1; i <= months; i++) {
            if(i %12 ==0) {
                amount = amount + currentSal;
                amount += amount * bank.getInterest()/12;
                currentSal += currentSal * e.setSalaryIncrease(e.rate)/100;
            } else {
                amount = amount + currentSal;
                amount += amount * bank.getInterest()/12;
            }
        }
        return amount;
    }

    public String print() {
      return e + " " + "has balance of " + String.format("%.2f", this.compute(months));
    }

    public int compareTo(SavingsAccount sa) {

		    if (this.compute(months) < sa.compute(months)) {
			       return -1;
		    } else {
		        return 1;
		    }
	  }
}
