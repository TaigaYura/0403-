
public class Rpg {
//	フィールドを外部からアクセスできないようにprivateで守っている
	private String name;
	private int hp;
	private int mp;
	private int exp;
	
//	publicによって外部からアクセスできるようにしている
	public String getName() {
		return this.name;
	}
	public int getHp() {
		return this.hp;
	}
	public int getMp() {
		return this.mp;
	}
	public int getExp() {
		return this.exp;
	}
	
//	voidは戻り値がないことを表している
	public void setName(String name) {
		this.name = name;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public void setMp(int mp) {
		this.mp = mp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
}
