package project1.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project1.dao.BookDAO;
import project1.dao.PersonDAO;
import project1.models.Book;
import project1.models.Person;


import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/people")
public class PersonController {
    @Autowired
    private PersonDAO personDAO;

    @Autowired
    private BookDAO bookDAO;

    @GetMapping
    public String index(Model model) {
        List<Person> people = personDAO.getAllPerson();
        model.addAttribute("people", people);
        return "/people/index";
    }

    @GetMapping("/{personId}")
    public String show(@PathVariable("personId") int personId, Model model) {
        List<Book> personsBooks = bookDAO.findPersonsBooks(personId);
        model.addAttribute("person", personDAO.findPersonById(personId));
        model.addAttribute("personsBooks", personsBooks);
        model.addAttribute("bookPersons", personsBooks.get(personId));
        return "/people/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "/people/new";
    }

    @PostMapping("/createPerson")
    public String create(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "/people/new";

        personDAO.save(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", personDAO.findPersonById(id));
        return "/people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "/people/edit";

        personDAO.update(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        personDAO.delete(id);
        return "redirect:/people";
    }
}
