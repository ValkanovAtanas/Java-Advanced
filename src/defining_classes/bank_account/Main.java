package defining_classes.bank_account;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, BankAccount> myMap = new HashMap<>();

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            if (input.equals("Create")) {
                BankAccount bankAccount = new BankAccount();
                myMap.put(bankAccount.getId(), bankAccount);
                System.out.printf("Account ID%d created%n", bankAccount.getId());
                input = scanner.nextLine();
                continue;
            }

            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            int id;

            switch (command) {
                case "Deposit":
                    id = Integer.parseInt(tokens[1]);
                    double depositAmount = Double.parseDouble(tokens[2]);
                    if (!myMap.containsKey(id)) {
                        System.out.println("Account does not exist");
                    } else {
                        double currentBalance = myMap.get(id).getBalance();
                        double newBalance = currentBalance + depositAmount;
                        myMap.get(id).setBalance(newBalance);
                        System.out.printf("Deposited %.0f to ID%d%n", depositAmount, id);
                    }
                    break;
                case "SetInterest":
                    double newInterest = Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(newInterest);
                    break;
                case "GetInterest":
                    id = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);
                    if (!myMap.containsKey(id)) {
                        System.out.println("Account does not exist");
                    } else {
                        double currentAmount = myMap.get(id).getInterest(years);
                        System.out.println(String.format("%.2f",currentAmount));
                    }

                    break;

            }
            input = scanner.nextLine();
        }
    }
}
