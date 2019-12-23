import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Set;

public class DBUtil {
     private static DBUtil instance = null;
     private HashMap<String, User> users = new HashMap<String,User>();
     private FileInputStream fs;
     private FileOutputStream fos;
     
     private DBUtil() throws Exception{
    	 getUsersFormInputStream("user.txt");
     }
     public void getUsersFormInputStream(String isName) throws Exception {
    	 fs=new FileInputStream(isName);
    	 byte[] content=new byte[1024];
    	 int i=0;
    	 int conInteger=0;
    	 while(true) {
    		 conInteger=fs.read();
    		 if(-1==conInteger) {
    			 break;
    		 }else if('\r'==(char)conInteger||'\n'==(char)conInteger) {
    			 this.processUserString(new String(content,"GBK").trim());
    			 i=0;
    		 }else {
    			 content[i]=(byte)conInteger;
    			 i++;
    		 }
    	 }
     }
     public void processUserString(String userString) {
    	 String[] userFields=userString.split(",");
    	 User u=new User();
    	 u.setCardId(userFields[0]);
    	 u.setCardPwd(userFields[1]);
    	 u.setUseName(userFields[2]);
    	 u.setCall(userFields[3]);
    	 u.setAmount(Integer.parseInt(userFields[4]));
    	 users.put(u.getCardId(), u);
     }
     public void addUser(User u) {
    	 users.put(u.getCardId(),u);
     }
     public void update() throws Exception {
    	 Set<String> userSet=users.keySet();
    	 StringBuffer uStringBuffer=new StringBuffer();
    	 for(String cardId:userSet) {
    		 User u=(User)users.get(cardId);
    		 String uString=u.getCardId()+","
    				 +u.getCardPwd()+","
    				 +u.getUserName()+","
    				 +u.getCall()+","
    				 +u.getAccount()+"\r\n";
    		 uStringBuffer.append(uString);
    	 }
    	 putUsersToFile(uStringBuffer.toString(),"user.txt");
     }
     private void putUsersToFile(String uString,String osName) throws Exception {
    	 fos=new FileOutputStream(osName);
    	 fos.write(uString.getBytes("GBK"));
     }
     public static DBUtil getInstance() throws Exception{
    	 if(instance == null){
    		 synchronized (DBUtil.class){
    			 if(instance == null){
    				 instance = new DBUtil();
    			 }
    		 }
    	 }
		return instance;
     }
     public User getUser(String cardId){
    	 User user = (User) users.get(cardId);
    	 return user;
     }
     public HashMap<String,User> getUsers(){
    	 return users;
     }
}