/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pa.microservicios.HomeTaskManager.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pa.microservicios.HomeTaskManager.Model.ActividadDTO;
import pa.microservicios.HomeTaskManager.Service.ActividadService;

/**
 *
 * @author Asus
 */
@Controller
@RequestMapping("actividad")
public class ActividadController {

    @Autowired
    private ActividadService actividadService;

    @RequestMapping(value = "/actividad", method = RequestMethod.GET)
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("actividad", new ActividadDTO());
        return "ingresodatos";
    }

    @RequestMapping(value = "/actividad", method = RequestMethod.POST)
    public String procesarFormularioRegistro(@ModelAttribute ActividadDTO actividadDTO) {
        return "redirect:/listado";
    }

    @RequestMapping(value = "/actividades", method = RequestMethod.GET)
    public String getAllActividades(Model model) {
        List<ActividadDTO> actividades = actividadService.getAllActividades();
        model.addAttribute("actividades", actividades);
        return "listado";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getActividadById(@PathVariable("id") Long id, Model model) {
        ActividadDTO actividad = actividadService.getActividadById(id);
        model.addAttribute("actividad", actividad);
        return "actividad";
    }

    @RequestMapping(value = "/borraractividad/{id}", method = RequestMethod.DELETE)
    public String borrarActividad(@PathVariable Long id) {
        actividadService.borrarActividad(id);
        return "redirect:/listado";
    }

    @RequestMapping(value = "/actualizaractividad/{id}", method = RequestMethod.PUT)
    public String mostrarFormularioActualizar(@PathVariable Long id, Model model) {
        ActividadDTO actividad = actividadService.getActividadById(id);
        model.addAttribute("actividad", actividad);
        return "ingresodatos";
    }

    @RequestMapping(value = "/actualizaractividad/{id}", method = RequestMethod.PUT)
    public String procesarFormularioActualizar(@PathVariable Long id, @ModelAttribute ActividadDTO actividad){
        actividadService.actualizarActividad(id, actividad);
        return "ingresodatos";
    }
}
