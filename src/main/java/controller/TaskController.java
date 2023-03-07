package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Task;
import util.ConnectionFactory;

public class TaskController {

  public void save(Task task) {
    String sql = "INSERT INTO tasks(idProject "
            + "Name, "
            + "description, "
            + "isCompleted, "
            + "Notes, "
            + "Deadline, "
            + "CreatedAt, "
            + "UpdatedAt) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    Connection conn = null;
    PreparedStatement statement = null;

    try {
      conn = ConnectionFactory.getConnection();
      statement = conn.prepareStatement(sql);
      statement.setInt(1, task.getIdProject());
      statement.setString(2, task.getName());
      statement.setString(3, task.getDescription());
      statement.setBoolean(4, task.isIsCompleted());
      statement.setString(5, task.getNotes());
      //nos dates abaixo devemos usar o pacote sql.date, não o util.date
      statement.setDate(6, new Date(task.getDeadLine().getTime()));
      statement.setDate(7, new Date(task.getCreatedAt().getTime()));
      statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
      statement.execute();
    } catch (Exception ex) {
      throw new RuntimeException("Erro ao salvar a tarefa. " + ex.getMessage(), ex);
    } finally {
      ConnectionFactory.closeConnection(conn, statement);
    }
  }

  public void update(Task task) {
    String sql = "UPDATE tasks SET "
            + "idProject = ?, "
            + "name = ?, "
            + "description = ?, "
            + "isCompleted = ?, "
            + "notes = ?, "
            + "deadline = ?, "
            + "createdAt = ?, "
            + "updatedAt = ?, "
            + "WHERE id = ?";

    Connection conn = null;
    PreparedStatement statement = null;

    try {
      conn = ConnectionFactory.getConnection();
      statement = conn.prepareStatement(sql);
      statement.setInt(1, task.getIdProject());
      statement.setString(2, task.getName());
      statement.setString(3, task.getDescription());
      statement.setBoolean(4, task.isIsCompleted());
      statement.setString(5, task.getNotes());
      statement.setDate(6, new Date(task.getDeadLine().getTime()));
      statement.setDate(7, new Date(task.getCreatedAt().getTime()));
      statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
      statement.setInt(9, task.getId());
      statement.execute();

    } catch (Exception ex) {
      throw new RuntimeException("Erro ao atualizar tarefa." + ex.getMessage() + ex);

    } finally {
      ConnectionFactory.closeConnection(conn, statement);
    }
  }

  public void removeByID(int taskId) throws SQLException {
    String sql = "DELETE FROM tasks WHERE id = ?";
    Connection conn = null;
    PreparedStatement statement = null;

    try {
      conn = ConnectionFactory.getConnection();
      statement = conn.prepareStatement(sql);
      statement.setInt(1, taskId);
      statement.execute();
    } catch (Exception ex) {
      throw new RuntimeException("Erro ao deletar a tarefa.", ex);
    } finally {
      ConnectionFactory.closeConnection(conn, statement);
    }
  }

  public List<Task> getAll(int idProject) {
    String sql = "SELECT * FROM tasks WHERE idProject = ?";

    Connection conn = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    List<Task> tasks = new ArrayList<Task>();

    try {
      conn = ConnectionFactory.getConnection();
      statement = conn.prepareStatement(sql);
      statement.setInt(1, idProject);
      //valor retornado pela execução da query
      resultSet = statement.executeQuery();

      while (resultSet.next()) {
        Task task = new Task();

        task.setId(resultSet.getInt("ID"));
        task.setIdProject(resultSet.getInt("idProject"));
        task.setName(resultSet.getString("name"));
        task.setDescription(resultSet.getString("Description"));
        task.setIsCompleted(resultSet.getBoolean("isCompleted"));
        task.setNotes(resultSet.getString("notes"));
        task.setDeadLine(resultSet.getDate("deadline"));
        task.setCreatedAt(resultSet.getDate("createdAt"));
        task.setUpdatedAt(resultSet.getDate("updateAt"));

        tasks.add(task);
      }

    } catch (Exception ex) {
      throw new RuntimeException("Erro ao inserir a tarefa.", ex);
    } finally {
      ConnectionFactory.closeConnection(conn, statement, resultSet);
    }

    return tasks;
  }

}
