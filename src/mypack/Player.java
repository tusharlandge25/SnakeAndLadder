package mypack;

class Player {
	
	private int curPos;
	
	public Player(int curPos) {
		super();
		this.curPos = curPos;
	}

	public int getCurPos() {
		return curPos;
	}

	public void setCurPos(int curPos) {
		this.curPos = curPos;
	}

	@Override
	public String toString() {
		return "Player [curPos=" + curPos + "]";
	}
}
