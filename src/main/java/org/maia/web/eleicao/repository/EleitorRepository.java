package org.maia.web.eleicao.repository;

import org.maia.web.eleicao.domain.Eleitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EleitorRepository extends JpaRepository<Eleitor, Long> {

}
