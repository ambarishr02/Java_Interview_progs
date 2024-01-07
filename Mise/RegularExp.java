import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.*;
	import java.io.*;
public class RegularExp {

	
	
	 
	/* Name of the class has to be "Main" only if the class is public. */

		public static void main (String[] args) throws java.lang.Exception
		{
			String myString = "https://local.camps.intuit.com:8443/camps-ams/v1/payrollsubscription?ein=345645673&license=399652640512849&canId=229720155&_=1592460696771";
			myString = myString.replaceAll("\\d*[&]", "*********");
			// OR myString = myString.replaceFirst("_[^.]*", "");
			
			
//			String reg="^[0-9]{3}\\.[0-9]{3}\\.[0-9]{4}$";
//			Pattern p= Pattern.compile(reg);
//			String str="546.123.6783";
//			Matcher m=p.matcher(str);
//			if(m.find()) {
//			//str=m.replaceAll();
//			}
//			System.out.println(str+":"+m.find());
			
			String mystr="{\"PSID\":\"107510405\",\"canId\":\"39037\",\"payrollLicenceNumber\":\"081158102870852\",\"Pin\":\"John0329\"}";
			
			mystr=mystr.replaceAll("payrollLicenceNumber\":\".*?\",","payrollLicenceNumber\":\"*************\",");
			mystr=mystr.replaceFirst("Pin\":\".*?\"","Pin\":\"*************\"");
			System.out.println(mystr);
//			
//			
//			String dd4v="\"PSID\":\"108166761\",\"canId\":\"712635328\",\"payrollLicenceNumber\":\"864599040853539\",\"Pin\":\"benjamiN4*\"}";
//			
//			String deact="Payload: {\"EIN\":[300055062],\"SubscriptionNumber\":\"595298\",\"canId\":\"431159856\",\"payrollLicenceNumber\":\"027282130494275\"}";
//			deact=deact.replaceAll("payrollLicenceNumber\":\".*?\"","payrollLicenceNumber\":\"*************\",");
//			deact=deact.replaceAll("EIN\":\\[.*?\\]","EIN\":\\[*******\\],");
			
			
			
			String maskedLogMessage= "Payload: {\"PSID\":\"107028962\",\"Company\":{\"EIN\":\"542155420\",\"PayrollAdmin\":{\"FirstName\":\"RYAN\",\"LastName\":\"AKAMINE\",\"EMail\":\"Administrator@GENIUSfile.org\",\"WorkPhone\":\"8082068282\"},\"LegalInfo\":{\"LegalName\":\"HAWAII FAMILY LAW CLINIC\",\"AddressLine1\":\"677 ALA MOANA BLVD STE 1005\",\"City\":\"Honolulu\",\"State\":\"HI\",\"Zip\":\"96813-5417\"},\"DBA\":\"HAWAII FAMILY LAW CLINIC\",\"MailingAddress\":{\"AddressLine1\":\"677 ALA MOANA BLVD STE 1005\",\"City\":\"Honolulu\",\"State\":\"HI\",\"Zip\":\"96813-5417\"},\"PrimaryPrincipal\":{\"FirstName\":\"Edwin\",\"LastName\":\"Flores\",\"EMail\":\"Ryan@GENIUSfile.org\",\"WorkPhone\":\"8085368000\"}},\"canId\":\"380520460\",\"payrollLicenceNumber\":\"965058864264286\"}";
			maskedLogMessage=maskedLogMessage.replaceFirst("EIN\":\".*?\",","EIN\":\"*************\"");
			maskedLogMessage=maskedLogMessage.replaceFirst("payrollLicenceNumber\":\".*?\"","payrollLicenceNumber\":\"*************\",");
			maskedLogMessage=maskedLogMessage.replaceAll("EMail\":\".*?\"","EMail\":\"*************\",");
			maskedLogMessage=maskedLogMessage.replaceAll("WorkPhone\":\".*?\"","WorkPhone\":\"*************\",");
			maskedLogMessage=maskedLogMessage.replaceAll("FirstName\":\".*?\"","FirstName\":\"*************\",");
			maskedLogMessage=maskedLogMessage.replaceAll("LastName\":\".*?\"","LastName\":\"*************\",");
			maskedLogMessage=maskedLogMessage.replaceAll("AddressLine1\":\".*?\"","AddressLine1\":\"*************\",");
			maskedLogMessage=maskedLogMessage.replaceAll("LegalName\":\".*?\"","LegalName\":\"*************\",");
			maskedLogMessage=maskedLogMessage.replaceAll("Zip\":\".*?\"","Zip\":\"*************\",");
			maskedLogMessage=maskedLogMessage.replaceAll("City\":\".*?\"","City\":\"*************\",");
;			maskedLogMessage=maskedLogMessage.replaceAll("DBA\":\".*?\"","DBA\":\"*************\",");
			
			
		//	updateDetails=updateDetails.replaceFirst("FirstName\":\".*?\"","FirstName\":\"*************\",");
			
		//	updateDetails=updateDetails.replaceFirst("PrimaryPrincipal\":\\{.*?\\}\"","PrimaryPrincipal\":\\{*************\\}\",");
		//	System.out.println(orignalLogMessage);
			
			
			
//			//deact=deact.replaceAll("EIN\":\\[\\d(?=(?:\\D*\\d){4})\\]","EIN\":\\[*\\],");
//			System.out.println(deact);
//			
			String consent="{\"feinValue\":\"541867732\",\"wccSignupDate\":\"06/22/2020\",\"wcConsentValue\":true}";
			consent=consent.replaceAll("feinValue\":\".*?\"","feinValue\":\"*************\",");
			System.out.println(consent);
			
			
			
			/*orignalLogMessage="{\"PSID\":\"108150622\",\"canId\":\"873938955\",\"payrollLicenceNumber\":\"531780175891292\",\"Services\":{\"DirectDepositService\":{\"BankAccount\":{\"BankName\":\"WELLS FARGO BANK NA\",\"AccountNumber\":\"6084877080\",\"RoutingNumber\":\"121042882\",\"QuickBooksName\":\"WELLS FARGO CHECKING\",\"AccountType\":\"CHECKING\",\"CreateRandomDebits\":false}}},\"ForceRandomDollar\":true}";
			orignalLogMessage=orignalLogMessage.replaceFirst("payrollLicenceNumber\":\".*?\"","payrollLicenceNumber\":\"*************\",");
			orignalLogMessage=orignalLogMessage.replaceFirst("AccountNumber\":\".*?\"","AccountNumber\":\"*************\",");
			orignalLogMessage=orignalLogMessage.replaceFirst("AccountType\":\".*?\"","AccountType\":\"*************\",");
			orignalLogMessage=orignalLogMessage.replaceFirst("BankName\":\".*?\"","BankName\":\"*************\",");
			orignalLogMessage=orignalLogMessage.replaceFirst("BankName\":\".*?\"","BankName\":\"*************\",");	
			System.out.println(orignalLogMessage);
			
			
			
			orignalLogMessage="Payload: {\"PSID\":\"104496893\",\"canId\":\"310781971\",\"payrollLicenceNumber\":\"362684723920718\",\"Services\":{\"DirectDeposit\":{\"BankAccount\":{\"RandomDebit1\":\"0.69\",\"RandomDebit2\":\"0.86\"}}}}";
			orignalLogMessage=orignalLogMessage.replaceFirst("payrollLicenceNumber\":\".*?\"","payrollLicenceNumber\":\"*************\",");
			orignalLogMessage=orignalLogMessage.replaceFirst("RandomDebit1\":\".*?\"","RandomDebit1\":\"****\"");
			orignalLogMessage=orignalLogMessage.replaceFirst("RandomDebit2\":\".*?\"","RandomDebit2\":\"****\"");
			System.out.println(orignalLogMessage);
			
			
			
			
			
			
			orignalLogMessage="Payload: {\"PSID\":\"106759260\",\"Pin\":\"Patrick13\",\"OldPin\":\"2032clyde\",\"canId\":\"288680357\",\"payrollLicenceNumber\":\"313446376585480\"}";
			orignalLogMessage=orignalLogMessage.replaceFirst("payrollLicenceNumber\":\".*?\"","payrollLicenceNumber\":\"*************\",");
			orignalLogMessage=orignalLogMessage.replaceFirst("Pin\":\".*?\"","Pin\":\"*************\"");
			orignalLogMessage=orignalLogMessage.replaceFirst("OldPin\":\".*?\"","OldPin\":\"*************\"");
			System.out.println(orignalLogMessage);
			
			orignalLogMessage="Payload: {\"CreatePinRequest\":{\"Pin\":\"Brandon1978\",\"PSID\":\"108149647\",\"canId\":\"952417317\",\"payrollLicenceNumber\":\"249026432071666\"}}";
			orignalLogMessage=orignalLogMessage.replaceFirst("payrollLicenceNumber\":\".*?\"","payrollLicenceNumber\":\"*************\",");
			orignalLogMessage=orignalLogMessage.replaceFirst("Pin\":\".*?\"","Pin\":\"*************\"");
			System.out.println(orignalLogMessage);*/
		}
	}

