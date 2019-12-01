public class Main {
     public static void main(String[] args) {
    	 Customer customer=new Customer("顾客小李");
    	 customer.addRental(new Rental(new Movie("《冰雪奇缘2》",1),5));
    	 customer.addRental(new Rental(new Movie("《天气之子》",2),6));
    	 customer.addRental(new Rental(new Movie("《复仇者联盟4》",0),7));
    	 System.out.println("租用清单："+"\n"+customer.statemant());
     }
}
