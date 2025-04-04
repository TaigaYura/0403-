package rensyu9_1;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
//		一円以上のアイテムを表示するとを通知
		System.out.println("一円以上のアイテムを一覧表示します");
		
//		価格が１以上のアイテムを取得
		ArrayList<Item> items = ItemsDAO.findByMinimumPrice(1);
		
//		各アイテムの名前、価格、重量を表示
		for (Item item : items) {
//			整形された形式を出力
			System.out.printf("%10s%4d%4d\n", item.getName(), item.getPrice(), item.getWeight());
		}
	}
}