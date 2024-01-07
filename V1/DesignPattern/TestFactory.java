package DesignPattern;

abstract class Computer {

	public abstract String getRAM();
	public abstract String getHDD();
	public abstract String getCPU();
}

class PC extends Computer {
	private String RAM;
	private String HDD;
	private String CPU;

	@Override
	public String getRAM() {
		
		return this.RAM;
	}

	@Override
	public String getHDD() {
		// TODO Auto-generated method stub
		return this.HDD;
	}

	@Override
	public String getCPU() {
		// TODO Auto-generated method stub
		return this.CPU;
	}

	public PC(String rAM, String hDD, String cPU) {
		super();
		RAM = rAM;
		HDD = hDD;
		CPU = cPU;
	}
	
	
 
}

class Server extends Computer {
	
	private String RAM;
	private String HDD;
	private String CPU;
	
	@Override
	public String getRAM() {
		
		return this.RAM;
	}

	@Override
	public String getHDD() {
		
		return this.HDD;
	}

	@Override
	public String getCPU() {
		
		return this.CPU;
	}

	public Server(String rAM, String hDD, String cPU) {
		super();
		RAM = rAM;
		HDD = hDD;
		CPU = cPU;
	}
	

}


class Factory{
	public static Computer getComputer(String type) {
	if(type.equals("PC"))
		return new PC("","","");
    if(type.equals("Server"))
    	return new Server("","","");
	return null;
}
}

public  class TestFactory {

	public static void main(String[] args) {
			System.out.println(Factory.getComputer("PC"));
	}

}
