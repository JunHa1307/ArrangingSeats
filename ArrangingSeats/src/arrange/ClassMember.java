package arrange;

import java.util.ArrayList;

public enum ClassMember {
	ONE("김민재",1),
	TWO("김예진",2),
	THREE("김진기",3),
	FOUR("김혜린",4),
	FIVE("김홍석",5),
	SIX("노지의",6),
	SEVEN("류준하",7),
	EIGHT("박가영",8),
	NINE("손석범", 9),
	TEN("엄태환",10),
	ELEVEN("오민석",11),
	TWELEVE("오현지",12),
	THIRTEEN("윤지영",13),
	FOURTEEN("이규정",14),
	FIFTEEN("이수진",15),
	SIXTEEN("이유진",16),
	SEVENTEEN("이준석",17),
	EIGHTTEEN("이충영",18),
	NINETEEN("이해민",19),
	TWENTY("임나훈",20),
	TWENTYONE("임재원",21),
	TWENTYTWO("장서영",22),
	TWENTYTHREE("장하은",23),
	TWENTYFOUR("정지연",24),
	TWENTYFIVE("한동휘",25),
	TWENTYSIX("한승은",26),
	TWENTYSEVEN("홍성빈",27),
	TWENTYEIGHT("황수환",28);
	
	private final String name;
	private final int num;
	
	ClassMember(String name, int num){
		this.name = name;
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public int getNum() {
		return num;
	}
	
	public static ClassMember valueOfname(int num) {
		ClassMember[] member = ClassMember.values();
		for(ClassMember m : member) {
			if(m.num == num) {
				return m;
			}
		}
		return null;
	}
}
