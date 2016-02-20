
public class Punto {
	private int x;
	private int y;

	public Punto() {
		x = 3;
		y = 3;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		if (x >= 0  && x <= 350) {
			this.x = x;
		}

	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		if (y >= 0 && y <= 250) {
			this.y = y;
		}
	}

	public Punto(int z, int k) {
		setX(z);
		setY(k);

	}

	public Punto(Punto q) {
		setX(q.getX());
		setY(q.getY());
	}

	public String toString() {
		return "Punto x=" + x + ", y=" + y+" ";
	}

	public boolean equals(Punto q) {
		if (this.x == q.getX() && this.y == q.getY()) {
			return true;
		} else {
			return false;
		}

	}
	public Punto clone(){
		return new Punto(this);
	}

}