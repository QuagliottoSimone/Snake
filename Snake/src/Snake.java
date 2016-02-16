import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
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
	private int randX;
	private int randY;
	private Text text;
	
	/**
	 * Launch the application.
	 * @param args
	 */
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
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(548, 320);
		shell.setText("SWT Application");
		
		testa.setX(MASX/2);
		testa.setY(MASY/2);
		
		
		
		Canvas canvas = new Canvas(shell, SWT.NONE);
		canvas.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));
		canvas.setBounds(10, 10, MASX, MASY);
		GC gc = new GC(canvas);
		
		Button btnProva = new Button(shell, SWT.NONE);
		btnProva.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				randX = ((int)Math.random()*MASX);
				randY = ((int)Math.random()*MASY);
				
				mela.setX(randX);
				mela.setY(randY);
				gc.drawRectangle(testa.getX(), testa.getY(), 5, 5);
				gc.drawOval(mela.getX(), mela.getY(), 5, 5);
				
			}
		});
		btnProva.setBounds(366, 10, 152, 42);
		btnProva.setText("Inizia");
		
		Button btnV = new Button(shell, SWT.NONE);
		btnV.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				gc.drawRectangle(testa.getX(), testa.getY()+5, 5, 5);
				testa.setY(testa.getY()+5);
			}
		});
		btnV.setBounds(419, 103, 46, 39);
		btnV.setText("v");
		
		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			
			public void widgetSelected(SelectionEvent e) {
				
				gc.drawRectangle(testa.getX(), testa.getY()-5, 5, 5);
				testa.setY(testa.getY()-5);
				
			}
			
		});
		button.setText("^");
		button.setBounds(419, 58, 44, 39);
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				gc.drawRectangle(testa.getX()-5, testa.getY(), 5, 5);
				testa.setX(testa.getX()-5);
			}
		});
		button_1.setText("<");
		button_1.setBounds(367, 103, 46, 39);
		
		Button button_2 = new Button(shell, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				gc.drawRectangle(testa.getX()+5, testa.getY(), 5, 5);
				testa.setX(testa.getX()+5);
			}
		});
		button_2.setText(">");
		button_2.setBounds(471, 103, 47, 39);
		
		Label lblPunti = new Label(shell, SWT.NONE);
		lblPunti.setBounds(382, 245, 38, 15);
		lblPunti.setText("Punti:");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(438, 239, 45, 21);
		
		

	}
}
