import java.sql.*;
import java.util.Scanner;
public class Book {

    public static void main(String args[])
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb","root","");
        }
        catch (Exception e){
            System.out.println(e);
        }
        int choice;
        String title,author,category;
        int chargeperday;
        Scanner s= new Scanner(System.in);
        while(true){
            System.out.println("1.select any option");
            System.out.println("1.insert");
            System.out.println("2.select");
            System.out.println("3.search");
            System.out.println("4.update");
            System.out.println("5.delete");
            System.out.println("6.exit");
            System.out.println("enter the choice");
            choice = s.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("insertdata");
                    System.out.println("enter book name");
                    String bookname = s.next();
                    System.out.println("enter author name");
                    author=s.next();
                    System.out.println("enter category");
                    category=s.next();
                    System.out.println("enter book charge per day");
                    int bookchargeperday = s.nextInt();

                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb","root","");
                        String sql="INSERT INTO `books`(`title`, `author`, `category`, `charge per day`) VALUES (?,?,?,?)";
                        PreparedStatement stmt = con.prepareStatement(sql);
                        stmt.setString(1,bookname);
                        stmt.setString(2,author);
                        stmt.setString(3,category );
                        stmt.setInt(4,bookchargeperday);

                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 2:
                    System.out.println("select data");
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb","root","");
                        String sql = "SELECT `id`, `title`, `author`, `category`, `charge per day` FROM `books` ";
                        Statement stmt = con.createStatement();
                        ResultSet rs= stmt.executeQuery(sql);
                        while (rs.next()){
                            String getbookname=rs.getString("title");
                            String getauthor=rs.getString("author");
                            String getcategory=rs.getString("category");
                            String getbookchargeperday=rs.getString("charge per day");

                            System.out.println("title="+getbookname);
                            System.out.println("author="+getauthor);
                            System.out.println("category="+getcategory);
                            System.out.println("charge per day="+getbookchargeperday);

                        }

                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;


                case 3:
                    System.out.println("search data");
                    System.out.println("enter bookcharge:");
                    chargeperday=s.nextInt();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb","root","");
                        String sql="SELECT `id`, `title`, `author`, `category`, `charge per day` FROM `books` WHERE `charge per day`="+String.valueOf(chargeperday);
                        Statement stmt = con.createStatement();
                        ResultSet rs= stmt.executeQuery(sql);
                        while(rs.next()){
                            String getbookname=rs.getString("title");
                            String getauthor=rs.getString("author");
                            String getcategory=rs.getString("category");
                            String getbookchargeperday=rs.getString("charge per day");

                            System.out.println("title="+getbookname);
                            System.out.println("author="+getauthor);
                            System.out.println("category="+getcategory);
                            System.out.println("charge per day="+getbookchargeperday);

                        }
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;


            case 4:
                System.out.println("update data");
                break;
                case 5:
                    System.out.println("delete data");
                    System.out.println("enter book charge:");
                    String charge=s.next();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb","root","");
                        String sql="DELETE FROM `books` WHERE `charge per day`="+charge;
                        Statement stmt =con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("deleted successfully");
                    }
                    catch (Exception e){
                        System.out.println((e));
                    }
                    break;
            case 6:
                System.out.println("exit");
                System.exit(0);
                break;
        }
    }
}
}