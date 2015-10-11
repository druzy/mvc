package druzy.mvc;

/**
*Classe abstraite du controleur (modèle MVC)
*@see druzy.mvc.AbstractModel
*@see druzy.mvc.AbstractView
*@since 1.7
*/

import java.util.ArrayList;

public abstract class AbstractController implements Controller{
	
	private ArrayList<View> views=null;
	private Model model=null;
	
	///{{{ constructeurs
	/**Constructeur par défault
	*@param model Le modèle lié à ce controleur
	*@since 1.7
	*/
	public AbstractController(Model model){ ///{{{
		this.model=model;
	}
	
	/**Renvoie les vues liées à ce controleur
	*@see java.util.ArrayList<E>
	*@see druzy.mvc.AbstractView
	*@return Une liste des vues liées à ce controleur
	*@since 1.7
	*/
	@Override
	public ArrayList<View> getViews(){return views;}
	
	/** Renvoie le modèle lié à ce controleur
	*@see druzy.mvc.AbstractModel
	*@return Le modèle lié à ce controleur
	*@since 1.7
	*/
	@Override
	public Model getModel(){return model;}
	
	/** Remplace la liste de vue par la liste de vue en paramètre
	*@see java.util.ArrayList<E>
	*@see druzy.mvc.AbstractView
	*@param views Liste de vue remplaçant la liste actuellement liée à ce controleur
	*@Exception NullPointerException Retourne une exception si views est null
	*@since 1.7
	*/
	@Override
	public void setViews(ArrayList<View> views){
		if (views==null){
			throw new NullPointerException("argument null");
		}else{
			removeListenersToModel();
			this.views=new ArrayList<View>();
			
			for (int i=0;i<views.size();i++){
				this.views.add(views.get(i));
			}
			addListenersToModel();
		}
		
	}
	
	/** Remplace le modèle courant par le modèle en paramètre
	*@see druzy.mvc.AbstractModel
	*@param model Le modèle remplaçant le modèle actuellement lié à ce controleur
	*@since 1.7
	*/
	@Override
	public void setModel(Model model){
		this.model=model;
	}
	
	/** Ajoute une vue à la liste de vue liée à ce controleur sans modifier les autres vues
	*@see druzy.mvc.AbstractView
	*@param view La vue à ajouter à ce controleur
	*@since 1.7
	*/
	@Override
	public void addView(View view){
		if (views==null){
			views=new ArrayList<View>();
		}
		views.add(view);
		model.addPropertyChangeListener(view);
	}
	
	/** Abonne les vues au modèle
	*@since 1.7
	*/
	private void addListenersToModel(){
		if (views!=null){
			for (int i=0;i<views.size();i++) model.addPropertyChangeListener(views.get(i));
		}
	}
	
	/** Désabonne les vues au modèle
	*@since 1.7
	*/
	private void removeListenersToModel(){
		if (views!=null){
			for (int i=0;i<views.size();i++) model.removePropertyChangeListener(views.get(i));	
		}
	}
	
	/** Affiche les vues
	*@since 1.7
	*/
	@Override
	public void displayViews(){
		if (views!=null){
			for (int i=0;i<views.size();i++) views.get(i).display();	
		}
	}
	
	/** Ferme les vues
	*@since 1.7
	*/
	@Override
	public void closeViews(){
		if (views!=null){
			for (int i=0;i<views.size();i++) views.get(i).close();	
		}
	}
	

	@Override
	public void viewsOnTop(){
		if (views!=null){
			for (int i=0;i<views.size();i++) views.get(i).onTop();
		}
	}
	
	/** Cette méthode sert à notifier les actions de la vue à la méthode
	*@see druzy.mvc.AbstractView
	*@param view La vue qui fait l'action
	*@param info Les info consernant l'action
	*@param action action faite par la vue
	*/
	@Override
	abstract public void notifyAction(View view,Object[] info, int action);
	

	@Override
	public void notifyAction(View view, Object o,int action){
		notifyAction(view,new Object[]{o},action);
	}
}
