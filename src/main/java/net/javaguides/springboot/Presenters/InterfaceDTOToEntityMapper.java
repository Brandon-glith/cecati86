package net.javaguides.springboot.Presenters;

public interface InterfaceDTOToEntityMapper<TDTO, TEntity> {

    TEntity convertToEntity(TDTO dto);
}
