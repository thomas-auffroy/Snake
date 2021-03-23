import java.util.ArrayList;

public class Apple {
	private ArrayList<Integer> positionApple = new ArrayList<Integer>();	
	private int width;
	
	public Apple(int w, int boundX, int boundY) {
		this.width = w;
		newApple(boundX,boundY);
	}
	
	public ArrayList<Integer> getPositionApple(){
		return this.positionApple;
	}
	
	public void newApple(int bX, int bY) {
		int x = (int) (Math.random()*bX - this.width/2);
		int y = (int) (Math.random()*bY - this.width/2);
		
		this.positionApple.clear();
		this.positionApple.add(x);
		this.positionApple.add(y);
	}
}
