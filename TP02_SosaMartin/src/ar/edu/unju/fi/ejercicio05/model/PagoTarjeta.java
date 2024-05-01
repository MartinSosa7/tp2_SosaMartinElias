package ar.edu.unju.fi.ejercicio05.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ar.edu.unju.fi.ejercicio05.interfaces.IPago;

public class PagoTarjeta implements IPago {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private String cardNumber;
	private LocalDate payoutDate;
	private Double paidAmount;
	
	public PagoTarjeta() {
		this.payoutDate = LocalDate.now();
		
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LocalDate getPayoutDate() {
		return payoutDate;
	}

	public void setPayoutDate(LocalDate payoutDate) {
		this.payoutDate = payoutDate;
	}

	public Double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(Double paidAmount) {
		this.paidAmount = paidAmount;
	}

	@Override
	public void realizarPago(double monto) {
		this.paidAmount = this.paidAmount + (this.paidAmount * 0.15d);
	}

	@Override
	public void imprimirRecibo() {
		System.out.println("\nNumero de tarjeta: "+this.cardNumber
				+ "\nFecha de pago: "+this.payoutDate.format(FORMATTER)
				+ "\nMonto pagado: "+this.paidAmount);
	}
	
	
	
}
