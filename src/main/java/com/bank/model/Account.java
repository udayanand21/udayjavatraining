
package com.bank.model;
public class Account{ private int accno; private String name,type; private double balance;
  public Account(){}
  public Account(int a,String n,String t,double b){accno=a;name=n;type=t;balance=b;}
  public int getAccno(){return accno;} public void setAccno(int v){accno=v;}
  public String getName(){return name;} public void setName(String v){name=v;}
  public String getType(){return type;} public void setType(String v){type=v;}
  public double getBalance(){return balance;} public void setBalance(double v){balance=v;}
}
