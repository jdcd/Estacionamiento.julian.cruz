package co.com.ceiba.estacionamiento.dominio.entidades;

public class PriceTable {
	
	private int precioHoraMoto;
	private int precioHoraAuto;
	private int precioMinutoMoto;
	private int precioMinutoAuto;
	private int precioAdicionCilindraje;
	
	public PriceTable(int precioHoraMoto, int precioHoraAuto, int precioMinutoMoto, int precioMinutoAuto, int precioAdicionCilindraje) {
		super();
		this.precioHoraMoto = precioHoraMoto;
		this.precioHoraAuto = precioHoraAuto;
		this.precioMinutoMoto = precioMinutoMoto;
		this.precioMinutoAuto = precioMinutoAuto;
	}

	public int getPrecioHoraMoto() {
		return precioHoraMoto;
	}

	public void setPrecioHoraMoto(int precioHoraMoto) {
		this.precioHoraMoto = precioHoraMoto;
	}

	public int getPrecioHoraAuto() {
		return precioHoraAuto;
	}

	public void setPrecioHoraAuto(int precioHoraAuto) {
		this.precioHoraAuto = precioHoraAuto;
	}

	public int getPrecioMinutoMoto() {
		return precioMinutoMoto;
	}

	public void setPrecioMinutoMoto(int precioMinutoMoto) {
		this.precioMinutoMoto = precioMinutoMoto;
	}

	public int getPrecioMinutoAuto() {
		return precioMinutoAuto;
	}

	public void setPrecioMinutoAuto(int precioMinutoAuto) {
		this.precioMinutoAuto = precioMinutoAuto;
	}

	public int getPrecioAdicionCilindraje() {
		return precioAdicionCilindraje;
	}

	public void setPrecioAdicionCilindraje(int precioAdicionCilindraje) {
		this.precioAdicionCilindraje = precioAdicionCilindraje;
	}
	
	
	
	
	
	
}
