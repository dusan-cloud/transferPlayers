package zavrsni.web.dto;

public class IgracDTO {

	
	private Long id;

	private String imeIPrezime;
	
	private String pozicija;
	
	private int brojDresa;
	
	private String datumRodjenja;
	
	private boolean naProdaju;
	
	
	private KlubDTO klubDTO;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImeIPrezime() {
		return imeIPrezime;
	}

	public void setImeIPrezime(String imeIPrezime) {
		this.imeIPrezime = imeIPrezime;
	}

	public String getPozicija() {
		return pozicija;
	}

	public void setPozicija(String pozicija) {
		this.pozicija = pozicija;
	}

	public int getBrojDresa() {
		return brojDresa;
	}

	public void setBrojDresa(int brojDresa) {
		this.brojDresa = brojDresa;
	}

	public String getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(String datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public boolean isNaProdaju() {
		return naProdaju;	
	}

	public void setNaProdaju(boolean naProdaju) {
		this.naProdaju = naProdaju;
	}

	public KlubDTO getKlubDTO() {
		return klubDTO;
	}

	public void setKlubDTO(KlubDTO klubDTO) {
		this.klubDTO = klubDTO;
	}

	
	
	
}
