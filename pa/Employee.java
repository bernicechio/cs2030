public class Employee {
    String firstName;
    String lastName;
    double salary;
    double rate;
    SalaryAdjust adjustment;

    public Employee(String firstName, String lastName, double salary, SalaryAdjust adjustment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.adjustment = adjustment;
    }

    public int setSalaryIncrease(double rate) {
        this.rate = rate;
        int adjustedRate = adjustment.adjust(rate);
        return adjustedRate;
    }
    @Override
    public String toString() {
        int salString = (int) salary/1000;
        return firstName + " " + lastName + ": salary is " + salString + "K, annual raise is " + setSalaryIncrease(rate) + "%";
    }

}
