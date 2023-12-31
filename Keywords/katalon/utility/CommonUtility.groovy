package katalon.utility

import java.util.regex.Matcher
import java.util.regex.Pattern
import java.util.stream.Collectors
import java.util.stream.IntStream
import internal.GlobalVariable



public class CommonUtility {

	static public String substringUseRegExp(String input, String regexp,int group) {
		Pattern pattern = Pattern.compile(regexp)
		Matcher matcher = pattern.matcher(input)
		if(!matcher.find()) {
			println 'Regexp not work'
		} else {
			return matcher.group(group)
		}
	}

	static public List<String> generateRandomUUIDs(int size) {
		return IntStream.rangeClosed(1, size).boxed().map{ item -> UUID.randomUUID().toString(); }.collect(Collectors.toList())
	}

	static public String randomNumber(int size) {
		def random = new Random()
		def randomNumber = (random.nextInt(size) + 1).toString()
		return randomNumber
	}

	static public String mergeRandomEmail(String email, int size) {
		Random random = new Random()
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
		String randomString = "+" + (1..size).collect { characters[random.nextInt(characters.length())] }.join()
		def (localPart, domainPart) = email.split('@')
		def emailMerged = "$localPart$randomString@$domainPart"
		println "emailMerged: $emailMerged"
		return emailMerged
	}

	static public String generateRandomProjectName(int size) {
		Random random = new Random()
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
		String randomString = (1..size).collect { characters[random.nextInt(characters.length())] }.join()
		String projectName = "$GlobalVariable.prefixName" + " " + randomString
		println "Random string of length $size: $randomString"
		return projectName
	}

	static public List<String> convertString2ListString(String st, String separator){
		List<String>rs = st.split(separator)
		return  rs.stream().map({r -> r.trim()}).collect(Collectors.toList())
	}

	static public String rgbaToHex(String rgba) {
		// Remove "rgba(" and ")" and split the values
		String[] rgbaValues = rgba.replaceAll("rgba\\(|\\)", "").split(",\\s*")

		// Convert each value to hexadecimal
		String hex = "#"
		for (String value : rgbaValues[0..2]) {
			hex += Integer.toHexString(Integer.parseInt(value)).toUpperCase().padLeft(2, '0')
		}

		return hex
	}

	static public String rgbToHex(String rgb) {
		// Remove "rgba(" and ")" and split the values
		String[] rgbValues = rgb.replaceAll("rgba\\(|\\)", "").split(",\\s*")

		// Convert each value to hexadecimal
		String hex = "#"
		for (String value : rgbValues[0..2]) {
			hex += Integer.toHexString(Integer.parseInt(value)).toUpperCase().padLeft(2, '0')
		}

		return hex
	}
}
