package br.com.teste_tecnico.teste.Controller.Apolices;

import br.com.teste_tecnico.teste.domain.Apolices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Optional;


@ComponentScan(basePackages = "br.com.teste_tecnico.teste.domain")
@RestController
@RequestMapping(path="cadastroApolice")
public class ApolicesController {

    @Autowired
    ApolicesRepository rp;

    @PostMapping(value = "/salvar")
    public Apolices gravar(@RequestBody Apolices novoApolices) {
        rp.save(novoApolices);
        return novoApolices;
    }

    @GetMapping(value = "vencimento/{numero_apolice}")
    public ResponseEntity<Apolices> getByNumero_Apolices(@PathVariable Number numero_apolice) {
        Optional<Apolices> pr = rp.findBYNumeroapolice(numero_apolice);
        Apolices ap = new Apolices();
        if (pr.isPresent()) {
            if (!(ap.getInc_vigencia() == ap.getFim_vingencia())) {
                ApoliceVencimento apolice_ok = ApoliceVencimento.Apolice_OK;
                ap.setVencimento_Apolice(apolice_ok.toString());
            } else {
                ApoliceVencimento Apolice_Vencida = ApoliceVencimento.Apolice_Vencida;
                ap.setVencimento_Apolice(Apolice_Vencida.toString());
            }
            return new ResponseEntity<>(pr.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(pr.get(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(value="Posvencimento/{numero_apolice}")
    public ResponseEntity<Apolices> getPosVencimento(@PathVariable Number numero_apolice) throws ParseException {
        Optional<Apolices> pr = rp.findBYNumeroapolice(numero_apolice);
        Apolices ap = new Apolices();
        if (pr.isPresent()) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Calendar diaVigenciaInicio= Calendar.getInstance();
                Calendar diaVigenciaFim = Calendar.getInstance();
                LocalDateTime diaAtual = null;
                try{
                    diaVigenciaInicio.setTime(sdf.parse(ap.getInc_vigencia()));
                    diaVigenciaFim.setTime(sdf.parse(ap.getFim_vingencia()));
                } catch (ParseException e){
                    e.printStackTrace();
                }
                //Calculo dos dias pos vencimento
                if (diaVigenciaFim.get(Calendar.DAY_OF_YEAR) < diaAtual.getDayOfYear()){
                    int diasPosVenc = diaAtual.getDayOfYear()-diaVigenciaFim.get(Calendar.DAY_OF_YEAR);
                    ap.setQtd_dias_Vencimento(diasPosVenc);
                    rp.save(ap);
                }

            return new ResponseEntity<>(pr.get(), HttpStatus.OK);
        }else
        {
            return new ResponseEntity<>(pr.get(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "apolice/{placa}")
    public ResponseEntity<Apolices> getByPlaca_Apolices(@PathVariable String placa_veiculo) {
        Optional<Apolices> pr = rp.Placa_Val_Apolice(placa_veiculo);
        Apolices ap = new Apolices();
        if (pr.isPresent()) {
            return new ResponseEntity<>(pr.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(pr.get(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value="/apagar/item/{id}")
    public void apagarItem(@PathVariable Long id){
       rp.deleteById(id);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Apolices> updateApolices(@PathVariable(value = "id") Long Id,
                                              @Validated @RequestBody Apolices Apolices)  {
        Apolices prod = rp.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Apolices Não encontrado:: "+ Apolices));

        final Apolices updatedProd = rp.save(prod);
        return ResponseEntity.ok(updatedProd);
    }
}
