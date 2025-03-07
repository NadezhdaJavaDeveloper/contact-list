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

    @GetMapping("/contact/create")
    public String showCreateForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "actions";
    }

    @PostMapping("/contact/create")
    public String createTask(@ModelAttribute Contact contact) {
        contactListService.save(contact);
        return "redirect:/";
    }

    @GetMapping("/contact/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Contact contact = contactListService.findById(id);
        if (contact != null) {
            model.addAttribute("contact", contact);
            return "actions";
        }
        return "redirect:/";
    }

    @PostMapping("/contact/edit")
    public String editContact(@ModelAttribute Contact contact) {
        contactListService.update(contact);
        return "redirect:/";
    }


    @GetMapping("/contact/delete/{id}")
    public String deleteContact(@PathVariable Long id) {
        contactListService.deleteById(id);
        return "redirect:/";
    }

}
