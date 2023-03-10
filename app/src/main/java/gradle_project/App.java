/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package gradle_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }
    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
        try {
            //here de-jdbc is database name, root is username and password is null. Fix them for your database settings.
            // 1. conn 생성
            Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/de_jdbc", "root","0000");
            // 2. statement 생성
            Statement stmt = con.createStatement();
            // 3. statement type 변수 stmt에 쿼리문을 대입
            ResultSet rs = stmt.executeQuery("select * from product");
            // 4. 반복문을 돌며 1번 컬럼부터 5번 컬럼까지의 모든 내용을 출력한다.
            while (rs.next()){
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " "
            + rs.getDate(3) + " " + rs.getString(4)
            + " " + rs.getInt(5));
            }
            // 5. 연결을 종료한다.
            con.close();
        }   catch (Exception e) {System.out.println(e);}
    }
}
