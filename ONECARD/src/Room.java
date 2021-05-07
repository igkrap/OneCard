public class Room {
	int RoomIP;
	int RoomPort;
	String RoomName;
	public Room(int roomIP, int roomPort, String roomName) {
		RoomIP=roomIP;
		RoomPort=roomPort;
		RoomName=roomName;
	}
	public void addPlayer() {
		
	}
	public void startGame() {
		Game game=new Game();
	}
}
