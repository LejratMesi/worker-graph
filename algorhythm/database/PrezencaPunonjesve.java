package algorhythm.database;

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
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/algorythmn", "root", "Erlind@23");
            stmt = conn.createStatement();

//Merr te dhenat e prezences

//            LocalDate firstDay = today.withDayOfMonth(1);
//            String query = "select p.id_punonjes, p.emerpunonjesi, p.mbiemerpunonjesi, a.dita, a.prezenca\n" +
//                    "from punonjes as p \n" +
//                    "inner join paraqitja as a\n" +
//                    "where p.id_punonjes = a.id_punonjes and localtime()` ;";
//            ResultSet rs = stmt.executeQuery(query);


//Printimi i rezultateve
//            while(rs.next()){
//                String algorythmnData = "";
//                for(int i=1; i<=5; i++){
//                    algorythmnData += rs.getString(i) + ":";
//                }
//                System.out.println(algorythmnData);
//            }


//Llogarit prezencen ne perqindje

            String query1 ="select count(a.prezenca) as ditepune, p.id_punonjes, p.emerpunonjesi, p.mbiemerpunonjesi\n" +
                    "from punonjes as p\n" +
                    "inner join paraqitja as a\n" +
                    "on a.id_punonjes = p.id_punonjes\n" +
                    "where  prezenca = 1 and dita between \"2023.05.01\" and localtime() \n" +
                    "group by p.id_punonjes;";
            ResultSet rs1 = stmt.executeQuery(query1);

            LocalDate dateFillimi = LocalDate.of(2023, 5, 1);
            LocalDate dateMbarimi = LocalDate.now();

            Period periudha = dateFillimi.until(dateMbarimi);

            int dite_total = periudha.getDays();
            final ResultSetMetaData meta = rs1.getMetaData();
            final int columnCount = meta.getColumnCount();
            final List<List<String>> rowList = new LinkedList<List<String>>();
            while (rs1.next())
            {
                final List<String> columnList = new LinkedList<String>();

                double prezenca  = (rs1.getDouble(1) /dite_total) * 100 ;


                System.out.println("Punonjesi " + rs1.getString(3) + " eshte paraqitur ne zyre "+ String.format("%.2f",prezenca) + "%");
            }

        }

        catch (SQLException e) {
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
