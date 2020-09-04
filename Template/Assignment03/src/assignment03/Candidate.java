package assignment03;

public class Candidate implements Comparable {

	private String name;
	private int numVotes = 0;
	private Vote[] votes;
	
	public Candidate(String name, int maxVotes) {
		this.name = name;
		votes = new Vote[maxVotes];
	}
	
	public String toString() {
		return "--------------Candidate------------\n" + "Name: " + name + "\nTotal Votes: " + numVotes;
	}
	
	public int toRegionString(int regionNum) {
		int regionVote=0;
		for(int i=0 ; i<numVotes ; i++) {
			if(votes[i].regionNum == regionNum)
				regionVote++;
		}
		return regionVote;
	}
	
	public void callAddVotes(int regionNum) throws InterruptedException {
		Vote vote = new Vote(regionNum);
		vote.addVote(regionNum);
	}
	
	@Override
	public int compareTo(Object obj) {
		if(obj==null) throw new NullPointerException("Object is null!");
		if(!this.getClass().equals(obj.getClass())) throw new ClassCastException("Object is not the same type!");
		
		Candidate temp = (Candidate) obj;
		if(this.numVotes > temp.numVotes) return -1;
		else if(this.numVotes == temp.numVotes) return 0;
		else return 1;
	}
	
	private class Vote {

		private int regionNum;
		
		public Vote(int regionNum) {
			this.regionNum = regionNum;
		}
		
		public synchronized void addVote(int regionNum) throws InterruptedException {
			Vote vote = new Vote(regionNum);
			votes[numVotes] = vote;
			numVotes++;
		}
	}
}
