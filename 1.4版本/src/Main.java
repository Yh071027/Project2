public class Main {
     public static void main(String[] args) {
    	 Customer customer=new Customer("�˿�С��");
    	 customer.addRental(new Rental(new Movie("����ѩ��Ե2��",1),5));
    	 customer.addRental(new Rental(new Movie("������֮�ӡ�",2),6));
    	 customer.addRental(new Rental(new Movie("������������4��",0),7));
    	 System.out.println("�����嵥��"+"\n"+customer.statemant());
     }
}
