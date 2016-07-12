package EstruturaProposta;

import java.util.ArrayList;
import java.util.LinkedList;

public class Painel {

	private int ID;
	private int parentID;
	private String TAG;
	private String aplica��o;
	private int tens�oAlimenta��oFaseFase;
	private int numFases;
	private boolean �TTA;
	private boolean temMedi��o;	
	private boolean temDPS;
	private boolean �Compartimentado;
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
		this.aplica��o = null;
		this.tens�oAlimenta��oFaseFase = 0;
		this.numFases = 0;
		this.�TTA = false;
		this.temMedi��o = false;	
		this.temDPS = false;
		this.�Compartimentado = false;
		this.correnteBarramento = 0;
		this.correnteCurtoCircuito = 0;
	}
	
	public Painel(ArrayList<String> infoPainel){
		this.ID = Integer.parseInt(infoPainel.get(0));
		this.parentID = Integer.parseInt(infoPainel.get(1));;
		this.TAG = infoPainel.get(2);
		this.aplica��o = infoPainel.get(3);
		this.tens�oAlimenta��oFaseFase = Integer.parseInt(infoPainel.get(4));
		this.numFases = Integer.parseInt(infoPainel.get(5));
		this.�TTA = Boolean.parseBoolean(infoPainel.get(6));
		this.temMedi��o = Boolean.parseBoolean(infoPainel.get(7));;
		this.temDPS = Boolean.parseBoolean(infoPainel.get(8));;
		this.�Compartimentado = Boolean.parseBoolean(infoPainel.get(9));;
		this.correnteBarramento = Integer.parseInt(infoPainel.get(10));		
		this.correnteCurtoCircuito = Integer.parseInt(infoPainel.get(11));
		this.listaItens = new LinkedList<Item>();
	}
	
	public Painel(String TAG, String aplica��o, int tens�oAlimenta��oFaseFase, 
					int numFases, boolean �TTA, boolean temMedi��o, boolean temDPS, 
					boolean �Compartimentado, int correnteBarramento,int correnteCurtoCircuito){
		this.TAG = TAG;
		this.aplica��o = aplica��o;
		this.tens�oAlimenta��oFaseFase = tens�oAlimenta��oFaseFase;
		this.numFases = numFases;
		this.�TTA = �TTA;
		this.temMedi��o = temMedi��o;	
		this.temDPS = temDPS;
		this.�Compartimentado = �Compartimentado;
		this.correnteBarramento = correnteBarramento;
		this.correnteCurtoCircuito = correnteCurtoCircuito;
	}

	
	//----------------------------------------------------------------------------
	//----------------------------------Sets--------------------------------------
	//----------------------------------------------------------------------------
	
	public void setTAG(String TAG){
		this.TAG = TAG;
	}
	public void setAplica��o(String aplica��o){
		this.aplica��o = aplica��o;
	}
	public void setTens�oAlimenta��oFaseFase(int tens�oAlimenta��o){
		this.tens�oAlimenta��oFaseFase = tens�oAlimenta��o;
	}
	public void setNumFases(int numFases){
		this.numFases = numFases;
	}
	public void set�TTA(boolean �TTA){
		this.�TTA = �TTA;
	}
	public void setTemMedi��o(boolean temMedi��o){
		this.temMedi��o = temMedi��o;
	}
	public void setTemDPS(boolean temDPS){
		this.temDPS = temDPS;
	}
	public void set�Compartimentado(boolean �Compartimentado){
		this.�Compartimentado = �Compartimentado;
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
	public String getAplica��o(){
		return this.aplica��o;
	}
	public int getTens�oAlimenta��oFaseFase(){
		return this.tens�oAlimenta��oFaseFase;
	}
	public int getNumFases(){
		return this.numFases;
	}
	public boolean get�TTA(){
		return this.�TTA;
	}
	public boolean getTemMedi��o(){
		return this.temMedi��o;
	}
	public boolean getTemDPS(){
		return this.temDPS;
	}
	public boolean get�Compartimentado(){
		return this.�Compartimentado;
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
	//---------------------------------A��es--------------------------------------
	//----------------------------------------------------------------------------
	public void adicionaItem(Item itemAdicionado){
		if(this.listaItens != null){
			this.listaItens.add(itemAdicionado);
		}
	}
}
