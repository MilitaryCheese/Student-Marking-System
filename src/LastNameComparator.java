import java.util.Comparator;

public class LastNameComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getlName().compareTo(o2.getlName());
	}

}