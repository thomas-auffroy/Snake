import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Line2D;
import javax.swing.JPanel;

public class Panel  extends JPanel implements KeyListener {

	private Plateau board;
	private boolean leftArrow, rightArrow, upArrow, downArrow;
	private boolean end = false;
	
	public Panel() {
		addKeyListener(this);
		
		leftArrow =false;
		rightArrow = false;
		upArrow = false;
		downArrow = false;
		
		board = new Plateau(500,500);
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		requestFocus();
		g2.translate(100, 100);
		g2.clearRect(0, 0, this.board.getWidth(), this.board.getHeigth());
		g2.drawRect(0, 0, this.board.getWidth(), this.board.getHeigth());
		g2.setStroke(new BasicStroke(this.board.snake.getWidth()));
		
		try {
			for (int i = 0; i < this.board.getPixelsToDisplay().size(); i++) {
				if (i == this.board.getPixelsToDisplay().size()-1) {
					g2.setColor(Color.red);
					g2.draw(new Line2D.Float(this.board.getPixelsToDisplay().get(i).get(0),this.board.getPixelsToDisplay().get(i).get(1),this.board.getPixelsToDisplay().get(i).get(0),this.board.getPixelsToDisplay().get(i).get(1)));
					g2.setColor(Color.black);
				}
				else{
					g2.draw(new Line2D.Float(this.board.getPixelsToDisplay().get(i).get(0),this.board.getPixelsToDisplay().get(i).get(1),this.board.getPixelsToDisplay().get(i).get(0),this.board.getPixelsToDisplay().get(i).get(1)));
				}
			}
		}
		catch(Exception IndexOutOfBound) {}

		moveSnake();
		this.end = this.board.isCollision();
	}
	
	public boolean isEnd() {
		return this.end;
	}
	
	public void moveSnake() {
		if(leftArrow) {this.board.snake.move(-1, 0);}
		else if(rightArrow) {this.board.snake.move(1, 0);}
		else if(upArrow) {this.board.snake.move(0, -1);}
		else if(downArrow) {this.board.snake.move(0, 1);}		
	}
	
	@Override
	public void keyPressed(KeyEvent event) {
		// TODO Auto-generated method stub
		if (event.getKeyCode() == KeyEvent.VK_LEFT) {
			leftArrow = true;
			rightArrow = false;
			upArrow = false;
			downArrow = false;
			this.board.snake.setMove(true);
		}
		else if (event.getKeyCode() == KeyEvent.VK_UP) {
			leftArrow = false;
			rightArrow = false;
			upArrow = true;
			downArrow = false;
			this.board.snake.setMove(true);
		} 
		else if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
			leftArrow = false;
			rightArrow = true;
			upArrow = false;
			downArrow = false;
			this.board.snake.setMove(true);
		} 
		else if (event.getKeyCode() == KeyEvent.VK_DOWN) {
			leftArrow = false;
			rightArrow = false;
			upArrow = false;
			downArrow = true;
			this.board.snake.setMove(true);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
