package org.terenin.jdbc;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Logger;

public class MyDataSource implements DataSource {

    public Connection connection;

    private final String url;
    private final String username;
    private final String password;

    public MyDataSource(String url, String username, String password){

        this.url = url;
        this.username = username;
        this.password = password;
        openConnection();

    }


    private void openConnection(){

        try {
            this.connection = DriverManager.getConnection(this.url, this.username, this.password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public Connection getConnection() throws SQLException {

        if (this.connection.isClosed() || this.connection == null){

            openConnection();

        }

        return connection;

    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public ConnectionBuilder createConnectionBuilder() throws SQLException {
        return DataSource.super.createConnectionBuilder();
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    @Override
    public ShardingKeyBuilder createShardingKeyBuilder() throws SQLException {
        return DataSource.super.createShardingKeyBuilder();
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }
}
