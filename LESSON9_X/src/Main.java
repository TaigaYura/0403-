import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
//		経験値が10以上の敵を表示することを通知
		System.out.println("経験値が１０以上の敵を一覧表示します");
		
//		価格が１以上のアイテムを取得
		ArrayList<Rpg> rpgs = RpgDAO.findByMinimumExp(10);
		
//		各アイテムの名前、価格、重量を表示
		for (Rpg rpg : rpgs) {
//			整形された形式を出力
			System.out.printf("%10s%4d%4d\n", rpg.getName(), rpg.getHp(), rpg.getMp(), rpg.getExp());
		}
	}
}
