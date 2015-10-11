package druzy.mvc;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public interface View extends PropertyChangeListener{
	
	/** Renvoie le controleur lié à cette vue
	*@see druzy.mvc.AbstractController
	*@return Le controleur lié à cette vue
	*@since 1.7
	*/
	public Controller getController();
	
	public void onTop();

	public void propertyChange(PropertyChangeEvent pce);
	
	/** Affiche la vue
	*@since 1.7
	*/
	public void display();
	
	public boolean isDisplaying();
	
	/** Ferme la vue
	*@since 1.7
	*/
	public void close();
}
