package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Project;
import util.ConnectionFactory;

public class ProjectController {

  public void Save(Project project) {
    String sql = "INSERT INTO projects(Name, "
            + "Description, "
            + "CreatedAt, "
            + "UpdatedAt) VALUES(?, ?, ?, ?)";

    Connection conn = null;
    PreparedStatement statement = null;

    try {
      conn = ConnectionFactory.getConnection();
      statement = conn.prepareStatement(sql);
      statement.setString(1, project.getName());
      statement.setString(2, project.getDescription());
      statement.setDate(3, new Date(project.getCreatedAt().getTime()));
      statement.setDate(4, new Date(project.getUpdatedAt().getTime()));

      statement.execute();
    } catch (Exception ex) {
      throw new RuntimeException("Erro ao salvar projeto. " + ex.getMessage(), ex);
    } finally {
      ConnectionFactory.closeConnection(conn, statement);
    }
  }

  public void update(Project project) {
    String sql = "UPDATE projects SET "
            + "Name = ?, "
            + "Description = ?, "
            + "CreatedAt = ?, "
            + "UpdatedAt = ? "
            + "WHERE id = ?";

    Connection conn = null;
    PreparedStatement statement = null;

    try {
      conn = ConnectionFactory.getConnection();
      statement = conn.prepareStatement(sql);

      statement.setString(1, project.getName());
      statement.setString(2, project.getDescription());
      statement.setDate(3, new Date(project.getCreatedAt().getTime()));
      statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
      statement.setInt(5, project.getId());

      statement.execute();
    } catch (Exception ex) {
      throw new RuntimeException("Erro ao atualizar projeto. " + ex.getMessage() + ex);

    } finally {
      ConnectionFactory.closeConnection(conn, statement);
    }
  }

  public List<Project> getALL() {
    String sql = "SELECT * FROM projects";

    Connection conn = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    List<Project> projects = new ArrayList<>();

    try {
      conn = ConnectionFactory.getConnection();
      statement = conn.prepareStatement(sql);
      resultSet = statement.executeQuery();

      while (resultSet.next()) {
        Project project = new Project();
        project.setId(resultSet.getInt("ID"));
        project.setName(resultSet.getString("Name"));
        project.setDescription(resultSet.getString("Description"));
        project.setCreatedAt(resultSet.getDate("CreatedAt"));
        project.setUpdatedAt(resultSet.getDate("UpdatedAt"));

        projects.add(project);
      }
    } catch (Exception ex) {
      throw new RuntimeException("Erro ao inserir o projeto. " + ex.getMessage(), ex);
    } finally {
      ConnectionFactory.closeConnection(conn, statement, resultSet);
    }

    return projects;
  }

  public void removeByID(int id) {
    String sql = "DELETE FROM projects WHERE id =?";

    Connection conn = null;
    PreparedStatement statement = null;

    try {
      conn = ConnectionFactory.getConnection();

      statement = conn.prepareStatement(sql);
      statement.setInt(1, id);

      statement.execute();
    } catch (Exception ex) {
      throw new RuntimeException("Erro ao deletar a projeto.", ex);

    } finally {
      ConnectionFactory.closeConnection(conn, statement);
    }
  }
}
