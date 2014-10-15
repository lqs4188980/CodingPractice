package com.thumbtack.challenge.database;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
 * 
 * Helper class to store the data
 * 
 * 
 * */
public class DB {
	private HashMap<String, Integer> db = null;
	private HashMap<Integer, HashSet<String>> valueToKey = null;
	
	private DB(HashMap<String, Integer> stringToValue, HashMap<Integer, HashSet<String>> valueToString) {
		db = stringToValue;
		
		valueToKey = new HashMap<Integer, HashSet<String>>();
		Set<Integer> keySet = valueToString.keySet();
		for (int key : keySet) {
			HashSet<String> valueSet = (HashSet<String>)valueToString.get(key).clone();
			valueToKey.put(key, valueSet);
		}
	}
	
	public DB() {
		// TODO Auto-generated constructor stub
		db = new HashMap<String, Integer>();
		valueToKey = new HashMap<Integer, HashSet<String>>();
	}
	
	void setValue(String key, int value) {
		if (db.containsKey(key)) {
			int originValue = db.get(key);
			db.put(key, value);
			valueToKey.get(originValue).remove(key);
			if (valueToKey.get(originValue).size() == 0) {
				valueToKey.remove(originValue);
			}
			
			if (valueToKey.containsKey(value)) {
				valueToKey.get(value).add(key);
			} else {
				HashSet<String> keySet = new HashSet<String>();
				keySet.add(key);
				valueToKey.put(value, keySet);
			}
		} else {
			db.put(key, value);
			if (valueToKey.containsKey(value)) {
				valueToKey.get(value).add(key);
			} else {
				HashSet<String> keySet = new HashSet<String>();
				keySet.add(key);
				valueToKey.put(value, keySet);
			}
		}
	}
	
	Integer getValue(String key) {
		if (!db.containsKey(key)) {
			return null;
		} else {
			return db.get(key);
		}
	}
	
	void unsetKey(String key) {
		if (db.containsKey(key)) {
			int value = db.get(key);
			db.remove(key);
			valueToKey.get(value).remove(key);
			if (valueToKey.get(value).size() == 0) {
				valueToKey.remove(value);
			}
		}
	}
	
	int getValueNum(int value) {
		if (valueToKey.containsKey(value)) {
			return valueToKey.get(value).size();
		} else {
			return 0;
		}
	}
	
	public DB clone() {
		DB instance = new DB((HashMap<String, Integer>)db.clone(), (HashMap<Integer, HashSet<String>>)valueToKey.clone());
		return instance;
	}
	
	public void mergeDiff(DB instance) {
		this.db = instance.db;
		this.valueToKey = instance.valueToKey;
	}

}
