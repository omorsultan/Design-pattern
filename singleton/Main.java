package singleton;

class DatabaseConnection {

    private static DatabaseConnection instance ;

    private DatabaseConnection(){
      System.out.println("Database connected");
    }

    public static DatabaseConnection getInstance(){
      if(instance == null){
        instance = new DatabaseConnection();
      }
      return instance;
    }
}

public class Main {

    public static void main(String[] args) {

        DatabaseConnection db1 =
                DatabaseConnection.getInstance();

        DatabaseConnection db2 =
                DatabaseConnection.getInstance();

        DatabaseConnection db3 =
                DatabaseConnection.getInstance();
    }
}