
public class Cerchio {
	private Punto c;
	private int r;
	public static int xmin=1;
	public static int xmax=350;
	public static int ymin=1;
	public static int ymax=250;
	
	public Cerchio(){
		c.setX(xmin);
		c.setY(ymin);
		r = 1;
	}
	public Cerchio(Punto c2, int r2){
		c.setX(c2.getX());
		c.setY(c2.getY());
		setR(r2);
	}
	public Punto getC() {
		return c;
	}
	public void setC(Punto c1) {
		if (c.getX() >= xmin && c.getX() <= xmax){
			c.setX(c1.getX());
		}
		else{
			this.c.setX(c1.getX());
		}
		if (c.getY() >= ymin && c.getY() <= ymax){
			c.setY(c1.getY());
		}else{
			this.c.setY(c1.getY());
		}
		
	}
	public int getR() {
		return r;
	}
	public void setR(int r1) {
		if (r1 >= xmin && r1 <= xmax){
			r = r1;
		}
		else{
			this.r = r1;
		}
	}
	
	
}
