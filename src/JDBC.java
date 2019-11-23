import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBC{

    static String data;
    /**
     * @param args
     */
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost/test?user=test&password=test";
        //Tworzymy proste zapytanie doa bazy danych
        String query = "Select * FROM ****";

        Connection connection = null;

        try {

            //Ustawiamy dane dotyczące podłączenia
            connection= DriverManager.getConnection(url);

            //Ustawiamy sterownik MySQL
            Class.forName("com.mysql.jdbc.Driver");

            //Uruchamiamy zapytanie do bazy danych

            ResultSet resultSet = connection.createStatement().executeQuery(query);

            while (resultSet.next()) {
                showDate(resultSet);
            }

            connection.close();
        }
        //Wyrzuć wyjątki jężeli nastąpią błędy z podłączeniem do bazy danych lub blędy zapytania o dane
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        catch(SQLException e) {
            //e.printStackTrace();
            //System.out.println("Problem z logowaniem\nProsze sprawdzic:\n nazwę użytkownika, hasło, nazwę bazy danych lub adres IP serwera");
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }

    }
    static void showDate(ResultSet resultSet){
        try{
            data = resultSet.getString(1);
            System.out.println("\n" + data + " ");
            data =resultSet.getString(2);
            System.out.println(data + " ");
            data = resultSet.getString(3);
            System.out.println(data);
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

}