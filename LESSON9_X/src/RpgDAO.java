import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RpgDAO {
	public static ArrayList<Rpg> findByMinimumExp(int i) {
//		H2ドライバの読み込み
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = null;
		
//		データベース接続
		try {
			con = DriverManager.getConnection("jdbc:h2:~/desktop/DB/RPG", "sa", "1234");
//			SQL文の準備
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM RPG WHERE EXP >= ?;");
//			パラメータをセット
			pstmt.setInt(1, i);
//			クエリ実行
			ResultSet rs = pstmt.executeQuery();
			
//			結果を格納するリスト
			ArrayList<Rpg> rpgs = new ArrayList<>();
//			結果セットを処理
			while (rs.next()) {
				Rpg rpg = new Rpg();
				rpg.setName(rs.getString("NAME"));
				rpg.setHp(rs.getInt("HP"));
				rpg.setMp(rs.getInt("MP"));
				rpg.setExp(rs.getInt("EXP"));
				rpgs.add(rpg);
			}
			rs.close();
			pstmt.close();
			return rpgs;
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
