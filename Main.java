package Pack;
import java.util.*;
public class Main {
	static List<customerDetails> detail=new ArrayList<>();
	static Scanner sc=new Scanner(System.in);
	static loadCashToAtm a12=new loadCashToAtm();
	public static void main(String[] args) {
		customerdetails();
		a12.upadate_cash(20, 100, 100);
		int choice;
		do {
			System.out.println("-------------CustomerDetails&AtmProcess-------------");
			System.out.println("Enter 1 to Load Cash to ATM");
			System.out.println("Enter 2 to check Atm Balance");
			System.out.println("Enter 3 to know Customer Details");
			System.out.println("Enter 4 to perform ATM Operations");
			choice=sc.nextInt();
			switch(choice) {
			case 1:
			    loadcash();
				break;
			case 2:
				displayatmdenomenation();
				break;
			case 3:
				displaydetails();
				break;
	 		case 4:
	 			atmoperation();
	 			break;
	 		case 5:
	 		   break;
	 		 default:
	 			 System.out.println("Enter valid choice\n");
	 			 break;
			}
		}while(choice!=5);
	}
	static void atmoperation() {
		//
	}
	static void loadcash() {
		System.out.println("----------Load Cash---------");
	    System.out.println("Enter the count of rupees note:");
	    System.out.println("Enter count_2000");
	    int _2000=sc.nextInt();
	    System.out.println("Enter count_500");
	    int _500=sc.nextInt();
	    System.out.println("Enter count_100");
	    int _100=sc.nextInt();
	    a12.upadate_cash(_2000,_500,_100);
	    displayatmdenomenation();
	}
	static void customerdetails() {
		customerDetails a1=new customerDetails(139,"Prince",2343,25234);
		customerDetails a2=new customerDetails(105,"Aravinth",5432,34123);
		customerDetails a3=new customerDetails(160,"Vignesh",7854,26100);
		customerDetails a4=new customerDetails(132,"Naresh",2345,80000);
		customerDetails a5=new customerDetails(146,"Sendhooran",1907,103400);
        detail.addAll(Arrays.asList(a1,a2,a3,a4,a5));
	}
    static void displaydetails() {
    	System.out.println("------------------------Customer Details-----------------------");
		System.out.println("---------------------------------------------------------------");  
		System.out.printf("%8s %20s %12s %16s", "Acc No", "Account Holder", "Pin Number", "Account Balance");  
		System.out.println();  
		System.out.println("---------------------------------------------------------------");   
		for(customerDetails customerdeatail: detail)  {  
			System.out.format("%7s %14s %14s %16s",customerdeatail.getAccNo(), customerdeatail.getAhName(), customerdeatail.getsPin(), customerdeatail.getBalance());  
			System.out.println();  
		}  
		System.out.println("----------------------------------------------------------------");
		System.out.print("\n");
	}
    static void displayatmdenomenation() {
    	System.out.println("------------------Atm Balance-------------------");
		System.out.println("---------------------------------------------");  
		System.out.printf("%8s %12s %12s ", "Denomination", "Number", "Value");  
		System.out.println();  
		System.out.println("---------------------------------------------");  
		System.out.format("%7s %16s %12s ","2000", a12.getCount_2000(),a12.getTotal_2000());
		System.out.println();
		System.out.format("%7s %16s %12s ","500", a12.getCount_500(),a12.getTotal_500());  
		System.out.println();
		System.out.format("%7s %16s %12s ","100", a12.getCount_100(),a12.getTotal_100()); 
		System.out.println();
		System.out.println("---------------------------------------------- ");  
		System.out.print("\n");
    }
}
class loadCashToAtm{
   int count_2000=0;
   int count_500=0;
   int count_100=0;
   int total_2000=0;
   int total_500=0;
   int total_100=0;
   int atmbalance=0;
   public int getTotal_2000() {
	   return total_2000;
   }
   public void setTotal_2000(int total_2000) {
	   this.total_2000 = total_2000;
   }
   public int getTotal_500() {
	   return total_500;
   }
   public void setTotal_500(int total_500) {
	   this.total_500 = total_500;
   }
   public int getTotal_100() {
	   return total_100;
   }
   public void setTotal_100(int total_100) {
	   this.total_100 = total_100;
   }
   public int getAtmbalance() {
	   return atmbalance;
   }
   public void setAtmbalance(int atmbalance) {
	   this.atmbalance = atmbalance;
   }
   public int getCount_2000() {
	    return count_2000;
   }
   public void setCount_2000(int count_2000) {
        this.count_2000 = count_2000;
    }
   public int getCount_500() {
	   return count_500;
   }
   public void setCount_500(int count_500) {
	   this.count_500 = count_500;
    }
   public int getCount_100() {
	   return count_100;
    }
   public void setCount_100(int count_100) {
	   this.count_100 = count_100;
   }
   public void upadate_cash(int count_2000, int count_500, int count_100) {
	   this.count_2000+=count_2000;
	   this.count_500+=count_500;
	   this.count_100+=count_100;
	   total_2000=count_2000*2000;
	   total_500=count_500*500;
	   total_100=count_100*100;
       atmbalance=total_2000+total_500+total_100;
   }
   public boolean update_withdrawl(int amt,int _2000count,int _500count,int _100count) {
	   if(_2000count<=count_2000&&_500count<=count_500&&_100count<=count_100) {
		   count_2000-=_2000count;
		   count_500-=_500count;
		   count_100-=_100count;
		   total_2000-=_2000count*2000;
		   total_500-=_500count*500;
		   total_100-=_100count*100;
	       atmbalance-=amt;
		   return true;
	   }
	   return false;
   }   
}
class customerDetails{
	int accNo;
	String ahName;
	int sPin;
	int balance;
	public customerDetails(int accNo, String ahName, int sPin, int balance) {
		super();
		this.accNo = accNo;
		this.ahName = ahName;
		this.sPin = sPin;
		this.balance = balance;
	}
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public String getAhName() {
		return ahName;
	}
	public void setAhName(String ahName) {
		this.ahName = ahName;
	}
	public int getsPin() {
		return sPin;
	}
	public void setsPin(int sPin) {
		this.sPin = sPin;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public void updatebalance(int amt) {
		balance-=amt;
	}
	static loadCashToAtm a12=new loadCashToAtm();
	void customercashupdate(customerDetails obj,int amt,int _2000count,int _500count,int _100count) {
		if(amt<=obj.balance) {
    		if(a12.update_withdrawl(amt,_2000count,_500count,_100count)) {
    		  obj.updatebalance(amt);
    		} 
    		else {
    			System.out.println("Sorry! Atm Balance Is Low");
    		}
    	}
    	else {
    		System.out.println("Sorry! Your Account Balance Is Low");
    	}
	}
	public String toString() {
		return  accNo + ahName + sPin + balance;
	}	
}
class AtmOperations extends Main{
	customerDetails obj1;
	Scanner sc=new Scanner(System.in);
	public AtmOperations() {
		System.out.println("-------------ATM Operations--------------");
	    System.out.println("1)Check Balance");
	    System.out.println("2)Withdraw Money");
	    System.out.println("3)Transfer Money");
	    System.out.println("4)Check ATM balance");
	    System.out.println("5)Deposit amount");
	    int choice=sc.nextInt();
	    switch(choice) {
	    case 1:
	    	checkbalance();
	    	break;
	    case 2:
	    	withdrawmoney();
	    	break;
	    case 3:
	    	transfermoney();
	    	break;
	    case 4:
	    	atmbalance();
	    	break;
	    case 5:
	    	DepositAmount();
	    	break;
	    }
	}
	void checkbalance() {
		System.out.println("Enter Secret Pin");
		int pin=sc.nextInt();
		for(customerDetails customerdeatail: detail)  
		{  
			if(customerdeatail.getsPin()==pin){
				System.out.println(customerdeatail.getBalance());  
			}  
		}  	
	}
	void withdrawmoney() {
		System.out.println("Enter Secret Pin");
		int pin=sc.nextInt();
		for(customerDetails customerdeatail: detail)  
		{  
			if(customerdeatail.getsPin()==pin){
				obj1=customerdeatail;
				int amt;
				int flag=1;
				do{
					System.out.println("Enter Amount Multiples of 100 and less than 10000:");
					amt=sc.nextInt();
					if(amt>=100&&amt<=10000 && amt%100==0) {
						flag=0;
					}
				}while(flag!=0);
				int _2000count=0,_500count=0,_100count=0;
				int amt_copy=amt;
				while(amt>=100){
					if(amt>=2000){
						_2000count++;
						amt-=2000;
					}
					else if(amt>=500&&amt<2000) {
						_500count++;
						amt-=500;
					}
					else if(amt>=100&&amt<500) {
			            _100count++;
			            amt-=100;
					}
				}
				customerdeatail.customercashupdate(obj1,amt_copy, _2000count,_500count ,_100count);	 
			}		   
		}  	
	}
	void transfermoney() {
		System.out.println("Enter pin");
		int pin=sc.nextInt();
		for(customerDetails customerdeatail: detail)  
		{  
			if(customerdeatail.getsPin()==pin){
				customerDetails obj1=customerdeatail;
				moneyupdate(obj1);
			}
		}  		
	}
	void  moneyupdate(customerDetails obj) {
		System.out.println("Enter Account Holder Name:");
		System.out.println("Enter Account number to transfer:");
		int accno=sc.nextInt();
		for(customerDetails customerdeatail1: detail){  
			if(customerdeatail1.getAccNo()==accno){
				int amt;
				do {
					System.out.println("Enter Amount less than 10000:");
					amt=sc.nextInt();
				}while(amt>10000);
				if(obj.balance>=amt) {
					obj.balance-=amt;
					customerdeatail1.balance+=amt;
					System.out.println("Amount has been transfered successfully!");
				}
			}
		}
	}
	void atmbalance() {
		displayatmdenomenation();		
	}
	void DepositAmount() {
		System.out.println("Enter pin");
		int pin=sc.nextInt();
		for(customerDetails customerdeatail: detail)  
		{  
			if(customerdeatail.getsPin()==pin){
				System.out.println("Enter Amount to be Deposited:");
				int amount=sc.nextInt();
				customerdeatail.balance+=amount;
			}
		}  		
	}
}