package dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * connection manager 싱글톤을 만들어
 * db와의 연결객체 생성
 */
public class ConnectionManager {
    private static ConnectionManager ourInstance = new ConnectionManager();
    private SqlSessionFactory factory;

    public static ConnectionManager getInstance() {
        return ourInstance;
    }
    /*
    * sqlsession factory리턴
    * */
    public SqlSessionFactory getFactory(){
        if(factory==null){
            try {
                Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");
                SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
                factory = ssfb.build(reader);
            }catch (IOException e){
                System.out.println("으흥?");
            }
        }
        return factory;
    }
}
