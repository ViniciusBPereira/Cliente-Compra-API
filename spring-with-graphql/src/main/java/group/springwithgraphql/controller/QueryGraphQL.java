package group.springwithgraphql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import group.springwithgraphql.model.Cliente;
import group.springwithgraphql.model.Compra;
import group.springwithgraphql.model.Produto;
import group.springwithgraphql.service.ClienteService;

@Controller
public class QueryGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver{
    
    @Autowired
    private ClienteService service;

    @QueryMapping
    public Cliente cliente(@Argument Long id){
        return service.findById(id);
    }

    @QueryMapping
    public Produto produto(@Argument Long id){
        return service.findByIdProd(id);
    }

    @QueryMapping
    public Compra compra(@Argument Long id){
        return service.findByIdComp(id);
    }

    @QueryMapping
    public List<Cliente> clientes(){
        return service.findAll();
    }

    @QueryMapping
    public List<Produto> produtos(){
        return service.findAllProd();
    }

    @QueryMapping
    public List<Compra> compras(){
        return service.findAllComp();
    }

    @MutationMapping
    public Cliente saveCliente(@Argument Long id,@Argument String nome,@Argument String email){
        return service.save(new Cliente(id, nome, email));
    }

    @MutationMapping
    public Produto saveProduto(@Argument Long id,@Argument String nome,@Argument Double valor){
        return service.saveProd(new Produto(id, nome, valor));
    }

    @MutationMapping
    public Compra saveCompra(@Argument Long id,@Argument Integer quantidade,@Argument String status,@Argument Long idcliente,@Argument Long idproduto){
        return service.saveComp(id, quantidade, status, idcliente, idproduto);
    }

    @MutationMapping
    public Boolean deleteCliente(@Argument Long id){
        return service.delete(id);
    }

    @MutationMapping
    public Boolean deleteProduto(@Argument Long id){
        return service.deleteProd(id);
    }

    @MutationMapping
    public Boolean deleteCompra(@Argument Long id){
        return service.deleteComp(id);
    }

}
