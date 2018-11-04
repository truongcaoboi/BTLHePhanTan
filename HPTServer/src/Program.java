import communication.Communication;

public class Program {
	public static String UpdateUID;
	public static String UpdateCID;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Communication middle1=new Communication();
		Communication middle2=new Communication();
		Thread exeMiddle1=new Thread() {
			@Override
			public void run() {
				middle1.ExecuteCommunication();
			}
		};
		Thread exeMiddle2=new Thread() {
			@Override
			public void run() {
				middle2.ExecuteCommunication();
			}
		};
		exeMiddle1.setDaemon(true);
		exeMiddle2.setDaemon(true);;
		exeMiddle1.start();
		exeMiddle2.start();
	}
}
