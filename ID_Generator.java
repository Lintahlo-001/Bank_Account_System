import java.util.*;

public class ID_Generator {
	final static String lexicon = "12345674890";
	final static Random rand = new Random();
	final static HashSet<String> identifiers = new HashSet<String>();

	public static String randomUserID() {
		StringBuilder builder = new StringBuilder();
		while (builder.toString().length() == 0) {
			int length = 10;
			for (int i = 0; i < length; i++) {
				builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
			}
			if (identifiers.contains(builder.toString())) {
				builder = new StringBuilder();
			} else {
				identifiers.add(builder.toString());
			}
		}
		return builder.toString();
	}
}