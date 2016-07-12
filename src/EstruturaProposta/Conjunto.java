package EstruturaProposta;

import java.util.ArrayList;
import java.util.LinkedList;

public class Conjunto {

	private int ID;
	private String nome;
	private String tipo;
	private LinkedList<Item> listaItens;
	
	//----------------------------------------------------------------------------
	//-----------------------------Construtores-----------------------------------
	//----------------------------------------------------------------------------
	
	public Conjunto() {
		this.ID = 0;
		this.nome = null;
		this.tipo = null;
	}
	
	public Conjunto(ArrayList<String> infoConjunto){
		this.ID = Integer.parseInt(infoConjunto.get(0));
		this.nome = infoConjunto.get(1);
		this.tipo = infoConjunto.get(2);
	}
	
	//----------------------------------------------------------------------------
	//---------------------------------Ações--------------------------------------
	//----------------------------------------------------------------------------
	public void adicionarItensPainel(Painel painel){
		for(int i=0; i<listaItens.size();i++){
			painel.adicionaItem(listaItens.get(i));
		}
	}
	
	//----------------------------------------------------------------------------
	//----------------------------------Sets--------------------------------------
	//----------------------------------------------------------------------------
	public void setID(int ID){
		this.ID = ID;
	}
	public void setNome(String nome){
		this.nome = nome;
	}
	public void setTipo(String tipo){
		this.tipo = tipo;
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
	public String getNome(){
		return this.nome;
	}
	public String getTipo(){
		return this.tipo;
	}
	public LinkedList<Item> getListaItens(){
		return this.listaItens;
	}
	
}
