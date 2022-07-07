package core;

import interfaces.ICoreInterface;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ObjectHelper extends CoreFields implements ICoreInterface {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() {
        // TODO Auto-generated method stub

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(getUrl(), getUserName(), getPassword());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
}


