import java.util.Comparator;

public class Sortbyname implements Comparator<Karyawan> {

	public int compare(Karyawan o1, Karyawan o2) {
		return o1.getnama().compareToIgnoreCase(o2.getnama());
	}
}
