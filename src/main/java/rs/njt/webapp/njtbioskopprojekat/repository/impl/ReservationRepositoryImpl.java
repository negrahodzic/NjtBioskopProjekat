/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.njt.webapp.njtbioskopprojekat.repository.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import rs.njt.webapp.njtbioskopprojekat.entity.Reservation;
import rs.njt.webapp.njtbioskopprojekat.repository.ReservationRepository;

/**
 *
 * @author Negra
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class ReservationRepositoryImpl implements ReservationRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Reservation> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reservation getById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
