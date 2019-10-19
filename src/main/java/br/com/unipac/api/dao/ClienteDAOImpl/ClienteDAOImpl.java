package br.com.unipac.api.dao.ClienteDAOImpl;

import br.com.unipac.api.dao.ClienteDAO;
import br.com.unipac.api.models.Cliente;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClienteDAOImpl implements ClienteDAO {

    List<Cliente> clientes = new ArrayList<>();

    @Override
    public boolean salvar(Cliente cliente) {
        return clientes.add(cliente);
    }

    @Override
    public boolean alterar(Long id, Cliente cliente) {
        cliente.update(id, cliente);
        return clientes.add(cliente);
    }

    @Override
    public List<Cliente> listarTodos() {
        return clientes;
    }

    @Override
    public boolean buscarPorId(Cliente cliente) {
        return clientes.contains(cliente);
    }

    @Override
    public boolean removerPorId(Cliente cliente) {
        return clientes.remove(cliente);
    }
}
