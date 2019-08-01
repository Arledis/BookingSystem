package com.codeclan.example.BookingSystem.repositories.CustomerRepository;

import com.codeclan.example.BookingSystem.models.Customer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;


public class CustomerRepositoryImpl implements CustomerRepositoryCustom{
    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Customer> findAllCustomersByCourse(String name){
        List<Customer> result = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Customer.class);
            cr.createAlias("bookings", "booking");
            cr.createAlias("booking.course", "course");
            cr.add(Restrictions.eq("course.name", name));
            result = cr.list();
        } catch (HibernateException e){
            e.printStackTrace();
        }
        return result;
    }




}
