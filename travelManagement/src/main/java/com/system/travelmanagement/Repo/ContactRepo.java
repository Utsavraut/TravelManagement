package com.system.travelmanagement.Repo;
import com.system.travelmanagement.Entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepo extends JpaRepository<Contact,Integer> {
}
