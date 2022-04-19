package kh.semi.lms.common.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcDbcp {
private static Connection conn = null;
   
   public static Connection getConnection() {
      try {
         Context initContext = new InitialContext();
         Context envContext = (Context)initContext.lookup("java:/comp/env");
         DataSource ds = (DataSource)envContext.lookup("jdbc/formsaeng1Pclass");
         conn = ds.getConnection();
      } catch(SQLException e) {
         System.out.println("db 접속 실패");
         e.printStackTrace();
      } catch (Exception e) {
         System.out.println("오류???");
         e.printStackTrace();
      }
      if(conn== null) {
         System.out.println("CONN이 널");
      } else {
         System.out.println("============DB 접속 성공==========");
      }
      return conn;
   }


   public static void close(Connection conn) {
      try {
         if(conn != null && !conn.isClosed()) conn.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
   public static void close(Statement stmt) {
      try {
         if(stmt != null && !stmt.isClosed()) stmt.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
   public static void close(ResultSet rs) {
      try {
         // TODO: 예시 자주발생가능성있음
         if(rs!=null && !rs.isClosed()) rs.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
   public static void setAutoCommit(Connection conn, boolean onoff) {
      try {
         if(conn!=null && !conn.isClosed())conn.setAutoCommit(onoff);
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
   public static void commit(Connection conn) {
      try {
         if(conn!=null && !conn.isClosed())conn.commit();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
   public static void rollback(Connection conn) {
      try {
         if(conn!=null && !conn.isClosed()) conn.rollback();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
}
