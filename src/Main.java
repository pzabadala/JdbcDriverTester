import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.*;
import java.util.Arrays;
import java.util.Properties;
import java.util.logging.Logger;
import java.util.stream.Stream;


public class Main {
    public static void main(String [] args) throws URISyntaxException {
        //try {
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Class.forName("com.mysql.cj.jdbc.Driver");
            //Class.forName("com.amazon.jdbc.jdbc42.JDBC42AbstractDataSource");
            //Class.forName("org.postgresql.Driver");
        //}catch(ClassNotFoundException ex){
         //   ex.printStackTrace();
        //}
        //String s = "jdbc:mysql://localhost:1111/db?user=user&password=password";
        String s = "jdbc:sqlserver://DE-12SQL-FRA22\\ST;;databaseName=devstepstoneat;sendStringParametersAsUnicode=false;applicationIntent=ReadOnly;packetSize=32767";
        //String s = "jdbc:redshift:iam://redshifttest.cx6y4cp6447a.us-east-1.redshift.amazonaws.com:5439/sample_database?AccessKeyID=ABC&SecretAccessKey=DFG&DbUser=admin&ssl=true";
        //String s = "jdbc:postgresql://localhost/test?user=fred";

        try {
            Properties pr = new Properties();
            //pr.setProperty("EndpointUrl", "examplecluster.abc123xyz789.us-west-2.redshift.amazonaws.com");
            //.setProperty("AccessKeyID", "");
            Driver driver = DriverManager.getDriver(s);
            DriverPropertyInfo []props = driver.getPropertyInfo(s, pr);
            //filter(p -> p.required == false)
            Arrays.stream(props).forEach(p -> {
                System.out.println(p.description);
                System.out.println(p.name);
                System.out.println(p.value);
                System.out.println("--//--");
            });

        }catch (SQLException ex){
            ex.printStackTrace();
        }

    }


}
