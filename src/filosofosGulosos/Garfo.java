package filosofosGulosos;

public class Garfo{
	private int idGarfo;
	private boolean estadoGarfo;
	private int dono;
	
	public Garfo(int id){
		idGarfo = id;
		estadoGarfo = false; // desocupado		
		dono = -1; // sem dono
	}
	
	public int getIdGarfo(){
		return idGarfo;
	}
	
	public void setIdGarfo(int g){
		idGarfo = g;
	}
	
	public int getDonoGarfo(){
		return dono;
	}
	
	public void setDonoGarfo(int d){
		dono = d;	
	}
	
	public boolean getEstadoGarfo(){
		return estadoGarfo;
	}
	
	public void setEstadoGarfo(boolean ocupado){
		estadoGarfo = ocupado;
	}
}