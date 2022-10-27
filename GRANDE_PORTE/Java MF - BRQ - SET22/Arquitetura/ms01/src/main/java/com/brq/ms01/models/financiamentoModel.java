package com.brq.ms01.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "financiamentos")
public class financiamentoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_financiamento")
	private Integer id;

	@Column(name = "numero_contrato")
	private Integer numeroContrato;

	@Column(name = "valor")
	private Double valor;
	// A entidade que possui a chave estrangeira deve ter o @JoinColumn
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private UsuarioModel usuario;
}