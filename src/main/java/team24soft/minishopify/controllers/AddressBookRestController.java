package team24soft.minishopify.controllers;

import team24soft.minishopify.models.AddressBook;
import team24soft.minishopify.models.BuddyInfo;
import team24soft.minishopify.repositories.AddressBookRepository;
import team24soft.minishopify.repositories.BuddyInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class AddressBookRestController {

    @Autowired
    AddressBookRepository addressBookRepository;
    @Autowired
    BuddyInfoRepository buddyInfoRepository;

    @GetMapping("/createBook")
    public AddressBook createBook(){

        AddressBook book = new AddressBook();

        addressBookRepository.save(book);

        return book;
    }

    @GetMapping("/addBuddy")
    public AddressBook addBuddy(@RequestParam(name="id", required = false,defaultValue = "1") long id,
                                @RequestParam(name="firstName", required = false,defaultValue = "") String firstName,
                                @RequestParam(name= "lastName", required = false,defaultValue = "") String lastName,
                                @RequestParam(name= "phone", required = false,defaultValue = "") String phone){

        AddressBook book = addressBookRepository.findById(id);

        BuddyInfo buddy = new BuddyInfo(firstName,lastName,phone);

        book.addBuddy(buddy);

        buddyInfoRepository.save(buddy);
        addressBookRepository.save(book);

        return book;
    }

    @GetMapping("/removeBuddy")
    public AddressBook removeBuddy(@RequestParam(name="bookId", required = false,defaultValue = "1") long idBook,
                                @RequestParam(name="firstName", required = false,defaultValue = "") long idBuddy){

        AddressBook book = addressBookRepository.findById(idBook);

        BuddyInfo buddy = buddyInfoRepository.findById(idBuddy);

        book.removeBuddy(buddy);

        addressBookRepository.save(book);

        return book;
    }

}