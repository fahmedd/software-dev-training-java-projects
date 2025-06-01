package comfdmgroupExercise3;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@NamedQuery (
		name= "Company.findByName",
		query= "SELECT c FROM Compnay c WHERE c.name = :CNAME")

@Entity
@Table(name="COMPANY")
public class Compnay extends BankCustomer{

	@Column(name="COMPANY_NAME", nullable=false, unique= true)
	private String name;
	
	@Column(name="COMPANY_ABN", nullable= false, unique= true)
	private long abn;
	
	public Compnay() {};
	

	public Compnay(String name, long abn, String address) {
		super(address);
		this.name = name;
		this.abn = abn;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getAbn() {
		return abn;
	}
	public void setAbn(long abn) {
		this.abn = abn;
	}
	
}
