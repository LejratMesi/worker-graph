package algorhythm.service;

import java.sql.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.LinkedList;
import java.util.List;
public class PrezencaPunonjesve {
    public static void llogaritja() {
        String url = "jdbc:mysql://localhost:3306/algorythmn";
        String username = "root";
        String password = "Erlind@23";
        Connection conn = null ;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();

            String queryForGettingPrezence ="select count(a.prezenca) as ditepune, p.id_punonjes, p.emerpunonjesi, p.mbiemerpunonjesi\n" +
                    "from punonjes as p\n" +
                    "inner join paraqitja as a\n" +
                    "on a.id_punonjes = p.id_punonjes\n" +
                    "where  prezenca = 1 and dita between \"2023.05.01\" and localtime() \n" +
                    "group by p.id_punonjes;";
            ResultSet resultSet = stmt.executeQuery(queryForGettingPrezence);

            LocalDate currentDate = LocalDate.now();
            LocalDate dateFillimi = LocalDate.of(2023, currentDate.getMonthValue() , 1);
            LocalDate dateMbarimi = LocalDate.now();

            Period periudha = dateFillimi.until(dateMbarimi);

            int dite_total = periudha.getDays();

            while (resultSet.next()) {
                double prezenca  = (resultSet.getDouble(1) /dite_total) * 100 ;
                System.out.println("Punonjesi " + resultSet.getString(3) + " eshte paraqitur ne zyre "+ String.format("%.2f",prezenca) + "%");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
