package druzy.mvc;

import java.util.ArrayList;

public interface Controller {
	/**Renvoie les vues liées à ce controleur
	*@see java.util.ArrayList<E>
	*@see druzy.mvc.AbstractView
	*@return Une liste des vues liées à ce controleur
	*@since 1.7
	*/
	public ArrayList<View> getViews();
	
	/** Renvoie le modèle lié à ce controleur
	*@see druzy.mvc.AbstractModel
	*@return Le modèle lié à ce controleur
	*@since 1.7
	*/
	public Model getModel();
	
	/** Remplace la liste de vue par la liste de vue en paramètre
	*@see java.util.ArrayList<E>
	*@see druzy.mvc.AbstractView
	*@param views Liste de vue remplaçant la liste actuellement liée à ce controleur
	*@Exception NullPointerException Retourne une exception si views est null
	*@since 1.7
	*/
	public void setViews(ArrayList<View> views);
	
	/** Remplace le modèle courant par le modèle en paramètre
	*@see druzy.mvc.AbstractModel
	*@param model Le modèle remplaçant le modèle actuellement lié à ce controleur
	*@since 1.7
	*/
	public void setModel(Model model);
	
	/** Ajoute une vue à la liste de vue liée à ce controleur sans modifier les autres vues
	*@see druzy.mvc.AbstractView
	*@param view La vue à ajouter à ce controleur
	*@since 1.7
	*/
	public void addView(View view);
	
	/** Affiche les vues
	*@since 1.7
	*/
	public void displayViews();
	
	/** Ferme les vues
	*@since 1.7
	*/
	public void closeViews();

	public void viewsOnTop();

	/** Cette méthode sert à notifier les actions de la vue à la méthode
	*@see druzy.mvc.AbstractView
	*@param view La vue qui fait l'action
	*@param info Les info consernant l'action
	*@param action action faite par la vue
	*/
	public void notifyAction(View view,Object[] info, int action);
	
	public void notifyAction(View view, Object o,int action);
}
