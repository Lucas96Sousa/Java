# Anotações sobre o exercicio

## Parte 1

Dentro do Domain Layer (entities), consiste duas classes (Contract e Installment).
Onde o <b>Contract</b> tem n instâncias de installments, que se traduz como um contrato tem várias prestações.

</br>

<b>O Contract tem as seguintes informações :</b>

```java
package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {
  private Integer number;
  private LocalDate date;
  private Double totalValue;

  private List<Installment> installments = new ArrayList<>();

  public Contract() {
  }

  public Contract(Integer number, LocalDate date, Double totalValue) {
    this.number = number;
    this.date = date;
    this.totalValue = totalValue;
  }

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public Double getTotalValue() {
    return totalValue;
  }

  public void setTotalValue(Double totalValue) {
    this.totalValue = totalValue;
  }

  public List<Installment> getInstallments() {
    return installments;
  }
}

 
```

Com esse modelo o Contract já esta finalizado.
<p>Getter and Setter foram criados e removido apenas o setList.</p>

<b>Seguindo com o Installment, incialmente ele tem apenas a base da classe: </b>

```java
package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installment {

  private LocalDate date;
  private Double amount;

  private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  public Installment() {
  }

  public Installment(LocalDate date, Double amount) {
    this.date = date;
    this.amount = amount;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  @Override
  public String toString() {
    return date.format(fmt) + " - " + String.format("%.2f", amount);
  }  
}
```

Já foi criado um DateTimeFormat para ser usado futuramente.



## Parte 2
Iniciando a parte 2, é onde criamos a camada de services que contém: ContractService, OnlinePaymentService e PaypalService.

Como o OnlinePaymentService irá atuar como a interface do projeto, ela terá as seguintes informações: 


<b>Layout do OnlinePaymentService</b>

```java
package services;

public interface OnlinePaymentService {
  double paymentFee(double amount);

  double interest(double amount, int months);
}
```
A classe <b>ContractService</b> tem como papel gerar os gerar as parcelas.

<b>Layout do ContractService</b>

```java
package services;

import java.time.LocalDate;

import entities.Contract;
import entities.Installment;

public class ContractService {
  private OnlinePaymentService onlinePaymentService;

  public ContractService(OnlinePaymentService onlinePaymentService) {
    this.onlinePaymentService = onlinePaymentService;
  }

  public void processContract(Contract contract, int months) {
    double basicQuota = contract.getTotalValue() / months;

    for(int i=1; i <= months; i++) {
        LocalDate dueDate = contract.getDate().plusMonths(i);

        double interest = onlinePaymentService.interest(basicQuota, i);
        double fee = onlinePaymentService.paymentFee(basicQuota + interest);
        double quota = basicQuota + interest + fee;

        contract.getInstallments().add(new Installment(dueDate, quota));
    } 
  }

}
```

Como o ContractService é dependente do OnlinePaymentService, o mesmo é incluso dentro da classe onde irá fornecer os dados para as operações.


## Parte 3

Aqui iremos fazer a implemtação dos juros das parcelas.
Dentro dos services é criado o PayPalService, que irá decidir quais as taxas do juros para as parcelas. Implementando o OnlinePaymentService a sua classe.

<b>Layout PayPalService</b>

```java
package services;

public class PaypalService implements OnlinePaymentService {
    
    @Override
    public double paymentFee(double amount) {
        return amount * 0.2;
    }

    @Override
    public double interest(double amount, int months) {
        return amount * 0.01 * months;
    }
}

```
Finalizado o modulo do paypal, é feito a modelagem do Main, para executar todo o programa.

<b>Layout do Main</b>

```java
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
```
</br>
Explicando as partes do projeto, quando é chamamos o <b>Contract</b>, é quando obtemos o numero de parcelas e em conjunto já temos os valores dos meses seguintes.

```java
    ContractService contractService = new ContractService(new PaypalService());

    contractService.processContract(contract, n);
```
Como é possível verficar, o método de gerar as parcelas já está sendo executado dentro do contract, com o PaypalService.