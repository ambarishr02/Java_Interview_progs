package DesignPattern;

class Volt{
	
	int volt;
	Volt(int volt){
		this.volt=volt;
	}
	public int getVolt() {
		return volt;
	}
	public void setVolt(int volt) {
		this.volt = volt;
	}
	
	
}

class Socket {
	
	public Volt getVolt(){
		 return new Volt(240);
	}
}

interface Adaptor12Volt {
	Volt get12V();
}


class MobileAdaptorImpl implements Adaptor12Volt {
	
	Socket socket =new Socket();

	@Override
	public Volt get12V() {
		 int desiredVolt=12;
		 Volt stdVolt=socket.getVolt();
		 return convert(stdVolt, desiredVolt);
	}

	private Volt convert(Volt stdVolt, int desiredVolt) {
		// TODO Auto-generated method stub
		return null;
	}
	
}





public class AdaptorExample2 {
	
	public static void main(String[] args) {
		
	}

}
