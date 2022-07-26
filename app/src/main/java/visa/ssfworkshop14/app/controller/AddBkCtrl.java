package visa.ssfworkshop14.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import visa.ssfworkshop14.app.model.Contact;
import visa.ssfworkshop14.app.service.ContactsRedis;

@Controller
public class AddBkCtrl {

    @Autowired
    ContactsRedis service;
    
    @GetMapping("/")
    public String showAddressbookForm(Model model){
        model.addAttribute("contact", new Contact());
        return"addressbook";
    }
    @PostMapping("/addressbook")
    public String saveContact(@ModelAttribute Contact contact, Model model){
        Contact c = new Contact(
                contact.getName(),
                contact.getEmail(),
                contact.getPhoneNum());
        service.save(c);
        model.addAttribute("contact", c);
        return "showContact";
    }

    @GetMapping("/addressbook/{contactId}")
    public String getContactById(Model model, @PathVariable(value="contactId") String contactId){
        Contact cc = service.findById(contactId);
        model.addAttribute("contact", cc);
        return "showContact";
    }
}
