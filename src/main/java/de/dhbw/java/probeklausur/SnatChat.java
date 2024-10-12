package de.dhbw.java.probeklausur;

import de.dhbw.java.probeklausur.Account;
import de.dhbw.java.probeklausur.SnatChatRoom;
import de.dhbw.java.probeklausur.SnatChatWindow;

public class SnatChat {
	
	public static void main(String[] args) {
		SnatChatRoom room = new SnatChatRoom("GansGeheim");
		
		room.register( new SnatChatWindow(room, new Account("Bob") ) );
		room.register( new SnatChatWindow(room, new Account("Alice") ) );
	}
	
}
