package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

public class Main {
  public static void main(String[] args) {

    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    System.out.println("Enter to contract data: ");
    System.out.print("Number: ");
    int number = sc.nextInt();
    System.out.print("Date (dd/MM/yyyy): ");
    LocalDate date = LocalDate.parse(sc.next(), fmt);
    System.out.print("Value contract: ");
    double totalValue = sc.nextDouble();


    Contract contract  = new Contract(number, date,totalValue);

    System.out.print("Enter number of installments: ");
    int n = sc.nextInt();

    ContractService contractService = new ContractService(new PaypalService());

    contractService.processContract(contract, n);
    

    System.out.println("Installments: ");

    for(Installment installment : contract.getInstallments()) {
      System.out.println(installment);
    }


    sc.close();
  }
}