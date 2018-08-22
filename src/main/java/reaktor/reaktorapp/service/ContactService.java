package reaktor.reaktorapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reaktor.reaktorapp.model.entity.Contact;
import reaktor.reaktorapp.repository.ContactRepository;

@Service
public class ContactService {
    ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Contact createContact(Contact contact){
        Contact savedContact = contactRepository.save(contact);
        return savedContact;
    }
}
