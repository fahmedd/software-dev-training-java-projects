package comfdmgroupjpaexercise2;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@NamedQuery(
	name= "Stream.findByStreamName",
	query= "SELECT s FROM Stream s WHERE s.name LIKE :stName"
	)
@Entity
@Table(name="STREAM")
public class Stream {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator= "ST_SEQ_GNTR")
	@SequenceGenerator(name= "ST_SEQ_GNTR", sequenceName= "ST_SEQ")
	@Column(name= "STREAM_ID",
			nullable=false)
	private int id;
	
	@Column(name= "STREAM_NAME",
			nullable=false, unique = true)
	private String name;
	
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name="STREAM_MODULE", 
	joinColumns=
	@JoinColumn(name= "FK_STREAM_ID",
			nullable=false),
	inverseJoinColumns=
	@JoinColumn(name="FK_MODULE_ID")
	)
	private List<Module>modules;

	
	public Stream() {}
	
	public Stream(String name, List<Module>modules) {
		this.name=name;
		this.modules= modules;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}
	
	

}
