package com.gof.voting.model;

/**
 * This Class is utility bean for transfering.
 * 
 * @author suraj singh
 */
public class VotingMenu {

	private int serialNumber;

	private String partyName;

	private int symbol;

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public int getSymbol() {
		return symbol;
	}

	public void setSymbol(int symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VotingMenu [serialNumber=").append(serialNumber)
				.append(", partyName=").append(partyName).append(", symbol=")
				.append(symbol).append("]");
		return builder.toString();
	}
}
