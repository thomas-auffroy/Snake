import java.util.ArrayList;

public class Plateau {
	
	protected Snake snake;
	protected Apple apple;
	
	private ArrayList<ArrayList<Integer>> pixels = new ArrayList<ArrayList<Integer>>();
	
	private int width, heigth;
	private int numberPixels;
	
	public Plateau(int w, int l) {
		this.width = w;
		this.heigth = l;
		
		snake = new Snake(100,7,this.width/2,this.heigth/2);
		apple = new Apple(7,this.width,this.heigth);
		
		this.numberPixels = this.width * this.heigth;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeigth() {
		return this.heigth;
	}
	
	public int getNumberPixels() {
		return this.numberPixels;
	}
	
	
	public ArrayList<ArrayList<Integer>> getPixelsToDisplay() {
		pixels.clear();		
		pixels.addAll(this.snake.getBody());
		pixels.add(this.snake.getHead());
		pixels.add(this.apple.getPositionApple());	
		
		return this.pixels;
	}
	
	public boolean isCollision() {
		for (int i = 0; i < (this.snake.getSize()-1); i++) {
			if(this.snake.getMove()) {
				if (this.snake.getBody().get(i).equals(this.snake.getHead()) || this.snake.getHead().get(0) >= this.width || this.snake.getHead().get(0) <= 0 || this.snake.getHead().get(1) >= this.heigth|| this.snake.getHead().get(1) <= 0) {
					return true;
				} 
				else if(this.apple.getPositionApple().get(0) >= this.snake.getHead().get(0)-(this.snake.getWidth()-1) 
						&& this.apple.getPositionApple().get(0) <= this.snake.getHead().get(0)+this.snake.getWidth()-1 
						&& (this.apple.getPositionApple().get(1) >= this.snake.getHead().get(1)-(this.snake.getWidth()-1) 
						&& this.apple.getPositionApple().get(1) <= this.snake.getHead().get(1)+this.snake.getWidth()-1)) {
					this.snake.grow();
					this.apple.newApple(this.width, this.heigth);
					break;
				}
			}
		}
		return false;
	}
}
