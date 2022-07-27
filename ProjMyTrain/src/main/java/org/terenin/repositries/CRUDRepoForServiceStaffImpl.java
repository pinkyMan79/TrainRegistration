package org.terenin.repositries;

import org.terenin.models.ServiceGuy;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUDRepoForServiceStaffImpl implements CRUDRepoForServiceStaff {

    private DataSource dataSource;

    public CRUDRepoForServiceStaffImpl(DataSource dataSource){

        this.dataSource = dataSource;

    }

    //language=SQL
    private static String SQL_CREATE_SERVICE_GUY = "INSERT INTO service_staff(id, first_name, last_name, email, password, type_of_working, access_token)" +
            "  VALUES (?,?,?,?,?,?)";

    //language=SQL
    private static String SQL_FIND_ALL = "SELECT * from service_staff";

    //language=SQL
    private static String SQL_FIND_SERVICEGUY_BY_ID = "SELECT * from service_staff WHERE id = ?";

    //language=SQL
    private static String SQL_UPDATE_SERVICE_GUY = "UPDATE service_staff" +
            " SET first_name = ?, last_name = ?, email = ?, password = ?, type_of_working = ?, access_token = ? WHERE id = ?";

    //language=SQL
    private static String SQL_DELETE_SERVICE_GUY = "DELETE FROM service_staff WHERE id = ?";

    @Override
    public void create(ServiceGuy serviceGuy) {

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement =
            connection.prepareStatement(SQL_CREATE_SERVICE_GUY, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(2, serviceGuy.getFirstName());
            preparedStatement.setString(3, serviceGuy.getLastName());
            preparedStatement.setString(4, serviceGuy.getEmail());
            preparedStatement.setString(5, serviceGuy.getPassword());
            preparedStatement.setString(6, serviceGuy.getTypeOfWorking());
            preparedStatement.setString(7, serviceGuy.getAccessToken());

            ResultSet keygen = preparedStatement.getGeneratedKeys();

            if (keygen.next()) {preparedStatement.setLong(1, keygen.getLong("id")); serviceGuy.setId(keygen.getLong("id"));}


            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows != 1) throw new RuntimeException("Error in: " + this.getClass().getName() + " in method:" + " create");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<ServiceGuy> findAll() {

        List<ServiceGuy> serviceGuys = new ArrayList<>();

        try(Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(SQL_FIND_ALL);

            while (resultSet.next()){

                serviceGuys.add(ServiceGuy.builder().
                        id(resultSet.getLong("id")).
                        firstName(resultSet.getString("first_name")).
                        lastName(resultSet.getString("last_name")).
                        email(resultSet.getString("email")).
                        password(resultSet.getString("password")).
                        typeOfWorking(resultSet.getString("type_of_working")).
                        accessToken(resultSet.getString("access_token"))
                        .build());

            }

            return serviceGuys;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public ServiceGuy findById(Long id) {

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_SERVICEGUY_BY_ID)) {

            statement.setLong(1, id);
            ResultSet set = statement.executeQuery();

            if (set.next()){

                return ServiceGuy.builder().
                        id(set.getLong("id")).
                        firstName(set.getString("first_name")).
                        lastName(set.getString("last_name")).
                        email(set.getString("email")).
                        password(set.getString("password")).
                        typeOfWorking(set.getString("type_of_working")).
                        accessToken(set.getString("access_token"))
                        .build();

            }else {

                throw new RuntimeException("Find by id in ServiceStaffImpl try hard");

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(ServiceGuy serviceGuy) {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_SERVICE_GUY)){

            statement.setString(1, serviceGuy.getFirstName());
            statement.setString(2, serviceGuy.getLastName());
            statement.setString(3, serviceGuy.getEmail());
            statement.setString(4, serviceGuy.getPassword());
            statement.setString(5, serviceGuy.getTypeOfWorking());
            statement.setString(6, serviceGuy.getAccessToken());

            statement.setLong(7, serviceGuy.getId());

            int changedRows = statement.executeUpdate();

            if (changedRows != 1){

                throw new RuntimeException("Critical Error when update service_staff");

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteById(ServiceGuy serviceGuy) {

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE_SERVICE_GUY)) {

            statement.setLong(1 ,serviceGuy.getId());

            int deletedRows = statement.executeUpdate();

            if (deletedRows != 1){

                throw new RuntimeException("Critical Error when delete guy from service_staff");

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
