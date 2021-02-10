
package org.maia.web.eleicao.domain.abstrac;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public abstract class GenericDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

}
