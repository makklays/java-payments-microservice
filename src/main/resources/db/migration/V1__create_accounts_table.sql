-- V1__create_accounts_table.sql
-- Migration #1: create table accounts

-- Creating table 'accounts' for saving main data of accounts
CREATE TABLE IF NOT EXISTS accounts (
    id              BIGSERIAL PRIMARY KEY,                -- Автоинкремент
    user_id         BIGINT NOT NULL,                      -- ID пользователя
    iban            VARCHAR(34) NOT NULL UNIQUE,          -- IBAN (макс 34 символа)
    swift_code      VARCHAR(11),                          -- SWIFT/BIC код банка
    account_type    VARCHAR(20) NOT NULL,                 -- Тип счета (CHECKING, SAVINGS, BUSINESS)
    currency_code   CHAR(3) NOT NULL,                     -- Валюта счета (USD, EUR, …)
    balance         NUMERIC(20, 2) NOT NULL DEFAULT 0,    -- Текущий баланс
    status          VARCHAR(20) NOT NULL,                 -- Статус счета (ACTIVE, BLOCKED, CLOSED)
    overdraft_limit NUMERIC(20, 2) DEFAULT 0,             -- Лимит овердрафта
    owner_name      VARCHAR(255),                         -- Имя владельца
    branch_id       BIGINT,                               -- ID филиала
    created_at      TIMESTAMP NOT NULL DEFAULT NOW(),     -- Дата создания
    updated_at      TIMESTAMP DEFAULT NOW()               -- Дата обновления
);

-- Adding index for fast searching by user_id, iban and status
CREATE INDEX idx_accounts_user_id ON accounts(user_id);
CREATE INDEX idx_accounts_iban ON accounts(iban);
CREATE INDEX idx_accounts_status ON accounts(status);

