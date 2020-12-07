package model;

import java.time.LocalDate;

public class MyDate
{
  private int day;
  private int month;
  private int year;

  public MyDate(int day, int month, int year)
  {
    set(day, month, year);
  }

  public MyDate()
  {
    LocalDate today = LocalDate.now();

    this.day = today.getDayOfMonth();
    this.month = today.getMonthValue();
    this.year = today.getYear();
  }
  public void set(int day, int month, int year)
  {
    if (year < 0)
    {
      year = -year;
    }
    if (month < 1)
    {
      month = 1;
    }
    else if (month > 12)
    {
      month = 12;
    }
    this.year = year;
    this.month = month;
    if (day < 1)
    {
      day = 1;
    }
    else if (day > numberOfDaysInMonth())
    {
      day = numberOfDaysInMonth();
    }
    this.day = day;
  }
  public int getDay()
  {
    return day;
  }

  public int getMonth()
  {
    return month;
  }

  public int getYear()
  {
    return year;
  }

  public boolean isLeapYear()
  {
    return (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0));
  }

  public String getMonthName()
  {
    switch (month)
    {
      case 1:
        return "January";
      case 2:
        return "February";
      case 3:
        return "March";
      case 4:
        return "April";
      case 5:
        return "May";
      case 6:
        return "June";
      case 7:
        return "July";
      case 8:
        return "August";
      case 9:
        return "September";
      case 10:
        return "October";
      case 11:
        return "November";
      case 12:
        return "December";
      default:
        return "Error";
    }
  }
  public int numberOfDaysInMonth()
  {
    switch (month)
    {
      case 2:
        if (isLeapYear())
        {
          return 29;
        }
        return 28;
      case 4:
      case 6:
      case 9:
      case 11:
        return 30;
      default:
        return 31;
    }
  }
  public boolean isBefore(MyDate other)
  {
    int dummyDaysOfThis = year * 400 + month * 31 + day;
    int dummyDaysOfOther = other.year * 400 + other.month * 31 + other.day;
    return dummyDaysOfThis < dummyDaysOfOther;
  }
  public void stepForward()
  {
    day++;
    if (day > numberOfDaysInMonth())
    {
      day = 1;
      month++;
      if (month > 12)
      {
        month = 1;
        year++;
      }
    }
  }

  public void stepForward(int days)
  {
    for (int i = 0; i < days; i++)
    {
      stepForward();
    }
  }
  public String dayOfWeek()
  {
    int q = day;
    int m = 0;
    switch (getMonthName())
    {
      case "January":
        m = 13;
        break;
      case "February":
        m = 14;
        break;
      case "March":
        m = 3;
        break;
      case "April":
        m = 4;
        break;
      case "May":
        m = 5;
        break;
      case "June":
        m = 6;
        break;
      case "July":
        m = 7;
        break;
      case "August":
        m = 8;
        break;
      case "September":
        m = 9;
        break;
      case "October":
        m = 10;
        break;
      case "November":
        m = 11;
        break;
      case "December":
        m = 12;
        break;

    }
    int k = 0;
    switch (getMonthName())
    {
      case "March":
      case "April":
      case "May":
      case "June":
      case "July":
      case "August":
      case "September":
      case "October":
      case "November":
      case "December":
        k = year % 100;
        break;
      case "January":
      case "February":
        k = (year - 1) % 100;
        break;

    }
    int j = 0;
    switch (getMonthName())
    {
      case "March":
      case "April":
      case "May":
      case "June":
      case "July":
      case "August":
      case "September":
      case "October":
      case "November":
      case "December":
        j = year / 100;
        break;
      case "January":
      case "February":
        j = (year - 1) / 100;
        break;

    }
    int h = (q + ((13 * (m + 1)) / 5) + k + (k / 4) + (j / 4) + (5 * j)) % 7;
    String t = null;
    switch (h)
    {
      case 0:
        t = "Saturday";
        break;
      case 1:
        t = "Sunday";
        break;
      case 2:
        t = "Monday";
        break;
      case 3:
        t = "Tuesday";
        break;
      case 4:
        t = "Wednesday";
        break;
      case 5:
        t = "Thursday";
        break;
      case 6:
        t = "Friday";
        break;
    }
    return t;

  }

  public MyDate copy()
  {
    MyDate other = new MyDate(day, month, year);
    return other;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof MyDate))
    {
      return false;
    }
    MyDate other = (MyDate) obj;
    return day == other.day && month == other.month && year == other.year;
  }
  public String toString()
  {
    return String.format("%02d/%02d/%02d", day, month, year);
  }

}
