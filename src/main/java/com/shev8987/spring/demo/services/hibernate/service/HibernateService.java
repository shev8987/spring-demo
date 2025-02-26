package com.shev8987.spring.demo.services.hibernate.service;

import com.shev8987.spring.demo.services.entities.SingerEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Slf4j
@Repository
@RequiredArgsConstructor
public class HibernateService {


    private final SessionFactory sessionFactory;


    @Transactional(readOnly = true)
    public List<SingerEntity> getSingerFullList() {

        var session = sessionFactory.openSession();
        session.beginTransaction();
        var result = session.createQuery("from SingerEntity s").list();
        session.getTransaction().commit();

        log.info(result.toString());
        return result;
    }

    @Transactional(readOnly = true)
    public SingerEntity getSingerById(Long id) {

        var session = sessionFactory.openSession();
        session.beginTransaction();
        var result = session
                .createQuery("from SingerEntity s where s.id= :id", SingerEntity.class)
                .setParameter("id", id)
                .uniqueResult();
        session.getTransaction().commit();
        log.info(result.toString());

        return result;

    }

    @Transactional
    public void save(SingerEntity singerEntity) {

        var session = sessionFactory.openSession();
        session.beginTransaction();

        if (Objects.isNull(singerEntity.getId())) {
            var entity = session.save(singerEntity);
            log.info("Entity saved with id:" + entity);
            session.getTransaction().commit();

        } else {

            var id = singerEntity.getId();
            var result = session
                    .createQuery("from SingerEntity s where s.id= :id", SingerEntity.class)
                    .setParameter("id", id)
                    .uniqueResult();

            if (Objects.isNull(result)) {
                log.info("Entity not found with id:" + singerEntity.getId());
                return;
            }

            session.saveOrUpdate(singerEntity);
            session.getTransaction().commit();

            log.info("Entity updated with id:" + id);
        }
    }

    @Transactional
    public void deleteSinger(Long id) {

        var session = sessionFactory.openSession();
        session.beginTransaction();

        var result = session
                .createQuery("from SingerEntity s where s.id= :id", SingerEntity.class)
                .setParameter("id", id)
                .uniqueResult();

        if (Objects.isNull(result)) {
            log.info("Entity not found with id:" + id);
            return;
        }

        session.delete(result);

        log.info("Entity deleted with id:" + id);

        session.getTransaction().commit();
    }

}
