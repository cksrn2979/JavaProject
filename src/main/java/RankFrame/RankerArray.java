package RankFrame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class RankerArray extends Vector<UserInfo> {
	
	RankerArray() {
		try {
			readPlayer();
			sortGrade();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void readPlayer() throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("resources/Score.txt"));

		String line;

		while ((line = in.readLine()) != null) {
			String[] split = line.split("\t");
			this.add(new UserInfo(split[0], split[1], Integer.parseInt(split[2])));
		}

		in.close();
	}

	void sortGrade() throws IOException {// 점수 순서대로 정렬
		Collections.sort(this, new NoDescCompare());
	}

	static class NoDescCompare implements Comparator<UserInfo> {
		public int compare(UserInfo arg0, UserInfo arg1) {
			return arg0.getScore() > arg1.getScore() ? -1 : arg0.getScore() < arg1.getScore() ? 1 : 0;
		}
	}

}