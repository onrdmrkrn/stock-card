package interfaces;

import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
//Front-end
public interface IUiInterface {
	
	
	public void initWindow();
	public JMenuBar initBar();
	public JPanel initPanel();
	public JTabbedPane initTabs();
}
