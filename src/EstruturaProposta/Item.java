package EstruturaProposta;

import java.util.ArrayList;

public class Item {

	private int ID;
	private int ConjuntoID;
	private String descrição;
	private String modelo;
	private int quantidade;
	private String tipo;
	private String fabricante;
	private String conjunto;
	
	public Item(){
		this.ID = 0;
		this.descrição = null;
		this.modelo = null;
		this.quantidade = 0;
		this.tipo = null;
		this.conjunto = null;
	}
	
	public Item(ArrayList<String> infoItem){
		this.ConjuntoID = 0;
		this.ID = Integer.parseInt(infoItem.get(0));
		this.descrição = infoItem.get(3);
		this.modelo = infoItem.get(4);
		this.quantidade = Integer.parseInt(infoItem.get(5));
		this.fabricante = infoItem.get(6);
		this.tipo = infoItem.get(7);
		this.conjunto = infoItem.get(8);
	}
	
	public Item(String descricao, String modelo, int quantidade, String fabricante,
				String tipo, String conjunto){
		this.ID = 0;
		this.ConjuntoID = 0;
		this.descrição = descricao;
		this.modelo = modelo;
		this.quantidade = quantidade;
		this.fabricante = fabricante;
		this.tipo = tipo;
		this.conjunto = conjunto;
	}
	
	//----------------------------------------------------------------------------
	//----------------------------------Sets--------------------------------------
	//----------------------------------------------------------------------------
	
	public void setID(int ID){
		this.ID = ID;
	}
	public void setDescrição(String descrição){
		this.descrição = descrição;
	}
	public void setModelo(String modelo){
		this.modelo = modelo;
	}
	public void setQuantidade(int quantidade){
		this.quantidade = quantidade;
	}
	public void setTipo(String tipo){
		this.tipo= tipo;
	}
	public void setFabricante(String fabricante){
		this.fabricante = fabricante;
	}
	public void setConjunto(String conjunto){
		this.conjunto = conjunto;
	}
	
	//----------------------------------------------------------------------------
	//----------------------------------Gets--------------------------------------
	//----------------------------------------------------------------------------
	
	public int getID(){
		return this.ID;
	}	
	public String getDescrição(){
		return this.descrição;
	}
	public String getModelo(){
		return this.modelo;
	}
	public int getQuantidade(){
		return this.quantidade;
	}
	public String getTipo(){
		return this.tipo;
	}
	public String getFabricante(){
		return this.fabricante;
	}
	public String getConjunto(){
		return this.conjunto;
	}
		
}
