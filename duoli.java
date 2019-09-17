public class duoli {
	private static duoli a = new duoli();
	private static duoli b = new duoli();
	private duoli(){	
	}
	public static duoli getInstance(int num){
		if(num == 1){
			return a;
		}
		return b;
	}
	
}