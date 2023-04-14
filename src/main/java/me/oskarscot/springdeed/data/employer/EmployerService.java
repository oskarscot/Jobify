package me.oskarscot.springdeed.data.employer;

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
