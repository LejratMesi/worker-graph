package Algorythmn.database;


import java.sql.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class PrezencaPunonjesve {
    public static void Llogaritja() {
        String url = "jdbc:mysql://localhost:3306/algorythmn";
        String username = "root";
        String password = "Erlind@23";
        Connection conn = null ;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/algorythmn", "root", "Erlind@23");
            stmt = conn.createStatement();

//Merr te dhenat e prezences
// Kjo pjese kodi sherben per te paraqitur te dhenat e prezences se punonjesve ne nje dite te caktuar

            LocalDate today = LocalDate.now();
//            LocalDate firstDay = today.withDayOfMonth(1);
//            String query = "select p.id_punonjes, p.emerpunonjesi, p.mbiemerpunonjesi, a.dita, a.prezenca\n" +
//                    "from punonjes as p \n" +
//                    "inner join paraqitja as a\n" +
//                    "where p.id_punonjes = a.id_punonjes and a.dita=\"2023.05.16\" ;";
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
            LocalDate today1 = LocalDate.now();
            LocalDate firstDay1 = today.withDayOfMonth(1);
            String query1 ="select count(a.prezenca) as ditepune, p.id_punonjes, p.emerpunonjesi, p.mbiemerpunonjesi\n" +
                    "from punonjes as p\n" +
                    "inner join paraqitja as a\n" +
                    "on a.id_punonjes = p.id_punonjes\n" +
                    "where  prezenca = 1 and dita between \"2023.05.01\" and \"2023.05.18\" \n" +
                    "group by p.id_punonjes;";
            ResultSet rs1 = stmt.executeQuery(query1);


            int dite_total = 18;
            final ResultSetMetaData meta = rs1.getMetaData();
            final int columnCount = meta.getColumnCount();
            final List<List<String>> rowList = new LinkedList<List<String>>();
            while (rs1.next())
            {
                final List<String> columnList = new LinkedList<String>();

                double prezenca  = (rs1.getDouble(1) /dite_total) * 100 ;

                System.out.println("Punonjesi " + rs1.getString(3) + " eshte paraqitur ne zyre " +  String.format("%.2f",prezenca) + "%");
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
