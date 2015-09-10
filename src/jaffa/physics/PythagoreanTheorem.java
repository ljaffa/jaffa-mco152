package jaffa.physics;

public class PythagoreanTheorem {
	
	private double a;
	private double b;
	private double c;
	
	/*public PythagoreanTheorem(double a, double b, double c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	//set values of A and B and computes C
	public void setAB(){
		this.c = (a * a) + (b * b); 
	}
	
	//set values of A and C and computes B
	public void setAC(){
		this.b = (c * c) - (a * a);
	}
	
	//set values of B and C and computes A
	public void setBC(){
		this.a = (c * c) - (b * b);
	}
	
	public double getA(){
		return a;
	}
	public double getB(){
		return b;
	}
	public double getC(){
		return c;
	}*/
	
	public PythagoreanTheorem(){
		
	}
	
	public void setAB(double a, double b){
		this.c = Math.sqrt((a * a) + (b * b)); 
	}
	
	//set values of A and C and computes B
	public void setAC(double a, double c){
		this.b = (c * c) - (a * a);
		this.b = Math.sqrt(b);
	}
	
	//set values of B and C and computes A
	public void setBC(double b, double c){
		this.a = Math.sqrt((c * c) - (b * b));
	}
	
	public double getA(){
		return a;
	}
	public double getB(){
		return b;
	}
	public double getC(){
		return c;
	}
	
	
}
