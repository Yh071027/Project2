package TreeSet;

import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.*;
public class TelcomUser {
	private String phoneNumber;
	private String callTo;
	@SuppressWarnings("rawtypes")
	private Vector communicationRecords;
	@SuppressWarnings("rawtypes")
	//private HashSet callToNumbers;
	private TreeSet callToNumbersSet;
	private ArrayList callToNumbersList;
	private HashSet callToNumberHashSet;
	public TelcomUser(String phoneNumber){
		this.phoneNumber=phoneNumber;
		this.communicationRecords=new Vector();
       //this.callToNumbersSet=new TreeSet(); 
       this.callToNumbersList=new ArrayList();
		this.callToNumbersSet=new TreeSet();
		this.callToNumberHashSet=new HashSet();
		
		//假定通话记录存在总理，以分号隔开；每条记录内部都有主叫和被叫、开始和结束时间
	}
	@SuppressWarnings("unchecked")
	void generateCommubicateRecord(){
		//随机生成通话记录数目
		int recordNum=new Random().nextInt(10);
		for(int i=0;i<=recordNum;i++){
			//随机生成第i条通话记录
			//开始时间，当前时间之前的某个随机时间
			//用System.currentTimeMillis()精确到毫秒
			long timeStart=System.currentTimeMillis()-new Random().nextInt(36000000);
			//结束时间开始后的十分钟内随机的一个时间，至少一分钟
			long timeEnd=timeStart+60000+new Random().nextInt(600000);
			//用Calendar获取当前时间
			Calendar cal=Calendar.getInstance();
			//随机减去若干小时（10小时以内）
			cal.add(Calendar.HOUR,-new Random().nextInt(10));
			//获得对应毫秒
			//long timeStart=cal.getTimeInMillis();
			//结束时间开始后的十分钟内随机的一个时间，至少一分钟
			//long timeEnd=timeStart+60000+new Random().nextInt(600000);
			
			//被叫号码
			this.callTo=getCallTophoneNumber();
			this.callToNumbersSet.add(this.callTo);
			//插入通话记录
			this.communicationRecords.add(this.phoneNumber+
					","+timeStart+","+timeEnd+
					","+this.callTo+
					";");
	}
	}
	//随机生成被叫号码（后四位随机）并返回
	private String getCallTophoneNumber(){
		return "1378252185"+String.valueOf(new Random().nextInt(10));
	}
	//模拟计费方法，以字符串的形式返回保留四位小数点计费结果
	private String accountFee(long timeStart,long timeEnd){
		//每分钟计费N元
		double feePerMinute=0.2;
		//通话分钟数按四舍五入计算
		int minutes=Math.round((timeEnd-timeStart)/60000);
		double feeTotal=feePerMinute * minutes;
		return String.format("%.4f",feeTotal);
	}
	//打印通话记录
	void printDetails(){
		//使用Enumeration接口遍历，注意应将communicationRecords定义为Vector
		Enumeration enumeration=this.communicationRecords.elements();
		while(enumeration.hasMoreElements()){
			System.out.println("---------通话记录分割线------");
		    String [] recordField=((String)enumeration.nextElement()).split(",");
			System.out.println("主叫："+recordField[0]);
			System.out.println("被叫："+recordField[3]);
			Date timeStart=new Date(Long.parseLong(recordField[1]));
			Date timeEnd=new Date(Long.parseLong(recordField[2]));
			DateFormat mediumFormat=DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");
		//	System.out.println("通话开始时间："+new Date(Long.parseLong(recordField[1])));
			//System.out.println("通话结束时间："+new Date(Long.parseLong(recordField[2])));
			System.out.println("通话开始时间："+simpleDateFormat.format(timeStart));
			System.out.println("通话结束时间：" + simpleDateFormat.format(timeEnd));
		//	System.out.println("通话结束时间："+new Date(Long.parseLong(recordField[2])));
			System.out.println("计费："
					+accountFee(Long.parseLong(recordField[1]),Long.parseLong(recordField[2]))
					+"元 。");
			//包装类Long的larseLong方法。可以将String转成Long 
		}
	}
	public void printCallToNumber() {
		for(Object callTo:this.callToNumbersList){
			System.out.println((String)callTo);
		}
		System.out.println("------List/TreeSet分割线-------");
		for(Object callTo:this.callToNumbersSet){
		System.out.println((String)callTo);
		}
	}
}

