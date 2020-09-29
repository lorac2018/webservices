package engsotware.projectws2.Controllers;

import engsotware.projectws2.Models.Consulta;
import engsotware.projectws2.Repositories.ConsultaRepoI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
public class ConsultaController {

    Map<String,String> example = new HashMap<String, String>();

    private void setExample(){
        example.put("ws1.1", "http://localhost:8080");
        example.put("ws1.2", "http://localhost:8081");
    }


    @GetMapping(value = "/{nomeClinica}",produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Iterable getAll(@PathVariable("nomeClinica") String nomeClinica){
        setExample();
        String path= example.get(nomeClinica);
        String getAll= "/consulta";
        path.concat(getAll);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> nullBodyRequest=new HttpEntity<>(null,headers);
        ResponseEntity<Iterable> responseEntity=makeRequest(path, HttpMethod.GET,nullBodyRequest,Iterable.class);
        return responseEntity.getBody();
    }

    @GetMapping(value = "/{nomeClinica}/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Iterable getById(@PathVariable("nomeClinica") String nomeClinica, @PathVariable("id") String id){
        setExample();
        String path= example.get(nomeClinica);
        String getAll= "/consulta/";
        path.concat(getAll);
        path.concat(id);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> nullBodyRequest=new HttpEntity<>(null,headers);
        ResponseEntity<Iterable> responseEntity=makeRequest(path, HttpMethod.GET,nullBodyRequest,Iterable.class);
        return responseEntity.getBody();
    }

    private ResponseEntity makeRequest(String path, HttpMethod method, HttpEntity request, Class responseType){
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate.exchange(path,method,request,responseType);
    }









//    private ConsultaRepoI consultaRepoI;
//
//    private Logger logger = LoggerFactory.getLogger(ConsultaController.class);
//
//    public ConsultaController(ConsultaRepoI consultaRepoI) {
//        this.consultaRepoI = consultaRepoI;
//    }

//    @PostMapping(value = "/{nameMedico}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Consulta> saveConsulta(@RequestBody Consulta consulta, @PathVariable("nameMedico") String nameMedico) {
//        logger.info(consulta.toString() + " " + nameMedico);
//        Optional<Consulta> consultaOptional = consultaRepoI.saveConsulta(consulta, nameMedico);
//        if (consultaOptional.isPresent()) {
//            return ResponseEntity.ok(consultaOptional.get());
//        }
//        return ResponseEntity.notFound().build();
//    }
}
