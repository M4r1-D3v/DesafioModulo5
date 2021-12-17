package br.com.zup.ContaZup;

import br.com.zup.ContaZup.controller.ContaController;
import br.com.zup.ContaZup.dto.CadastroContaDto;
import br.com.zup.ContaZup.dto.PagamentoContaDto;
import br.com.zup.ContaZup.dto.RespostaPagamentoDto;
import br.com.zup.ContaZup.enums.Tipo;
import br.com.zup.ContaZup.model.Conta;
import br.com.zup.ContaZup.service.ContaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

@WebMvcTest(ContaController.class)
public class ContaControllerTest {

    @MockBean
    private ContaService contaService;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ModelMapper modelMapper;

    private ObjectMapper objectMapper;
    private CadastroContaDto cadastroContaDto;
    private RespostaPagamentoDto respostaPagamentoDto;
    private PagamentoContaDto pagamentoContaDto;
    private List<RespostaPagamentoDto>listaDeContaDto;
    private ObjectMapper objectMapper1;

    @BeforeEach
    public void setup(){
       ObjectMapper objectMapper = new ObjectMapper();
      cadastroContaDto   = new CadastroContaDto();
      cadastroContaDto.setNome("Ana");
      cadastroContaDto.setValor(250.0);
      cadastroContaDto.setTipo(Tipo.LUZ);
      cadastroContaDto.setDataDeVencimento(LocalDate.now());
    }

    @Test
    public void TestasCadastrarContaCaminhoBom(){
        Mockito.when((modelMapper.map(cadastroContaDto, Conta.class))).thenReturn(conta);
    }

}
