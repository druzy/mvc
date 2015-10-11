package druzy.mvc;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public interface Model {
	
	/** Ajoute un PropertyChangeListener au modèle
	*@see java.beans.PropertyChangeListener
	*@param listener Le PropertyChangeListener à ajouter
	*@since 1.7
	*/
	public void addPropertyChangeListener(PropertyChangeListener listener);
	
	/** Supprime un PropertyChangeListener au modèle 
	*@see java.beans.PropertyChangeListener
	*@param listener Le PropertyChangeListener à supprimer
	*@since 1.7
	*/
	public void removePropertyChangeListener(PropertyChangeListener listener);
	
	/** Déclenche un évènement de type PropertyChangeEvent
	*@see java.beans.PropertyChangeEvent
	*@param pce L'évènement qui est déclenché
	*@since 1.7
	*/
	public void firePropertyChange(PropertyChangeEvent pce);
	
	public void fireAnotherChange(AnotherChangeEvent event);
	
	
}
