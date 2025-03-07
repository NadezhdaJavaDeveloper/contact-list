package org.example.contactList.controller;


import lombok.RequiredArgsConstructor;
import org.example.contactList.Contact;
import org.example.contactList.service.ContactListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;;

@Controller
@RequiredArgsConstructor
public class ContactListController {

    private final ContactListService contactListService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("contacts", contactListService.findAll());
        return "index";
    }

    //нужен для отображнения формы, с помощью к-ой будем создавать задачу
    @GetMapping("/contact/create")
    public String showCreateForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "actions";
    }


    @PostMapping("/contact/create")
    public String createTask(@ModelAttribute Contact contact) { //@ModelAttribute эти параметры будут автоматически заполняться моделью, которая получила данные из представления
        contactListService.save(contact);
        return "redirect:/"; //это строка перебрасывает на @GetMapping("/")
    }

    @GetMapping("/contact/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) { //читает значение указанное в пути
        Contact contact = contactListService.findById(id);
        if (contact != null) {
            model.addAttribute("contact", contact);
            return "actions";
        }
        return "redirect:/"; //это строка перебрасывает на @GetMapping("/")
    }

    @PostMapping("/contact/edit")
    public String editContact(@ModelAttribute Contact contact) {
        contactListService.update(contact);
        return "redirect:/"; //это строка перебрасывает на @GetMapping("/")
    }


    @GetMapping("/contact/delete/{id}")
    public String deleteContact(@PathVariable Long id) {
        contactListService.deleteById(id);
        return "redirect:/"; //это строка перебрасывает на @GetMapping("/")
    }

}
