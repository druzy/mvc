package druzy.mvc;

/**
* Classe abstraite vue (modèle MVC)
*@version 1.0
*@since 1.7
*@see druzy.mvc.AbstractModel
*@see druzy.mvc.AbstractController
*@see java.beans.PropertyChangeListener
*/

import java.beans.PropertyChangeEvent;

public abstract class AbstractView implements View{
	private Controller controller=null;
	
	/** Constructeur par défault de l'AbstracView
	*@see druzy.mvc.AbstractController
	*@param controller Le controleur lié à cette vue.
	*@since 1.7
	*/
	public AbstractView(Controller controller){
		super();
		this.controller = controller;
	}
	
	/** Renvoie le controleur lié à cette vue
	*@see druzy.mvc.AbstractController
	*@return Le controleur lié à cette vue
	*@since 1.7
	*/
	@Override
	public Controller getController(){return controller;}
	
	@Override
	public abstract void onTop();
	
	/** Méthode déclenchée leur d'un évènement du modèle associé
	*@see java.beans.PropertyChangeListener#propertyChange(PropertyChangeEvent)
	*@see java.beans.PropertyChangeEvent
	*@param pce L'évènement généré par le modèle
	*/
	@Override
	public abstract void propertyChange(PropertyChangeEvent pce);
	
	/** Affiche la vue
	*@since 1.7
	*/
	@Override
	public abstract void display();
	
	@Override
	public abstract boolean isDisplaying();
	
	/** Ferme la vue
	*@since 1.7
	*/
	@Override
	public abstract void close();
}
