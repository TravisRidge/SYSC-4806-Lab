package App;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BuddyController {
    @Autowired
    BuddyInfoRepository repository;

    @GetMapping("/addBuddy")
    public String addBuddyForm(Model model) {
        model.addAttribute("buddy", new BuddyInfo());
        return "addBuddy";
    }

    @PostMapping("/addBuddy")
    public String addBuddySubmit(Model model, @ModelAttribute BuddyInfo buddy) {
        model.addAttribute("buddy", buddy);
        repository.save(buddy);
        return "addResult";
    }
}
