package Resultado;

import java.util.LinkedList;

import EstruturaProposta.*;

public class PropostaEditada {

	private static Proposta propostaSelecionada = new Proposta();	
	private static Painel painelSelecionado = new Painel();
	
	//----------------------------------------------------------------------------
	//------------------------------Construtor------------------------------------
	//----------------------------------------------------------------------------

	
	//----------------------------------------------------------------------------
	//----------------------------------Sets--------------------------------------
	//----------------------------------------------------------------------------
	
	public static void setPropostaSelecionada(Proposta propostaSelecionada){
		PropostaEditada.propostaSelecionada = propostaSelecionada;
		System.out.println(propostaSelecionada.getID());
	}
	
	public static void setPaineisPropostaSelecionada(LinkedList<Painel> listaPaineis){
		propostaSelecionada.setListaPaineis(listaPaineis);
	}
	
	public static void adicionaPainelPropostaSelecionada(Painel painelSelecionado){
		propostaSelecionada.adicionaPainel(painelSelecionado);
	}
	
	public static void setItensPaineis(LinkedList<Item> listaItens,int indexPainel){
		propostaSelecionada.setItensPaineis(listaItens, indexPainel);;
	}
	
	public static void setPainelSelecionado(Painel painelSelecionado){
		PropostaEditada.painelSelecionado = painelSelecionado;
	}

	//----------------------------------------------------------------------------
	//----------------------------------Gets--------------------------------------
	//----------------------------------------------------------------------------
	
	public static Proposta getPropostaSelecionada(){
		return propostaSelecionada;
	}
	
	public static LinkedList<Painel> getPaineisPropostaSelecionada(){
		return propostaSelecionada.getListaPaineis();
	}
	
	public static Painel getPainelPropostaSelecionada(int indexPainel){
		return propostaSelecionada.getPainelSelecionado(indexPainel);
	}
	
	public static LinkedList<Item> getItensPainelPropostaSelecionada(int indexPainel){
		return propostaSelecionada.getPainelSelecionado(indexPainel).getListaItens();
	}
	
	public static Painel getPainelSelecionado(){
		return painelSelecionado;
	}
	
	//----------------------------------------------------------------------------
	//---------------------------------Métodos------------------------------------
	//----------------------------------------------------------------------------
	
	public static void adicionaPainelPropostaSelecionada(){
		propostaSelecionada.adicionaPainel(painelSelecionado);
	}
	
	
}