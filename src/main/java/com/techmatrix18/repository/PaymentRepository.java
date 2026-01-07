package com.techmatrix18.repository;

import com.techmatrix18.enums.PaymentStatus;
import com.techmatrix18.enums.PaymentType;
import com.techmatrix18.model.Payment;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

/**
 * Repository interface for Payment entity operations.
 *
 * save(S entity)	                            Mono<T>	Сохраняет объект (insert или update)
 * saveAll(Iterable<S> entities)	            Flux<S>	Сохраняет несколько объектов
 * saveAll(Publisher<S> entityStream)	        Flux<S>	Сохраняет поток объектов (reactive)
 * findById(ID id)	                            Mono<T>	Найти объект по id
 * existsById(ID id)	                        Mono<Boolean>	Проверить, существует ли объект по id
 * findAll()	                                Flux<T>	Найти все объекты
 * findAllById(Iterable<ID> ids)	            Flux<T>	Найти объекты по списку id
 * findAll(Sort sort)	                        Flux<T>	Найти все объекты с сортировкой
 * count()	                                    Mono<Long>	Количество объектов в репозитории
 * deleteById(ID id)	                        Mono<Void>	Удалить объект по id
 * delete(T entity)	                            Mono<Void>	Удалить объект
 * deleteAll(Iterable<? extends T> entities)	Mono<Void>	Удалить список объектов
 * deleteAll()	                                Mono<Void>	Удалить все объекты
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 05.01.2026
 */
@Repository
public interface PaymentRepository extends ReactiveCrudRepository<Payment, Long> {

    // Все платежи пользователя
    Flux<Payment> findAllByUserId(Long userId);

    // Платежи пользователя с определённым статусом
    Flux<Payment> findAllByUserIdAndStatus(Long userId, PaymentStatus status);

    // Платежи определённого типа
    Flux<Payment> findAllByType(PaymentType type);

    // Проверка существования платежа по внешнему ID
    Mono<Boolean> existsByExternalId(String externalId);

    // Найти платеж по внешнему ID
    Mono<Payment> findByExternalId(String externalId);

    // Платежи, созданные в заданный период
    Flux<Payment> findAllByCreatedAtBetween(LocalDateTime from, LocalDateTime to);

    // Платежи пользователя, созданные в период
    Flux<Payment> findAllByUserIdAndCreatedAtBetween(Long userId, LocalDateTime from, LocalDateTime to);
}

