package br.com.educonnect.negocio.basica;

import java.util.Date;
import java.util.List;

import br.com.educonnect.negocio.MatriculaIgualException;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
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
	
	@Column(nullable = false, length = 128)
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataNasc;
	
	@Column(nullable = false, length = 14)
	private String cpf;

	@Column(unique = true, nullable = true)
	private String email;
	
	//devo colocar em uma classe separada, para colocar OneToMany
	@Column(unique = true, nullable = true)
	private String phone;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Login login;
	
	@OneToMany
	private List<Matricula> matriculas;

	//JPA required empty constructor
	public Pessoa() {}
	
	public Pessoa(String nome, Date dataNasc, String cpf, String email, String phone) {
		this.setNome(nome);
		this.setDataNasc(dataNasc);
		this.setCpf(cpf);
		this.setEmail(email);
		this.setPhone(phone);
	}
	//uma disciplina pode ter varios horarios.
	//uma disciplina pode ser ministrada por prof diferentes
	public void solicitarMatricula(int semestre, Disciplina dis) throws MatriculaIgualException {
		Matricula mat = new Matricula(semestre, dis);
		
		if(!matriculas.contains(mat)) {
			this.matriculas.add(mat);
		} else {
			MatriculaIgualException ex = new MatriculaIgualException(semestre, dis);
			throw ex;
		}
	}
	
	//JPA require all getters and setters.
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
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}
}
