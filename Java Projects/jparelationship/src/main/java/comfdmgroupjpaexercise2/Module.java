package comfdmgroupjpaexercise2;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="MODULE")
public class Module {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator= "MO_SEQ_GNTR")
	@SequenceGenerator(name= "MO_SEQ_GNTR", sequenceName= "MO_SEQ")
	@Column(name= "MODULE_ID",
	nullable=false,length=2)
	private int id;
	
	@Column(name= "MODULE_NAME",
			nullable=false, unique = true)
	private String name;
	
	@ManyToMany(mappedBy= "modules")
	private List<Stream> streams;
	
	public Module() {}
	
	public Module(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	};
	
	public void setId(int id) {
		this.id=id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Stream> getStreams() {
		return streams;
	}

	public void setStreams(List<Stream> streams) {
		this.streams = streams;
	}
	
	
	
	
	
	
}
