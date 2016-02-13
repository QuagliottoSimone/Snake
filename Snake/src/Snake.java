import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Canvas;

public class Snake {

	protected Shell shell;
	private Punto testa = new Punto ()

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
		shell.setSize(509, 311);
		shell.setText("SWT Application");
		
		Canvas canvas = new Canvas(shell, SWT.NONE);
		canvas.setBounds(10, 10, 350, 250);
		GC gc = new GC(canvas);
		
		Button btnProva = new Button(shell, SWT.NONE);
		btnProva.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Okay");
			}
		});
		btnProva.setBounds(382, 10, 102, 25);
		btnProva.setText("Inizia");
		
		Button btnV = new Button(shell, SWT.NONE);
		btnV.setBounds(418, 72, 30, 25);
		btnV.setText("v");
		
		Button button = new Button(shell, SWT.NONE);
		button.setText("^");
		button.setBounds(419, 41, 30, 25);
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.setText("<");
		button_1.setBounds(382, 72, 30, 25);
		
		Button button_2 = new Button(shell, SWT.NONE);
		button_2.setText(">");
		button_2.setBounds(454, 72, 30, 25);
		
		

	}
}
