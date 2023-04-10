package br.com.educonnect.negocio.basica;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
<<<<<<< HEAD
	
	private String nome;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataNasc;
=======

	@Column(nullable = false, length = 128)
	private String nome;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataNasc;

	@Column(nullable = false, length = 14)
>>>>>>> d86ecae9faef454e508f6803bbc2f906719672b2
	private String cpf;

	@Column(unique = true, nullable = true)
	private String email;
<<<<<<< HEAD
=======

	// devo colocar em uma classe separada, para colocar OneToMany
	@Column(unique = true, nullable = true)
>>>>>>> d86ecae9faef454e508f6803bbc2f906719672b2
	private String phone;

	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;
<<<<<<< HEAD
	
=======

	@OneToOne(cascade = CascadeType.ALL)
	private Login login;
	@OneToMany
	private List<Matricula> matriculas;
>>>>>>> d86ecae9faef454e508f6803bbc2f906719672b2

	// JPA required empty constructor
	public Pessoa() {
	}

	public Pessoa(String nome, Date dataNasc, String cpf, String email, String phone) {
		this.setNome(nome);
		this.setDataNasc(dataNasc);
		this.setCpf(cpf);
		this.setEmail(email);
		this.setPhone(phone);
	}

<<<<<<< HEAD
	
	
	//JPA require all getters and setters.
	public long getId() {
		return id;
	}
=======
	// JPA required all get and set.
	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

>>>>>>> d86ecae9faef454e508f6803bbc2f906719672b2
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
