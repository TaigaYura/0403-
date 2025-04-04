package rensyu9_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemsDAO {
	public static ArrayList<Item> findByMinimumPrice(int i) {
//		H2ドライバの読み込み
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = null;
		
//		データベース接続
		try {
			con = DriverManager.getConnection("jdbc:h2:~/desktop/DB/ITEMS", "sa", "1234");
//			SQL文の準備
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM ITEMS WHERE PRICE >= ?");
//			パラメータをセット
			pstmt.setInt(1, i);
//			クエリ実行
			ResultSet rs = pstmt.executeQuery();
			
//			結果を格納するリスト
			ArrayList<Item> items = new ArrayList<>();
//			結果セットを処理
			while (rs.next()) {
				Item item = new Item();
				item.setName(rs.getString("NAME"));
				item.setPrice(rs.getInt("PRICE"));
				item.setWeight(rs.getInt("WEIGHT"));
				items.add(item);
			}
			rs.close();
			pstmt.close();
			return items;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
//			接続のクローズ
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
