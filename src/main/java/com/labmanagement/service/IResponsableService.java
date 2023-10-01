package com.labmanagement.service;

import java.util.Collection;
import java.util.List;

import com.labmanagement.model.entity.ExpressionBesoin;
import com.labmanagement.model.entity.Responsable;

public interface IResponsableService {

    Responsable addResponsable(Responsable responsable);

    List<Responsable> findAllResponsables();

    Responsable findResponsableById(Long id);

    Responsable updateResponsable(Responsable responsable);

    void deleteResponsable(Long id);

    Collection<ExpressionBesoin> findExpressionBesoinsByResponsableId(Long id);
}
