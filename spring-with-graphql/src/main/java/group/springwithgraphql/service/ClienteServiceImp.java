package group.springwithgraphql.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Service;

import group.springwithgraphql.model.Cliente;
import group.springwithgraphql.model.Compra;
import group.springwithgraphql.model.Produto;
import group.springwithgraphql.repository.ClienteRepository;
import group.springwithgraphql.repository.CompraRepository;
import group.springwithgraphql.repository.ProdutoRepository;

@Service
public class ClienteServiceImp implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private CompraRepository compraRepository;

    public Cliente findById(@Argument Long id){
        return clienteRepository.findById(id).orElse(null);
    }

    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    @Transactional
    public Cliente save(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @Transactional
    public Boolean delete(@Argument Long id){
        if(findById(id) != null){
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Produto findByIdProd(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Produto> findAllProd() {
        return produtoRepository.findAll();
    }

    @Transactional
    @Override
    public Produto saveProd(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Transactional
    @Override
    public Boolean deleteProd(Long id) {
        if(findByIdProd(id) != null){
            produtoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Compra findByIdComp(Long id) {
        return compraRepository.findById(id).orElse(null);
    }

    @Override
    public List<Compra> findAllComp() {
        return compraRepository.findAll();
    }

    @Transactional
    @Override
    public Compra saveComp(Long id,Integer quantidade, String status, Long id_cliente, Long id_produto) {
        Cliente cliente = findById(id_cliente);
        Produto produto = findByIdProd(id_produto);
        return compraRepository.save(new Compra(id, quantidade, status, cliente, produto));
    }

    @Transactional
    @Override
    public Boolean deleteComp(Long id) {
        if(findByIdComp(id) != null){
            compraRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
