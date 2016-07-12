package EstruturaProposta;

import java.util.ArrayList;

public class DisjuntorMotor {
	
	private int ID;
	private String descricao;
	private int sobrecorrente;
	private int sobrecorrenteMin;
	private String tamanho;
	private String modelo;
	private int largura;
	private int altura;
	private int profundidade;
	private int icc220;
	private int icc380;
	private int icc460;
	private int icc500;
	
	//----------------------------------------------------------------------------
	//-----------------------------Construtores-----------------------------------
	//----------------------------------------------------------------------------
	
	public DisjuntorMotor(ArrayList<String> infoDisjuntorMotor){

		this.ID = Integer.parseInt(infoDisjuntorMotor.get(0));
		this.descricao = infoDisjuntorMotor.get(1);
		this.sobrecorrente = Integer.parseInt(infoDisjuntorMotor.get(2));
		this.sobrecorrenteMin = Integer.parseInt(infoDisjuntorMotor.get(3));
		this.tamanho = infoDisjuntorMotor.get(4);
		this.modelo = infoDisjuntorMotor.get(5);
		this.largura = Integer.parseInt(infoDisjuntorMotor.get(6));
		this.altura = Integer.parseInt(infoDisjuntorMotor.get(7));
		this.profundidade = Integer.parseInt(infoDisjuntorMotor.get(8));
		this.icc220 = Integer.parseInt(infoDisjuntorMotor.get(9));
		this.icc380 = Integer.parseInt(infoDisjuntorMotor.get(10));
		this.icc460 = Integer.parseInt(infoDisjuntorMotor.get(11));
		this.icc500 = Integer.parseInt(infoDisjuntorMotor.get(12));
		
	}
	
	public DisjuntorMotor(int ID, String descricao, int sobrecorrente, int sobrecorrenteMin, 
							String tamanho, String modelo, int largura, int altura, int profundidade,
							int icc220, int icc380, int icc460, int icc500){
		
		this.ID = ID;
		this.descricao = descricao;
		this.sobrecorrente = sobrecorrente;
		this.sobrecorrenteMin = sobrecorrenteMin;
		this.tamanho = tamanho;
		this.modelo = modelo;
		this.largura = largura;
		this.altura = altura;
		this.profundidade = profundidade;
		this.icc220 = icc220;
		this.icc380 = icc380;
		this.icc460 = icc460;
		this.icc500 = icc500;
	}
	
	public DisjuntorMotor(){
		
		this.ID = 0;
		this.descricao = null;
		this.sobrecorrente = 0;
		this.sobrecorrenteMin = 0;
		this.tamanho = null;
		this.modelo = null;
		this.largura = 0;
		this.altura = 0;
		this.profundidade = 0;
		this.icc220 = 0;
		this.icc380 = 0;
		this.icc460 = 0;
		this.icc500 = 0;
	}
	
	
	//----------------------------------------------------------------------------
	//----------------------------------Sets--------------------------------------
	//----------------------------------------------------------------------------
	
	public void setID(int ID){
		this.ID = ID;
	}
	public void setDescricao(String descricao){
		this.descricao = descricao;
	}
	public void setSobrecorrente(int sobrecorrente){
		this.sobrecorrente = sobrecorrente;
	}
	public void setSobrecorrenteMin(int sobrecorrenteMin){
		this.sobrecorrenteMin = sobrecorrenteMin;
	}
	public void setTamanho(String tamanho){
		this.tamanho = tamanho;
	}
	public void setModelo(String modelo){
		this.modelo = modelo;
	}
	public void setLargura(int largura){
		this.largura = largura;
	}
	public void setAltura(int altura){
		this.altura = altura;
	}
	public void setProfundidade(int profundidade){
		this.profundidade = profundidade;
	}
	public void setIcc220(int icc220){
		this.icc220 = icc220;
	}
	public void setIcc380(int icc380){
		this.icc380 = icc380;
	}
	public void setIcc460(int icc460){
		this.icc460 = icc460;
	}
	public void setIcc500(int icc500){
		this.icc500 = icc500;
	}
	
	//----------------------------------------------------------------------------
	//----------------------------------Gets--------------------------------------
	//----------------------------------------------------------------------------
	
	public int getID(){
		return ID;
	}
	public String getDescricao(){
		return descricao;
	}
	public int getSobrecorrente(){
		return sobrecorrente;
	}
	public int getSobrecorrenteMin(){
		return sobrecorrenteMin;
	}
	public String getTamanho(){
		return tamanho;
	}
	public String getModelo(){
		return modelo;
	}
	public int getLargura(){
		return largura;
	}
	public int getAltura(){
		return altura;
	}
	public int getProfundidade(){
		return profundidade;
	}
	public int getIcc220(){
		return icc220;
	}
	public int getIcc380(){
		return icc380;
	}
	public int getIcc460(){
		return icc460;
	}
	public int getIcc500(){
		return icc500;
	}
	
}
