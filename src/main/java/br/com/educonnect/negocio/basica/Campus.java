package br.com.educonnect.negocio.basica;

public class Campus{
  private int id;
  private String nome;
  
  public Campus(){
    this.id = id;
    this.nome = nome;
  }
  
  public int getId(){
    return id;
  }
  public void setId(int id){
    this.id = id;
  }
  
  public String getnome(){
    return nome;
  }
}

Campus campus = new Campus(01, "UAG - Unidade Acadêmica de Garanhuns" )
