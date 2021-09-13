package automoveis.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import automoveis.validation.MaxAnoAtualMais;

@NamedQueries({
	@NamedQuery(name=Automovel.LISTAR_DESTAQUES, query="select a from Automovel a", hints={
			@QueryHint(name="org.hibernate.cacheable", value="true"),
			@QueryHint(name="org.hibernate.cacheRegion", value=Automovel.LISTAR_DESTAQUES)})
})

@Entity
public class Automovel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Modelo modelo;
	
	@Min(1900)
	@MaxAnoAtualMais(message="O máximo do ano de fabricação é {0}")
	private Integer anoFabricacao;
	
	@Min(1900)
	@MaxAnoAtualMais(value=1, message="O máximo do ano do modelo é {0}")
	private Integer anoModelo;
	
	@NotBlank
	private Float preco;
	
	@NotBlank
	private Double kilometragem;
	
	private String observacoes;
	
	public static final String LISTAR_DESTAQUES = "Automovel.buscarDestaques";
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(Integer anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public Integer getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(Integer anoModelo) {
		this.anoModelo = anoModelo;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public Double getKilometragem() {
		return kilometragem;
	}

	public void setKilometragem(Double kilometragem) {
		this.kilometragem = kilometragem;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
}
