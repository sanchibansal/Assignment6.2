import java.util.*;
//user defined exception
class BankATMException extends ArithmeticException{
	public BankATMException(){
		super("Balance is either less than 10000 or amount requested to withdraw is more than the deposit");
	}
}
class BankAtm1 {
	Scanner g= new Scanner(System.in);
	int atmId;
	String bankName;
	String location;
	double BALANCE=12345;			//if balance is less than 10000 it throws an error
	void withdraw(double amt){		
		if (BALANCE<10000 || amt>BALANCE){	//throws exception if the given conditions are not fulfilled
			throw new BankATMException() ;
		}
		else{
			System.out.println("amount withdrawn= "+amt);
			BALANCE=BALANCE-amt;					//new balance
			System.out.println("press 1 to show balance \npress 2 to exit");
			int k=g.nextInt();
			switch(k){
			     case 1:{
				      show();			//calls the show method to display the balance
				      break;
			     }     
			     case 2:{
				      break;
			     }
			}
		}
	}
	void deposit(double amt){
		System.out.println("amount deposited"+amt);
		BALANCE= BALANCE+amt;					//new balance
		System.out.println("press 1 to show balance \npress 2 to exit");
		int k=g.nextInt();
		switch(k){
		    case 1:{
			    show();     //calls the show method to display the balance
			    break;
		    }
		    case 2:{
			    break;
		    }
		}
	}
	void show(){
		System.out.println("your balance= " +BALANCE);
	}
}
class Bank{
	public static void main(String args[]){
		Scanner g= new Scanner(System.in);
		int Id;
		double amt;
		BankAtm1 b1= new BankAtm1();		// 3 objects created 
		BankAtm1 b2= new BankAtm1();
		BankAtm1 b3= new BankAtm1();
		try{
		    System.out.println("enter pin");		//correct pin =7891
		    Id=g.nextInt();
		    if(Id==7891){
			System.out.println("press 1 to withdraw \npress 2 to deposit \npress 3 to show balance" );
		    	int a=g.nextInt();
			switch(a){ 
			        case 1:{
				         System.out.println("enter amount to be withdrawn=");
				         amt=g.nextDouble();
				         b1.withdraw(amt);
				         break;
				 }
			        case 2:{
				         System.out.println("enter amount to be deposited");
				         amt=g.nextDouble();
				         b1.deposit(amt);
				         break;
			        }
			        case 3:{
				         b1.show();
				         break;
			        }
		         }
		    }
		    else{
			    System.out.println("incorrect pin.");
		    }
		}
		catch(BankATMException e){			//any exceptions in the above block calls the exception 
			System.out.println(e);
		}
	}
}
