package com.example.demo.entitiy;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
public class Member {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
        private Long id;
	    
	    @NotBlank(message = "Name is mandatory")
	    @Column(name = "name")
        private String name;
	    
	    @Column(name = "email")
	    @NotBlank(message = "Email is mandatory")
        @Email(message = "Email should be valid")
        private String email;
	    
	    //@JsonIgnore
	    @OneToMany(mappedBy = "member")
	    @JsonIgnore
	    private List<Loan> loans;
	    

	
}
