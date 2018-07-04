package com.ecd.tool;

import java.util.UUID;

public class UUIDGet {

	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		String uuidStr = str.replace("-", "");
		return uuidStr;
	}
}
