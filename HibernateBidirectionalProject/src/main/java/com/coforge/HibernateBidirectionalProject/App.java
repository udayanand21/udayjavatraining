package com.coforge.HibernateBidirectionalProject;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.coforge.Util.HibernateUtil;
import com.coforge.entities.Aadhar;
import com.coforge.entities.Citizen;

public class App {

   public static void main(String[] args) {

       Scanner sc = new Scanner(System.in);
       SessionFactory factory = HibernateUtil.getSessionFactory();

       while (true) {

           System.out.println("\n===== MENU =====");
           System.out.println("1 Insert Citizen");
           System.out.println("2 Get All Citizens");
           System.out.println("3 Get citizen by aadhar number");
           System.out.println("4 Update Citizen");
           System.out.println("5 Delete Citizen");
           System.out.println("6 Exit");

           System.out.print("Enter choice: ");
           int ch = sc.nextInt();

           Session session = factory.openSession();
           Transaction tx = session.beginTransaction();

           switch (ch) {

           case 1:

               System.out.print("enter name ");
               String name = sc.next();

               System.out.print("enter address: ");
               String address = sc.next();

               Citizen citizen = new Citizen();
               citizen.setCname(name);

               Aadhar aadhar = new Aadhar();
               aadhar.setAddress(address);
               citizen.setAadhar(aadhar);
               aadhar.setCitizen(citizen);

               session.persist(citizen);

               tx.commit();

               System.out.println("inserted successful");
               break;

           case 2:

               List<Citizen> list = session.createQuery("from Citizen", Citizen.class).list();

               for (Citizen c : list) {
                   System.out.println("citizen id: " + c.getCid());
                   System.out.println("Name: " + c.getCname());
                   System.out.println("aadhar adress:"+c.getAadhar().getAddress());
               }

               break;

           case 3:

               System.out.print("Enter aadharid: ");
               long aid = sc.nextLong();

               Aadhar a = session.get(Aadhar.class, aid);

               if (a != null) {
                   Citizen c = a.getCitizen();

                   System.out.println("citizen id: " + c.getCid());
                   System.out.println("citizen name: " + c.getCname());
                   System.out.println("Address: " + a.getAddress());
               } else {
                   System.out.println("Citizen not found");
               }

               break;

           case 4:

               System.out.print("Enter id to update: ");
               long id = sc.nextLong();

               Citizen c = session.get(Citizen.class, id);

               if (c != null) {

                   System.out.print("Enter new name: ");
                   String newName = sc.next();

                   c.setCname(newName);

                   session.update(c);
                   tx.commit();

                   System.out.println("Citizen Updated");
               } else {
                   System.out.println("Citizen not found");
               }

               break;

           case 5:

               System.out.print("Enter Citizen ID to Delete: ");
               long deleteId = sc.nextLong();

               Citizen citizenDelete = session.get(Citizen.class, deleteId);

               if (citizenDelete != null) {

                   session.delete(citizenDelete);
                   tx.commit();

                   System.out.println("Citizen Deleted");
               } else {
                   System.out.println("Citizen not found");
               }

               break;

           case 6:
               factory.close();
               sc.close();
               System.exit(0);

           default:
               System.out.println("invalid Choice");
           }

           session.close();
       }
   }
}