package bean;

public class Home {
	private int id;
	private String name;
	private Bed bed;
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
	public Bed getBed() {
		return bed;
	}
	public void setBed(Bed bed) {
		this.bed = bed;
	}
	@Override
	public String toString() {
		return "Home [id=" + id + ", name=" + name + ", bed=" + bed + "]";
	}
	
	
}
