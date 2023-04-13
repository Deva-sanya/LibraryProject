package project1.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project1.models.Book;
import project1.models.Person;
import project1.repositories.PersonRepository;
import project1.services.BooksService;
import project1.services.PeopleService;
import project1.util.PersonValidator;


import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/people")
public class PersonController {

    private PeopleService peopleService;
    private BooksService booksService;
    private PersonValidator personValidator;

    @Autowired
    public PersonController(PeopleService peopleService, PersonValidator personValidator, BooksService booksService) {
        this.peopleService = peopleService;
        this.personValidator = personValidator;
        this.booksService= booksService;
    }


    @GetMapping
    public String index(Model model) {
        List<Person> people = peopleService.findAllPeople();
        model.addAttribute("people", people);
        return "/people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", peopleService.findPersonById(id));
        List<Book> personsBooks = booksService.findPersonsBooks(id);
        model.addAttribute("books", personsBooks);
        return "/people/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "/people/new";
    }

    @PostMapping("/createPerson")
    public String create(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult) {
        personValidator.validate(person, bindingResult);

        if (bindingResult.hasErrors())
            return "/people/new";

        peopleService.savePerson(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", peopleService.findPersonById(id));
        return "/people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "/people/edit";

        peopleService.updatePerson(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        peopleService.delete(id);
        return "redirect:/people";
    }
}
