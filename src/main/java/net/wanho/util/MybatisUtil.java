package net.wanho.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Created by Administrator on 2019/6/5.
 */
public class MybatisUtil {
    private static ThreadLocal<SqlSession> threadLocal;
    private static SqlSessionFactory sf;

    static {
        threadLocal = new ThreadLocal<SqlSession>();
        InputStream inputStream = MybatisUtil.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        sf = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public static SqlSession getSqlSession() {
        SqlSession sqlSession = threadLocal.get();
        if (sqlSession == null) {
            sqlSession = sf.openSession();
            threadLocal.set(sqlSession);
        }
        return sqlSession;
    }
    public static void closeSqlSession(){
        SqlSession sqlSession = threadLocal.get();
        if(sqlSession!=null){
            sqlSession.close();
            threadLocal.remove();
        }
    }
}
