package com.example.demo.util;

public class Util {
	public static String jsReplace(String msg, String url) {
		if (msg == null) {
			msg = "";
		}
		if (url == null || url.length() == 0) {
			url = "/";
		}
		
		String result = String.format("""
				<script>
					const al = alert(msg)
				</script>
				""", null);
		
		return result;
	}
}
