package group.springwithgraphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import group.springwithgraphql.model.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long>{
    
}
