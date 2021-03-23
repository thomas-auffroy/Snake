import java.util.ArrayList;
import java.util.Collections;

public class Snake {

	private ArrayList<ArrayList<Integer>> body = new ArrayList<ArrayList<Integer>>();
	private ArrayList<Integer> head = new ArrayList<Integer>();
	private int size, width;
	private boolean move = false;
	
	public Snake(int s, int w, int x, int y) {
		ArrayList<Integer> posInit = new ArrayList<Integer>();
		posInit.add(x);
		posInit.add(y);
				
		for (int i = 0; i<(s-1); i++) {this.body.add(posInit);}
		
		this.head.add(x);
		this.head.add(y);
		
		this.size = s;
		this.width = w;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public ArrayList<ArrayList<Integer>> getBody(){
		return this.body;
	}
	
	public boolean getMove() {
		return this.move;
	}
	
	public ArrayList<Integer> getHead(){
		return this.head;
	}
	
	public void setMove(boolean b) {
		this.move = b;
	}
	
	public void moveBody() {
		ArrayList<Integer> pos = new ArrayList<Integer>();
		pos.add(this.head.get(0));
		pos.add(this.head.get(1));
		
		removeTail();
		this.body.add(pos);
	}
	
	public void addHeadPosition(int x, int y) {
		ArrayList<Integer> pos = new ArrayList<Integer>();
		
		pos.add(x+this.head.get(0));
		pos.add(y+this.head.get(1));
		
		this.head.clear();
		this.head.addAll(pos);
	}
		
	public void removeTail() {
		this.body.remove(0);
	}
	
	public void move(int x, int y) {
		moveBody();
		addHeadPosition(x,y);
	}
	
	public void grow() {
		for (int i = 0; i<10; i++) {
			ArrayList<Integer> pos = new ArrayList<Integer>();
			pos.add(this.body.get(0).get(0));
			pos.add(this.body.get(0).get(1));
		
			this.body.add(0, pos);
			this.size += 1;		
		}
	}
}
