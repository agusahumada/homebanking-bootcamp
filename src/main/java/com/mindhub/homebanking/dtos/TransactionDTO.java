package com.mindhub.homebanking.dtos;

import com.mindhub.homebanking.models.Transaction;
import com.mindhub.homebanking.models.TransactionType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class TransactionDTO {

    private Long id;

    private double amount;

    private String description;

    private LocalDateTime date;

    private TransactionType type;

    public TransactionDTO(Long id, double amount, String description, LocalDateTime date, TransactionType type) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.date = date;
        this.type = type;
    }

    public TransactionDTO(Transaction transaction){
        this.id= transaction.getId();
        this.amount= transaction.getAmount();
        this.description= transaction.getDescription();
        this.date=transaction.getDate();
        this.type=transaction.getType();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        String descripcionFinal=descripcionFinal=this.description;
            switch (this.type){
                case CREDIT :descripcionFinal= descripcionFinal + " -  CREDIT";
                break;
                case DEBIT: descripcionFinal= descripcionFinal + " -  DEBIT";
                break;
                default: descripcionFinal= descripcionFinal+ " - ERROR";
            }

        if (this.date.toLocalDate().isEqual(LocalDate.now())) {
            descripcionFinal = descripcionFinal + "- Actual";
        }else if (this.date.toLocalDate().isBefore(LocalDate.now())) {
            descripcionFinal = descripcionFinal + "- Anterior";
        } else if (this.date.toLocalDate().isAfter(LocalDate.now())) {
            descripcionFinal = descripcionFinal + "- Marty McFly?";
        }

        return descripcionFinal;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }


}
