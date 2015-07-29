package testjsonxml;

public class Package {
	private int id;
	private String name;
	private String left;
	private String right;
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
	public String getLeft() {
		return left;
	}
	public void setLeft(String left) {
		this.left = left;
	}
	public String getRight() {
		return right;
	}
	public void setRight(String right) {
		this.right = right;
	}
	public Package(int id, String name, String left, String right) {
		super();
		this.id = id;
		this.name = name;
		this.left = left;
		this.right = right;
	}
	
}
