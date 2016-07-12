package EstruturaProposta;

import java.util.ArrayList;
import java.util.LinkedList;

public class Proposta {

	private int ID;
	private String nome = null;
	private String cadastro = null;
	private int revisao = 0;
	private boolean ÈCadastrada;
	private LinkedList<Painel> listaPaineis;
	private LinkedList<Conjunto> listaConjuntos;
	
	//----------------------------------------------------------------------------
	//-----------------------------Construtores-----------------------------------
	//----------------------------------------------------------------------------	
	
	public Proposta(ArrayList<String> infoProposta){
		ID = Integer.parseInt(infoProposta.get(0));
		ÈCadastrada = true;
		nome = infoProposta.get(1);
		cadastro = infoProposta.get(2);
		revisao = Integer.parseInt(infoProposta.get(3));
		listaPaineis = new LinkedList<Painel>();
	}
	
	public Proposta(String nome, String cadastro, int revis„o){
		//this.ÈCadastrada = ÈCadastrada;
		this.nome = nome;
		this.cadastro = cadastro;
		this.revisao = revis„o;
		this.listaPaineis = new LinkedList<Painel>();
	}
	
	public Proposta(){
		ID = 0;
		nome = null;
		cadastro = null;
		revisao = 0;
		ÈCadastrada = false;
		listaPaineis = null;
	}
	
	//----------------------------------------------------------------------------
	//----------------------------------Sets--------------------------------------
	//----------------------------------------------------------------------------
	
	public void setNome(String nome){
		this.nome = nome;
	}
	public void setCadastro(String cadastro){
		this.cadastro = cadastro;
	}
	public void setRevisao(int revisao){
		this.revisao = revisao;
	}
	public void set…Cadastrada(boolean ÈCadastrada){
		this.ÈCadastrada = ÈCadastrada;
	}
	public void setListaPaineis(LinkedList<Painel> listaPaineis){
		this.listaPaineis = listaPaineis;
	}
	
	public void setItensPaineis(LinkedList<Item> listaItens, int indexPainel){
		this.listaPaineis.get(indexPainel).setListaItens(listaItens);
	}
	
	//----------------------------------------------------------------------------
	//----------------------------------Gets--------------------------------------
	//----------------------------------------------------------------------------
	
	public int getID(){
		return ID;
	}	
	public String getNome(){
		return nome;
	}
	public String getCadastro(){
		return cadastro;
	}
	public int getRevisao(){
		return revisao;
	}
	public boolean get…Cadastrada(){
		return ÈCadastrada;
	}
	public LinkedList<Painel> getListaPaineis(){
		return listaPaineis;
	}
	public Painel getPainelSelecionado(int indexPainel){
		return listaPaineis.get(indexPainel);
	}
		
	//----------------------------------------------------------------------------
	//---------------------------------AÁıes--------------------------------------
	//----------------------------------------------------------------------------
	
	public void adicionaPainel(Painel painelAdicionado){
			listaPaineis.add(painelAdicionado);
			System.out.println("add");
	}
}
