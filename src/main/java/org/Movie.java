package org;

import javax.persistence.Column;
import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Movie extends PanacheEntity {

	@Column(length = 100)
	public String title;

	@Column(length= 200)
	public String description;

	@Column(name = "Director")
	public String director;

	@Column(name = "Country")
	public String country;

}