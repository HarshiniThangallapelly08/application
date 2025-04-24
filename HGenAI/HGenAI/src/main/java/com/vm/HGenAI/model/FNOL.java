package com.vm.HGenAI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class FNOL {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100, message = "Policyholder name must not exceed 100 characters")
    private String policyholderName;

    @NotNull
    @Pattern(regexp = "^[A-Z][0-9]{7}$", message = "Policy number must start with an uppercase letter followed by 7 digits")
    private String policyNumber;

    @NotNull
    @PastOrPresent(message = "Policy start date must be less than or equal to the current date")
    private LocalDate policyStartDate;

    @NotNull
    private LocalDate policyEndDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPolicyholderName() {
        return policyholderName;
    }

    public void setPolicyholderName(String policyholderName) {
        this.policyholderName = policyholderName;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public LocalDate getPolicyStartDate() {
        return policyStartDate;
    }

    public void setPolicyStartDate(LocalDate policyStartDate) {
        this.policyStartDate = policyStartDate;
    }

    public LocalDate getPolicyEndDate() {
        return policyEndDate;
    }

    public void setPolicyEndDate(LocalDate policyEndDate) {
        if (policyStartDate != null && policyEndDate.isBefore(policyStartDate)) {
            throw new IllegalArgumentException("Policy end date must be greater than or equal to the policy start date");
        }
        this.policyEndDate = policyEndDate;
    }
}