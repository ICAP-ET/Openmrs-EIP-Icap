package org.openmrs.sync.core.entity.light;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "person_attribute_type")
@AttributeOverride(name = "id", column = @Column(name = "person_attribute_type_id"))
public class PersonAttributeTypeLight extends LightEntity {

    @NotNull
    @Column(name = "name")
    private String name;
}
