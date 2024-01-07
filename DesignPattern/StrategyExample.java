package DesignPattern;

interface taxpaystrategy{
	int  pay();
}


class India implements taxpaystrategy{

	@Override
	public int pay() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}



class Us implements taxpaystrategy{

	@Override
	public int pay() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}


class Taxpay{
	
	public void payTax(taxpaystrategy strategy) {
		 strategy.pay();
	}
	
}

public class StrategyExample {
	
	public static void main(String[] args) {
		
		Taxpay tax=new Taxpay();
		
		India in=new India();
		Us us=new Us();
		
		tax.payTax(in);
		tax.payTax(us);
		
	}

}
