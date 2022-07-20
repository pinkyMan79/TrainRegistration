package org.terenin.repositries;

import org.apache.commons.logging.Log;
import org.terenin.dto.SignUpFormForUser;
import org.terenin.jdbc.MyDataSource;
import org.terenin.models.Client;

import javax.sql.DataSource;
import java.io.Reader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CRUDRepoForClientsImpl implements CRUDRepoForClients {

    //language=SQL
    private final String SQL_CREATE_NEW_CLIENT = "INSERT INTO client(first_name, last_name, email, password)" +
            " VALUES (?, ?, ?, ?)";

    //language=SQL
    private final String SQL_UPDATE_CLIENT = "UPDATE client SET first_name= ?, last_name = ?, email = ?, password = ? WHERE id = ?";

    //language=SQL
    private final String SQL_FIND_ALL = "SELECT * from client";

    //language=SQL
    private final String SQL_FIND_BY_ID = "SELECT * from client WHERE  id = ?";

    //language=SQL
    private final String SQL_DELETE = "DELETE FROM client WHERE id = ?";


    private DataSource dataSource;

    public CRUDRepoForClientsImpl(MyDataSource dataSource){

        this.dataSource = dataSource;

    }

    private Function<SignUpFormForUser, Client> clientFunction = signUpFormForUser -> Client.builder()
            .firstName(signUpFormForUser.getFirstName())
            .lastName(signUpFormForUser.getLastName())
            .email(signUpFormForUser.getEmail())
            .password(signUpFormForUser.getPassword())
            .build();

    @Override
    public void create(Client client) {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_CREATE_NEW_CLIENT,
                     Statement.RETURN_GENERATED_KEYS)){

            statement.setString(1, client.getFirstName());
            statement.setString(2, client.getLastName());
            statement.setString(3, client.getEmail());
            statement.setString(4, client.getPassword());

            int createdRows = statement.executeUpdate();
            if (createdRows != 1) throw new SQLException("something goes wrong");

            ResultSet keygen = statement.getGeneratedKeys();
            if (keygen.next()) client.setId(keygen.getLong("id"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Client> findAll() {

        List<Client> clients = new ArrayList<>();

        try(Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(SQL_FIND_ALL);

            while(resultSet.next()){

                clients.add(Client.builder().
                        id(resultSet.getLong("id")).
                        firstName(resultSet.getString("first_name")).
                        lastName(resultSet.getString("last_name")).
                        email(resultSet.getString("email")).
                        password(resultSet.getString("password")).
                        build());

            }

            return clients;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Client findById(Long id) {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_ID)){

            statement.setLong(1, id);

            ResultSet set = statement.executeQuery();

            if (set.next()){

                return Client.builder().
                        firstName(set.getString(2)).
                        lastName(set.getString(3)).
                        email(set.getString(4)).
                        password(set.getString(5)).
                        build();

            }else {

                throw new RuntimeException("The trouble in" + CRUDRepoForClientsImpl.class.getName());

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(Client client) {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_CLIENT)){

            statement.setString(1, client.getFirstName());
            statement.setString(2, client.getLastName());
            statement.setString(3, client.getEmail());
            statement.setString(4, client.getPassword());

            statement.setLong(5, client.getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteById(Long id) {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_DELETE)){

            statement.setLong(1, id);

            int affectedRows =  statement.executeUpdate();

            if (affectedRows != 1){

                throw new RuntimeException("Something goes wrong in: " + CRUDRepoForClientsImpl.class.getName() + " method:" + "deleteById");

            }else {

                System.out.println("all done");

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
