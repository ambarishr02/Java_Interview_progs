package DesignPattern;

interface v1{
	
}

interface v2{
	public Object call(Object ob);
}




class DownStream implements v2 {

	@Override
	public Object call(Object ob) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

interface V2toV1Adaptor{

	public Object getBillingProfile(Object v2obj);
	public Object getEntitlements(Object v2obj);
}

class V2toV1AdaptorImpl  implements V2toV1Adaptor{
	
	DownStream downstream=new DownStream();

	@Override
	public Object getBillingProfile(Object v2obj) {
		//downstream.call(ob)
		return null;
	}

	@Override
	public Object getEntitlements(Object v2obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}


public class V2toV1AdaptorExample{
	public static void main(String[] args) {
		
	}
}