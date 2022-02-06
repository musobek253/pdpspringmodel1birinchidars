
import java.sql.*;

public class DbConnectionService {

    private final String url = "jdbc:postgresql://localhost:5432/computer_db";

    private  final String username = "postgres";

    private final String password = "user";

    public void getproduct(){
        try {
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String qurey = " select*from product";
            ResultSet resultSet = statement.executeQuery(qurey);
            while (resultSet.next()){
                String maker = resultSet.getString(1);
                int model = resultSet.getInt(2);
                String type = resultSet.getString(3);
                Product product = new Product(maker,model,type);

                System.out.println(product);
                statement.close();
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getusish(){
        try {
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String qurey = " with usish AS (\n" +
                    "    select maker,model,price from pc\n" +
                    "    join product p using (model)\n" +
                    "    union all\n" +
                    "\n" +
                    "    select maker,model,price from laptop\n" +
                    "    join product p using (model)\n" +
                    "    union all\n" +
                    "\n" +
                    "    select maker,model,price from printer\n" +
                    "    join product p using (model)\n" +
                    "\n" +
                    "\n" +
                    ")\n" +
                    "select maker,model,price from usish order by price asc ;";
            ResultSet resultSet = statement.executeQuery(qurey);
            while (resultSet.next()){
                String maker = resultSet.getString(1);
                int model = resultSet.getInt(2);
                int price = resultSet.getInt(3);
                Usish usish = new Usish(maker,model,price);

                System.out.println(usish);
                statement.close();
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void getPc(){
        try {
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String qurey = "select maker,model,price from pc join product p using (model)";
            ResultSet resultSet = statement.executeQuery(qurey);
            while (resultSet.next()){
                String maker = resultSet.getString(1);
                int model = resultSet.getInt(2);
                int price = resultSet.getInt(3);
               Usish usish = new Usish(maker,model,price);

                System.out.println(usish);

                statement.close();
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getLoptop(){
        try {
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String qurey = "select maker,model,price from laptop join product p using (model)";
            ResultSet resultSet = statement.executeQuery(qurey);
            while (resultSet.next()){
                String maker = resultSet.getString(1);
                int model = resultSet.getInt(2);
                int price = resultSet.getInt(3);
                Usish usish = new Usish(maker,model,price);

                System.out.println(usish);

                statement.close();
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getPrinter(){
        try {
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String qurey = "select maker,model,price from printer join product p using (model)";
            ResultSet resultSet = statement.executeQuery(qurey);
            while (resultSet.next()){
                String maker = resultSet.getString(1);
                int model = resultSet.getInt(2);
                int price = resultSet.getInt(3);
                Usish usish = new Usish(maker,model,price);

                System.out.println(usish);

                statement.close();
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
