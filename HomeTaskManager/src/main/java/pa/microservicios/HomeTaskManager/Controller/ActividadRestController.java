package pa.microservicios.HomeTaskManager.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pa.microservicios.HomeTaskManager.Service.ActividadService;

/**
 *
 * @author Asus
 *
 */
@RestController
//generar una misma ruta para todos los endpoint
@RequestMapping("actividad")
public class ActividadRestController {   
    @Autowired
    private ActividadService actividadService;
    
    
    
    
}