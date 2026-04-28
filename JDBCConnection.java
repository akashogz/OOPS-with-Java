import java.sql.*;



public void JDBCConnection {
    private static final String url = "";
    private static final String userName = "";
    private static final String password = "";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(url, userName, password);

        Statement stmt = con.createStatement();

        String query = "Select * from students";
        stmt.executeQuery(query);


    }
}