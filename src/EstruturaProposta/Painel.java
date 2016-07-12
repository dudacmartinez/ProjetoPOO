package EstruturaProposta;

import java.util.ArrayList;
import java.util.LinkedList;

public class Painel {

	private int ID;
	private int parentID;
	private String TAG;
	private String aplicação;
	private int tensãoAlimentaçãoFaseFase;
	private int numFases;
	private boolean éTTA;
	private boolean temMedição;	
	private boolean temDPS;
	private boolean éCompartimentado;
	private int correnteBarramento;
	private int correnteCurtoCircuito;
	private LinkedList<Item> listaItens;
	
	//private short altura;
	//private short largura;
	//private short profundidade;
	//private LinkedList<Item> listaItens;
	
	//----------------------------------------------------------------------------
	//-----------------------------Construtores-----------------------------------
	//----------------------------------------------------------------------------	
	public Painel(){
		this.ID = 0;
		this.parentID = 0;
		this.TAG = null;
		this.aplicação = null;
		this.tensãoAlimentaçãoFaseFase = 0;
		this.numFases = 0;
		this.éTTA = false;
		this.temMedição = false;	
		this.temDPS = false;
		this.éCompartimentado = false;
		this.correnteBarramento = 0;
		this.correnteCurtoCircuito = 0;
	}
	
	public Painel(ArrayList<String> infoPainel){
		this.ID = Integer.parseInt(infoPainel.get(0));
		this.parentID = Integer.parseInt(infoPainel.get(1));;
		this.TAG = infoPainel.get(2);
		this.aplicação = infoPainel.get(3);
		this.tensãoAlimentaçãoFaseFase = Integer.parseInt(infoPainel.get(4));
		this.numFases = Integer.parseInt(infoPainel.get(5));
		this.éTTA = Boolean.parseBoolean(infoPainel.get(6));
		this.temMedição = Boolean.parseBoolean(infoPainel.get(7));;
		this.temDPS = Boolean.parseBoolean(infoPainel.get(8));;
		this.éCompartimentado = Boolean.parseBoolean(infoPainel.get(9));;
		this.correnteBarramento = Integer.parseInt(infoPainel.get(10));		
		this.correnteCurtoCircuito = Integer.parseInt(infoPainel.get(11));
		this.listaItens = new LinkedList<Item>();
	}
	
	public Painel(String TAG, String aplicação, int tensãoAlimentaçãoFaseFase, 
					int numFases, boolean éTTA, boolean temMedição, boolean temDPS, 
					boolean éCompartimentado, int correnteBarramento,int correnteCurtoCircuito){
		this.TAG = TAG;
		this.aplicação = aplicação;
		this.tensãoAlimentaçãoFaseFase = tensãoAlimentaçãoFaseFase;
		this.numFases = numFases;
		this.éTTA = éTTA;
		this.temMedição = temMedição;	
		this.temDPS = temDPS;
		this.éCompartimentado = éCompartimentado;
		this.correnteBarramento = correnteBarramento;
		this.correnteCurtoCircuito = correnteCurtoCircuito;
	}

	
	//----------------------------------------------------------------------------
	//----------------------------------Sets--------------------------------------
	//----------------------------------------------------------------------------
	
	public void setTAG(String TAG){
		this.TAG = TAG;
	}
	public void setAplicação(String aplicação){
		this.aplicação = aplicação;
	}
	public void setTensãoAlimentaçãoFaseFase(int tensãoAlimentação){
		this.tensãoAlimentaçãoFaseFase = tensãoAlimentação;
	}
	public void setNumFases(int numFases){
		this.numFases = numFases;
	}
	public void setÉTTA(boolean éTTA){
		this.éTTA = éTTA;
	}
	public void setTemMedição(boolean temMedição){
		this.temMedição = temMedição;
	}
	public void setTemDPS(boolean temDPS){
		this.temDPS = temDPS;
	}
	public void setÉCompartimentado(boolean éCompartimentado){
		this.éCompartimentado = éCompartimentado;
	}
	public void setCorrenteBarramento(int correnteBarramento){
		this.correnteBarramento = correnteBarramento;
	}
	public void setCorrenteCurtoCircuito(int correnteCurtoCircuito){
		this.correnteCurtoCircuito = correnteCurtoCircuito;
	}
	public void setListaItens(LinkedList<Item> listaItens){
		this.listaItens = listaItens;
	}
	
	//----------------------------------------------------------------------------
	//----------------------------------Gets--------------------------------------
	//----------------------------------------------------------------------------
	
	public int getID(){
		return this.ID;
	}
	public int getParentID(){
		return this.parentID;
	}
	public String getTAG(){
		return this.TAG;
	}
	public String getAplicação(){
		return this.aplicação;
	}
	public int getTensãoAlimentaçãoFaseFase(){
		return this.tensãoAlimentaçãoFaseFase;
	}
	public int getNumFases(){
		return this.numFases;
	}
	public boolean getÉTTA(){
		return this.éTTA;
	}
	public boolean getTemMedição(){
		return this.temMedição;
	}
	public boolean getTemDPS(){
		return this.temDPS;
	}
	public boolean getÉCompartimentado(){
		return this.éCompartimentado;
	}
	public int getCorrenteBarramento(){
		return this.correnteBarramento;
	}
	public int getCorrenteCurtoCircuito(){
		return this.correnteCurtoCircuito;
	}
	public LinkedList<Item> getListaItens(){
		return this.listaItens;
	}
	
	//----------------------------------------------------------------------------
	//---------------------------------Ações--------------------------------------
	//----------------------------------------------------------------------------
	public void adicionaItem(Item itemAdicionado){
		if(this.listaItens != null){
			this.listaItens.add(itemAdicionado);
		}
	}
}
