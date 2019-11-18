package ���żƷ�ϵͳ;

import java.util.*;
public class TelcomUser {
	public String phonenumber;//����
	public String callTo;//����
	public StringBuffer communicationRecords;
	public TelcomUser(String phonenumber) {
		this.phonenumber=phonenumber;
		this.callTo = getCallToPhoneNumber();
		this.communicationRecords=new StringBuffer();
		//ͨ����¼����communicationRecords��ֺ������ÿ����¼�ڲ������к��룬���к��룬��ʼʱ�䣬����ʱ��
	}
	//ģ��ͨ����¼������
	void createCommunicateRecord() {
		//�������ͨ����¼��Ŀ
		int recordNum=new Random().nextInt(10);
		for(int i=0;i<=recordNum;i++) {
			//��i��ͨ����¼���������
			//��ʼʱ�䣬��ǰʱ��֮ǰ��ĳ�����ʱ��
			long timeStart = System.currentTimeMillis()-new Random().nextInt(36000000);
			//����ʱ�䣬��ʼ���ʮ�����������һ��ʱ�䣬����һ����
			long timeEnd = timeStart+60000+new Random().nextInt(600000);
			//���к��룬������ɣ�����λ�����������
			this.callTo= getCallToPhoneNumber();
			//����ͨ����¼
			this.communicationRecords.append(this.phonenumber+
					","+timeStart+
					","+timeEnd+
					","+this.callTo+
					";");
		}
	}
	public String getCallToPhoneNumber() {
		return "1378252" + String.valueOf(new Random().nextInt(10))
		+String.valueOf(new Random().nextInt(10))
		+String.valueOf(new Random().nextInt(10))
		+String.valueOf(new Random().nextInt(10));
	}
	//ģ��Ʒѷ��������ַ�������ʽ���ر���4λС���ļƷѽ��
	public String accountFee(long timeStart,long timeEnd) {
		//ÿ�����շ�*Ԫ
		double feePerMinute=0.2;
		//ͨ���������������������
		int minutes=Math.round((timeEnd-timeStart)/60000);
		double feeTotal=feePerMinute*minutes;
		return String.format("%.4f",feeTotal);
	}
	//��ӡͨ����¼
	void printDetails() {
		//��ȡȫ��ͨ����¼
		String allRecords=this.communicationRecords.toString();
		//�ָ�ͨ����¼
		String [] recordArray=allRecords.split(";");
		//ѭ���ָ��¼�ڵ�ÿһ�����
		for(int i=0;i<recordArray.length;i++) {
			String [] recordField=recordArray[i].split(",");
			System.out.println("���У�"+recordField[0]);
			System.out.println("���У�"+recordField[3]);
			System.out.println("ͨ����ʼʱ�䣺"+new Date(Long.parseLong(recordField[1])));
			System.out.println("ͨ������ʱ�䣺"+new Date(Long.parseLong(recordField[2])));
			System.out.println("�Ʒѣ�"+accountFee(Long.parseLong(recordField[1]),Long.parseLong(recordField[2]))+
					"Ԫ");
		}
	}
}