package me.oskarscot.springdeed.service;

import me.oskarscot.springdeed.database.employer.EmployerRepository;
import me.oskarscot.springdeed.model.common.employer.Employer;
import org.springframework.stereotype.Service;

@Service
public class EmployerService {

  private final EmployerRepository employerRepository;

  public EmployerService(EmployerRepository employerRepository) {
    this.employerRepository = employerRepository;
  }

  public Employer save(Employer employer) {
    return employerRepository.save(employer);
  }

}
