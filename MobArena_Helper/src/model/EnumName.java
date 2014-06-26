package model;

import java.util.*;

import model.enums.*;

public class EnumName {

	private static ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("gui.enums");

	private EnumName() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		}
		catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}

	public static void load() {
		RESOURCE_BUNDLE = ResourceBundle.getBundle("gui.enums");
		EAbilities.load();
		EAmount.load();
		ECatW.load();
		EGrowth.load();
		EHealth.load();
		EItemCat.load();
		EMonsters.load();
		ETypeW.load();
		ERewardType.load();
	}
}
