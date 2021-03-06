package com.springcatalog.application.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "image_catalog")
public class Image implements Serializable {

	private static final long serialVersionUID = -55342477435690367L;

	@Id
	@Column(name = "id_image", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "ds_type", nullable = false)
	private String type;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_product")
	private Product product;

	public Long getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	@JsonIgnore
	public Product getProduct() {
		return product;
	}

	public void setImageId(Long id) {
		this.id = id;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
