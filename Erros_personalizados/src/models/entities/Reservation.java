package models.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
  private Integer roomNumber;
  private Date checkIn;
  private Date checkOut;

  private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

  public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
    this.roomNumber = roomNumber;
    this.checkIn = checkIn;
    this.checkOut = checkOut;
  }


  public Integer getRoomNumber() {
    return this.roomNumber;
  }

  public void setRoomNumber(Integer roomNumber) {
    this.roomNumber = roomNumber;
  }

  public Date getCheckIn() {
    return this.checkIn;
  }

  public Date getCheckOut() {
    return this.checkOut;
  }

  public long duration(){
    long diff = checkOut.getTime() - checkIn.getTime();
    return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);    
  }

  public void updateDates(Date checkIn, Date checkOut){
    this.checkIn = checkIn;
    this.checkOut = checkOut;
  }


  @Override
  public String toString() {
    return "Room" 
      + roomNumber
      +", check-in: "
      + sdf.format(checkIn)
      + ", "
      + duration()
      + " nights" ;
  }


}
