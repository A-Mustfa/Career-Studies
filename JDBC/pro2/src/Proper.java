import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Proper {


    public static SQLServerDataSource dataSource(){
        Properties pro = new Properties();
        FileInputStream fis = null;
        SQLServerDataSource ssD = new SQLServerDataSource();
        try {
            fis = new FileInputStream("prop.properties");
            pro.load(fis);
            ssD.setURL(pro.getProperty("DB_URL"));
            ssD.setUser(pro.getProperty("USER"));
            ssD.setPassword(pro.getProperty("PASS"));
        }catch(Exception e){
            System.out.println(e);
        }
        return ssD;

    }
}
