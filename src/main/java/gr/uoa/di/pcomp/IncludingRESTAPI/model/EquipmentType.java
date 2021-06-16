package gr.uoa.di.pcomp.IncludingRESTAPI.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


/**
 * The persistent class for the equipment_type database table.
 * 
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="equipment_type")
@NamedQuery(name="EquipmentType.findAll", query="SELECT e FROM EquipmentType e")
public class EquipmentType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="equipment_type_id")
	private Integer equipmentTypeId;
	
	@Column(name="equipment_type")
	private String equipmentType;

	@OneToMany(mappedBy="equipmentType")
	private List<Equipment> equipments;

	public Equipment addEquipment(Equipment equipment) {
		getEquipments().add(equipment);
		equipment.setEquipmentType(this);
		return equipment;
	}

	public Equipment removeEquipment(Equipment equipment) {
		getEquipments().remove(equipment);
		equipment.setEquipmentType(null);
		return equipment;
	}

	public EquipmentType(Integer equipmentTypeId, String equipmentType) {
		super();
		this.equipmentTypeId = equipmentTypeId;
		this.equipmentType = equipmentType;
	}

}