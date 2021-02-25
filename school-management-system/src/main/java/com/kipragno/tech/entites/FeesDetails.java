package com.kipragno.tech.entites;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FeesDetails {

	@Column(name="fees_paid")
	private String feesPaid;
	@Column(name="receipt_no")
	private String receiptNo;

	public FeesDetails() {
		super();
	}

	public FeesDetails(String feesPaid, String receiptNo) {
		super();
		this.feesPaid = feesPaid;
		this.receiptNo = receiptNo;
	}

	public String getFeesPaid() {
		return feesPaid;
	}

	public void setFeesPaid(String feesPaid) {
		this.feesPaid = feesPaid;
	}

	public String getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}

}
