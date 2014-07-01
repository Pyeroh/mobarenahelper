package model.exceptions;


public class MonsterException extends ArenaException {

	/**
	 *
	 */
	private static final long serialVersionUID = 8294116292112346489L;

	public MonsterException(String monsterName) {
		super("No monster named : " + monsterName);
	}

}
