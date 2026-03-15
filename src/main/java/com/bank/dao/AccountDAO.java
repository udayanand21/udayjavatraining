
package com.bank.dao; import java.sql.*; import java.util.*; import com.bank.model.Account;
public class AccountDAO{
  Connection con;
  public AccountDAO() throws Exception{
    Class.forName("com.mysql.cj.jdbc.Driver");
    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cfgb","root","cfg@1234");
  }
  public void create(Account a) throws Exception{
    PreparedStatement ps=con.prepareStatement("insert into account values(?,?,?,?)");
    ps.setInt(1,a.getAccno()); ps.setString(2,a.getName()); ps.setString(3,a.getType()); ps.setDouble(4,a.getBalance()); ps.executeUpdate();
  }
  public List<Account> all() throws Exception{
    List<Account> l=new ArrayList<>(); ResultSet rs=con.createStatement().executeQuery("select * from account");
    while(rs.next()) l.add(new Account(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4))); return l;
  }
  public void deposit(int accno, double amt) throws Exception {
	    PreparedStatement ps =
	        con.prepareStatement("update account set balance = balance + ? where accno=?");
	    ps.setDouble(1, amt);
	    ps.setInt(2, accno);
	    ps.executeUpdate();
	}

	public void withdraw(int accno, double amt) throws Exception {
	    PreparedStatement ps =
	        con.prepareStatement("update account set balance = balance - ? where accno=?");
	    ps.setDouble(1, amt);
	    ps.setInt(2, accno);
	    ps.executeUpdate();
	}
}

