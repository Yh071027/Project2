class danli{
	private static danli  instance = new Singleton();
                private danli(){}
	public static danli getInstance() {
		return instance;
	}
}