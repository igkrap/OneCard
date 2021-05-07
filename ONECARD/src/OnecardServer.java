public class OnecardServer {
	public OnecardServer() {
		
	}
	void makeRoom(int roomNo, int roomIP, int roomPort, String roomName) {
		Room newRoom=new Room(roomNo,roomIP,roomPort,roomName);
	}
}
