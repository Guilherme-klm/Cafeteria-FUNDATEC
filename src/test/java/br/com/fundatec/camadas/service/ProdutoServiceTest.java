package br.com.fundatec.camadas.service;

import br.com.fundatec.camadas.model.Produto;
import br.com.fundatec.camadas.repository.ProdutoRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.Arrays;
import java.util.List;

public class ProdutoServiceTest {

    private ProdutoService produtoService;
    private ProdutoRepository produtoRepository;

    @Before
    public void setUp () {
        produtoRepository = Mockito.mock(ProdutoRepository.class);
        produtoService =  new ProdutoService();
        produtoService.setProdutoRepository(produtoRepository);
    }

    @Test
    public void deveConsultarProdutos () {
        Produto p1 = new Produto(1L, "Nescau", 2D);
        List<Produto> lista = Arrays.asList(p1);
        Mockito.when(produtoService.listar()).thenReturn(lista);
    }

    @Test
    public void deveListarPorId () {
        Produto p1 = new Produto(3L,"Toddy",2D);
        Produto p2 = new Produto(1L,"Nescau",7D);
        Produto p3 = new Produto(5L,"Bom Bril",1D);
        List<Produto> lista = Arrays.asList(p1,p2,p3);

        Mockito.when(produtoRepository.listar()).thenReturn(lista);
        Produto resultado = produtoService.consultar(5L);

        Assert.assertEquals(p3, resultado);

    }
}
