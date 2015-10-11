package druzy.mvc;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.event.EventListenerList;

/**
* Classe abstraite modèle (modèle MVC)
*@version 1.0
*@since 1.7
*@see druzy.mvc.AbstractController
*@see druzy.mvc.AbstractView
*/

public abstract class AbstractModel implements Model{
	private EventListenerList listeners=null;
	
	/** Constructeur par défault du modèle
	*@since 1.7
	*/
	public AbstractModel(){
		listeners=new EventListenerList();
	}
	
	/** Ajoute un PropertyChangeListener au modèle
	*@see java.beans.PropertyChangeListener
	*@param listener Le PropertyChangeListener à ajouter
	*@since 1.7
	*/
	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener){
		listeners.add(PropertyChangeListener.class,listener);
	}
	
	/** Supprime un PropertyChangeListener au modèle 
	*@see java.beans.PropertyChangeListener
	*@param listener Le PropertyChangeListener à supprimer
	*@since 1.7
	*/
	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener){
		listeners.remove(PropertyChangeListener.class,listener);	
	}
	
	/** Déclenche un évènement de type PropertyChangeEvent
	*@see java.beans.PropertyChangeEvent
	*@param pce L'évènement qui est déclenché
	*@since 1.7
	*/
	@Override
	public void firePropertyChange(PropertyChangeEvent pce){
		PropertyChangeListener[] listenerList = listeners.getListeners(PropertyChangeListener.class);
		
		for(PropertyChangeListener listener : listenerList){
			listener.propertyChange(pce);
		}
	}
	

	@Override
	public void fireAnotherChange(AnotherChangeEvent event){
		AnotherChangeListener[] listenerList=listeners.getListeners(AnotherChangeListener.class);
		
		for (AnotherChangeListener listener : listenerList){
			listener.anotherChange(event);
		}
	}
}
