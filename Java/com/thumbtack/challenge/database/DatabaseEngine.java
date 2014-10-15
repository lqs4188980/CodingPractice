package com.thumbtack.challenge.database;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class DatabaseEngine {
	private static DatabaseEngine engine = null;
	private static final HashMap<String, Integer> commandDb = new HashMap<String, Integer>();
	private static DB db = null;
	private LinkedList<DB> cache = new LinkedList<DB>();
	private DatabaseEngine() {
		db = new DB();
		commandDb.put("SET", 3);
		commandDb.put("GET", 2);
		commandDb.put("NUMEQUALTO", 2);
		commandDb.put("UNSET", 2);
		commandDb.put("END", 1);
		commandDb.put("BEGIN", 1);
		commandDb.put("ROLLBACK", 1);
		commandDb.put("COMMIT", 1);
	}
	
	
	public static DatabaseEngine getInstance() {
		if (engine == null) {
			engine = new DatabaseEngine();
			return engine;
		} else {
			return engine;
		}
	} 
	
	// Read commands
	public void commandReader() {
		Scanner scanIn = new Scanner(System.in);
		while (true) {
			String rawIn = scanIn.nextLine();
			String[] formalizer = rawIn.split(" ");
			formalizer[0] = formalizer[0].toUpperCase();
			if (!commandValidation(formalizer)) {
				System.out.println("Invalid Command. Try again.");
				continue;
			}
		
			
			if (formalizer[0].equals("SET")) {
				db.setValue(formalizer[1], Integer.parseInt(formalizer[2]));
				System.out.print('\n');
			} 
			if (formalizer[0].equals("GET")) {
				System.out.println(db.getValue(formalizer[1]));
			} 
			if (formalizer[0].equals("UNSET")) {
				db.unsetKey(formalizer[1]);
				System.out.print('\n');
			}
			if (formalizer[0].equals("NUMEQUALTO")) {
				System.out.println(db.getValueNum(Integer.parseInt(formalizer[1])));
			}
			if (formalizer[0].equals("END")) {
				System.exit(0);
			}
			if (formalizer[0].equals("BEGIN")) {
				System.out.print('\n');
				transaction();
			}
			if (formalizer[0].equals("ROLLBACK")) {
				System.out.println("NO TRANSACTION");
			}
			if (formalizer[0].equals("COMMIT")) {
				System.out.println("NO TRANSACTION");
			}
			
		}
	}
	
	// Deal with transactions
	private boolean transaction() {
		Scanner scanIn = new Scanner(System.in);
		DB cacheObject = db.clone();
		cache.push(cacheObject);
		while (true) {
			String rawIn = scanIn.nextLine();
			String[] formalizer = rawIn.split(" ");
			formalizer[0] = formalizer[0].toUpperCase();
			if (!commandValidation(formalizer)) {
				System.out.println("Invalid Command. Try again.");
				continue;
			}
			
			if (formalizer[0].equals("SET")) {
				cacheObject.setValue(formalizer[1], Integer.parseInt(formalizer[2]));
				System.out.print('\n');
			}
			if (formalizer[0].equals("GET")) {
				System.out.println(cacheObject.getValue(formalizer[1]));
			}
			if (formalizer[0].equals("UNSET")) {
				cacheObject.unsetKey(formalizer[1]);
				System.out.print('\n');
			}
			if (formalizer[0].equals("NUMEQUALTO")) {
				System.out.println(cacheObject.getValueNum(Integer.parseInt(formalizer[1])));
			}
			if (formalizer[0].equals("END")) {
				System.exit(0);
			}
			if (formalizer[0].equals("BEGIN")) {
				if (transaction()) {
					return true;
				}
			}
			if (formalizer[0].equals("ROLLBACK")) {
				if (!cache.isEmpty()) {
					cache.pop();
				}
				System.out.print('\n');
				return false;
			}
			if (formalizer[0].equals("COMMIT")) {
				db.mergeDiff(cacheObject);
				System.out.print('\n');
				return true;
			}
		}
	}
	
	 
	// Validate commands. Check command and arguments. If the command is invalid, user can re-enter the command.
	private boolean commandValidation(String[] formalized) {
		if (commandDb.containsKey(formalized[0])) {
			if (commandDb.get(formalized[0]) == formalized.length) {
				return true;
			}
		}
		return false;
	}
}
