package reaktor.reaktorapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import reaktor.reaktorapp.model.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
