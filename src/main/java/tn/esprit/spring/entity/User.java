package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Table(name="T_User")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	@NonNull
	private String firstName;
	@NonNull
	private String lastName;
	
	@NonNull @Enumerated(EnumType.STRING)
	Role role;
	
	@NonNull @Temporal(TemporalType.DATE)
	private Date date;
}
