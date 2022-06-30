package group.springwithgraphql.service;

import java.util.List;

import group.springwithgraphql.model.Cliente;
import group.springwithgraphql.model.Compra;
import group.springwithgraphql.model.Produto;

public interface ClienteService {
    public Cliente findById(Long id);
    public List<Cliente> findAll();
    public Cliente save(Cliente cliente);
    public Boolean delete(Long id);
    
    public Produto findByIdProd(Long id);
    public List<Produto> findAllProd();
    public Produto saveProd(Produto produto);
    public Boolean deleteProd(Long id);

    public Compra findByIdComp(Long id);
    public List<Compra> findAllComp();
    public Compra saveComp(Long id,Integer quantidade, String status, Long id_cliente, Long id_produto);
    public Boolean deleteComp(Long id);
}
