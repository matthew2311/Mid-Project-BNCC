import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {
	Scanner scan = new Scanner(System.in);
	public Random rand = new Random();
	ArrayList<Karyawan> ListKaryawan = new ArrayList<Karyawan>();
	ArrayList<String> Managerlist = new ArrayList<String>();
	ArrayList<String> Supervisorlist = new ArrayList<String>();
	ArrayList<String> Adminlist = new ArrayList<String>();
	ArrayList<String> IDlist = new ArrayList<String>();

	public Main() {
		mainMenu();
	}

	private void mainMenu() {
		int menu = 0;
		do {
			// Menu Awal
			System.out.println("Menu Data Karyawan PT.Mentol");
			System.out.println("----------------------------");
			System.out.println("1. Insert Data Karyawan");
			System.out.println("2. View Data Karyawan");
			System.out.println("3. Update Data Karyawan");
			System.out.println("4. Delete Data Karyawan");
			menu = scan.nextInt();
			scan.nextLine();

			switch (menu) {

			case 1:
				Insertdata();
				break;
			case 2:
				Viewdata();
				break;
			case 3:
				Updatedata();
				InserdataForUpdate();
				break;
			case 4:
				Deletedata();
				break;
			case 5:
				mainMenu();
				break;
			}

			if (menu < 5) {
				eContinue();
			}
		} while (menu != 5);

	}

	private void eContinue() {
		System.out.println("Enter to return");
		scan.nextLine();
	}

	private void Insertdata() {
		String name, kelamin;
		String Jabatan;
		String ID = "";
		do {
			System.out.print("Input nama karyawan [>=3]: ");
			name = scan.nextLine();
		} while (name.length() <= 2);

		do {
			System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
			kelamin = scan.nextLine();
		} while (!kelamin.equals("Laki-laki") && !kelamin.equals("Perempuan"));

		do {
			System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
			Jabatan = scan.nextLine();
		} while (!Jabatan.equals("Manager") && !Jabatan.equals("Supervisor") && !Jabatan.equals("Admin"));
		for (int x = 0; x < 2; x++) {
			ID += (char) (rand.nextInt(23) + 65);
		}
		ID = ID.concat("-");
		for (int i = 0; i < 4; i++) {
			if (i == 0) {
				ID += (rand.nextInt(10));
			} else {
				ID += rand.nextInt(10);
			}
		}
		IDlist.add(ID);
		int tempA = 0;
		if (Jabatan.equals("Manager")) {
			tempA = 8000000;
			Managerlist.add(ID);
		} else if (Jabatan.equals("Supervisor")) {
			tempA = 6000000;
			Supervisorlist.add(ID);
		} else if (Jabatan.equals("Admin")) {
			tempA = 4000000;
			Adminlist.add(ID);
		}
		System.out.println("Berhasil menambahkan karyawan dengan id " + ID);
		if (((Managerlist.size() - 1) % 3) == 0) {
			if (Managerlist.size() - 1 == 0) {

			} else {
				System.out.print("Bonus sebesar 10% telah diberikan kepada karyawan dengan id ");
				for (int x = 0; x < Managerlist.size() - 1; x++) {
					if (x == Managerlist.size() - 2) {
						System.out.printf("%6s", Managerlist.get(x));
					} else {
						System.out.printf("%6s, ", Managerlist.get(x));
					}
					int i;
					for (i = 0; i < IDlist.size(); i++) {
						if (IDlist.get(i) == Managerlist.get(x)) {
							ListKaryawan.get(i)
									.SetGaji(ListKaryawan.get(i).getGaji() + (ListKaryawan.get(i).getGaji() * 1 / 10));
						}
					}
				}
				System.out.printf("\n");
			}
		}
		if (((Supervisorlist.size() - 1) % 3) == 0) {
			if (Supervisorlist.size() - 1 == 0) {

			} else {
				System.out.print("Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id ");
				for (int x = 0; x < Supervisorlist.size() - 1; x++) {
					if (x == Supervisorlist.size() - 2) {
						System.out.printf("%6s", Supervisorlist.get(x));
					} else {
						System.out.printf("%6s, ", Supervisorlist.get(x));
					}
					int a;
					for (a = 0; a < IDlist.size(); a++) {
						if (IDlist.get(a) == Supervisorlist.get(x)) {
							ListKaryawan.get(a)
									.SetGaji(ListKaryawan.get(a).getGaji() + (ListKaryawan.get(a).getGaji() * 3 / 40));
						}
					}
				}
				System.out.printf("\n");
			}
		}
		if (((Adminlist.size() - 1) % 3) == 0) {
			if (Adminlist.size() - 1 == 0) {

			} else {
				System.out.print("Bonus sebesar 5% telah diberikan kepada karyawan dengan id");
				for (int x = 0; x < Adminlist.size() - 1; x++) {
					if (x == Adminlist.size() - 2) {
						System.out.printf("%6s", Adminlist.get(x));
					} else {
						System.out.printf("%6s, ", Adminlist.get(x));
					}
					int i;
					for (i = 0; i < IDlist.size(); i++) {
						if (IDlist.get(i) == Adminlist.get(x)) {
							ListKaryawan.get(i)
									.SetGaji(ListKaryawan.get(i).getGaji() + (ListKaryawan.get(i).getGaji() * 1 / 20));
						}
					}
				}
				System.out.println("\n");
			}
		}
		if (Jabatan.equals("Manager") || Jabatan.equals("Supervisor") || Jabatan.equals("Admin")) {
			ListKaryawan.add(new Karyawan(name, Jabatan, kelamin, tempA, ID));
		}
		Collections.sort(ListKaryawan, new Sortbyname());
	}

	private void Viewdata() {
		if (ListKaryawan.isEmpty()) {
			System.out.println("There is no data....");
		} else {
			int idx = 0;
			System.out.println("");
			System.out.println(
					"|----|-----------------|-------------------------|---------------|---------------|-------------|");
			System.out.println(
					"|No  |Kode Karyawan    |Nama Karyawan            |Jenis Kelamin  |Jabatan	 |Gaji Karyawan|");
			System.out.println(
					"|----|-----------------|-------------------------|---------------|---------------|-------------|");
			for (Karyawan karyawan : ListKaryawan) {
				idx++;
				System.out.printf("| %3s| %16s| %24s| %14s| %14s| %12d| \n", (idx), karyawan.getID(),
						karyawan.getnama(), karyawan.getGender(), karyawan.getJabatan(), karyawan.getGaji());
			}
			System.out.println(
					"|----|-----------------|-------------------------|---------------|---------------|-------------|");
		}
	}

	private void Updatedata() {
		Viewdata();
		if (ListKaryawan.isEmpty()) {
			System.out.println("There is no data....");
		} else {
			int idx = 0;
			do {
				System.out.println("Input Karyawan number to update : ");
				idx = scan.nextInt();
				scan.nextLine();
			} while (idx < 1 || idx > ListKaryawan.size());
			for (int x = 0; x < Managerlist.size(); x++) {
				if (IDlist.get(idx - 1) == Managerlist.get(x)) {
					Managerlist.remove(x);
				}
			}
			for (int x = 0; x < Supervisorlist.size(); x++) {
				if (IDlist.get(idx - 1) == Supervisorlist.get(x)) {
					Supervisorlist.remove(x);
				}
			}
			for (int x = 0; x < Adminlist.size(); x++) {
				if (IDlist.get(idx - 1) == Adminlist.get(x)) {
					Adminlist.remove(x);
				}
			}
			ListKaryawan.remove(idx - 1);
		}
	}

	private void InserdataForUpdate() {
		String name, kelamin;
		String Jabatan;
		String ID = "";
		do {
			System.out.print("Input nama karyawan [>=3]: ");
			name = scan.nextLine();
		} while (name.length() <= 2);

		do {
			System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
			kelamin = scan.nextLine();
		} while (!kelamin.equals("Laki-laki") && !kelamin.equals("Perempuan"));

		do {
			System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
			Jabatan = scan.nextLine();
		} while (!Jabatan.equals("Manager") && !Jabatan.equals("Supervisor") && !Jabatan.equals("Admin"));
		for (int x = 0; x < 2; x++) {
			ID += (char) (rand.nextInt(23) + 65);
		}

		for (int i = 0; i < 4; i++) {
			if (i == 0) {
				ID += (-rand.nextInt(10));
			} else {
				ID += rand.nextInt(10);
			}
		}
		IDlist.add(ID);
		int tempA = 0;
		if (Jabatan.equals("Manager")) {
			tempA = 8000000;
			Managerlist.add(ID);
		} else if (Jabatan.equals("Supervisor")) {
			tempA = 6000000;
			Supervisorlist.add(ID);
		} else if (Jabatan.equals("Admin")) {
			tempA = 4000000;
			Adminlist.add(ID);
		}
		System.out.println("Berhasil menambahkan karyawan dengan id " + ID);
		if (Jabatan.equals("Manager") || Jabatan.equals("Supervisor") || Jabatan.equals("Admin")) {
			ListKaryawan.add(new Karyawan(name, Jabatan, kelamin, tempA, ID));
		}
		Collections.sort(ListKaryawan, new Sortbyname());
	}

	private void Deletedata() {
		if (ListKaryawan.isEmpty()) {
			System.out.println("There is no data....");
		} else {
			int idx = 0;
			Viewdata();

			do {
				System.out.println("Input Karyawan number to delete : ");
				idx = scan.nextInt();
				scan.nextLine();
			} while (idx < 1 || idx > ListKaryawan.size());
			for (int x = 0; x < Managerlist.size(); x++) {
				if (IDlist.get(idx - 1) == Managerlist.get(x)) {
					Managerlist.remove(x);
				}
			}
			for (int x = 0; x < Supervisorlist.size(); x++) {
				if (IDlist.get(idx - 1) == Supervisorlist.get(x)) {
					Supervisorlist.remove(x);
				}
			}
			for (int x = 0; x < Adminlist.size(); x++) {
				if (IDlist.get(idx - 1) == Adminlist.get(x)) {
					Adminlist.remove(x);
				}
			}
			ListKaryawan.remove(idx - 1);
			System.out.println("Delete Succes");
		}

	}

	public static void main(String[] args) {
		new Main();
	}
}
