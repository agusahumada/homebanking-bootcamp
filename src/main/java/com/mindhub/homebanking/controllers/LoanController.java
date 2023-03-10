package com.mindhub.homebanking.controllers;

import com.mindhub.homebanking.dtos.ClientDTO;
import com.mindhub.homebanking.dtos.LoanDTO;
import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.models.Loan;
import com.mindhub.homebanking.repositories.ClientRepository;
import com.mindhub.homebanking.repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;


@RestController
@RequestMapping("/api")
public class LoanController {

    @Autowired
    private LoanRepository loanRepository;

    @GetMapping("/loans")
    public List<LoanDTO> getClients() {
        return loanRepository.findAll().stream().map(LoanDTO::new).collect(toList());
    }

    @GetMapping("/loans/{id}")
    public LoanDTO getLoan(@PathVariable Long id) {
        Optional<Loan> clientOptional = loanRepository.findById(id);
        return loanRepository.findById(id).map(LoanDTO::new).orElse(null);
    }

}



