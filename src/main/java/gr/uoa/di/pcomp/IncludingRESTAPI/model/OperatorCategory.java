package gr.uoa.di.pcomp.IncludingRESTAPI.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


/**
 * The persistent class for the operators_category database table.
 * 
 */
@Entity
@NoArgsConstructor
@Getter @Setter
@Table(name="operator_category")
@NamedQuery(name="OperatorCategory.findAll", query="SELECT o FROM OperatorCategory o")
public class OperatorCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="operator_category_id")
	private Integer operatorCategoryId;

	@Column(name="operator_category")
	private String operatorCategory;

	@OneToMany(mappedBy="operatorCategory")
	private List<Operator> operators;

	public Operator addOperator(Operator operator) {
		getOperators().add(operator);
		operator.setOperatorCategory(this);
		return operator;
	}

	public Operator removeOperator(Operator operator) {
		getOperators().remove(operator);
		operator.setOperatorCategory(null);
		return operator;
	}

	public OperatorCategory(Integer operatorsCategoryId, String operatorsCategory) {
		super();
		this.operatorCategoryId = operatorsCategoryId;
		this.operatorCategory = operatorsCategory;
	}
}