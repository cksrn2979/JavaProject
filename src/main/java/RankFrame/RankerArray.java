package RankFrame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class RankerArray extends Vector<RankerInfo> {
	
	RankerArray() {
		try {
			readPlayer();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sortGrade();
	}

	void readPlayer() throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("resources/Rank.txt"));

		String line="";

		while ((line = in.readLine()) != null) {
			String[] split = line.split("\t");
			this.add(new RankerInfo(split[0], split[1], Integer.parseInt(split[2])));
		}

		in.close();
	}

	void sortGrade(){// 점수 순서대로 정렬
		Collections.sort(this, new NoDescCompare());
	}

	class NoDescCompare implements Comparator<RankerInfo> {
		public int compare(RankerInfo arg0, RankerInfo arg1) {
			return arg0.getScore() > arg1.getScore() ? -1 : arg0.getScore() < arg1.getScore() ? 1 : 0;
		}
	}

}