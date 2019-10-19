package br.com.unipac.api.dao;

import br.com.unipac.api.models.Cliente;

import java.util.List;

public interface ClienteDAO {

    boolean salvar(Cliente cliente);

    boolean alterar(Long id, Cliente cliente);

    List<Cliente> listarTodos();

    boolean buscarPorId(Cliente cliente);

    boolean removerPorId(Cliente cliente);
}
