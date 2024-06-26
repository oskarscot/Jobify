package me.oskarscot.springdeed.database.employer;

import me.oskarscot.springdeed.model.common.employer.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employer, Integer> {


}
