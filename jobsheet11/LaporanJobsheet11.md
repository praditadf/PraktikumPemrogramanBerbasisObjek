|            | Praktikum Pemrograman Berbasis Objek                                                        |
| ---------- | ------------------------------------------------------------------------------------------- |
| NIM        | 254107020130                                                                                |
| Nama       | Achmad Pradita Dwi Firmansyah                                                               |
| Kelas      | TI - 2G                                                                                     |
| Repository | [link](https://github.com/praditadf/PraktikumPemrogramanBerbasisObjek/tree/main/jobsheet11) |

## Langkah 1: Proyek dan Kelas Dasar (Customer, Exception, Account)

## Langkah 2: Subclass dan Interface (SavingsAccount, CheckingAccount)

## Langkah 3: Bank Berbasis Array dan Program Utama

### Hasil Run Terminal

```
PS C:\G\PraktikumPemrogramanBerbasisObjek>
Withdrawal failed: A003: insufficient balance for a withdrawal of 70000.0
Withdrawal succeeded, new balance: 70000.0
A001 interest applied, new balance: 505000.0
A001 monthly fee: 0.0
A002 monthly fee: 15000.0
A003 interest applied, new balance: 71400.0
A003 monthly fee: 0.0
PS C:\G\PraktikumPemrogramanBerbasisObjek>
```

### Class Bank.java

```
package jobsheet11;

public class Bank {
    private Account[] accounts;
    private int count;

    public Bank(int capacity) {
        accounts = new Account[capacity];
        count = 0;
    }

    public boolean addAccount(Account account) {
        if (count >= accounts.length) {
            return false;
        }
        accounts[count] = account;
        count++;
        return true;
    }

    public Account findAccount(String accountNumber) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber)) {
                return accounts[i];
            }
        }
        return null;
    }

    public void printAllAccounts() {
        for (int i = 0; i < count; i++) {
            accounts[i].printInfo();
        }
    }

    public void printMonthlyFees() {
        for (int i = 0; i < count; i++) {
            System.out.println(accounts[i].getAccountNumber() + " fee: " + accounts[i].monthlyFee());
        }
    }

    public void processMonthEnd() {
        for (int i = 0; i < count; i++) {
            Account acc = accounts[i];
            if (acc instanceof InterestBearing bearing) {
                bearing.applyInterest();
                System.out.println(acc.getAccountNumber() + " interest applied, new balance: " + acc.getBalance());
            }
            System.out.println(acc.getAccountNumber() + " monthly fee: " + acc.monthlyFee());
        }
    }
}
```

## Langkah 4: Bank Beralih dari Array ke Map

### Hasil Run Terminal

```
PS C:\G\PraktikumPemrogramanBerbasisObjek>
Withdrawal failed: A003: insufficient balance for a withdrawal of 70000.0
Withdrawal succeeded, new balance: 70000.0
A001 interest applied, new balance: 505000.0
A001 monthly fee: 0.0
A002 monthly fee: 15000.0
A003 interest applied, new balance: 71400.0
A003 monthly fee: 0.0
PS C:\G\PraktikumPemrogramanBerbasisObjek>
```

### Class Bank.java

```
package jobsheet11;
import java.util.LinkedHashMap;
import java.util.Map;

public class Bank {
    private Map<String, Account> accounts = new LinkedHashMap<>();

    public boolean addAccount(Account account) {
        if (accounts.containsKey(account.getAccountNumber())) {
            return false;
        }
        accounts.put(account.getAccountNumber(), account);
        return true;
    }

    public Account findAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public void printAllAccounts() {
        for (Account acc : accounts.values()) {
            acc.printInfo();
        }
    }

    public void printMonthlyFees() {
        for (Account acc : accounts.values()) {
            System.out.println(acc.getAccountNumber() + " fee: " + acc.monthlyFee());
        }
    }

    public void processMonthEnd() {
        for (Account acc : accounts.values()) {
            if (acc instanceof InterestBearing bearing) {
                bearing.applyInterest();
                System.out.println(acc.getAccountNumber() + " interest applied, new balance: " + acc.getBalance());
            }
            System.out.println(acc.getAccountNumber() + " monthly fee: " + acc.monthlyFee());
        }
    }
}
```

### Class Main.java

```
package jobsheet11;

public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Nadia", "0812-0000-0001");
        SavingsAccount acc1 = new SavingsAccount("A001", customer1, 500000, 0.01);

        Customer customer2 = new Customer("Sari", "0812-0000-0002");
        CheckingAccount acc2 = new CheckingAccount("A002", customer2, 200000, 50000);

        Customer customer3 = new Customer("Rian", "0812-0000-0003");
        SavingsAccount savings = new SavingsAccount("A003", customer3, 100000, 0.02);

        try {
            savings.withdraw(70000);
        } catch (InsufficientBalanceException e) {
            System.out.println("Withdrawal failed: " + e.getMessage());
        }

        try {
            savings.withdraw(30000);
            System.out.println("Withdrawal succeeded, new balance: " + savings.getBalance());
        } catch (InsufficientBalanceException e) {
            System.out.println("Withdrawal failed: " + e.getMessage());
        }

        Bank bank = new Bank();
        bank.addAccount(acc1);
        bank.addAccount(acc2);
        bank.addAccount(savings);
        bank.processMonthEnd();
    }
}
```

## Langkah 5: Transaction, Single Responsibility Principle

### Hasil Run Terminal

```
PS C:\G\PraktikumPemrogramanBerbasisObjek>
Withdrawal failed: A003: insufficient balance for a withdrawal of 70000.0
Withdrawal succeeded, new balance: 70000.0
A001 interest applied, new balance: 505000.0
A001 monthly fee: 0.0
A002 monthly fee: 15000.0
A003 interest applied, new balance: 71400.0
A003 monthly fee: 0.0
A003 WITHDRAW 30000.0
A003 DEPOSIT 1400.0
PS C:\G\PraktikumPemrogramanBerbasisObjek>
```

### Class Main.java

```
package jobsheet11;

public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Nadia", "0812-0000-0001");
        SavingsAccount acc1 = new SavingsAccount("A001", customer1, 500000, 0.01);

        Customer customer2 = new Customer("Sari", "0812-0000-0002");
        CheckingAccount acc2 = new CheckingAccount("A002", customer2, 200000, 50000);

        Customer customer3 = new Customer("Rian", "0812-0000-0003");
        SavingsAccount savings = new SavingsAccount("A003", customer3, 100000, 0.02);

        try {
            savings.withdraw(70000);
        } catch (InsufficientBalanceException e) {
            System.out.println("Withdrawal failed: " + e.getMessage());
        }

        try {
            savings.withdraw(30000);
            System.out.println("Withdrawal succeeded, new balance: " + savings.getBalance());
        } catch (InsufficientBalanceException e) {
            System.out.println("Withdrawal failed: " + e.getMessage());
        }

        Bank bank = new Bank();
        bank.addAccount(acc1);
        bank.addAccount(acc2);
        bank.addAccount(savings);
        bank.processMonthEnd();
        bank.printHistory("A003");
    }
}
```

### Class Account.java

```
package jobsheet11;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    private String accountNumber;
    private Customer owner;
    private double balance;
    private List<Transaction> history = new ArrayList<>();

    public List<Transaction> getHistory() {
        return history;
    }

    public Account(String accountNumber, Customer owner, double balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Customer getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }
        balance += amount;
        history.add(new Transaction(TransactionType.DEPOSIT, amount));
        return true;
    }

    public boolean deposit(double amount, String note) {
        if (!deposit(amount)) {
            return false;
        }
        System.out.println(accountNumber + " deposit note: " + note);
        return true;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (!canWithdraw(amount)) {
            throw new InsufficientBalanceException(
                    accountNumber + ": insufficient balance for a withdrawal of " + amount);
        }
        balance -= amount;
        history.add(new Transaction(TransactionType.WITHDRAW, amount));
    }

    protected boolean canWithdraw(double amount) {
        return amount > 0 && amount <= balance;
    }

    public void printInfo() {
        System.out.println(accountNumber + " - " + owner.getName() + " - balance: " + balance);
    }

    public abstract double monthlyFee();
}
```

### Class Bank.java

```
package jobsheet11;

import java.util.LinkedHashMap;
import java.util.Map;

public class Bank {
    private Map<String, Account> accounts = new LinkedHashMap<>();

    public boolean addAccount(Account account) {
        if (accounts.containsKey(account.getAccountNumber())) {
            return false;
        }
        accounts.put(account.getAccountNumber(), account);
        return true;
    }

    public Account findAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public void printAllAccounts() {
        for (Account acc : accounts.values()) {
            acc.printInfo();
        }
    }

    public void printMonthlyFees() {
        for (Account acc : accounts.values()) {
            System.out.println(acc.getAccountNumber() + " fee: " + acc.monthlyFee());
        }
    }

    public void processMonthEnd() {
        for (Account acc : accounts.values()) {
            if (acc instanceof InterestBearing bearing) {
                bearing.applyInterest();
                System.out.println(acc.getAccountNumber() + " interest applied, new balance: " + acc.getBalance());
            }
            System.out.println(acc.getAccountNumber() + " monthly fee: " + acc.monthlyFee());
        }
    }

    public void printHistory(String accountNumber) {
        Account acc = findAccount(accountNumber);
        if (acc == null) {
            System.out.println("Account not found: " + accountNumber);
            return;
        }
        for (Transaction t : acc.getHistory()) {
            System.out.println(accountNumber + " " + t);
        }
    }
}
```

### Class TransactionType.java

```
package jobsheet11;

public enum TransactionType {
    DEPOSIT, WITHDRAW
}

package jobsheet11;

public class Transaction {
    private TransactionType type;
    private double amount;

    public Transaction(TransactionType type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public TransactionType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return type + " " + amount;
    }
}
```

## Langkah 6: AccountRepository, Dependency Inversion Principle

### Class AccountRepository.java

```
package jobsheet11;

import java.util.Collection;

public interface AccountRepository {
    void save(Account account);

    Account findByNumber(String accountNumber);

    Collection<Account> findAll();
}
```

### Class InMemoryAccountRepository.java

```
package jobsheet11;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class InMemoryAccountRepository implements AccountRepository {
    private Map<String, Account> accounts = new LinkedHashMap<>();

    @Override
    public void save(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    @Override
    public Account findByNumber(String accountNumber) {
        return accounts.get(accountNumber);
    }

    @Override
    public Collection<Account> findAll() {
        return accounts.values();
    }
}
```

### Class Bank.java

```
package jobsheet11;

public class Bank {
    private AccountRepository repository;

    public Bank(AccountRepository repository) {
        this.repository = repository;
    }

    public boolean addAccount(Account account) {
        if (repository.findByNumber(account.getAccountNumber()) != null) {
            return false;
        }
        repository.save(account);
        return true;
    }

    public Account findAccount(String accountNumber) {
        return repository.findByNumber(accountNumber);
    }

    public void printAllAccounts() {
        for (Account acc : repository.findAll()) {
            acc.printInfo();
        }
    }

    public void printMonthlyFees() {
        for (Account acc : repository.findAll()) {
            System.out.println(acc.getAccountNumber() + " fee: " + acc.monthlyFee());
        }
    }

    public void processMonthEnd() {
        for (Account acc : repository.findAll()) {
            if (acc instanceof InterestBearing bearing) {
                bearing.applyInterest();
                System.out.println(acc.getAccountNumber() + " interest applied, new balance: " + acc.getBalance());
            }
            System.out.println(acc.getAccountNumber() + " monthly fee: " + acc.monthlyFee());
        }
    }

    public void printHistory(String accountNumber) {
        Account acc = findAccount(accountNumber);
        if (acc == null) {
            System.out.println("Account not found: " + accountNumber);
            return;
        }
        for (Transaction t : acc.getHistory()) {
            System.out.println(accountNumber + " " + t);
        }
    }
}
```

### Class Main.java

```
package jobsheet11;

public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Nadia", "0812-0000-0001");
        SavingsAccount acc1 = new SavingsAccount("A001", customer1, 500000, 0.01);

        Customer customer2 = new Customer("Sari", "0812-0000-0002");
        CheckingAccount acc2 = new CheckingAccount("A002", customer2, 200000, 50000);

        Customer customer3 = new Customer("Rian", "0812-0000-0003");
        SavingsAccount savings = new SavingsAccount("A003", customer3, 100000, 0.02);

        try {
            savings.withdraw(70000);
        } catch (InsufficientBalanceException e) {
            System.out.println("Withdrawal failed: " + e.getMessage());
        }

        try {
            savings.withdraw(30000);
            System.out.println("Withdrawal succeeded, new balance: " + savings.getBalance());
        } catch (InsufficientBalanceException e) {
            System.out.println("Withdrawal failed: " + e.getMessage());
        }

        Bank bank = new Bank(new InMemoryAccountRepository());
        bank.addAccount(acc1);
        bank.addAccount(acc2);
        bank.addAccount(savings);
        bank.processMonthEnd();
        bank.printHistory("A003");
    }
}
```

### Hasil Run Terminal

```
PS C:\G\PraktikumPemrogramanBerbasisObjek>
Withdrawal failed: A003: insufficient balance for a withdrawal of 70000.0
Withdrawal succeeded, new balance: 70000.0
A001 interest applied, new balance: 505000.0
A001 monthly fee: 0.0
A002 monthly fee: 15000.0
A003 interest applied, new balance: 71400.0
A003 monthly fee: 0.0
A003 WITHDRAW 30000.0
A003 DEPOSIT 1400.0
PS C:\G\PraktikumPemrogramanBerbasisObjek>
```

## Langkah 7: Menelusuri OCP, LSP, dan ISP pada Kode yang Sudah Dibangun

## Tugas dan Hasil Kerja

## Class BusinessAccount.java

```
package jobsheet11;

public class BusinessAccount extends Account {
    private static final double MINIMUM_BALANCE = 1000000;

    public BusinessAccount(String accountNumber, Customer owner, double balance) {
        super(accountNumber, owner, balance);
    }

    @Override
    protected boolean canWithdraw(double amount) {
        return amount > 0 && (getBalance() - amount) >= MINIMUM_BALANCE;
    }

    @Override
    public double monthlyFee() {
        return 0;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Account type: Bussiness");
    }
}
```

### Class Main.java

```
package jobsheet11;

public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Nadia", "0812-0000-0001");
        SavingsAccount acc1 = new SavingsAccount("A001", customer1, 500000, 0.01);

        Customer customer2 = new Customer("Sari", "0812-0000-0002");
        CheckingAccount acc2 = new CheckingAccount("A002", customer2, 200000, 50000);

        Customer customer3 = new Customer("Rian", "0812-0000-0003");
        SavingsAccount savings = new SavingsAccount("A003", customer3, 100000, 0.02);

        try {
            savings.withdraw(70000);
        } catch (InsufficientBalanceException e) {
            System.out.println("Withdrawal failed: " + e.getMessage());
        }

        try {
            savings.withdraw(30000);
            System.out.println("Withdrawal succeeded, new balance: " + savings.getBalance());
        } catch (InsufficientBalanceException e) {
            System.out.println("Withdrawal failed: " + e.getMessage());
        }

        Customer customer4 = new Customer("Budi", "0812-0000-0004");
        BusinessAccount business = new BusinessAccount("A004", customer4, 2000000);

        Bank bank = new Bank(new InMemoryAccountRepository());
        bank.addAccount(acc1);
        bank.addAccount(acc2);
        bank.addAccount(savings);
        bank.processMonthEnd();
        bank.addAccount(business);
        bank.processMonthEnd();
        bank.printAllAccounts();

        bank.printHistory("A003");
    }
}
```

### Hasil Run Terminal

```
PS C:\G\PraktikumPemrogramanBerbasisObjek>
Withdrawal failed: A003: insufficient balance for a withdrawal of 70000.0
Withdrawal succeeded, new balance: 70000.0
A001 interest applied, new balance: 505000.0
A001 monthly fee: 0.0
A002 monthly fee: 15000.0
A003 interest applied, new balance: 71400.0
A003 monthly fee: 0.0
A001 interest applied, new balance: 510050.0
A001 monthly fee: 0.0
A002 monthly fee: 15000.0
A003 interest applied, new balance: 72828.0
A003 monthly fee: 0.0
A004 monthly fee: 0.0
A001 - Nadia - balance: 510050.0
Account type: Savings, interest rate: 0.01
A002 - Sari - balance: 200000.0
Account type: Checking, overdraft limit: 50000.0
A003 - Rian - balance: 72828.0
Account type: Savings, interest rate: 0.02
A004 - Budi - balance: 2000000.0
Account type: Bussiness
A003 WITHDRAW 30000.0
A003 DEPOSIT 1400.0
A003 DEPOSIT 1428.0
PS C:\G\PraktikumPemrogramanBerbasisObjek>
```

2. Jawab secara singkat (2-3 kalimat untuk masing-masing pertanyaan):

- (a) sebutkan prinsip SOLID mana yang dibuktikan oleh fakta bahwa Account.java dan Bank.java tidak berubah sama sekali setelah BusinessAccount ditambahkan, dan jelaskan mengapa.

```
Yang dibuktikan adalah Open/Closed Principle. Account dan Bank terbuka untuk diperluas lewat subclass baru, tetapi tertutup untuk diubah. Aturan rekening bisnis cukup ditulis lewat override canWithdraw(), monthlyFee(), dan printInfo().
```

- (b) processMonthEnd() memakai instanceof InterestBearing, bukan instanceof SavingsAccount. Jelaskan mengapa BusinessAccount otomatis diperlakukan benar (tidak dikenai bunga) tanpa Bank.java perlu tahu apa pun tentang keberadaannya.

```
processMonthEnd() memeriksa instanceof InterestBearing, yaitu kemampuan, bukan kelas konkret. BusinessAccount tidak meng-implement interface itu, jadi pengecekannya otomatis false dan tidak ada bunga. Bank tidak perlu tahu BusinessAccount ada. Ini Interface Segregation Principle.
```

- (c) Suatu saat nanti, InMemoryAccountRepository akan diganti kelas lain yang menyimpan data ke database. Jelaskan mengapa Bank.java tidak perlu diubah satu baris pun untuk pergantian itu, dan prinsip SOLID mana yang membuat ini mungkin.

```
Bank hanya bergantung pada interface AccountRepository, bukan pada InMemoryAccountRepository. Kelas database cukup meng-implement save, findByNumber, dan findAll, lalu dipasang di Main lewat new Bank(new DatabaseAccountRepository()). Prinsip yang membuatnya mungkin adalah Dependency Inversion Principle.
```
