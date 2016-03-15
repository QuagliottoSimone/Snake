import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.io.BufferedWriter;
import java.io.FileWriter;
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
	private final int MASX = 300;
	private final int MASY = 300;
	private Canvas canvas;
	private Random randomGenerator = new Random();
	GC gc;
	int ix = 300;
	int iy = 300;
	int gX = MASX/30;
	int gY = MASY/30;
	Label labelPunt;
	
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
		shell.setSize(548, 434);
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
				gX = gX * randomGenerator.nextInt(30);
				gY = gY * randomGenerator.nextInt(30);
				gc.drawRectangle(testa.getX(), testa.getY(), 10, 10);
				gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
				gc.drawOval(gX, gY, 10, 10);
				gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
				mela.setX(gX);
				mela.setY(gY);
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
					gc.drawOval(gX, gY, 10, 10);
					gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
					gc.drawRectangle(testa.getX(), testa.getY()+10, 10, 10);
					testa.setY(testa.getY()+10);
					if(mela.equals(testa)== true){
						
						labelPunt.setText("" +  (Integer.parseInt(labelPunt.getText())+10));
			
				}
						
					}
					
			}
			
		);
		btnV.setBounds(417, 148, 46, 39);
		btnV.setText("v");
		
		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			
			public void widgetSelected(SelectionEvent e) {
				gc.fillRectangle(0,0,MASX,MASY);
				gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
				gc.drawOval(gX, gY, 10, 10);
				gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
				gc.drawRectangle(testa.getX(), testa.getY()-10, 10, 10);
				testa.setY(testa.getY()-10);
				if(mela.equals(testa)== true){
					
					labelPunt.setText("" +  (Integer.parseInt(labelPunt.getText())+10));
				
			}
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
				gc.drawOval(gX, gY, 10, 10);
				gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
				gc.drawRectangle(testa.getX()-10, testa.getY(), 10, 10);
				testa.setX(testa.getX()-10);
				if(mela.equals(testa)== true){
					
					labelPunt.setText("" +  (Integer.parseInt(labelPunt.getText())+10));
				
			}
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
				gc.drawOval(gX, gY, 10, 10);
				gc.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
				gc.drawRectangle(testa.getX()+5, testa.getY(), 10, 10);
				testa.setX(testa.getX()+10);
				if(mela.equals(testa)== true){
					
					labelPunt.setText("" +  (Integer.parseInt(labelPunt.getText())+10));
				
			}
			}
		});
		button_2.setText(">");
		button_2.setBounds(471, 148, 47, 39);
		
		Label lblSnake = new Label(shell, SWT.NONE);
		lblSnake.setAlignment(SWT.CENTER);
		lblSnake.setFont(SWTResourceManager.getFont("Showcard Gothic", 20, SWT.ITALIC));
		lblSnake.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblSnake.setBounds(200, 10, 114, 42);
		lblSnake.setText("SNAKE");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				BufferedWriter scrittore;
				try{
					scrittore = new BufferedWriter(new FileWriter("punti.txt"));
					scrittore.write(labelPunt.getText());
					scrittore.write("X: " + mela.getX() + "Y: " + mela.getY());
					scrittore.newLine();
					scrittore.close();
				}catch(Exception e1){
					System.out.println("Errore");
				}
			}
		});
		btnNewButton.setBounds(366, 193, 152, 25);
		btnNewButton.setText("Salva");
		
		Label lblPunti_1 = new Label(shell, SWT.NONE);
		lblPunti_1.setFont(SWTResourceManager.getFont("Segoe Script", 12, SWT.NORMAL));
		lblPunti_1.setBounds(330, 297, 82, 25);
		lblPunti_1.setText("Punti:");
		
		labelPunt = new Label(shell, SWT.NONE);
		labelPunt.setBounds(417, 302, 75, 25);
		labelPunt.setText("0");
		
		

	}
}
