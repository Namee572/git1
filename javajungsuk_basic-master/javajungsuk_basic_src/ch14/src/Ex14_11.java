import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

class Student3 {
	String name;
	boolean isMale; // ����
	int hak;        // �г�
	int ban;        // ��
	int score;

	Student3(String name, boolean isMale, int hak, int ban, int score) { 
		this.name	= name;
		this.isMale	= isMale;
		this.hak   	= hak;
		this.ban	= ban;
		this.score 	= score;
	}

	String	getName() 	 { return name;    }
	boolean isMale()  	 { return isMale;  }
	int		getHak()   	 { return hak;	   }
	int		getBan()  	 { return ban;	   }
	int		getScore()	 { return score;   }

	public String toString() {
		return String.format("[%s, %s, %d�г� %d��, %3d��]", name, isMale ? "��" : "��", hak, ban, score);
	}

	enum Level {
		HIGH, MID, LOW
	}
}

class Ex14_11 {
	public static void main(String[] args) {
		Student3[] stuArr = {
			new Student3("���ڹ�", true,  1, 1, 300),	
			new Student3("������", false, 1, 1, 250),	
			new Student3("���ڹ�", true,  1, 1, 200),	
			new Student3("������", false, 1, 2, 150),	
			new Student3("���ڹ�", true,  1, 2, 100),	
			new Student3("������", false, 1, 2,  50),	
			new Student3("Ȳ����", false, 1, 3, 100),	
			new Student3("������", false, 1, 3, 150),	
// �� �������� ��ӵ˴ϴ�.
			new Student3("���ڹ�", true,  1, 3, 200),	
			new Student3("���ڹ�", true,  2, 1, 300),	
			new Student3("������", false, 2, 1, 250),	
			new Student3("���ڹ�", true,  2, 1, 200),	
			new Student3("������", false, 2, 2, 150),	
			new Student3("���ڹ�", true,  2, 2, 100),	
			new Student3("������", false, 2, 2,  50),	
			new Student3("Ȳ����", false, 2, 3, 100),	
			new Student3("������", false, 2, 3, 150),	
			new Student3("���ڹ�", true,  2, 3, 200)	
		};

		System.out.printf("1. �ܼ��׷�ȭ(�ݺ��� �׷�ȭ)%n");
		Map<Integer, List<Student3>> stuByBan = Stream.of(stuArr)
				.collect(groupingBy(Student3::getBan));

		for(List<Student3> ban : stuByBan.values()) {
			for(Student3 s : ban) {
				System.out.println(s);
			}
		}

		System.out.printf("%n2. �ܼ��׷�ȭ(�������� �׷�ȭ)%n");
		Map<Student3.Level, List<Student3>> stuByLevel = Stream.of(stuArr)
				.collect(groupingBy(s-> {
						 if(s.getScore() >= 200) return Student3.Level.HIGH;
					else if(s.getScore() >= 100) return Student3.Level.MID;
					else                         return Student3.Level.LOW;
				}));

		TreeSet<Student3.Level> keySet = new TreeSet<>(stuByLevel.keySet());

		for(Student3.Level key : keySet) {
			System.out.println("["+key+"]");

			for(Student3 s : stuByLevel.get(key))
				System.out.println(s);
			System.out.println();
		}

		System.out.printf("%n3. �ܼ��׷�ȭ + ���(������ �л���)%n");
		Map<Student3.Level, Long> stuCntByLevel = Stream.of(stuArr)
				.collect(groupingBy(s-> {
					     if(s.getScore() >= 200) return Student3.Level.HIGH;
					else if(s.getScore() >= 100) return Student3.Level.MID;
					else                         return Student3.Level.LOW;
				}, counting()));
		for(Student3.Level key : stuCntByLevel.keySet())
			System.out.printf("[%s] - %d��, ", key, stuCntByLevel.get(key));
		System.out.println();
/*
		for(List<Student3> level : stuByLevel.values()) {
			System.out.println();
			for(Student3 s : level) {
				System.out.println(s);
			}
		}
*/
		System.out.printf("%n4. ���߱׷�ȭ(�г⺰, �ݺ�)");
		Map<Integer, Map<Integer, List<Student3>>> stuByHakAndBan =
          Stream.of(stuArr)
				.collect(groupingBy(Student3::getHak,
						 groupingBy(Student3::getBan)
				));

		for(Map<Integer, List<Student3>> hak : stuByHakAndBan.values()) {
			for(List<Student3> ban : hak.values()) {
				System.out.println();
				for(Student3 s : ban)
					System.out.println(s);
			}
		}

		System.out.printf("%n5. ���߱׷�ȭ + ���(�г⺰, �ݺ� 1��)%n");
		Map<Integer, Map<Integer, Student3>> topStuByHakAndBan =
          Stream.of(stuArr)
				.collect(groupingBy(Student3::getHak,
						 groupingBy(Student3::getBan,
						     collectingAndThen(
						         maxBy(comparingInt(Student3::getScore))
						         , Optional::get
						     )
						 )
				));

		for(Map<Integer, Student3> ban : topStuByHakAndBan.values())
			for(Student3 s : ban.values())
				System.out.println(s);

// �� �������� ��ӵ˴ϴ�.
		System.out.printf("%n6. ���߱׷�ȭ + ���(�г⺰, �ݺ� �����׷�)%n");
		Map<String, Set<Student3.Level>> stuByScoreGroup = Stream.of(stuArr)
			.collect(groupingBy(s-> s.getHak() + "-" + s.getBan(),
					mapping(s-> {
						 if(s.getScore() >= 200) return Student3.Level.HIGH;
					else if(s.getScore() >= 100) return Student3.Level.MID;
						 else                    return Student3.Level.LOW;
					} , toSet())
			));

		Set<String> keySet2 = stuByScoreGroup.keySet();

		for(String key : keySet2) {
			System.out.println("["+key+"]" + stuByScoreGroup.get(key));
		}
	}  // main�� ��
}