package com.example.demo.entitiy;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "Loan date is mandatory")
    @Column(name = "loanDate")
    private LocalDateTime loanDate;

    @NotNull(message = "Return date is mandatory")
    @Column(name = "returnDate")
    private LocalDateTime returnDate;

   
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    @NotNull(message = "Book must be specified")
    private Book book;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    @NotNull(message = "Member must be specified")
    private Member member;
}
