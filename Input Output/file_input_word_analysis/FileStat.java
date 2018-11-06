package file_input_word_analysis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.TreeMap;

	public class FileStat {

		private Map<String, Integer> words;
		private File file;
		private int wordCount;

		public FileStat(File file) {
			this.file = file;
			readFile();
		}

		private void readFile() {
			words = new TreeMap<String, Integer>();

			try {
				
				// Read in entire file as a BufferReader
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));

				String s = null;
				StringBuilder sb = new StringBuilder();

				// Store entire file in a StringBuilder
				while((s = br.readLine()) != null) {
					sb.append(" ");
					sb.append(s);
				}

				// Split entire string into an array of words
				String[] word = sb.toString().split("[\\s\\p{Blank}\\p{Punct}\\W]+");
				wordCount = word.length;

				// Put array of words into HashMap with value count
				for(String w : word) {
					w = w.toLowerCase();
					if(!words.containsKey(w)) {
						words.put(w, 1);
					}
					else {
						int value = words.get(w);
						value++;
						words.put(w, value);
					}
				}
				br.close();
			}

			catch(UnsupportedEncodingException e) {
				System.err.println(e.toString());
			}

			catch(IOException ie) {
				System.err.println(ie);
			}
		}

		public int getWordCount() {
			return wordCount;
		}

		public int getUniqueWordCount() {
			return words.size();
		}

		public int specificWordCount(String theWord) {
			theWord = theWord.toLowerCase();
			if(!words.containsKey(theWord)) //nullpointer error checking
				return 0;
			else {
			return words.get(theWord);
			}
		}

	}
	

