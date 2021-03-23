import javax.swing.JFrame;

public class Window extends JFrame {

	private Panel pan = new Panel();
	
	public Window() {
		// TODO Auto-generated constructor stub
		this.setTitle("Snake");
		this.setSize(720,750);
		this.setResizable(false);
		this.setContentPane(pan);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);	
		
		move();
	}

	public void move() {
		while(!pan.isEnd()) {
			pan.repaint();
			try {Thread.sleep(5);} catch (InterruptedException e) {e.printStackTrace();}
		}
		this.dispose();
		System.out.println("GAME OVER");
	}	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Window();
	}

}
