/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto2;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author Sandra
 */    
public class DataSourceJDBC {
    
    private DriverManagerDataSource dataSource = new DriverManagerDataSource();
    private final String url = "jdbc:mysql://127.0.0.1:3306/product3?useUnicode=true&characterEncoding=utf8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final String dbUsername = "root";
    private final String dbPassword = "arkarianKirtash4";
 

    public DataSourceJDBC() {
    dataSource.setUrl(url);
    dataSource.setUsername(dbUsername);
    dataSource.setPassword(dbPassword);
    }
    
    public DriverManagerDataSource getDataSource() {
    return dataSource;
    }
}
    

