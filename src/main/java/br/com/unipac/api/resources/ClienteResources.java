package br.com.unipac.api.resources;

import br.com.unipac.api.dao.ClienteDAO;
import br.com.unipac.api.models.Cliente;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteResources {

    private ClienteDAO dao;

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity<List<Cliente>> listaTodos() {
        List<Cliente> clientes = dao.listarTodos();
        return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity<Boolean> salvar(@RequestBody Cliente cliente) {
        boolean resultado = dao.salvar(cliente);
        return new ResponseEntity<Boolean>(resultado, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity<Boolean> alterar(@PathParam(value = "id") Long id,
                                           @RequestBody Cliente cliente) {
        boolean resultado = dao.alterar(id, cliente);
        return new ResponseEntity<Boolean>(resultado, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity<Boolean> deletar(@PathParam(value = "id") Long id, @RequestBody
            Cliente cliente) {
        boolean resultado = dao.removerPorId(cliente);
        return new ResponseEntity<Boolean>(resultado, HttpStatus.OK);
    }
}
