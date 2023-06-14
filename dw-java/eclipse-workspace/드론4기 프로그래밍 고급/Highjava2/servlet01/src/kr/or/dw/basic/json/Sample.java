package kr.or.dw.basic.json;

public class Sample {
	private int id;
	private String name;
	
	// 기본 생성자
	public Sample() {}

	public Sample(int id, String name) {
		this.id = id;
		this.name = name;
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
	};
	
	
	
}
