package comfdmgroupjpaexercise2;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@NamedQuery(
		name= "Trainee.findByStream",
		query= "SELECT t FROM Trainee t WHERE t.stream = :trstream"
		)
@Entity
public class Trainee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator= "TR_SEQ_GNTR")
	@SequenceGenerator(name= "TR_SEQ_GNTR", sequenceName= "TR_SEQ")
	@Column(name= "STREAM_ID",
	nullable=false, unique = true)
	private int id;
	
	
	@Column(name="FIRST_NAME", nullable=false, updatable=false)
	private String firstName;
	
	@Column(name="LAST_NAME", nullable=false, updatable=false)
	private String lastName;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="FK_STREAM_ID", nullable=false)
	private Stream stream;
	
	
	public Trainee() {
		
	}
	
	public Trainee(String firstName, String lastName, Stream stream) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.stream = stream;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Stream getStream() {
		return stream;
	}
	public void setStream(Stream stream) {
		this.stream = stream;
	}
	
	

}
