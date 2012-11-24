

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;



public class GameRegistry {
	List<String> myUMoves = new ArrayList<String>();
	List<String> myCMoves = new ArrayList<String>();
	List<String> winnerList = new ArrayList<String>();
	List<Integer> uDoubleMoves = new ArrayList<Integer>();
	List<Integer> cDoubleMoves = new ArrayList<Integer>();

	/**
	 * Static default instance
	 */
	
	private static GameRegistry defaultInstance = createDefaultInstance();

	public static GameRegistry getDefault() {
		return defaultInstance;
		
	}
	
	/**
	 * Creates a default FountainRegistry Instance that 
	 *  is made by the parsing of the KML
	 * @throws IOException 
	 */
	private static GameRegistry createDefaultInstance() {
				
		GameRegistry made = new GameRegistry();
		return made;
	}

	public void addUMove(String move) {
		int size = myUMoves.size();
		myUMoves.add(move);
		if (size >= 1) {
			if (myUMoves.get(size - 1).equals(move)) {
				uDoubleMoves.add(size);
			}
		}
	}
	
	public void addCMove(String move) {
		int size = myCMoves.size();
		myCMoves.add(move);
		if (size >= 1) {
			if (myCMoves.get(size - 1).equals(move)) {
				cDoubleMoves.add(size);
			}	
		}
	}
	
	public void addWinner(int winner) {
		if (winner == 1)
			winnerList.add("User");
		else winnerList.add("Computer");
		
	}
	
	public void printMoves() {
		System.out.println("User moves: ");
		System.out.println(myUMoves);
		System.out.println(uDoubleMoves);
		System.out.println("Computer moves: ");
		System.out.println(myCMoves);
		System.out.println(cDoubleMoves);
	}


}