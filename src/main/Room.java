
public class Room {

	
	private int x;
	private int y;
	
	private boolean hasMonsters = false;
	private boolean isDark = false;
	
	public Room(int x, int y) {
		this.x = x;
		this.y = y;
		
	}
	
	public boolean hasMonsters() {
		return hasMonsters;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public void killMonsters() {
		hasMonsters = false;
	}
	public void spawnMonsters() {
		hasMonsters = true;
	}
	public void setDark() {
		isDark = true;
	}
}
