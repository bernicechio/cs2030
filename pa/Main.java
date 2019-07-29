import java.util.Scanner;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<SavingsAccount> pq = new PriorityQueue<>();
        Scanner sc = new Scanner(System.in);
        SalaryAdjust adjustment = new Type1Adjustment();
        int months = sc.nextInt();
        Bank.BANKS = new Bank[4];
        for(int i = 0; i < Bank.BANKS.length; i++) {
            Bank.BANKS[i] = new Bank(sc.next(), sc.nextDouble());
        }

        while (sc.hasNext()) {
            Employee employee = new Employee(sc.next(), sc.next(), sc.nextDouble(), adjustment);
            employee.setSalaryIncrease(sc.nextDouble());
            SavingsAccount account = new SavingsAccount(employee, Bank.getBankByName(sc.next()), months);
            pq.add(account);
        }
        while(!pq.isEmpty()) {
			       System.out.println(pq.poll().print());
        }
    }
}
