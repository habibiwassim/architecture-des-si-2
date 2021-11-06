package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name="T_User")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	
	@Enumerated(EnumType.STRING)
	Role role;
	
	@Temporal(TemporalType.DATE)
	private Date date;
}
