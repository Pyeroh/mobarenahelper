package model.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import model.GestYaml;

public class GlobalSettings implements Serializable {

	private static final long serialVersionUID = 6749259890578977742L;

	private boolean enabled = true;

	private boolean update_notifications = true;

	private ArrayList<String> allowed_commands = new ArrayList<>();

	public GlobalSettings() {
	}

	public GlobalSettings(LinkedHashMap<String, Object> settings) {
		GestYaml g = new GestYaml(settings);

		enabled = g.getBool("enabled");
		update_notifications = g.getBool("update-notification");
		String[] commands = g.getString("allowed-commands").split(",");
		for (String command : commands) {
			if (command.trim().length() != 0) {
				allowed_commands.add(command.trim());
			}
		}

	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isUpdate_notifications() {
		return update_notifications;
	}

	public void setUpdate_notifications(boolean update_notifications) {
		this.update_notifications = update_notifications;
	}

	public ArrayList<String> getAllowed_commands() {
		return allowed_commands;
	}

	public LinkedHashMap<String, Object> getMap() {
		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("enabled", enabled);
		String commands = "";
		for (int i = 0; i < allowed_commands.size(); i++) {
			commands += allowed_commands.get(i) + ", ";
		}
		if (allowed_commands.size() > 0)
			commands = commands.substring(0, commands.length() - 2);
		map.put("allowed-commands", commands);
		map.put("update-notification", update_notifications);
		return map;
	}

}
