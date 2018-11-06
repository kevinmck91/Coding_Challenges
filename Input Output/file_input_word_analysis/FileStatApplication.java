package file_input_word_analysis;

import java.io.File;
import javax.swing.JOptionPane;

/**
 * Given a txt file, compute the word count, the unique word count and the
 * occurrences of a specific word.
 */

public class FileStatApplication {

	public static void main(String[] args) {

		// C:\Users\kmk\Desktop\alice.txt
		
		String location = JOptionPane.showInputDialog("Enter a location: ");
		File file = new File(location);

		while (!file.exists()) {
			location = JOptionPane
					.showInputDialog("File does not exist. Enter a valid location: ");

			if (location == null)
				System.exit(0);

			file = new File(location);
		}

		FileStat fs = new FileStat(file);

		System.out.println("Word Count : " + fs.getWordCount());
		System.out.println("Unique Word Count : " + fs.getUniqueWordCount());
		System.out.println("Specific Word Count of 'the' : " + fs.specificWordCount("the"));

	}

}
