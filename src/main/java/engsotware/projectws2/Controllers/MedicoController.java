package engsotware.projectws2.Controllers;

import engsotware.projectws2.Models.Medico;
import engsotware.projectws2.Repositories.MedicoRepoI;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/medico")
public class MedicoController {

    private MedicoRepoI medicoRepoI;

    public MedicoController(MedicoRepoI medicoRepoI) {
        this.medicoRepoI = medicoRepoI;
    }

    @RequestMapping(value="/{name}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public  @ResponseBody
    Medico getByName(@PathVariable("name") String name){
        return medicoRepoI.findByName(name).get();
    }
}
