package in.cloudnine.nanoerp.model.inventory;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import in.cloudnine.serverframework.data.interfaces.root.DataReferenceImpl;


/**
 * The persistent class for the RollTransaction database table.
 * 
 */
@JsonIdentityInfo(
		generator=ObjectIdGenerators.UUIDGenerator.class,
		property="_rollTransactionId",
		scope=RollTransaction.class
		)

@Entity
@Table(name="RollTransaction")
@NamedQuery(name="RollTransaction.findAll", query="SELECT r FROM RollTransaction r")
public class RollTransaction extends DataReferenceImpl  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="RollTransactionId", unique=true, nullable=false, length=36)
	private String rollTransactionId;

	//bi-directional many-to-one association to StockRoll
	@ManyToOne
	@JoinColumn(name="StockRollId", nullable=false)
	private StockRoll stockRoll;

	//bi-directional many-to-one association to StoresVoucherExternalRoll
	@ManyToOne
	@JoinColumn(name="StoresVoucherExternalRollsId", nullable=false)
	private StoresVoucherExternalRoll storesVoucherExternalRoll;

	public RollTransaction() {
	}

	public String getRollTransactionId() {
		return this.rollTransactionId;
	}

	public void setRollTransactionId(String rollTransactionId) {
		this.rollTransactionId = rollTransactionId;
	}

	public StockRoll getStockRoll() {
		return this.stockRoll;
	}

	public void setStockRoll(StockRoll stockRoll) {
		this.stockRoll = stockRoll;
	}

	public StoresVoucherExternalRoll getStoresVoucherExternalRoll() {
		return this.storesVoucherExternalRoll;
	}

	public void setStoresVoucherExternalRoll(StoresVoucherExternalRoll storesVoucherExternalRoll) {
		this.storesVoucherExternalRoll = storesVoucherExternalRoll;
	}

}