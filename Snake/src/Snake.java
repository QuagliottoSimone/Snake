import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.util.Random;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class Snake {

	protected Shell shell;
	private Punto testa = new Punto ();
	private Punto mela = new Punto ();
	private final int MASX = 350;
	private final int MASY = 250;
	private Text text;
	private Canvas canvas;
	private Random randomGenerator = new Random();
	GC gc;
	private boolean flag = true;
	/**
	 * Launch the application.
	 * @param args
	 */
	public void generaMela(int x, int y){
		
		mela.setX(randomGenerator.nextInt(x));
		mela.setY(randomGenerator.nextInt(y));
		
	}
	public static void main(String[] args) {
		try {
			Snake window = new Snake();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				gc = new GC(canvas);
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(548, 380);
		shell.setText("SWT Application");
		
		testa.setX(MASX/2);
		testa.setY(MASY/2);
		
		generaMela(MASX, MASY);
		
		
		canvas = new Canvas(shell, SWT.NONE);
		canvas.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		canvas.setBounds(10, 58, MASX, MASY);
		
		
		Button btnProva = new Button(shell, SWT.NONE);
		btnProva.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gc.drawRectangle(testa.getX(), testa.getY(), 5, 5);
				gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
				gc.drawOval(mela.getX(), mela.getY(), 5, 5);
				gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
			}
		});
		btnProva.setBounds(366, 58, 152, 42);
		btnProva.setText("Inizia");
		
		Button btnV = new Button(shell, SWT.NONE);
		btnV.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
					gc.fillRectangle(0,0,MASX,MASY);
					gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
					gc.drawOval(mela.getX(), mela.getY(), 5, 5);
					gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
					gc.drawRectangle(testa.getX(), testa.getY()+5, 5, 5);
					testa.setY(testa.getY()+5);
			}
		});
		btnV.setBounds(417, 148, 46, 39);
		btnV.setText("v");
		
		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			
			public void widgetSelected(SelectionEvent e) {
				gc.fillRectangle(0,0,MASX,MASY);
				gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
				gc.drawOval(mela.getX(), mela.getY(), 5, 5);
				gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
				gc.drawRectangle(testa.getX(), testa.getY()-5, 5, 5);
				testa.setY(testa.getY()-5);
				
			}
			
		});
		button.setText("^");
		button.setBounds(419, 106, 44, 39);
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				gc.fillRectangle(0,0,MASX,MASY);
				gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
				gc.drawOval(mela.getX(), mela.getY(), 5, 5);
				gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
				gc.drawRectangle(testa.getX()-5, testa.getY(), 5, 5);
				testa.setX(testa.getX()-5);
			}
		});
		button_1.setText("<");
		button_1.setBounds(366, 148, 46, 39);
		
		Button button_2 = new Button(shell, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				gc.fillRectangle(0,0,MASX,MASY);
				gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
				gc.drawOval(mela.getX(), mela.getY(), 5, 5);
				gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
				gc.drawRectangle(testa.getX()+5, testa.getY(), 5, 5);
				testa.setX(testa.getX()+5);
			}
		});
		button_2.setText(">");
		button_2.setBounds(471, 148, 47, 39);
		
		Label lblPunti = new Label(shell, SWT.NONE);
		lblPunti.setFont(SWTResourceManager.getFont("Segoe Script", 12, SWT.NORMAL));
		lblPunti.setBounds(366, 269, 77, 39);
		lblPunti.setText("Punti:");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(433, 271, 85, 21);
		
		Label lblSnake = new Label(shell, SWT.NONE);
		lblSnake.setAlignment(SWT.CENTER);
		lblSnake.setFont(SWTResourceManager.getFont("Showcard Gothic", 20, SWT.ITALIC));
		lblSnake.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblSnake.setBounds(200, 10, 114, 42);
		lblSnake.setText("SNAKE");
		
		

	}
}
