package com.techmatrix18.repository;

import com.techmatrix18.enums.AccountStatus;
import com.techmatrix18.model.Account;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

/**
 * Repository interface for Account entity operations.
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
public interface AccountRepository extends ReactiveCrudRepository<Account, Long> {

    // Найти все счета пользователя
    Flux<Account> findAllByUserId(Long userId);

    // Найти счёт по IBAN
    Mono<Account> findByIban(String iban);

    // Проверка существования счёта по IBAN
    Mono<Boolean> existsByIban(String iban);

    // Найти счёт пользователя по IBAN (для доп. безопасности)
    Mono<Account> findByUserIdAndIban(Long userId, String iban);

    // Найти все счета в определённой валюте
    Flux<Account> findAllByCurrencyCode(String currencyCode);

    // Проверка существования счёта у пользователя
    Mono<Boolean> existsByUserId(Long userId);

    // Найти все счета пользователя с определённым статусом
    Flux<Account> findAllByUserIdAndStatus(Long userId, AccountStatus status);

    // Найти все счета, созданные в определённом диапазоне дат
    Flux<Account> findAllByCreatedAtBetween(LocalDateTime from, LocalDateTime to);
}

