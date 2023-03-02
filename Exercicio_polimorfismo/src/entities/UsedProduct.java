package entities;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product {

  private LocalDate manufactureDate;

  public UsedProduct() {
    super();
  }

  public UsedProduct(String name, Double price, LocalDate manufactureDate) {
    super(name, price);
    this.manufactureDate = manufactureDate;
  }

  public LocalDate getManufactureDate() {
    return this.manufactureDate;
  }

  public void setManufactureDate(LocalDate manufactureDate) {
    this.manufactureDate = manufactureDate;
  }

  @Override
  public String priceTag() {
    return getName()
        + " (used) $ "
        + String.format("%.2f", this.getPrice())
        + " (Manufacture Date: "
        + manufactureDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        + ")";
  }

}
