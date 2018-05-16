package vavrtest;

public class Sample {
	public String prop1;
	public String prop2;
	public String prop3;

	public Sample() {
	}

	public Sample(String prop1, String prop2, String prop3) {
		super();
		this.prop1 = prop1;
		this.prop2 = prop2;
		this.prop3 = prop3;
	}

	@Override
	public String toString() {
		return "Sample [prop1=" + prop1 + ", prop2=" + prop2 + ", prop3=" + prop3 + "]";
	}

}