package org.cours.jpa.controleur;

import org.cours.jpa.modele.CoursModule;
import org.cours.jpa.service.CoursModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CoursModuleController {
    @Autowired
    private CoursModuleService coursModuleService;

    @RequestMapping("/modules")
    public List<CoursModule> getModules() {
        return coursModuleService.getAllModules();
    }

    @RequestMapping("/modules/{id}")
    public Optional<CoursModule> getModule(@PathVariable Integer id) {
        return coursModuleService.getModule(id);
    }

    @RequestMapping(method= RequestMethod.POST, value="/modules")
    public void ajouterModule(@RequestBody CoursModule coursModule) {
        coursModuleService.ajouterModule(coursModule);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/modules/{id}")
    public void modifierModule(@RequestBody CoursModule coursModule, @PathVariable Integer id) {
        coursModuleService.modifierModule(id, coursModule);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/modules/{id}")
    public void supprimerModule(@PathVariable Integer id) {
        coursModuleService.supprimerModule(id);
    }
}
