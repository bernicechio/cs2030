public class Bank {
    String name;
    double interest;
    static Bank[] BANKS;
    public Bank(String name, double interest) {
        this.name = name;
        this.interest = interest;
    }

    public String getName() {
      return this.name;
    }

    public double getInterest() {
      return this.interest;
    }

    public static Bank getBankByName(String name) {
      Bank b = null;

      for(int i = 0; i < Bank.BANKS.length; i++) {
        b = Bank.BANKS[i];
        if(b.getName().equals(name)) {
          b = new Bank(b.getName(), b.getInterest());
          break;
        }
      }
      return b;
    }
}
