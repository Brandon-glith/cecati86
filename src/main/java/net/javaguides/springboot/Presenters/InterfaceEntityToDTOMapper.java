package net.javaguides.springboot.Presenters;

public interface InterfaceEntityToDTOMapper<TDTO, TEntity> {

    
    
    TDTO convertToDTO(TEntity entity);
}
