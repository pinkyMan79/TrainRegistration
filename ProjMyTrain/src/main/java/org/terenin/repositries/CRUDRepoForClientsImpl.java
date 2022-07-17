package org.terenin.repositries;

import org.apache.commons.logging.Log;
import org.terenin.dto.SignUpFormForUser;
import org.terenin.models.Client;

import javax.sql.DataSource;
import java.io.Reader;
import java.sql.*;
import java.util.List;
import java.util.function.Function;

public class CRUDRepoForClientsImpl implements CRUDRepoForClients {

    //language=SQL
    private final String SQL_CREATE_NEW_CLIENT = "INSERT INTO client(first_name, last_name, email, password)" +
            " VALUES (?, ?, ?, ?)";

    //language=SQL
    private final String SQL_UPDATE_CLIENT = "UPDATE client SET first_name= ?, last_name = ?, email = ?, password = ? WHERE id = ?";


    private DataSource dataSource;

    public CRUDRepoForClientsImpl(DataSource dataSource){

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
             PreparedStatement statement = connection.prepareStatement(SQL_CREATE_NEW_CLIENT, Statement.RETURN_GENERATED_KEYS)){

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
        return null;
    }

    @Override
    public Client findById(Long id) {
        return null;
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

    }
}
