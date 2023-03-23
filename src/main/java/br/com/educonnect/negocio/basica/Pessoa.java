package br.com.educonnect.negocio.basica;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private long id;
	
	@Column(name = "nome", nullable = false, length = 128)
	private String nome;
	
	@Temporal(TemporalType.DATE)
	private Date dataNasc;
	
	@Column(name = "nome", nullable = false, length = 14)
	private String cpf;

	@Column(unique = true, nullable = true)
	private String email;
	
	//devo colocar em uma classe separada, para colocar OneToMany
	@Column(unique = true, nullable = true)
	private String phone;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;
	
	//JPA required empty constructor
	public Pessoa() {}
	
	public Pessoa(String nome, Date dataNasc, String cpf, String email, String phone) {
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.cpf = cpf;
		this.email = email;
		this.setPhone(phone);
	}
	
	//JPA required all get and set.
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
