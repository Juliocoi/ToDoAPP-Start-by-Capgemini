package capgemini.todoapp;
// aula Aula 11.J

import java.sql.Connection;
import util.ConnectionFactory;

public class ToDoAPP {

  public static void main(String[] args) {
    System.out.println("Hello World!");
    Connection c = ConnectionFactory.getConnection();
    ConnectionFactory.closeConnection(c);

  }
}
