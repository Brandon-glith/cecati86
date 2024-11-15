package net.javaguides.springboot.ApplicationLayer;

import javax.validation.GroupSequence;

@GroupSequence({ BasicValidationGroup.class, AdvancedValidationGroup.class })
public interface ValidationSequence {

}
