package SprintTask2.Spring.web.controller;

import SprintTask2.Spring.web.entities.ApplicationRequest;
import SprintTask2.Spring.web.repository.AppRepository;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/app")
public class HomeController {
    @Autowired
    AppRepository appRepository;

    @GetMapping(value = "/")
    public String getIndex(Model modal){
        List<ApplicationRequest> applicationRequestList = appRepository.findAll();
        modal.addAttribute("applicationRequestList", applicationRequestList);
        return "index";
    }
    @GetMapping(value = "/add_Req")
    public String addRequest(){
        return "addRequest";
    }
    @PostMapping(value = "/add_Req")
    public String addRequest(@RequestParam(name="user_name") String name,
                             @RequestParam(name="course") String course,
                             @RequestParam(name="phone") String phone,
                             @RequestParam(name="comment") String comment){
        ApplicationRequest app = new ApplicationRequest();
        app.setHandled(false);
        app.setUserName(name);
        app.setCourseName(course);
        app.setPhone(phone);
        app.setCommentary(comment);

        appRepository.save(app);

        return "redirect:/app/";
    }
    @GetMapping(value = "/details/{id}")
    public String detailsRequest(@PathVariable(name="id") Long id,
                                 Model model){
        ApplicationRequest app = appRepository.findById(id).orElseThrow(null);
        model.addAttribute("app", app);
        List<ApplicationRequest> applicationRequestList = appRepository.findAll();
        model.addAttribute("applicationRequestList", applicationRequestList);
        return "details";
    }
    @PostMapping(value = "/update_app")
    public String updateApp(@RequestParam(name="user_name") String name,
                            @RequestParam(name="course") String course,
                            @RequestParam(name="phone") String phone,
                            @RequestParam(name="comment") String comment,
                            @RequestParam(name = "id") Long id){
        ApplicationRequest app = new ApplicationRequest();
        app.setId(id);
        app.setUserName(name);
        app.setCourseName(course);
        app.setPhone(phone);
        app.setCommentary(comment);
        app.setHandled(true);
        appRepository.save(app);

        return "redirect:/app/";
    }
    @PostMapping(value="/delete_app")
    public String deleteApp(@RequestParam(name = "app_id") Long id){
        appRepository.deleteById(id);
        return "redirect:/app/";
    }
    @GetMapping(value = "/new_app")
    public String newApp(Model model){
        List<ApplicationRequest> applicationRequestList = appRepository.findAll();
        model.addAttribute("applicationRequestList", applicationRequestList);
        return "newApp";
    }
    @GetMapping(value = "/handle_app")
    public String handleApp(Model model){
        List<ApplicationRequest> applicationRequestList = appRepository.findAll();
        model.addAttribute("applicationRequestList", applicationRequestList);
        return "handleApp";
    }
}
