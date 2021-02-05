public class Karyawan {

	private String nama, Jabatan, Gender, ID;
	private int Gaji = 0;
	public Karyawan() {

	}

	public Karyawan(String nama, String jabatan, String gender, int gaji, String ID) {
		super();
		this.nama = nama;
		this.Jabatan = jabatan;
		this.Gender = gender;
		this.Gaji = gaji;
		this.ID = ID;

	}
	
	public void SetGaji(int Gaji) {
		this.Gaji= Gaji;
	}
	public int getGaji() {
		return Gaji;
	}

	public String getnama() {
		return nama;
	}

	public String getJabatan() {
		return Jabatan;
	}

	public String getGender() {
		return Gender;
	}

	public String getID() {
		return ID;
	}

}
